package cn.v5cn.v5cms.controller;

import cn.v5cn.v5cms.service.SiteService;
import cn.v5cn.v5cms.entity.Site;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.jboss.logging.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

import static cn.v5cn.v5cms.util.MessageSourceHelper.getMessage;

/**
 * Created by ZYW on 2014/6/29.
 */
@Controller
@RequestMapping("/manager/site")
public class SiteSettingController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SiteSettingController.class);

    @Autowired
    private SiteService siteService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String siteInfo(ModelMap model){
        ImmutableList<Site> result = siteService.finadAll();
        model.addAttribute("sites",result);
        LOGGER.debug("获取站点列表，length:"+result.size());
        return "setting/site_list";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String addSite(ModelMap model){
        model.addAttribute("site", new Site());
        return "setting/site_edit";
    }

    @RequestMapping(value = "/update/{siteId}",method = RequestMethod.GET)
    public String updateSite(ModelMap model,@PathVariable Long siteId){
        Site result = siteService.findBySiteId(siteId);
        model.addAttribute("site",result);
        model.addAttribute("page_title",getMessage("site.updatepage.title"));
        return "setting/site_edit";
    }

    @ResponseBody
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public ImmutableMap<String,Object> addUpdateSite(@Valid Site site,BindingResult binding){
        if (binding.hasErrors()) {
            Map<String, Object> errorMessage = Maps.newHashMap();
            errorMessage.put("status", 0);
            List<FieldError> fes = binding.getFieldErrors();
            for (FieldError fe : fes) {
                errorMessage.put(fe.getField(), fe.getDefaultMessage());
            }
            return ImmutableMap.<String, Object>builder().putAll(errorMessage).build();
        }
        //修改操作
        if(site.getSiteId() != null){
            try {
                siteService.addSite(site);
            }catch (Exception e) {
                LOGGER.error("Site更新异常：{}",e.getMessage());
                return ImmutableMap.<String, Object>of("status","0","message", getMessage("site.updatefailed.message"));
            }
            return ImmutableMap.<String, Object>of("status","1","message", getMessage("site.updatesuccess.message"));
        }
        //新增操作
        Long result = siteService.addSite(site);
        if(result != 0L){
            return ImmutableMap.<String, Object>of("status","1","message",getMessage("site.addsuccess.message"));
        }
        return ImmutableMap.<String, Object>of("status","0","message",getMessage("site.addfailed.message"));
    }

    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ImmutableMap<String,String> deleteSite(Long[] siteIds){
        LOGGER.info("删除站点信息，ID为{}",siteIds);
        try {
            siteService.deleteSite(siteIds);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("删除站点信息失败，ID为{}",siteIds);
            return ImmutableMap.of("status","0","message",getMessage("site.deletefailed.message"));
        }
        return ImmutableMap.of("status","1","message",getMessage("site.deletesuccess.message"));
    }

    @ResponseBody
    @RequestMapping(value = "/domain/count",method = RequestMethod.POST)
    public ImmutableMap<String,String> countDomain(String param,@Param Long siteId) {
        if(siteId == null) siteId = 0L;
        long domainCount = siteService.countByDomainAndSiteIdNot(param,siteId);
        if(domainCount > 0){
            return ImmutableMap.of("info","域名已存在！","status","n");
        } else {
            return ImmutableMap.of("info","验证通过！","status","y");
        }
    }
}

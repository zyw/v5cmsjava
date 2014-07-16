package cn.v5cn.v5cms.action;

import cn.v5cn.v5cms.biz.SiteBiz;
import cn.v5cn.v5cms.entity.Site;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static cn.v5cn.v5cms.util.MessageSourceHelper.getMessage;

/**
 * Created by ZYW on 2014/6/29.
 */
@Controller
@RequestMapping("/manager")
public class SiteSettingAction {
    private static final Logger LOGGER = LoggerFactory.getLogger(SiteSettingAction.class);

    @Autowired
    private SiteBiz siteBiz;

    @RequestMapping(value = "/siteList",method = RequestMethod.GET)
    public String siteInfo(ModelMap model){
        ImmutableList<Site> result = siteBiz.finadAll();
        model.addAttribute("sites",result);
        LOGGER.debug("获取站点列表，length:"+result.size());
        return "backstage/site_list";
    }

/*    @RequestMapping(value = "/sitelist",method = RequestMethod.GET)
    @ResponseBody
    public List<Site> siteList(){
        return siteBiz.findSize(-1).asList();
    }*/

    @RequestMapping(value = "/addsite",method = RequestMethod.GET)
    public String addSite(ModelMap model){
        model.addAttribute("site",new Site());
        return "backstage/site_au";
    }

    @RequestMapping(value = "/updatesite/{siteId}",method = RequestMethod.GET)
    public String updateSite(ModelMap model,@PathVariable Long siteId){
        Site result = siteBiz.findBySiteId(siteId);
        model.addAttribute("site",result);
        return "backstage/site_au";
    }

    @ResponseBody
    @RequestMapping(value = "/ausite",method = RequestMethod.POST)
    public ImmutableMap<String,String> addUpdateSite(Site site){
        if(site.getSiteId() != null){
            try {
                siteBiz.updateSite(site);
            } catch (Exception e) {
                e.printStackTrace();
                return ImmutableMap.of("status","0","message", getMessage("site.updatefailed.message"));
            }
            return ImmutableMap.of("status","1","message", getMessage("site.updatesuccess.message"));
        }
        Long result = siteBiz.addSite(site);
        if(result != 0L){
            return ImmutableMap.of("status","1","message",getMessage("site.addsuccess.message"));
        }
        return ImmutableMap.of("status","0","message",getMessage("site.addfailed.message"));
    }

    @ResponseBody
    @RequestMapping(value = "/deletesite/{siteId}",method = RequestMethod.GET)
    public ImmutableMap<String,String> deleteSite(@PathVariable Long siteId){
        try {
            siteBiz.deleteSite(siteId);
        } catch (Exception e) {
            e.printStackTrace();
            return ImmutableMap.of("status","0","message",getMessage("site.deletefailed.message"));
        }
        return ImmutableMap.of("status","1","message",getMessage("site.deletesuccess.message"));
    }
}

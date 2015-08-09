package cn.v5cn.v5cms.controller;

import cn.v5cn.v5cms.entity.Banner;
import cn.v5cn.v5cms.service.BannerService;
import cn.v5cn.v5cms.util.HttpUtils;
import cn.v5cn.v5cms.util.SystemUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zyw on 15/7/26.
 */
@Controller
@RequestMapping(value = "/manager/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @RequestMapping(value = "/list/{p}",method = {RequestMethod.GET,RequestMethod.POST})
    public String linkList(Banner banner,@PathVariable Integer p,HttpServletRequest request,ModelMap modelMap){
        Session session = SystemUtils.getShiroSession();
        if(StringUtils.isNotBlank(banner.getBannerName())){
            session.setAttribute("bannerSearch",banner);
            modelMap.addAttribute("searchBanner",banner);
        }else{
            session.setAttribute("bannerSearch",null);
        }
        Object searchObj = session.getAttribute("bannerSearch");

        Page<Banner> result =  bannerService.findBannerPageable((searchObj == null ? (new Banner()) : ((Banner) searchObj)), p);

        modelMap.addAttribute("banners",result.getContent());
        modelMap.addAttribute("pagination", SystemUtils.pagination(result, HttpUtils.getContextPath(request) + "/manager/banner/list"));
        return "setting/banner_list";
    }

    @RequestMapping(value = "/edit/{bannerId}",method = RequestMethod.GET)
    public String linkEdit(@PathVariable Long bannerId,ModelMap modelMap){
        if(bannerId == null || bannerId == 0){
            modelMap.addAttribute(new Banner());
            return "setting/banner_edit";
        }
        Banner banner = bannerService.findOne(bannerId);
        modelMap.addAttribute(banner);
        return "setting/banner_edit";
    }
}

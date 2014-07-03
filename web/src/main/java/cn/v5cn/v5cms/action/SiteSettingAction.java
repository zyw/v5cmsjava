package cn.v5cn.v5cms.action;

import cn.v5cn.v5cms.biz.SiteBiz;
import cn.v5cn.v5cms.entity.Site;
import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ZYW on 2014/6/29.
 */
@Controller
@RequestMapping("/manager")
public class SiteSettingAction {

    @Autowired
    private SiteBiz siteBiz;

    @RequestMapping(value = "/siteInfo",method = RequestMethod.GET)
    public String siteInfo(ModelMap model){
        ImmutableList<Site> result = siteBiz.findSize(-1);
        model.addAttribute("sites",result);
        return "backstage/siteInfo";
    }

    @RequestMapping(value = "/addsite",method = RequestMethod.GET)
    public String addSite(ModelMap model){
        model.addAttribute("site",new Site());
        return "backstage/siteAdd";
    }
    @RequestMapping(value = "addsite/{siteId}",method = RequestMethod.GET)
    public String updateSite(ModelMap model,@PathVariable Integer siteId){
        ImmutableList<Site> result = siteBiz.findSize(siteId);
        model.addAttribute("site",result.get(0));
        return "backstage/siteAdd";
    }
}

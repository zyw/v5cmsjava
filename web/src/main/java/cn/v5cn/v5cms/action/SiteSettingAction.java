package cn.v5cn.v5cms.action;

import cn.v5cn.v5cms.biz.SiteBiz;
import cn.v5cn.v5cms.entity.Site;
import cn.v5cn.v5cms.util.PropertyUtils;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

/*    @RequestMapping(value = "/sitelist",method = RequestMethod.GET)
    @ResponseBody
    public List<Site> siteList(){
        return siteBiz.findSize(-1).asList();
    }*/

    @RequestMapping(value = "/addsite",method = RequestMethod.GET)
    public String addSite(ModelMap model){
        model.addAttribute("site",new Site());
        return "backstage/siteAdd";
    }

    @RequestMapping(value = "/addsite/{siteId}",method = RequestMethod.GET)
    public String updateSite(ModelMap model,@PathVariable Integer siteId){
        ImmutableList<Site> result = siteBiz.findSize(siteId);
        model.addAttribute("site",result.get(0));
        return "backstage/siteAdd";
    }

    @ResponseBody
    @RequestMapping(value = "/ausite",method = RequestMethod.POST)
    public ImmutableMap<String,String> addUpdateSite(Site site){
        if(site.getTbId() != 0){
            int result = siteBiz.updateSite(site);
            if(result > 0){
                return ImmutableMap.of("status","1","message",PropertyUtils.getValue("site.updatesuccess.message").or(""));
            }
            return ImmutableMap.of("status","0","message",PropertyUtils.getValue("site.updatefailed.message").or(""));
        }
        int result = siteBiz.addSite(site);
        if(result != 0){
            return ImmutableMap.of("status","1","message",PropertyUtils.getValue("site.addsuccess.message").or(""));
        }
        return ImmutableMap.of("status","0","message",PropertyUtils.getValue("site.addfailed.message").or(""));
    }

    @ResponseBody
    @RequestMapping(value = "/deletesite/{siteId}",method = RequestMethod.GET)
    public ImmutableMap<String,String> deleteSite(@PathVariable int siteId){
        int result = siteBiz.deleteSite(siteId);
        if(result > 0){
            return ImmutableMap.of("status","1","message",PropertyUtils.getValue("site.deletesuccess.message").or(""));
        }
        return ImmutableMap.of("status","0","message",PropertyUtils.getValue("site.deletefailed.message").or(""));
    }
}

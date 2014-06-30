package cn.v5cn.v5cms.action;

import cn.v5cn.v5cms.biz.SiteBiz;
import cn.v5cn.v5cms.entity.Site;
import com.google.common.base.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ZYW on 2014/6/29.
 */
@Controller
@RequestMapping("/manager")
public class SiteSetting {

    @Autowired
    private SiteBiz siteBiz;

    @RequestMapping(value = "/siteInfo",method = RequestMethod.GET)
    public String siteInfo(ModelMap model){
        Optional<Site> result = siteBiz.findSize();
        model.addAttribute("site",result.get());
        return "backstage/siteInfo";
    }
}

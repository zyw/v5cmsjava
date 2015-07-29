package cn.v5cn.v5cms.front.controller;

import cn.v5cn.v5cms.entity.Site;
import cn.v5cn.v5cms.util.SystemConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ZXF-PC1 on 2015/7/29.
 */
@Controller
@RequestMapping("/nav")
public class FrontColumnController {

    @RequestMapping(value = "/{navId}.htm")
    public String columnList(@PathVariable Long navId,HttpServletRequest request){
        Site site = (Site)request.getSession().getAttribute(SystemConstant.FRONT_SITE_SESSION_KEY);
        return site.getThemeName()+"/column";
    }
}

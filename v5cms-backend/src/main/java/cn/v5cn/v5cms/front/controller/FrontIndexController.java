package cn.v5cn.v5cms.front.controller;

import cn.v5cn.v5cms.entity.Site;
import cn.v5cn.v5cms.service.SiteService;
import cn.v5cn.v5cms.util.SystemConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ZYW on 2014/6/30.
 */
@Controller
public class FrontIndexController {

    @Autowired
    private SiteService siteService;

    @RequestMapping(value = "index.htm",method = RequestMethod.GET)
    public String index(HttpServletRequest request){

        Site site = (Site)request.getSession().getAttribute(SystemConstant.FRONT_SITE_SESSION_KEY);

        return site.getThemeName()+"/index";
    }
}

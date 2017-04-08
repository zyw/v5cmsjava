package cn.v5cn.v5cms.front.interceptor;

import cn.v5cn.v5cms.entity.Site;
import cn.v5cn.v5cms.service.SiteService;
import cn.v5cn.v5cms.util.SystemConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zyw on 15/8/3.
 */
public class FrontInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private SiteService siteService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o) throws Exception {

        Object siteObj = request.getSession().getAttribute(SystemConstant.FRONT_SITE_SESSION_KEY);
        if(siteObj != null) return true;

        String serverName = request.getServerName();
        int serverPort = request.getServerPort();
        Site site = siteService.findByDomain(serverName + ":" + serverPort);

        request.getSession().setAttribute(SystemConstant.FRONT_SITE_SESSION_KEY,site);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

    }
}

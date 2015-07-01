package cn.v5cn.v5cms.filter;

import cn.v5cn.v5cms.service.SiteService;
import cn.v5cn.v5cms.entity.Site;
import com.google.common.collect.ImmutableList;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static cn.v5cn.v5cms.util.SystemConstant.SITES_SESSION_KEY;
import static cn.v5cn.v5cms.util.SystemConstant.SITE_SESSION_KEY;

/**
 * Created by ZYW on 2014/6/10.
 */
public class GlobalInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private SiteService siteService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if(StringUtils.contains(request.getRequestURI(),"/manager/login")) return true;

        HttpSession session = request.getSession();
        if(session.getAttribute(SITES_SESSION_KEY) != null) return true;

        ImmutableList<Site> resultBiz = siteService.findByIsclosesite(1);
        Site temp = resultBiz.size() == 0 ? new Site(): resultBiz.get(0);
        session.setAttribute(SITES_SESSION_KEY,resultBiz);
        session.setAttribute(SITE_SESSION_KEY,temp);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {


//        if(modelAndView == null) return;

//        modelAndView.addObject(BASE_PATH,getBasePath(request));
//        modelAndView.addObject(CONTEXT_PATH,getContextPath(request));
//        modelAndView.getModel().put(BASE_PATH,getBasePath(request));
//        modelAndView.getModel().put(CONTEXT_PATH,getContextPath(request));
//        request.setAttribute(BASE_PATH,getBasePath(request));
//        request.setAttribute(CONTEXT_PATH,getContextPath(request));
    }
}

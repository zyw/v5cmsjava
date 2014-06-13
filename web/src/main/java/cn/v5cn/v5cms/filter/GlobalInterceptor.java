package cn.v5cn.v5cms.filter;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static cn.v5cn.v5cms.util.HttpUtils.getBasePath;
import static cn.v5cn.v5cms.util.HttpUtils.getContextPath;
import static cn.v5cn.v5cms.util.SystemConstant.BASE_PATH;
import static cn.v5cn.v5cms.util.SystemConstant.CONTEXT_PATH;

/**
 * Created by ZYW on 2014/6/10.
 */
public class GlobalInterceptor extends HandlerInterceptorAdapter {
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        if(modelAndView == null) return;

//        modelAndView.addObject(BASE_PATH,getBasePath(request));
//        modelAndView.addObject(CONTEXT_PATH,getContextPath(request));
//        modelAndView.getModel().put(BASE_PATH,getBasePath(request));
//        modelAndView.getModel().put(CONTEXT_PATH,getContextPath(request));
        request.setAttribute(BASE_PATH,getBasePath(request));
        request.setAttribute(CONTEXT_PATH,getContextPath(request));
    }
}

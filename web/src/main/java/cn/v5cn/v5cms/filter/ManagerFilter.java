package cn.v5cn.v5cms.filter;

import cn.v5cn.v5cms.entity.Manager;
import cn.v5cn.v5cms.util.HttpUtils;
import cn.v5cn.v5cms.util.SystemConstant;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ZYW on 2014/6/10.
 */
public class ManagerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Manager manager = (Manager)request.getSession().getAttribute(SystemConstant.SESSION_KEY);
        if(manager == null){
            response.sendRedirect(HttpUtils.getBasePath(request) + "/admin/manager/login");
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}

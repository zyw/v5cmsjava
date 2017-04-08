package cn.v5cn.v5cms.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ZYW on 2014/6/10.
 */
public class HttpUtils {
    public static String getBasePath(HttpServletRequest request) {
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName()
                + ":" + request.getServerPort() + path;
        return basePath;
    }
    public static String getContextPath(HttpServletRequest request) {
        String path = request.getContextPath();
        return path;
    }

    public static String getRealPath(HttpServletRequest request,String basePath){
        String realPath = request.getSession().getServletContext().getRealPath(basePath);
        return realPath;
    }
}

package cn.v5cn.v5cms.util;

import cn.v5cn.v5cms.exception.V5CMSSessionValueNullException;
import cn.v5cn.v5cms.util.annotation.Ignore;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;

import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

/**
 * Created by ZYW on 2014/7/18.
 */
public class SystemUtils {

    private final static Logger LOGGER = LoggerFactory.getLogger(SystemUtils.class);

    private static final BeanUtilsBean BEAN_UTILS_BEAN = BeanUtilsBean.getInstance();

    public static void copyProperties(Object dest, Object orig)
            throws IllegalAccessException, InvocationTargetException {

        // Validate existence of the specified beans
        if (dest == null) {
            throw new IllegalArgumentException
                    ("No destination bean specified");
        }
        if (orig == null) {
            throw new IllegalArgumentException("No origin bean specified");
        }

        if (orig instanceof Map) {
            @SuppressWarnings("unchecked")
            // Map properties are always of type <String, Object>
                    Map<String, Object> propMap = (Map<String, Object>) orig;
            for (Map.Entry<String, Object> entry : propMap.entrySet()) {
                String name = entry.getKey();
                if (BEAN_UTILS_BEAN.getPropertyUtils().isWriteable(dest, name)) {
                    BEAN_UTILS_BEAN.copyProperty(dest, name, entry.getValue());
                }
            }
        } else /* if (orig is a standard JavaBean) */ {
            PropertyDescriptor[] origDescriptors =
                    BEAN_UTILS_BEAN.getPropertyUtils().getPropertyDescriptors(orig);
            for (int i = 0; i < origDescriptors.length; i++) {
                String name = origDescriptors[i].getName();
                if ("class".equals(name)) {
                    continue; // No point in trying to set an object's class
                }
                Ignore ignore = origDescriptors[i].getReadMethod().getAnnotation(Ignore.class);
                if(ignore != null) continue;
                if (BEAN_UTILS_BEAN.getPropertyUtils().isReadable(orig, name) && BEAN_UTILS_BEAN.getPropertyUtils().isWriteable(dest, name)) {
                    try {
                        Object value = BEAN_UTILS_BEAN.getPropertyUtils().getSimpleProperty(orig, name);
                        BEAN_UTILS_BEAN.copyProperty(dest, name, value);
                    } catch (NoSuchMethodException e) {
                        // Should not happen
                    }
                }
            }
        }

    }

    public static String getFileNameExt(String fileName){
        if(fileName == null || StringUtils.isEmpty(fileName)){
            throw new RuntimeException("参数fileName不能为空值！");
        }
        return "."+FilenameUtils.getExtension(fileName);
    }

    public static String timeFileName(String fileName){
        String fileExt = getFileNameExt(fileName);
        return new Date().getTime()+fileExt;
    }
    /**
     * 判断目录是否存在，如果不存在就创建
     * */
    public static boolean isNotExistCreate(String filePath){
        File f = new File(filePath);
        if(!f.exists()){
            return f.mkdirs();
        }
        return true;
    }

    /**
     * 分页字符串拼接
     * */
    public static <T extends Serializable> String pagination(Page<T> page,String href){
        StringBuilder htmlSb = new StringBuilder("<ul class='pagination pagination-sm no-margin pull-right'>");
        if(page.isFirst()){
            htmlSb.append("<li class='disabled'><a>&laquo;</a></li>");
        }else{
            htmlSb.append("<li><a href='").append(href+"/1").append("'>&laquo;</a></li>");
        }
        int currPage = page.getNumber()+1;
        int page_start = currPage - 2 > 0 ? currPage-2 : 1;
        int page_end = page_start + 4 >= page.getTotalPages() ? page.getTotalPages() : page_start + 4;
        if(page_start > 1){
            htmlSb.append("<li><a>...</a></li>");
        }
        for(int i = page_start; i <= page_end; i++){
            int pageIndex = i;
            if(i == currPage){
                htmlSb.append("<li class='disabled'><a>").append(i).append("</a></li>");
            }else{
                htmlSb.append("<li><a href='").append(href+"/"+pageIndex).append("'>").append(i).append("</a></li>");
            }
        }
        if(page_end < page.getTotalPages()){
            htmlSb.append("<li><a>...</a></li>");
        }
        if(currPage == page.getTotalPages()) {
            htmlSb.append("<li class='disabled'><a>&raquo;</a></li>");
        }else{
            htmlSb.append("<li><a href='").append(href+"/"+(page.getTotalPages())).append("'>&raquo;</a></li>");
        }
        htmlSb.append("</ul>");
        return htmlSb.toString();
    }

    public static Session getShiroSession(){
        return SecurityUtils.getSubject().getSession();
    }

    public static Object getSessionSite(){
        Object siteObj = getShiroSession().getAttribute(SystemConstant.SITE_SESSION_KEY);
        if(siteObj == null){
            LOGGER.error("Session中存储的站点信息为空！");
            throw new V5CMSSessionValueNullException("Session中存储的站点信息为空！");
        }
        return siteObj;
    }

    public static Object getSessionUser(){
        Object userObj = getShiroSession().getAttribute(SystemConstant.SESSION_KEY);
        if(userObj == null) {
            LOGGER.error("Session中存储的用户信息为空！");
            throw new V5CMSSessionValueNullException("Session中存储的用户信息为空！");
        }
        return userObj;
    }
    /**
     * 格式化Uri将\exp.html替换成/exp.html
     *
     * */
    public static String formatUri(String uri){
        if(uri == null || uri.trim().equals("")|| uri.indexOf("\\") == -1) return uri;

        return uri.replaceAll("\\\\","/");
    }
 }

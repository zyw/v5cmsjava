package cn.v5cn.v5cms.util;

import cn.v5cn.v5cms.util.annotation.Ignore;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

import java.beans.PropertyDescriptor;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

/**
 * Created by ZYW on 2014/7/18.
 */
public class SystemUtils {

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
}

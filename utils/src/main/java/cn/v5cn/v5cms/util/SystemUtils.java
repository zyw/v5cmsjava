package cn.v5cn.v5cms.util;

import cn.v5cn.v5cms.util.annotation.Ignore;
import org.apache.commons.beanutils.BeanUtilsBean;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
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

        // Copy the properties, converting as necessary
//        if (orig instanceof DynaBean) {
//            DynaProperty[] origDescriptors =
//                    ((DynaBean) orig).getDynaClass().getDynaProperties();
//            for (int i = 0; i < origDescriptors.length; i++) {
//                String name = origDescriptors[i].getName();
//                // Need to check isReadable() for WrapDynaBean
//                // (see Jira issue# BEANUTILS-61)
//                if (BEAN_UTILS_BEAN.getPropertyUtils().isReadable(orig, name) &&
//                        BEAN_UTILS_BEAN.getPropertyUtils().isWriteable(dest, name)) {
//                    Object value = ((DynaBean) orig).get(name);
//                    BEAN_UTILS_BEAN.copyProperty(dest, name, value);
//                }
//            }
//        } else
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
}

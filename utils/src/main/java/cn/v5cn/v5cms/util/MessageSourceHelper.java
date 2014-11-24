package cn.v5cn.v5cms.util;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

/**
 * Created by ZYW on 2014/7/7.
 * 在java代码中使用国际化的帮助类。
 * 在Spring配置文件中的配置如下：
 * <!-- 配置国际化 -->
 * <bean id="messageSource" class="org.springframework.context.support.ResourceBundleMessageSource">
 *    <property name="basename" value="messages"/>
 *    <property name="defaultEncoding" value="UTF-8"/>
 *    <property name="alwaysUseMessageFormat" value="true"/>
 * </bean>
 * <!-- 在代码中使用国际化的自定义类 -->
 * <bean id="messageSourceHelper" class="cn.v5cn.v5cms.util.MessageSourceHelper">
 *    <property name="messageSource" ref="messageSource"/>
 * </bean>
 * 在java代码中就可以使用MessageSourceHelper.getMessage(key,args,defaultMessage,locale)获得
 * 国际化消息
 */
public class MessageSourceHelper {
    private static MessageSource messageSource;

    public void setMessageSource(ResourceBundleMessageSource messageSource) {
        MessageSourceHelper.messageSource = messageSource;
    }

    public static String  getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
        String msg = messageSource.getMessage(code, args, defaultMessage, locale);
        return msg != null ? msg.trim() : defaultMessage;
    }

    public static String getMessage(String code,Object[] args,String defaultMessage){

        String msg = getMessage(code,args,defaultMessage,Locale.SIMPLIFIED_CHINESE);
        return msg;
    }

    public static String getMessage(String code,String defaultMessage){
        String msg = getMessage(code,new Object[]{},defaultMessage,Locale.SIMPLIFIED_CHINESE);
        return msg;
    }

    public static String getMessage(String code){
        String msg = getMessage(code,new Object[]{},"",Locale.SIMPLIFIED_CHINESE);
        return msg;
    }
}

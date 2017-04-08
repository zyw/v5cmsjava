package cn.v5cn.v5cms.filter;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by ZYW on 2014/10/30.
 */
public class JCaptchaValidateFilter extends AccessControlFilter {

    @Autowired
    private DefaultKaptcha captchaProducer;

    private boolean jcaptchaEbabled = true;     //是否开启验证码支持
    private String jcaptchaParam = "jcaptchaCode";  //前台提交的验证码参数名
    private String failureKeyAttribute = "shiroLoginFailure";   //验证失败后存储到的属性名

    public void setJcaptchaEbabled(boolean jcaptchaEbabled) {
        this.jcaptchaEbabled = jcaptchaEbabled;
    }

    public void setJcaptchaParam(String jcaptchaParam) {
        this.jcaptchaParam = jcaptchaParam;
    }

    public void setFailureKeyAttribute(String failureKeyAttribute) {
        this.failureKeyAttribute = failureKeyAttribute;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        //1、设置验证码是否开启属性，页面可以根据该属性来决定是否显示验证码
        request.setAttribute("jcaptchaEbabled",jcaptchaEbabled);
        HttpServletRequest httpRequest = WebUtils.toHttp(request);
        //2、判断验证码是否禁用或不是表单提交（允许访问）
        if(!jcaptchaEbabled || !"post".equalsIgnoreCase(httpRequest.getMethod())){
            return true;
        }
        //3、此时是表单提交，验证验证码是否正确
        String captchaSession = (String)httpRequest.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);

        return (httpRequest.getParameter(jcaptchaParam)).equalsIgnoreCase(captchaSession);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        request.setAttribute(failureKeyAttribute,"jCaptcha.error");
        return true;
    }
}

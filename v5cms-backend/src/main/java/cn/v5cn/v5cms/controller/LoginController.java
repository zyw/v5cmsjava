package cn.v5cn.v5cms.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

/**
 * Created by ZYW on 2014/5/30.
 */
@Controller
@RequestMapping("/manager")
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

//    @Autowired
//    private ManagerService managerBiz;

    @Autowired
    private DefaultKaptcha captchaProducer;

    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request,ModelMap modelMap/*String loginName,String loginPwd,String captcha,HttpServletRequest request*/){
        //LOGGER.info("用户{}开始登录！",loginName);
        /*String captchaSession = (String)request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        *//*if(!captchaSession.equalsIgnoreCase(captcha)){
            request.setAttribute(SystemConstant.ERROR_MESSAGE,getMessage("login.captchaerror.message"));
            LOGGER.warn("用户{}验证码输入错误！",loginName);
            return "backstage/login";
        }*//*
        List<Manager> result = managerBiz.findByManagerLoginname(loginName);
        if(result==null || result.isEmpty()){
            request.setAttribute(SystemConstant.ERROR_MESSAGE,getMessage("login.usernameerror.message"));
            LOGGER.warn("用户{}不存在！",loginName);
            return "backstage/login";
        }
        Manager manager = result.get(0);
        if(!manager.getManagerPassword().equals(Md5AndSha1.encodeByMD5(loginPwd))){
            request.setAttribute(SystemConstant.ERROR_MESSAGE,getMessage("login.pwderror.message"));
            LOGGER.warn("用户{}密码输入错误！",loginName);
            return "backstage/login";
        }
        LOGGER.info("用户{}登录成功！",loginName);
        manager.setManagerPassword("");
        request.getSession().setAttribute(SystemConstant.SESSION_KEY,manager);
        return "redirect:/manager/index";*/
        String exceptionClassName = (String)request.getAttribute("shiroLoginFailure");
        String error = null;
        if(UnknownAccountException.class.getName().equals(exceptionClassName)){
            error = "用户名/密码错误";
        }else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)){
            error = "用户名/密码错误";
        }else if("jCaptcha.error".equals(exceptionClassName)){
            error = "验证码输入错误";
        }else if(exceptionClassName != null){
            error = "其他错误：" + exceptionClassName;
        }
        modelMap.addAttribute("error",error);
        return "login";
    }

    @RequestMapping(value="/login/captcha",method = RequestMethod.GET)
    public void captcha(HttpServletRequest request,HttpServletResponse response) throws Exception{
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control",
                "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        String capText = captchaProducer.createText();
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
    }
}

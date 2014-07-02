package cn.v5cn.v5cms.action;

import cn.v5cn.v5cms.biz.ManagerBiz;
import cn.v5cn.v5cms.entity.Manager;
import cn.v5cn.v5cms.util.Md5AndSha1;
import cn.v5cn.v5cms.util.SystemConstant;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 * Created by ZYW on 2014/5/30.
 */
@Controller
@RequestMapping("/admin/manager")
public class LoginAction {

    @Autowired
    private ManagerBiz managerBiz;

    @Autowired
    private DefaultKaptcha captchaProducer;

    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String login(){
        return "backstage/login";
    }

    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String login(String loginName,String loginPwd,String captcha,HttpServletRequest request){

        /*String captchaSession = (String)request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if(!captchaSession.equalsIgnoreCase(captcha)){
            request.setAttribute(SystemConstant.ERROR_MESSAGE,"验证码输入错误！");
            return "backstage/login";
        }*/
        List<Manager> result = managerBiz.login(loginName);
        if(result==null || result.isEmpty()){
            request.setAttribute(SystemConstant.ERROR_MESSAGE,"用户不存在！");
            return "backstage/login";
        }
        Manager manager = result.get(0);
        if(!manager.getManagerPassword().equals(Md5AndSha1.encodeByMD5(loginPwd))){
            request.setAttribute(SystemConstant.ERROR_MESSAGE,"密码输入错误！");
            return "backstage/login";
        }
        manager.setManagerPassword("");
        request.getSession().setAttribute(SystemConstant.SESSION_KEY,manager);
        return "redirect:/manager/index";
    }

    @RequestMapping(value="/captcha",method = RequestMethod.GET)
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

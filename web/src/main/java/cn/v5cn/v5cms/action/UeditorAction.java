package cn.v5cn.v5cms.action;

import com.baidu.ueditor.ActionEnter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ZYW on 2014/11/22.
 */
@Controller
@RequestMapping("/manager/ueditor")
public class UeditorAction {

    @RequestMapping(value = "/config",method = RequestMethod.GET)
    public void ueditorConfig(HttpServletRequest request,HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        response.setHeader("Content-Type" , "text/html");

        String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/config/");
        out.write(new ActionEnter(request,realPath).exec());
        out.flush();
    }
}

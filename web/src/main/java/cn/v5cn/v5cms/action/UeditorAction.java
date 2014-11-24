package cn.v5cn.v5cms.action;

import com.baidu.ueditor.ActionEnter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

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

    @Autowired
    private CommonsMultipartResolver multipartResolver;

    @RequestMapping(value = "/config",method = {RequestMethod.GET,RequestMethod.POST})
    public void ueditorConfig(HttpServletRequest request,HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        response.setHeader("Content-Type" , "text/html");

        String realPath = request.getSession().getServletContext().getRealPath("/");
        out.write(new ActionEnter(null,request,realPath).exec());
        out.flush();
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public void ueditorUpload(MultipartFile upfile,HttpServletRequest request,HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        response.setHeader("Content-Type" , "text/html");

        String realPath = request.getSession().getServletContext().getRealPath("/");
        out.write(new ActionEnter(upfile,request,realPath).exec());
        out.flush();
    }
}

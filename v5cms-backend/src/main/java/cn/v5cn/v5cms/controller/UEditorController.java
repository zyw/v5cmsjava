package cn.v5cn.v5cms.controller;

import cn.v5cn.v5cms.entity.Site;
import cn.v5cn.v5cms.util.HttpUtils;
import cn.v5cn.v5cms.util.SystemUtils;
import com.baidu.ueditor.ActionEnter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ZYW on 2014/11/22.
 */
@Controller
@RequestMapping("/manager/ueditor")
public class UEditorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UEditorController.class);

    @RequestMapping(value = "/config",method = {RequestMethod.GET,RequestMethod.POST})
    public void ueditorConfig(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Site site = (Site)(SystemUtils.getSessionSite());
        PrintWriter out = response.getWriter();
        response.setHeader("Content-Type" , "text/html");

        String realPath = HttpUtils.getRealPath(request,"/");//request.getSession().getServletContext().getRealPath("/");
        out.write(new ActionEnter(null,request,realPath,site.getSiteId()+"").exec());
        out.flush();
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public void ueditorUpload(MultipartFile file,HttpServletRequest request,HttpServletResponse response) throws IOException {

        Site site = (Site)(SystemUtils.getSessionSite());

        PrintWriter out = response.getWriter();
        response.setHeader("Content-Type" , "text/html");

        String realPath = HttpUtils.getRealPath(request,"/");//request.getSession().getServletContext().getRealPath("/");
        String uploadFileInfo = new ActionEnter(file, request, realPath,site.getSiteId()+"").exec();
        out.write(uploadFileInfo);
        out.flush();
    }
}

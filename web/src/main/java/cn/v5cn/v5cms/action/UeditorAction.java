package cn.v5cn.v5cms.action;

import cn.v5cn.v5cms.entity.Site;
import cn.v5cn.v5cms.exception.V5CMSSessionValueNullException;
import cn.v5cn.v5cms.util.HttpUtils;
import cn.v5cn.v5cms.util.SystemConstant;
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
public class UeditorAction {

    private static final Logger LOGGER = LoggerFactory.getLogger(UeditorAction.class);

    @RequestMapping(value = "/config",method = {RequestMethod.GET,RequestMethod.POST})
    public void ueditorConfig(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Object siteObj = request.getSession().getAttribute(SystemConstant.SITE_SESSION_KEY);
        if(siteObj == null){
            LOGGER.error("Session中存储的站点信息为空！");
            throw new V5CMSSessionValueNullException("Session中存储的站点信息为空！");
        }
        Site site = (Site)siteObj;
        PrintWriter out = response.getWriter();
        response.setHeader("Content-Type" , "text/html");

        String realPath = HttpUtils.getRealPath(request,"/");//request.getSession().getServletContext().getRealPath("/");
        out.write(new ActionEnter(null,request,realPath,site.getSiteId()+"").exec());
        out.flush();
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public void ueditorUpload(MultipartFile upfile,HttpServletRequest request,HttpServletResponse response) throws IOException {
        Object siteObj = request.getSession().getAttribute(SystemConstant.SITE_SESSION_KEY);
        if(siteObj == null){
            LOGGER.error("Session中存储的站点信息为空！");
            throw new V5CMSSessionValueNullException("Session中存储的站点信息为空！");
        }
        Site site = (Site)siteObj;

        PrintWriter out = response.getWriter();
        response.setHeader("Content-Type" , "text/html");

        String realPath = HttpUtils.getRealPath(request,"/");//request.getSession().getServletContext().getRealPath("/");
        String uploadFileInfo = new ActionEnter(upfile, request, realPath,site.getSiteId()+"").exec();
        out.write(uploadFileInfo);
        out.flush();
    }
}

package cn.v5cn.v5cms.controller;

import cn.v5cn.v5cms.entity.Link;
import cn.v5cn.v5cms.entity.Site;
import cn.v5cn.v5cms.service.LinkService;
import cn.v5cn.v5cms.util.HttpUtils;
import cn.v5cn.v5cms.util.SystemConstant;
import cn.v5cn.v5cms.util.SystemUtils;
import com.baidu.ueditor.PathFormat;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static cn.v5cn.v5cms.util.MessageSourceHelper.getMessage;

/**
 * Created by ZXF-PC1 on 2015/7/22.
 */

@Controller
@RequestMapping(value = "/manager/link")
public class LinkController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LinkController.class);

    @Autowired
    private LinkService linkService;

    @RequestMapping(value = "/list/{p}",method = {RequestMethod.GET,RequestMethod.POST})
    public String linkList(Link link,@PathVariable Integer p,HttpServletRequest request,ModelMap modelMap){
        Session session = SystemUtils.getShiroSession();
        if(StringUtils.isNotBlank(link.getLinkName())){
            session.setAttribute("linkSearch",link);
            modelMap.addAttribute("searchLink",link);
        }else{
            session.setAttribute("linkSearch",null);
        }
        Object searchObj = session.getAttribute("linkSearch");

        Page<Link> result =  linkService.findLinkPageable((searchObj == null ? (new Link()) : ((Link) searchObj)), p);

        modelMap.addAttribute("links",result.getContent());
        modelMap.addAttribute("pagination", SystemUtils.pagination(result, HttpUtils.getContextPath(request) + "/manager/link/list"));
        return "link/link_list";
    }

    @RequestMapping(value = "/edit/{linkId}",method = RequestMethod.GET)
    public String linkEdit(@PathVariable Long linkId,ModelMap modelMap){
        if(linkId == null || linkId == 0){
            modelMap.addAttribute(new Link());
            return "link/link_edit";
        }
        Link link = linkService.findOne(linkId);
        modelMap.addAttribute(link);
        return "link/link_edit";
    }

    @ResponseBody
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public ImmutableMap<String,Object> linkEdit(@Valid Link link,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            Map<String, Object> errorMessage = Maps.newHashMap();
            errorMessage.put("status", 0);
            List<FieldError> fes = bindingResult.getFieldErrors();
            for (FieldError fe : fes) {
                errorMessage.put(fe.getField(), fe.getDefaultMessage());
            }
            return ImmutableMap.<String, Object>builder().putAll(errorMessage).build();
        }

        if(link.getLinkId() == null || link.getLinkId() == 0){
            Link result = linkService.save(link);
            if(result == null || result.getLinkId() == null || result.getLinkId() == 0){
                LOGGER.warn("内容链接失败，链接{}",result);
                return ImmutableMap.<String, Object>of("status","0","message",getMessage("link.addfailed.message"));
            }
            LOGGER.info("内容添加成功，链接ID{}",result.getLinkId());
            return ImmutableMap.<String, Object>of("status","1","message",getMessage("link.addsuccess.message"));
        }
        try {
            linkService.save(link);
        } catch (Exception e) {
            LOGGER.error("链接修改失败,{}", e);
            return ImmutableMap.<String, Object>of("status","0","message",getMessage("link.updatefailed.message"));
        }
        LOGGER.info("链接添加成功,{}", link);
        return ImmutableMap.<String, Object>of("status","1","message",getMessage("link.updatesuccess.message"));
    }

    @ResponseBody
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public ImmutableMap<String,String> linkImgUpload(MultipartFile file,HttpServletRequest request){
        if(file.isEmpty()){
            return ImmutableMap.of("status", "0", "message", getMessage("global.uploadempty.message"));
        }
        Site site = (Site)(SystemUtils.getSessionSite());
        String linkPath = PathFormat.parseSiteId(SystemConstant.LINK_RES_PATH, site.getSiteId() + "");
        String realPath = HttpUtils.getRealPath(request, linkPath);

        SystemUtils.isNotExistCreate(realPath);

        String timeFileName = SystemUtils.timeFileName(file.getOriginalFilename());
        try {
            file.transferTo(new File(realPath + "/" + timeFileName));
        } catch (IOException e) {
            LOGGER.error("链接图片添加失败，错误：{}",e.getMessage());
            return ImmutableMap.of("status","0","message",getMessage("link.uploaderror.message"));
        }
        return ImmutableMap.of("status","1","message",getMessage("link.uploadsuccess.message"),
                "filePath",(linkPath + "/" + timeFileName),"contentPath", HttpUtils.getBasePath(request));
    }

    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ImmutableMap<String,String> linkDelete(Long[] linkIds,HttpSession session){
        try {
            if(linkIds == null || linkIds.length == 0) {
                LOGGER.warn("要删除链接的ID为空！");
                return ImmutableMap.of("status","0","message",getMessage("link.deletefailed.message"));
            }
            List<Link> links = linkService.findAll(linkIds);
            String realPath = session.getServletContext().getRealPath("");
            List<File> deleteFiles = Lists.newArrayList();
            File deleteFile;
            for(Link link : links){
                if(link.getLinkPic() == null || "".equals(link.getLinkPic())) continue;
                deleteFile = new File(realPath + link.getLinkPic());
                deleteFiles.add(deleteFile);
            }
            linkService.deleteInBatch(links);
            deleteLinkRes(deleteFiles);
        } catch (Exception e) {
            LOGGER.error("链接信息删除失败，失败原因：{}",e.getMessage());
            return ImmutableMap.of("status","0","message",getMessage("link.deletefailed.message"));
        }
        LOGGER.info("链接信息删除成功，ID为{}",StringUtils.join(linkIds,","));
        return ImmutableMap.of("status","1","message",getMessage("link.deletesuccess.message"));
    }

    private void deleteLinkRes(List<File> files){
        for(File file : files){
            if(!file.exists()) continue;
            file.delete();
        }
    }
}

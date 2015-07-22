package cn.v5cn.v5cms.controller;

import cn.v5cn.v5cms.service.ColumnService;
import cn.v5cn.v5cms.service.ContentService;
import cn.v5cn.v5cms.entity.*;
import cn.v5cn.v5cms.entity.wrapper.ZTreeNode;
import cn.v5cn.v5cms.util.HttpUtils;
import cn.v5cn.v5cms.util.SystemUtils;
import com.google.common.collect.ImmutableMap;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static cn.v5cn.v5cms.util.MessageSourceHelper.getMessage;

/**
 * Created by ZYW on 2014/11/17.
 */
@Controller
@RequestMapping("/manager/content")
public class ContentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContentController.class);

    @Autowired
    private ColumnService columnService;

    @Autowired
    private ContentService contentService;

    @RequestMapping(value = "/list/{cid}/{p}",method = {RequestMethod.GET,RequestMethod.POST})
    public String contentList(Content content,@PathVariable Long cid,@PathVariable Integer p,HttpServletRequest request,ModelMap modelMap){
        Session session = SecurityUtils.getSubject().getSession();
        if(content.getState() != null && content.getState() != 0){
            session.setAttribute("contentFilter",content);
            modelMap.addAttribute("contentFilter", content);
        } else if(cid != 0L) {
            Column column = new Column();
            column.setColsId(cid);
            content.setColumn(column);
            session.setAttribute("contentFilter", content);
        } else {
            session.setAttribute("contentFilter",null);
        }
        Object content_obj = session.getAttribute("contentFilter");

        content = content_obj == null ? new Content() : ((Content) content_obj);

        Site site = (Site)(SystemUtils.getSessionSite());
        content.setSiteId(site.getSiteId());

        if(cid != 0L) {
            Column column = columnService.findOne(cid);
            modelMap.addAttribute("colName",column.getColumnName());
        }

        Page<Content> pageContents = contentService.findContentPageable(content, p);
        modelMap.addAttribute("contents",pageContents.getContent());
        modelMap.addAttribute("pagination", SystemUtils.pagination(pageContents, HttpUtils.getContextPath(request) + "/manager/content/list"));
        return "content/content_list";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String contentEdit(ModelMap modelMap){

        Content content = new Content();
        content.setColumn(new Column());
        modelMap.addAttribute(content);

        return "content/content_edit";
    }

    @RequestMapping(value = "/edit/{cid}",method = RequestMethod.GET)
    public String contentEdit(@PathVariable Long cid,ModelMap modelMap){
        LOGGER.debug("内容ID：{}",cid);

        Content content = contentService.findOne(cid);
        modelMap.addAttribute(content);
        modelMap.addAttribute("page_title","内容编辑");

        return "content/content_edit";
    }

    @ResponseBody
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public ImmutableMap<String,String> contentSave(Content content){
        SystemUser user = (SystemUser)SystemUtils.getSessionUser();
        Site site = (Site)(SystemUtils.getSessionSite());
        content.setWriterId(user.getId());
        content.setSiteId(site.getSiteId());
        content.setLastdt(DateTime.now().toDate());
        if(content.getContentId() == null || content.getContentId() == 0L){

            Content result = contentService.save(content);
            if(result != null && result.getContentId() != null){
                LOGGER.info("内容添加成功，内容ID{}",result.getContentId());
                return ImmutableMap.of("status","1","message",getMessage("content.addsuccess.message"));
            }

            LOGGER.info("内容添加失败，内容标题{}",result.getCname());
            return ImmutableMap.of("status","0","message",getMessage("content.addfailed.message"));
        }
        //修改
        try {
            contentService.save(content);
        } catch (Exception e) {
            LOGGER.error("内容修改失败,{}",e);
            e.printStackTrace();
            return ImmutableMap.of("status","0","message",getMessage("content.updatefailed.message"));
        }
        LOGGER.info("内容添加成功,{}", content);
        return ImmutableMap.of("status","1","message",getMessage("content.updatesuccess.message"));
    }

    @ResponseBody
    @RequestMapping(value = "/tree/json",method = RequestMethod.POST)
    public ZTreeNode columnTree(){
        List<ZTreeNode> treeNodes = columnService.buildTreeNode(0L);
        ZTreeNode rootNode = new ZTreeNode();
        rootNode.setId(0L);
        rootNode.setName("栏目树");
        rootNode.setChildren(treeNodes);
        LOGGER.debug("treeNodes: " + treeNodes);
        return rootNode;
    }
}

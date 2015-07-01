package cn.v5cn.v5cms.action;

import cn.v5cn.v5cms.biz.ContentBiz;
import cn.v5cn.v5cms.entity.*;
import cn.v5cn.v5cms.util.HttpUtils;
import cn.v5cn.v5cms.util.SystemConstant;
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

import static cn.v5cn.v5cms.util.MessageSourceHelper.getMessage;

/**
 * Created by ZYW on 2014/11/17.
 */
@Controller
@RequestMapping("/manager/content")
public class ContentAction {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContentAction.class);

    @Autowired
    private ContentBiz contentBiz;

    @RequestMapping(value = "/list/{p}",method = {RequestMethod.GET,RequestMethod.POST})
    public String contentList(Content content,@PathVariable Integer p,HttpServletRequest request,ModelMap modelMap){
        Session session = SecurityUtils.getSubject().getSession();
        if(content.getColumn() != null && content.getColumn().getColsId() != null){
            session.setAttribute("contentFilter",content);
            //modelMap.addAttribute("columnIdFilter",columnType.getColTypeName());
        }else {
            session.setAttribute("contentFilter",null);
        }
        Object content_obj = session.getAttribute("contentFilter");

        content = content_obj == null ? new Content() : ((Content) content_obj);

        Site site = (Site)(SystemUtils.getSessionSite());
        content.setSiteId(site.getSiteId());

        Page<Content> pageContents = contentBiz.findContentPageable(content, p);
        modelMap.addAttribute("contents",pageContents.getContent());
        modelMap.addAttribute("pagination", SystemUtils.pagination(pageContents, HttpUtils.getContextPath(request) + "/manager/content/list"));
        return "content_list";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String contentEdit(){
        return "content_edit";
    }

    @ResponseBody
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ImmutableMap<String,String> contentSave(Content content){
        Session session = SystemUtils.getShiroSession();
        SystemUser user = (SystemUser)session.getAttribute(SystemConstant.SESSION_KEY);
        content.setWriterId(user.getId());
        content.setLastdt(DateTime.now().toDate());
        Site site = (Site)(SystemUtils.getSessionSite());
        content.setSiteId(site.getSiteId());

        Content result = contentBiz.save(content);
        if(result != null && result.getContentId() != null){
            LOGGER.info("内容添加成功，内容ID{}",result.getContentId());
            return ImmutableMap.of("status","1","message",getMessage("content.addsuccess.message"));
        }

        LOGGER.info("内容添加失败，内容标题{}",result.getCname());
        return ImmutableMap.of("status","0","message",getMessage("content.addfailed.message"));
    }
}

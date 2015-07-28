package cn.v5cn.v5cms.controller;

import cn.v5cn.v5cms.entity.Comments;
import cn.v5cn.v5cms.service.CommentsService;
import cn.v5cn.v5cms.util.HttpUtils;
import cn.v5cn.v5cms.util.SystemUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ZXF-PC1 on 2015/7/28.
 */
@Controller
@RequestMapping("/manager/comment")
public class CommentsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommentsController.class);

    @Autowired
    private CommentsService commentsService;

    @RequestMapping(value = "/list/{p}",method = {RequestMethod.GET,RequestMethod.POST})
    public String commentsList(Comments comment,@PathVariable Integer p,HttpServletRequest request,ModelMap modelMap){
        Session session = SystemUtils.getShiroSession();
        if(StringUtils.isNotBlank(comment.getCommentContent())){
            session.setAttribute("commentsSearch",comment);
            modelMap.addAttribute("searchComments",comment);
        }else{
            session.setAttribute("commentsSearch",null);
        }
        Object searchObj = session.getAttribute("commentsSearch");

        Page<Comments> result =  commentsService.findCommentsPageable((searchObj == null ? (new Comments()) : ((Comments) searchObj)), p);

        modelMap.addAttribute("comments",result.getContent());
        modelMap.addAttribute("pagination", SystemUtils.pagination(result, HttpUtils.getContextPath(request) + "/manager/comment/list"));
        return "comments/comments_list";
    }
}

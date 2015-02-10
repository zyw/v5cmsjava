package cn.v5cn.v5cms.action;

import cn.v5cn.v5cms.biz.ContentBiz;
import cn.v5cn.v5cms.entity.Content;
import cn.v5cn.v5cms.entity.Manager;
import cn.v5cn.v5cms.util.SystemConstant;
import com.google.common.collect.ImmutableMap;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

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
    public String contentList(){
        return "content_list";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String contentEdit(){
        return "content_edit";
    }

    @ResponseBody
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ImmutableMap<String,String> contentSave(Content content,HttpSession session){
        System.out.println(content);
        Manager manager = (Manager)session.getAttribute(SystemConstant.SESSION_KEY);
        content.setWriterId(manager.getManagerId());
        content.setLastdt(DateTime.now().toDate());
        Content result = contentBiz.save(content);
        if(result != null && result.getContentId() != null){
            LOGGER.info("内容添加成功，内容ID{}",result.getContentId());
            return ImmutableMap.of("status","1","message",getMessage("content.addsuccess.message"));
        }

        LOGGER.info("内容添加失败，内容标题{}",result.getCname());
        return ImmutableMap.of("status","0","message",getMessage("content.addfailed.message"));
    }
}

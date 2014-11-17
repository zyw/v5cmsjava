package cn.v5cn.v5cms.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ZYW on 2014/11/17.
 */
@Controller
@RequestMapping("/manager/content")
public class ContentAction {

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String contentList(){
        return "content_list";
    }
}

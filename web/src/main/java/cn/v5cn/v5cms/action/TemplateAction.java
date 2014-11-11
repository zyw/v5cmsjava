package cn.v5cn.v5cms.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ZYW on 2014/8/13.
 */
@Controller
@RequestMapping("/manager/tpl")
public class TemplateAction {

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String tplList(){
        return "tpl_list";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String tplEdit(){
        return "tpl_edit";
    }
}

package cn.v5cn.v5cms.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ZYW on 2014/8/13.
 */
@Controller
@RequestMapping("/manager")
public class TemplateAction {

    @RequestMapping(value = "/tpllist",method = RequestMethod.GET)
    public String tplList(){
        return "backstage/tpl_list";
    }

    @RequestMapping(value = "/tpledit",method = RequestMethod.GET)
    public String tplEdit(){
        return "backstage/tpl_edit";
    }
}

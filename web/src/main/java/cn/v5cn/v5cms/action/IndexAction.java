package cn.v5cn.v5cms.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ZYW on 2014/5/30.
 */
@Controller
@RequestMapping("/manager")
public class IndexAction {
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "backstage/index";
    }
}

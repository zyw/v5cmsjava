package cn.v5cn.v5cms.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ZYW on 2014/5/30.
 */
@Controller
public class IndexAction {
    @RequestMapping(value = {"/"},method = RequestMethod.GET)
    public String index(){
        System.out.println("------------");
        return "index";
    }
}

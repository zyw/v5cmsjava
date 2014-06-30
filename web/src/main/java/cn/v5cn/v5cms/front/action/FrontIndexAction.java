package cn.v5cn.v5cms.front.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ZYW on 2014/6/30.
 */
@Controller
public class FrontIndexAction {

    @RequestMapping(value = {"/"})
    public String index(){
        return "front";
    }
}

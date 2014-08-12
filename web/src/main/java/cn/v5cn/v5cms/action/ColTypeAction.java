package cn.v5cn.v5cms.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ZYW on 2014/8/12.
 */
@Controller
@RequestMapping("/manager")
public class ColTypeAction {

    @RequestMapping(value = "/coltypelist",method = RequestMethod.GET)
    public String colTypeList(){
        return "backstage/coltype_list";
    }

    @RequestMapping(value = "/coltypeaup",method = RequestMethod.GET)
    public String colTypeaup(){
        return "backstage/coltype_au";
    }
}

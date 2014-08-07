package cn.v5cn.v5cms.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ZYW on 2014/8/7.
 */
@Controller
@RequestMapping("/manager")
public class ColumnAction {

    @RequestMapping(value = "/collist",method = RequestMethod.GET)
    public String columnList(){
        return "backstage/column_list";
    }
}

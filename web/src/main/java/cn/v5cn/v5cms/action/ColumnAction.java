package cn.v5cn.v5cms.action;

import cn.v5cn.v5cms.biz.ColumnBiz;
import cn.v5cn.v5cms.entity.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by ZYW on 2014/8/7.
 */
@Controller
@RequestMapping("/manager")
public class ColumnAction {

    @Autowired
    private ColumnBiz columnBiz;

    @RequestMapping(value = "/collist",method = RequestMethod.GET)
    public String columnList(ModelMap modelMap){
        List<Column> columns = columnBiz.findAll();
        System.out.println(columns);
        modelMap.addAttribute("columns",columns);
        return "backstage/column_list";
    }
}

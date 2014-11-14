package cn.v5cn.v5cms.action;

import cn.v5cn.v5cms.biz.ColumnBiz;
import cn.v5cn.v5cms.biz.ColumnTypeBiz;
import cn.v5cn.v5cms.entity.Column;
import cn.v5cn.v5cms.entity.ColumnType;
import cn.v5cn.v5cms.entity.Site;
import cn.v5cn.v5cms.exception.V5CMSSessionValueNullException;
import cn.v5cn.v5cms.util.SystemConstant;
import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

import static cn.v5cn.v5cms.util.MessageSourceHelper.getMessage;

/**
 * Created by ZYW on 2014/8/7.
 */
@Controller
@RequestMapping("/manager/column")
public class ColumnAction {

    private static final Logger LOGGER = LoggerFactory.getLogger(ColumnAction.class);

    @Autowired
    private ColumnBiz columnBiz;

    @Autowired
    private ColumnTypeBiz columnTypeBiz;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String columnList(ModelMap modelMap,HttpSession session){
        Object siteObj = session.getAttribute(SystemConstant.SITE_SESSION_KEY);
        if(siteObj == null){
            LOGGER.error("Session中存储的站点信息为空！");
            throw new V5CMSSessionValueNullException("Session中存储的站点信息为空！");
        }
        Site site = (Site)siteObj;
        List<Column> columns = columnBiz.findOrderByParentIdsAndColsId(site.getSiteId());
        System.out.println(columns);
        modelMap.addAttribute("columns",columns);
        return "column_list";
    }

    @RequestMapping(value = "/edit/{columnId}",method = RequestMethod.GET)
    public String columnEdit(@PathVariable Long columnId,ModelMap modelMap){
        Column column = new Column();
        if(columnId == 0){
            column.setParentIds("0/");
            column.setParentId(0L);
            modelMap.addAttribute("column",column);
            modelMap.addAttribute("parentName","一级栏目");
        }else{
            Column dbColumn = columnBiz.findOne(columnId);
            column.setParentIds(dbColumn.getParentIds()+dbColumn.getColsId()+"/");
            column.setParentId(dbColumn.getColsId());
            modelMap.addAttribute("parentName",dbColumn.getColumnName());
            modelMap.addAttribute("column",column);
        }
        List<ColumnType> colTypes = columnTypeBiz.findAll();
        modelMap.addAttribute("colTypes",colTypes);
        return "column_edit";
    }

    @ResponseBody
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public ImmutableMap<String,String> columnEdits(Column column,HttpSession session){
        //设置站点ID
        Object siteObj = session.getAttribute(SystemConstant.SITE_SESSION_KEY);
        if(siteObj == null){
            LOGGER.error("Session中存储的站点信息为Null！");
            throw new V5CMSSessionValueNullException("Session中存储的站点信息为Null！");
        }
        Site site = (Site)siteObj;
        column.setSiteId(site.getSiteId());

        column = columnBiz.save(column);
        if(column.getColsId() != null){
            LOGGER.info("栏目添加成功,{}",column);
            return ImmutableMap.of("status","1","message",getMessage("column.addsuccess.message"));
        }
        LOGGER.error("栏目添加失败,{}",column);
        return ImmutableMap.of("status","0","message",getMessage("column.addfailed.message"));
    }
}

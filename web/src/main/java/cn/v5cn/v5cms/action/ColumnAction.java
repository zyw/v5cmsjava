package cn.v5cn.v5cms.action;

import cn.v5cn.v5cms.biz.ColumnBiz;
import cn.v5cn.v5cms.entity.Column;
import cn.v5cn.v5cms.entity.Site;
import cn.v5cn.v5cms.exception.V5CMSSessionValueNullException;
import cn.v5cn.v5cms.util.SystemConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by ZYW on 2014/8/7.
 */
@Controller
@RequestMapping("/manager/column")
public class ColumnAction {

    private static final Logger LOGGER = LoggerFactory.getLogger(ColumnAction.class);

    @Autowired
    private ColumnBiz columnBiz;

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

    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String columnEdit(){
        return "column_edit";
    }
}

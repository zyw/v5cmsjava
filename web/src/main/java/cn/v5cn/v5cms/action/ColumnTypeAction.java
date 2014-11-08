package cn.v5cn.v5cms.action;

import cn.v5cn.v5cms.biz.ColumnTypeBiz;
import cn.v5cn.v5cms.entity.ColumnType;
import cn.v5cn.v5cms.entity.Site;
import cn.v5cn.v5cms.exception.V5CMSNullValueException;
import cn.v5cn.v5cms.exception.V5CMSSessionValueNullException;
import cn.v5cn.v5cms.util.HttpUtils;
import cn.v5cn.v5cms.util.SystemConstant;
import cn.v5cn.v5cms.util.SystemUtils;
import cn.v5cn.v5cms.util.TwoTuple;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

import static cn.v5cn.v5cms.util.MessageSourceHelper.getMessage;

/**
 * Created by ZYW on 2014/8/12.
 */
@Controller
@RequestMapping("/manager/coltype")
public class ColumnTypeAction {

    private static final Logger LOGGER = LoggerFactory.getLogger(ColumnTypeAction.class);

    @Autowired
    private ColumnTypeBiz columnTypeBiz;

    @RequestMapping(value = "/list/{p}",method = RequestMethod.GET)
    public String colTypeList(ColumnType columnType,@PathVariable Integer p,HttpSession session,HttpServletRequest request,ModelMap modelMap){
        if(StringUtils.isNotBlank(columnType.getColTypeName())){
            session.setAttribute("columnTypeSearch",columnType);
            modelMap.addAttribute("colTypeNameSearch",columnType.getColTypeName());
        }else {
            session.setAttribute("columnTypeSearch",null);
        }
        Object searchObj = session.getAttribute("columnTypeSearch");
        Page<ColumnType> pageColumnTypes = columnTypeBiz.findColumnTypeByColTypeNamePageable((searchObj == null ? (new ColumnType()) : ((ColumnType) searchObj)), p);
        modelMap.addAttribute("cts",pageColumnTypes.getContent());
        modelMap.addAttribute("pagination", SystemUtils.pagination(pageColumnTypes, HttpUtils.getContextPath(request) + "/manager/coltype/list"));
        return "backstage/coltype_list";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String columnTypeEdit(ModelMap modelMap,HttpSession session){
        Object siteObj = session.getAttribute(SystemConstant.SITE_SESSION_KEY);
        if(siteObj == null){
            LOGGER.error("Session中存储的站点信息为Null！");
            throw new V5CMSSessionValueNullException("Session中存储的站点信息为Null！");
        }
        Site site = (Site)siteObj;
        String templateBasePath = session.getServletContext().getRealPath(SystemConstant.SITE_TEMPLATE_PATH);
        String themeName = site.getThemeName();
        if(StringUtils.isBlank(themeName)){
            LOGGER.error("{}站点没有保存主题信息",site.getSiteName());
            throw new V5CMSNullValueException("站点没有保存主题信息");
        }
        File templateFile = new File(templateBasePath+File.separator+themeName);
        List<TwoTuple<String,String>> mapList = columnTypeBiz.templatePathAndName(templateFile);


        List<TwoTuple<String,String>> result = Lists.newArrayList();
        for(TwoTuple<String,String> nameAndUri : mapList){
            String uri = StringUtils.remove(nameAndUri.b, templateBasePath + File.separator + themeName);
            result.add(new TwoTuple<String, String>(nameAndUri.a,uri));
        }
        System.out.println(result);

        modelMap.addAttribute("templates",result);
        return "backstage/coltype_edit";
    }

    @ResponseBody
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public ImmutableMap<String,String> columnTypeEdit(ColumnType columnType){
        ColumnType saveColType = columnTypeBiz.save(columnType);
        if(saveColType.getColTypeId() != null){
            LOGGER.info("栏目类型添加成功，{}",saveColType);
            return ImmutableMap.of("status","1","message",getMessage("column.type.addsuccess.message"));
        }
        LOGGER.info("栏目类型添加失败，{}",saveColType);
        return ImmutableMap.of("status","0","message",getMessage("column.type.addfailed.message"));
    }
}

package cn.v5cn.v5cms.front.controller;

import cn.v5cn.v5cms.entity.Column;
import cn.v5cn.v5cms.entity.Site;
import cn.v5cn.v5cms.service.ColumnService;
import cn.v5cn.v5cms.util.SystemConstant;
import cn.v5cn.v5cms.util.SystemUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ZXF-PC1 on 2015/7/29.
 */
@Controller
@RequestMapping("/nav")
public class FrontColumnController {

    @Autowired
    private ColumnService columnService;

    @RequestMapping(value = "/{navId}.htm")
    public String columnList(@PathVariable Long navId,HttpServletRequest request,ModelMap modelMap){
        Site site = (Site)request.getSession().getAttribute(SystemConstant.FRONT_SITE_SESSION_KEY);
        Column column = columnService.findOne(navId);
        modelMap.addAttribute(column);

        String coltpl = FilenameUtils.removeExtension(SystemUtils.formatUri(column.getColumnType().getColtpl()));
        return site.getThemeName() + "/" + coltpl;
    }
}

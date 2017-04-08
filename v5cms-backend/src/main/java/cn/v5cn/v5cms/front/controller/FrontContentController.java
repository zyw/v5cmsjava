package cn.v5cn.v5cms.front.controller;

import cn.v5cn.v5cms.entity.Content;
import cn.v5cn.v5cms.entity.Site;
import cn.v5cn.v5cms.service.ContentService;
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
 * Created by zyw on 15/8/6.
 */
@Controller
@RequestMapping("/content")
public class FrontContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping(value = "/{contentId}.htm")
    public String contentInfo(@PathVariable Long contentId,ModelMap modelMap,HttpServletRequest request) {
        Site site = (Site)request.getSession().getAttribute(SystemConstant.FRONT_SITE_SESSION_KEY);
        Content content = contentService.findOne(contentId);

        modelMap.addAttribute("content",content);

        String contpl = FilenameUtils.removeExtension(SystemUtils.formatUri(content.getColumn().getColumnType().getContenttpl()));
        return site.getThemeName() + "/" + contpl;
    }
}

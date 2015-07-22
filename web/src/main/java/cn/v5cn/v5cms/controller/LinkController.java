package cn.v5cn.v5cms.controller;

import cn.v5cn.v5cms.entity.Link;
import cn.v5cn.v5cms.service.LinkService;
import cn.v5cn.v5cms.util.HttpUtils;
import cn.v5cn.v5cms.util.SystemUtils;
import com.google.common.collect.ImmutableMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static cn.v5cn.v5cms.util.MessageSourceHelper.getMessage;

/**
 * Created by ZXF-PC1 on 2015/7/22.
 */

@Controller
@RequestMapping(value = "/manager/link")
public class LinkController {

    @Autowired
    private LinkService linkService;

    @RequestMapping(value = "/list/{p}",method = {RequestMethod.GET,RequestMethod.POST})
    public String linkList(Link link,@PathVariable Integer p,HttpServletRequest request,ModelMap modelMap){
        Session session = SystemUtils.getShiroSession();
        if(StringUtils.isNotBlank(link.getLinkName())){
            session.setAttribute("linkSearch",link);
            modelMap.addAttribute("searchLink",link);
        }else{
            session.setAttribute("linkSearch",null);
        }
        Object searchObj = session.getAttribute("linkSearch");

        Page<Link> result =  linkService.findLinkPageable((searchObj == null ? (new Link()) : ((Link) searchObj)), p);

        modelMap.addAttribute("links",result.getContent());
        modelMap.addAttribute("pagination", SystemUtils.pagination(result, HttpUtils.getContextPath(request) + "/manager/link/list"));
        return "link/link_list";
    }

    @RequestMapping(value = "/edit/{linkId}",method = RequestMethod.GET)
    public String linkEdit(@PathVariable Long linkId,ModelMap modelMap){

        modelMap.addAttribute(new Link());

        return "link/link_edit";
    }

    @ResponseBody
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public ImmutableMap<String,String> linkEdit(@Valid Link link,BindingResult bindingResult){
        return ImmutableMap.<String, String>of("status","1","message",getMessage("role.addsuccess.message"));
    }
}

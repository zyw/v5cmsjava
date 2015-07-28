package cn.v5cn.v5cms.controller;

import cn.v5cn.v5cms.entity.LeaveWordType;
import cn.v5cn.v5cms.service.LeaveWordTypeService;
import cn.v5cn.v5cms.util.HttpUtils;
import cn.v5cn.v5cms.util.SystemUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ZXF-PC1 on 2015/7/28.
 */
@Controller
@RequestMapping("/manager/lwt")
public class LeaveWordTypeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LeaveWordTypeController.class);

    @Autowired
    private LeaveWordTypeService leaveWordTypeService;

    @RequestMapping(value = "/list/{p}",method = {RequestMethod.GET,RequestMethod.POST})
    public String lwtList(LeaveWordType lwt,@PathVariable Integer p,HttpServletRequest request,ModelMap modelMap){
        Session session = SystemUtils.getShiroSession();
        if(StringUtils.isNotBlank(lwt.getName())){
            session.setAttribute("lwtSearch",lwt);
            modelMap.addAttribute("searchLwt",lwt);
        }else{
            session.setAttribute("lwtSearch",null);
        }
        Object searchObj = session.getAttribute("lwtSearch");

        Page<LeaveWordType> result =  leaveWordTypeService.findLeaveWordTypePageable((searchObj == null ? (new LeaveWordType()) : ((LeaveWordType) searchObj)), p);

        modelMap.addAttribute("lwts",result.getContent());
        modelMap.addAttribute("pagination", SystemUtils.pagination(result, HttpUtils.getContextPath(request) + "/manager/lwt/list"));
        return "leave-word/lwt_list";
    }
}

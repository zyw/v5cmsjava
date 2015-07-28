package cn.v5cn.v5cms.controller;

import cn.v5cn.v5cms.entity.LeaveWord;
import cn.v5cn.v5cms.service.LeaveWordService;
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
@RequestMapping("/manager/lw")
public class LeaveWordController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LeaveWordController.class);

    @Autowired
    private LeaveWordService leaveWordService;

    @RequestMapping(value = "/list/{p}",method = {RequestMethod.GET,RequestMethod.POST})
    public String leaveWordList(LeaveWord leaveWord,@PathVariable Integer p,HttpServletRequest request,ModelMap modelMap){
        Session session = SystemUtils.getShiroSession();
        if(StringUtils.isNotBlank(leaveWord.getTitle())){
            session.setAttribute("leaveWordSearch",leaveWord);
            modelMap.addAttribute("searchleaveWord",leaveWord);
        }else{
            session.setAttribute("leaveWordSearch",null);
        }
        Object searchObj = session.getAttribute("leaveWordSearch");

        Page<LeaveWord> result =  leaveWordService.findLeaveWordPageable((searchObj == null ? (new LeaveWord()) : ((LeaveWord) searchObj)), p);

        modelMap.addAttribute("leaveWords",result.getContent());
        modelMap.addAttribute("pagination", SystemUtils.pagination(result, HttpUtils.getContextPath(request) + "/manager/lw/list"));
        return "leave-word/lw_list";
    }
}

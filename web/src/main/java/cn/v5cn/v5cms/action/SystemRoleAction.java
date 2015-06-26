package cn.v5cn.v5cms.action;

import cn.v5cn.v5cms.biz.SystemRoleBiz;
import cn.v5cn.v5cms.entity.SystemRole;
import cn.v5cn.v5cms.util.HttpUtils;
import cn.v5cn.v5cms.util.SystemUtils;
import com.google.common.collect.ImmutableList;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by ZXF-PC1 on 2015/6/26.
 */
@Controller
@RequestMapping("/manager/role")
public class SystemRoleAction {

    @Autowired
    private SystemRoleBiz systemRoleBiz;

    @RequestMapping(value = "/list/{p}",method = {RequestMethod.GET,RequestMethod.POST})
    public String roleList(SystemRole role,@PathVariable Integer p,HttpSession session,HttpServletRequest request,ModelMap modelMap){
        if(StringUtils.isNotBlank(role.getName())){
            session.setAttribute("roleSearch",role);
            modelMap.addAttribute("searchRole",role);
        }else{
            session.setAttribute("roleSearch",null);
        }
        Object searchObj = session.getAttribute("roleSearch");

        Page<SystemRole> result =  systemRoleBiz.findRoleByRoleNamePageable((searchObj == null ? (new SystemRole()):((SystemRole)searchObj)),p);

        modelMap.addAttribute("roles",result);
        modelMap.addAttribute("pagination", SystemUtils.pagination(result, HttpUtils.getContextPath(request) + "/manager/role/list"));

        return "userauth/role_list";
    }
}

package cn.v5cn.v5cms.action;

import cn.v5cn.v5cms.biz.SystemUserBiz;
import cn.v5cn.v5cms.entity.SystemUser;
import cn.v5cn.v5cms.util.HttpUtils;
import cn.v5cn.v5cms.util.SystemUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.session.Session;
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
 * Created by ZXF-PC1 on 2015/6/18.
 */
@Controller
@RequestMapping("/manager/user")
public class SystemUserAction {
    @Autowired
    private SystemUserBiz systemUserBiz;

    @RequestMapping(value = "/list/{p}",method = {RequestMethod.GET,RequestMethod.POST})
    public String userList(SystemUser user,@PathVariable Integer p,HttpServletRequest request,ModelMap modelMap){
        Session session = SystemUtils.getShiroSession();
        if(StringUtils.isNotBlank(user.getName())){
            session.setAttribute("userSearch",user);
            modelMap.addAttribute("searchUser",user);
        }else{
            session.setAttribute("userSearch",null);
        }
        Object searchObj = session.getAttribute("userSearch");

        Page<SystemUser> result =  systemUserBiz.findUserByUserNamePageable((searchObj == null ? (new SystemUser()) : ((SystemUser) searchObj)), p);

        modelMap.addAttribute("users",result);
        modelMap.addAttribute("pagination", SystemUtils.pagination(result, HttpUtils.getContextPath(request) + "/manager/user/list"));

        return "userauth/user_list";
    }
}

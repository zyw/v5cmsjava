package cn.v5cn.v5cms.controller;

import cn.v5cn.v5cms.service.SystemUserService;
import cn.v5cn.v5cms.entity.SystemUser;
import cn.v5cn.v5cms.util.HttpUtils;
import cn.v5cn.v5cms.util.SystemUtils;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

import static cn.v5cn.v5cms.util.MessageSourceHelper.getMessage;

/**
 * Created by ZXF-PC1 on 2015/6/18.
 */
@Controller
@RequestMapping("/manager/user")
public class SystemUserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LinkController.class);

    @Autowired
    private SystemUserService systemUserService;

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

        Page<SystemUser> result =  systemUserService.findUserByUserNamePageable((searchObj == null ? (new SystemUser()) : ((SystemUser) searchObj)), p);

        modelMap.addAttribute("users",result);
        modelMap.addAttribute("pagination", SystemUtils.pagination(result, HttpUtils.getContextPath(request) + "/manager/user/list"));

        return "userauth/user_list";
    }
    @RequestMapping(value = "/edit/{userId}",method = RequestMethod.GET)
    public String userEdit(@PathVariable Long userId,ModelMap modelMap){
        if(userId == null || userId == 0){
            modelMap.addAttribute(new SystemUser());
            return "userauth/user_edit";
        }
        SystemUser user = systemUserService.findOne(userId);
        modelMap.addAttribute(user);
        return "userauth/user_edit";
    }

    @ResponseBody
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public ImmutableMap<String,Object> userEdit(@Valid SystemUser user,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            Map<String, Object> errorMessage = Maps.newHashMap();
            errorMessage.put("status", 0);
            List<FieldError> fes = bindingResult.getFieldErrors();
            for (FieldError fe : fes) {
                errorMessage.put(fe.getField(), fe.getDefaultMessage());
            }
            return ImmutableMap.<String, Object>builder().putAll(errorMessage).build();
        }

        //TODO 修改提示语为用户添加
        if(user.getId() == null || user.getId() == 0){
            SystemUser result = systemUserService.save(user);
            if(result == null || result.getId() == null || result.getId() == 0){
                LOGGER.warn("添加用户失败，用户{}",result);
                return ImmutableMap.<String, Object>of("status","0","message",getMessage("link.addfailed.message"));
            }
            LOGGER.info("用户添加成功，用户ID{}",result.getId());
            return ImmutableMap.<String, Object>of("status","1","message",getMessage("link.addsuccess.message"));
        }
        try {
            systemUserService.save(user);
        } catch (Exception e) {
            LOGGER.error("用户修改失败,{}", e);
            return ImmutableMap.<String, Object>of("status","0","message",getMessage("link.updatefailed.message"));
        }
        LOGGER.info("用户修改成功,{}", user);
        return ImmutableMap.<String, Object>of("status","1","message",getMessage("link.updatesuccess.message"));
    }
}

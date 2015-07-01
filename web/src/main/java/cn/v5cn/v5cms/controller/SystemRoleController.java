package cn.v5cn.v5cms.controller;

import cn.v5cn.v5cms.service.SystemRoleService;
import cn.v5cn.v5cms.entity.SystemRole;
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
 * Created by ZXF-PC1 on 2015/6/26.
 */
@Controller
@RequestMapping("/manager/role")
public class SystemRoleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SystemRoleController.class);

    @Autowired
    private SystemRoleService systemRoleService;

    @RequestMapping(value = "/list/{p}",method = {RequestMethod.GET,RequestMethod.POST})
    public String roleList(SystemRole role,@PathVariable Integer p,HttpServletRequest request,ModelMap modelMap){
        Session session = SystemUtils.getShiroSession();
        if(StringUtils.isNotBlank(role.getName())){
            session.setAttribute("roleSearch",role);
            modelMap.addAttribute("searchRole",role);
        }else{
            session.setAttribute("roleSearch",null);
        }
        Object searchObj = session.getAttribute("roleSearch");

        Page<SystemRole> result =  systemRoleService.findRoleByRoleNamePageable((searchObj == null ? (new SystemRole()):((SystemRole)searchObj)),p);

        modelMap.addAttribute("roles",result);
        modelMap.addAttribute("pagination", SystemUtils.pagination(result, HttpUtils.getContextPath(request) + "/manager/role/list"));

        return "userauth/role_list";
    }
    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String roleEdit(ModelMap model){
        model.addAttribute("role",new SystemRole());
        return "userauth/role_edit";
    }
    @ResponseBody
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public ImmutableMap<String,Object> addUpdateRole(String resIds,@Valid SystemRole role,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            Map<String, Object> errorMessage = Maps.newHashMap();
            errorMessage.put("status", 0);
            List<FieldError> fes = bindingResult.getFieldErrors();
            for (FieldError fe : fes) {
                errorMessage.put("message",fe.getField()+","+fe.getDefaultMessage());
            }
            return ImmutableMap.<String, Object>builder().putAll(errorMessage).build();
        }
        //新增操作
        if(role.getId() == null){
            Long result = systemRoleService.save(role,resIds);
            if(result !=null && result != 0L){
                LOGGER.info("新增角色成功，{}",role);
                return ImmutableMap.<String, Object>of("status","1","message",getMessage("role.addsuccess.message"));
            }
            LOGGER.warn("新增角色失败，{}",result);
            return ImmutableMap.<String, Object>of("status","0","message",getMessage("role.addfailed.message"));
        }
        //修改操作
        try {
            systemRoleService.save(role,resIds);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("修改角色失败，{},失败堆栈错误：{}",role,e.getMessage());
            return ImmutableMap.<String, Object>of("status","0","message",getMessage("role.updatefailed.message"));
        }
        LOGGER.info("修改角色成功，{}",role);
        return ImmutableMap.<String, Object>of("status","1","message",getMessage("role.updatesuccess.message"));
    }
}

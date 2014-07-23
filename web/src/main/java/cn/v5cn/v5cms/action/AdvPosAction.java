package cn.v5cn.v5cms.action;

import cn.v5cn.v5cms.biz.AdvPosBiz;
import cn.v5cn.v5cms.entity.AdvPos;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

import static cn.v5cn.v5cms.util.MessageSourceHelper.getMessage;

/**
 * Created by ZYW on 2014/7/23.
 */
@Controller
@RequestMapping("/manager")
public class AdvPosAction {
    private static final Logger LOGGER = LoggerFactory.getLogger(AdvPosAction.class);
    @Autowired
    private AdvPosBiz advPosBiz;

    @RequestMapping(value = "/advposlist",method = RequestMethod.GET)
    public String advPosList(ModelMap model){
        model.addAttribute("advposs", advPosBiz.finadAll());
        return "backstage/advpos_list";
    }

    @RequestMapping(value = "/advposaup",method = RequestMethod.GET)
    public String advPosaup(@RequestParam(required=false) Long advPosId,ModelMap model){
        if(advPosId == null){
            model.addAttribute("advpos",new AdvPos());
        }

        return "backstage/advpos_au";
    }

    @ResponseBody
    @RequestMapping(value = "/advposau",method = RequestMethod.POST)
    public ImmutableMap<String,Object> addUpdateAdvPos(@Valid AdvPos advPos,BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            Map<String, Object> errorMessage = Maps.newHashMap();
            errorMessage.put("status", 0);
            List<FieldError> fes = bindingResult.getFieldErrors();
            for (FieldError fe : fes) {
                errorMessage.put("message",fe.getField()+","+fe.getDefaultMessage());
            }
            return ImmutableMap.<String, Object>builder().putAll(errorMessage).build();
        }
        if(advPos.getAdvPosId() == null){
            AdvPos result = advPosBiz.save(advPos);
            if(result.getAdvPosId() !=null && result.getAdvPosId() != 0L){
                LOGGER.info("新增广告版位成功，{}",result);
                return ImmutableMap.<String, Object>of("status","1","message",getMessage("advpos.addsuccess.message"));
            }
            LOGGER.warn("新增广告版位失败，{}",result);
            return ImmutableMap.<String, Object>of("status","0","message",getMessage("advpos.addfailed.message"));
        }
        return ImmutableMap.of();
    }
}

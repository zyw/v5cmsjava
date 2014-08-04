package cn.v5cn.v5cms.action;

import cn.v5cn.v5cms.biz.AdvBiz;
import cn.v5cn.v5cms.biz.AdvPosBiz;
import cn.v5cn.v5cms.entity.Adv;
import cn.v5cn.v5cms.entity.AdvPos;
import cn.v5cn.v5cms.entity.wrapper.AdvWrapper;
import cn.v5cn.v5cms.util.HttpUtils;
import cn.v5cn.v5cms.util.SystemUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

import static cn.v5cn.v5cms.util.MessageSourceHelper.getMessage;

/**
 * Created by ZYW on 2014/7/24.
 */
@Controller
@RequestMapping("/manager")
public class AdvAction {

    private final static Logger LOGGER = LoggerFactory.getLogger(AdvAction.class);

    @Autowired
    private AdvPosBiz advPosBiz;
    @Autowired
    private AdvBiz advBiz;

    @RequestMapping(value = "/advlist",method = {RequestMethod.GET,RequestMethod.POST})
    public String advList(@ModelAttribute Adv adv,
                          @RequestParam(value = "p",defaultValue = "0")int currPage,
                          ModelMap modelMap,HttpServletRequest request){

        HttpSession session = request.getSession();
        if("GET".equalsIgnoreCase(request.getMethod())){
            adv = (Adv)session.getAttribute("search_adv");
        }
        if("POST".equalsIgnoreCase(request.getMethod())){
            session.setAttribute("search_adv",null);
            if(StringUtils.isNotBlank(adv.getAdvName()) || adv.getAdvPos().getAdvPosId() != null){
                session.setAttribute("search_adv",adv);
            }
        }
        Page<Adv> pageListAdv =  advBiz.findAdvByAdvNamePageable((adv == null ? (new Adv()):adv),currPage);
        modelMap.addAttribute("advs",pageListAdv);
        modelMap.addAttribute("pagination",SystemUtils.pagination(pageListAdv,HttpUtils.getBasePath(request)+"/manager/advlist"));
        ImmutableList<AdvPos> advposes = advPosBiz.finadAll();
        modelMap.addAttribute("aps",advposes);

        return "backstage/adv_list";
    }

    @RequestMapping(value = "/advaup",method = RequestMethod.GET)
    public String advPosaup(ModelMap model){
        ImmutableList<AdvPos> advposes = advPosBiz.finadAll();
        model.addAttribute("aps",advposes);
        model.addAttribute(new Adv());
        return "backstage/adv_au";
    }

    @RequestMapping(value = "/advaup/{advId}",method = RequestMethod.GET)
    public String advPosaup(@PathVariable Long advId,ModelMap model){
        ImmutableList<AdvPos> advposes = advPosBiz.finadAll();
        model.addAttribute("aps",advposes);
        model.addAttribute(advBiz.findOne(advId));
        return "backstage/adv_au";
    }

    @ResponseBody
    @RequestMapping(value = "/advau",method = RequestMethod.POST)
    public ImmutableMap<String,Object> advAU(@ModelAttribute("adv") AdvWrapper advWrapper){
        System.out.println(advWrapper);
        LOGGER.info("添加广告信息，{}",advWrapper);
        try {
            Adv adv= advBiz.save(advWrapper);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            LOGGER.error("添加广告时转换JSON出错！{}",e.getMessage());
            ImmutableMap.<String,Object>of("status","0","message",getMessage("adv.addfailed.message"));
        }
        return ImmutableMap.<String,Object>of("status","1","message",getMessage("adv.addsuccess.message"));
    }

    @ResponseBody
    @RequestMapping(value = "/advupload",method = RequestMethod.POST)
    public ImmutableMap<String,Object> advUploader(MultipartFile file,HttpServletRequest request){
        if(file.isEmpty()){
            return ImmutableMap.<String,Object>of("status","0","message",getMessage("global.uploadempty.message"));
        }
        String realPath = HttpUtils.getRealPath(request,"/WEB-INF/uploads/advfiles/");

        SystemUtils.isNotExistCreate(realPath);
        String timeFileName = SystemUtils.timeFileName(file.getOriginalFilename());
        try {
            file.transferTo(new File(realPath+"/"+timeFileName));
        } catch (IOException e) {
            e.printStackTrace();
            return ImmutableMap.<String,Object>of("status","0","message",getMessage("adv.uploaderror.message"));
        }
        return ImmutableMap.<String,Object>of("status","1","message",getMessage("adv.uploadsuccess.message"),
                "filePath","/r/advfiles/"+timeFileName,"contentPath", HttpUtils.getBasePath(request));
    }

    @ResponseBody
    @RequestMapping(value = "/deleteadvif",method = RequestMethod.POST)
    public ImmutableMap<String,Object> deleteAdvImage(String if_path,HttpServletRequest request){
        String fileExt = FilenameUtils.getExtension(if_path);
        String fileName = FilenameUtils.getName(if_path);
        String realPath = HttpUtils.getRealPath(request, "/WEB-INF/uploads/advfiles/");
        boolean result = FileUtils.deleteQuietly(new File(realPath+"/"+fileName));
        if(result){
            String successMessage = "swf".equalsIgnoreCase(fileExt)?getMessage("adv.flashdeletesuccess.message"):getMessage("adv.imagedeletesuccess.message");
            return ImmutableMap.<String,Object>of("status","1","message",successMessage);
        }
        String failedMessage = "swf".equalsIgnoreCase(fileExt)?getMessage("adv.flashdeletefailed.message"):getMessage("adv.imagedeletefailed.message");
        return ImmutableMap.<String,Object>of("status","0","message",failedMessage);
    }
}

package cn.v5cn.v5cms.action;

import cn.v5cn.v5cms.biz.AdvBiz;
import cn.v5cn.v5cms.biz.AdvPosBiz;
import cn.v5cn.v5cms.entity.Adv;
import cn.v5cn.v5cms.entity.AdvPos;
import cn.v5cn.v5cms.entity.wrapper.AdvWrapper;
import cn.v5cn.v5cms.util.HttpUtils;
import cn.v5cn.v5cms.util.SystemUtils;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

import static cn.v5cn.v5cms.util.MessageSourceHelper.getMessage;

/**
 * Created by ZYW on 2014/7/24.
 */
@Controller
@RequestMapping("/manager")
public class AdvAction {

    @Autowired
    private AdvPosBiz advPosBiz;
    @Autowired
    private AdvBiz advBiz;

    @RequestMapping(value = "/advlist",method = RequestMethod.GET)
    public String advList(){
        return "backstage/adv_list";
    }

    @RequestMapping(value = "/advaup",method = RequestMethod.GET)
    public String advPosaup(ModelMap model){
        ImmutableList<AdvPos> advposes = advPosBiz.finadAll();
        model.addAttribute("aps",advposes);
        model.addAttribute(new Adv());
        return "backstage/adv_au";
    }

    @ResponseBody
    @RequestMapping(value = "/advau",method = RequestMethod.POST)
    public ImmutableMap<String,Object> advAU(AdvWrapper advWrapper){
        System.out.println(advWrapper);
        return ImmutableMap.of();
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

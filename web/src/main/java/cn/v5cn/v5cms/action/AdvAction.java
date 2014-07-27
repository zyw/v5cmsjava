package cn.v5cn.v5cms.action;

import cn.v5cn.v5cms.util.HttpUtils;
import cn.v5cn.v5cms.util.SystemUtils;
import com.google.common.collect.ImmutableMap;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
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

    @RequestMapping(value = "/advlist",method = RequestMethod.GET)
    public String advList(){
        return "backstage/adv_list";
    }

    @RequestMapping(value = "/advaup",method = RequestMethod.GET)
    public String advPosaup(ModelMap model){
        //model.addAttribute("advpos",new AdvPos());
        return "backstage/adv_au";
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
    @RequestMapping(value = "/deleteadvimage",method = RequestMethod.POST)
    public ImmutableMap<String,Object> deleteAdvImage(String image_path,HttpServletRequest request){
        String fileName = FilenameUtils.getName(image_path);
        String realPath = HttpUtils.getRealPath(request, "/WEB-INF/uploads/advfiles/");
        boolean result = FileUtils.deleteQuietly(new File(realPath+"/"+fileName));
        if(result){
            return ImmutableMap.<String,Object>of("status","1","message",getMessage("adv.imagedeletesuccess.message"));
        }
        return ImmutableMap.<String,Object>of("status","0","message",getMessage("adv.imagedeletefailed.message"));
    }
}

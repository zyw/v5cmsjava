package cn.v5cn.v5cms.action;

import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

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
        String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/uploads/advfiles/");
        String timeName = DateTime.now().getMillis()+"";
        List<String> fileNames =  Splitter.on(".").splitToList(file.getOriginalFilename());
        String fileExts = fileNames.get(fileNames.size()-1);
        try {
            file.transferTo(new File(realPath+"/"+timeName + "."+fileExts));
        } catch (IOException e) {
            e.printStackTrace();
            return ImmutableMap.<String,Object>of("status","0","message",getMessage("adv.uploaderror.message"));
        }
        return ImmutableMap.<String,Object>of("status","0","message",getMessage("adv.uploaderror.message"),"filePath","/r/advfiles/"+timeName + "."+fileExts);
    }
}

package cn.v5cn.v5cms.controller;

import cn.v5cn.v5cms.service.AdvService;
import cn.v5cn.v5cms.service.AdvPosService;
import cn.v5cn.v5cms.entity.Adv;
import cn.v5cn.v5cms.entity.AdvPos;
import cn.v5cn.v5cms.entity.Site;
import cn.v5cn.v5cms.entity.wrapper.AdvWrapper;
import cn.v5cn.v5cms.exception.V5CMSNullValueException;
import cn.v5cn.v5cms.util.HttpUtils;
import cn.v5cn.v5cms.util.SystemConstant;
import cn.v5cn.v5cms.util.SystemUtils;
import com.baidu.ueditor.PathFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
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
import java.util.Map;

import static cn.v5cn.v5cms.util.MessageSourceHelper.getMessage;

/**
 * Created by ZYW on 2014/7/24.
 */
@Controller
@RequestMapping("/manager/adv")
public class AdvController {

    private final static Logger LOGGER = LoggerFactory.getLogger(AdvController.class);

    @Autowired
    private AdvPosService advPosService;
    @Autowired
    private AdvService advService;

    @RequestMapping(value = "/list/{p}",method = {RequestMethod.GET,RequestMethod.POST})
    public String advList(Adv adv,@PathVariable Integer p,HttpSession session,HttpServletRequest request,ModelMap modelMap){
        if(StringUtils.isNotBlank(adv.getAdvName())
                || (adv.getAdvPos() != null && adv.getAdvPos().getAdvPosId() != null)){
            session.setAttribute("advSearch",adv);
            modelMap.addAttribute("searchAdv",adv);
        }else{
            session.setAttribute("advSearch",null);
        }
        Object searchObj = session.getAttribute("advSearch");

        Page<Adv> result =  advService.findAdvByAdvNamePageable((searchObj == null ? (new Adv()):((Adv)searchObj)),p);

        modelMap.addAttribute("advs",result);
        modelMap.addAttribute("pagination",SystemUtils.pagination(result,HttpUtils.getContextPath(request)+"/manager/adv/list"));
        ImmutableList<AdvPos> advposes = advPosService.finadAll();
        modelMap.addAttribute("aps",advposes);

        return "setting/adv_list";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String advPosaup(ModelMap model){
        ImmutableList<AdvPos> advposes = advPosService.finadAll();
        model.addAttribute("aps",advposes);
        model.addAttribute(new Adv());
        model.addAttribute("advTypes", Maps.newHashMap());
        return "setting/adv_edit";
    }

    @RequestMapping(value = "/edit/{advId}",method = RequestMethod.GET)
    public String advEdit(@PathVariable Long advId,ModelMap model){
        ImmutableList<AdvPos> advposes = advPosService.finadAll();
        model.addAttribute("aps",advposes);
        Adv adv = advService.findOne(advId);

        if(adv == null){
            LOGGER.error("通过ID为{}没有查到广告信息。",advId);
            throw new V5CMSNullValueException("通过ID为"+advId+"没有查到广告信息。");
        }

        ObjectMapper jsonObj = new ObjectMapper();
        Map<String,String> advTypeMap = null;
        try {
            advTypeMap = jsonObj.readValue(adv.getAdvTypeInfo(),Map.class);
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("JSON转换Map对象异常，异常消息{}",e.getMessage());
        }
        model.addAttribute(adv);
        model.addAttribute("advTypes",advTypeMap);
        model.addAttribute("page_title",getMessage("adv.updatepage.title"));
        return "setting/adv_edit";
    }

    @ResponseBody
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public ImmutableMap<String,Object> advEdit(@ModelAttribute("adv") AdvWrapper advWrapper,HttpServletRequest request){
//        List<String> deleteFilePaths = (List<String>)request.getSession().getAttribute("adv_delete_file_real_path");
//        if(deleteFilePaths != null && deleteFilePaths.size() > 0){
//            for(String deleteFilePath : deleteFilePaths){
//                String fileExt = FilenameUtils.getExtension(deleteFilePath);
//                boolean result = FileUtils.deleteQuietly(new File(deleteFilePath));
//                if(!result){
//                    //String failedMessage = "swf".equalsIgnoreCase(fileExt)?getMessage("adv.flashdeletefailed.message"):getMessage("adv.imagedeletefailed.message");
//                    LOGGER.warn("广告图片或者Flash删除失败，名称{}",deleteFilePath);
//                    //return ImmutableMap.<String,Object>of("status","0","message",failedMessage);
//                }
//            }
//            request.getSession().setAttribute("adv_delete_file_real_path",null);
//        }

        if(advWrapper.getAdv().getAdvId() != null){
            try {
                advService.update(advWrapper);
                return ImmutableMap.<String,Object>of("status","1","message",getMessage("adv.updatesuccess.message"));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                LOGGER.error("修改广告失败，{}",e.getMessage());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                LOGGER.error("修改广告失败，{}",e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                LOGGER.error("修改广告失败，{}",e.getMessage());
            }
            return ImmutableMap.<String,Object>of("status","0","message",getMessage("adv.updatefailed.message"));
        }
        LOGGER.info("添加广告信息，{}",advWrapper);
        try {
            Adv adv= advService.save(advWrapper);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            LOGGER.error("添加广告时转换JSON出错！{}",e.getMessage());
            ImmutableMap.<String,Object>of("status","0","message",getMessage("adv.addfailed.message"));
        }
        return ImmutableMap.<String,Object>of("status","1","message",getMessage("adv.addsuccess.message"));
    }

    @ResponseBody
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public ImmutableMap<String,Object> advUploader(MultipartFile file,HttpServletRequest request){
        if(file.isEmpty()){
            return ImmutableMap.<String,Object>of("status","0","message",getMessage("global.uploadempty.message"));
        }
        Site site = (Site)(SystemUtils.getSessionSite());
        String advPath = PathFormat.parseSiteId(SystemConstant.ADV_RES_PATH, site.getSiteId() + "");
        String realPath = HttpUtils.getRealPath(request, advPath);

        SystemUtils.isNotExistCreate(realPath);

        String timeFileName = SystemUtils.timeFileName(file.getOriginalFilename());
        try {
            file.transferTo(new File(realPath+"/"+timeFileName));
        } catch (IOException e) {
            e.printStackTrace();
            return ImmutableMap.<String,Object>of("status","0","message",getMessage("adv.uploaderror.message"));
        }
        return ImmutableMap.<String,Object>of("status","1","message",getMessage("adv.uploadsuccess.message"),
                "filePath",advPath+timeFileName,"contentPath", HttpUtils.getBasePath(request));
    }

    @ResponseBody
    @RequestMapping(value = "/delete/if",method = RequestMethod.POST)
    public ImmutableMap<String,String> deleteAdvImage(String if_path,HttpServletRequest request){
//        Object siteObj = request.getSession().getAttribute(SystemConstant.SITE_SESSION_KEY);
//        if(siteObj == null){
//            LOGGER.error("Session中存储的站点信息为空！");
//            throw new V5CMSSessionValueNullException("Session中存储的站点信息为空！");
//        }
//        Site site = (Site)siteObj;
        String fileExt = FilenameUtils.getExtension(if_path);
//        String fileName = FilenameUtils.getName(if_path);

        String realPath = HttpUtils.getRealPath(request, if_path);

        boolean deleteResult = FileUtils.deleteQuietly(new File(realPath));

//        List<String> deletePaths = (List<String>)request.getSession().getAttribute("adv_delete_file_real_path");
//        if(deletePaths == null){
//            deletePaths = Lists.newArrayList();
//        }
//        deletePaths.add(realPath+"/"+fileName);
//
//        request.getSession().setAttribute("adv_delete_file_real_path",deletePaths);
        String failedMessage = "";
        if(deleteResult){
            failedMessage = "swf".equalsIgnoreCase(fileExt)?(getMessage("adv.flashdeletesuccess.message")):(getMessage("adv.imagedeletesuccess.message"));
        }else{
            failedMessage = "swf".equalsIgnoreCase(fileExt)?(getMessage("adv.flashdeletefailed.message")):(getMessage("adv.imagedeletefailed.message"));
        }
        return ImmutableMap.of("status","1","message",failedMessage);
    }

    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ImmutableMap<String,Object> deleteAdvs(Long[] advIds,HttpServletRequest request){
        LOGGER.info("删除广告信息，ID为{}",advIds);
        try {
            advService.deleteAdvs(advIds,request);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("删除广告信息失败，ID为{}",advIds);
            return ImmutableMap.<String,Object>of("status","0","message",getMessage("adv.deletefailed.message"));
        }
        return ImmutableMap.<String,Object>of("status","1","message",getMessage("adv.deletesuccess.message"));
    }
}

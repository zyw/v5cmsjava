package cn.v5cn.v5cms.controller;

import cn.v5cn.v5cms.entity.Banner;
import cn.v5cn.v5cms.entity.Site;
import cn.v5cn.v5cms.service.BannerService;
import cn.v5cn.v5cms.util.HttpUtils;
import cn.v5cn.v5cms.util.SystemConstant;
import cn.v5cn.v5cms.util.SystemUtils;
import com.baidu.ueditor.PathFormat;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static cn.v5cn.v5cms.util.MessageSourceHelper.getMessage;

/**
 * Created by zyw on 15/7/26.
 */
@Controller
@RequestMapping(value = "/manager/banner")
public class BannerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BannerController.class);

    @Autowired
    private BannerService bannerService;

    @RequestMapping(value = "/list/{p}",method = {RequestMethod.GET,RequestMethod.POST})
    public String bannerList(Banner banner,@PathVariable Integer p,HttpServletRequest request,ModelMap modelMap){
        Session session = SystemUtils.getShiroSession();
        if(StringUtils.isNotBlank(banner.getBannerName())){
            session.setAttribute("bannerSearch",banner);
            modelMap.addAttribute("searchBanner",banner);
        }else{
            session.setAttribute("bannerSearch",null);
        }
        Object searchObj = session.getAttribute("bannerSearch");

        Page<Banner> result =  bannerService.findBannerPageable((searchObj == null ? (new Banner()) : ((Banner) searchObj)), p);

        modelMap.addAttribute("banners",result.getContent());
        modelMap.addAttribute("pagination", SystemUtils.pagination(result, HttpUtils.getContextPath(request) + "/manager/banner/list"));
        return "setting/banner_list";
    }

    @RequestMapping(value = "/edit/{bannerId}",method = RequestMethod.GET)
    public String bannerEdit(@PathVariable Long bannerId,ModelMap modelMap){
        if(bannerId == null || bannerId == 0){
            modelMap.addAttribute(new Banner());
            return "setting/banner_edit";
        }
        Banner banner = bannerService.findOne(bannerId);
        modelMap.addAttribute(banner);
        return "setting/banner_edit";
    }

    @ResponseBody
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public ImmutableMap<String,Object> bannerEdit(@Valid Banner banner,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            Map<String, Object> errorMessage = Maps.newHashMap();
            errorMessage.put("status", 0);
            List<FieldError> fes = bindingResult.getFieldErrors();
            for (FieldError fe : fes) {
                errorMessage.put(fe.getField(), fe.getDefaultMessage());
            }
            return ImmutableMap.<String, Object>builder().putAll(errorMessage).build();
        }

        if(banner.getBannerId() == null || banner.getBannerId() == 0){
            Banner result = bannerService.save(banner);
            if(result == null || result.getBannerId() == null || result.getBannerId() == 0){
                LOGGER.warn("Banner添加失败，链接{}",result);
                return ImmutableMap.<String, Object>of("status","0","message",getMessage("banner.addfailed.message"));
            }
            LOGGER.info("Banner添加成功，链接ID{}",result.getBannerds());
            return ImmutableMap.<String, Object>of("status","1","message",getMessage("banner.addsuccess.message"));
        }
        try {
            bannerService.save(banner);
        } catch (Exception e) {
            LOGGER.error("Banner修改失败,{}", e);
            return ImmutableMap.<String, Object>of("status","0","message",getMessage("banner.updatefailed.message"));
        }
        LOGGER.info("Banner修改成功,{}", banner);
        return ImmutableMap.<String, Object>of("status","1","message",getMessage("banner.updatesuccess.message"));
    }

    @ResponseBody
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public ImmutableMap<String,String> bannerImgUpload(MultipartFile file,HttpServletRequest request){
        if(file.isEmpty()){
            return ImmutableMap.of("status", "0", "message", getMessage("global.uploadempty.message"));
        }
        Site site = (Site)(SystemUtils.getSessionSite());
        String bannerPath = PathFormat.parseSiteId(SystemConstant.BANNER_RES_PATH, site.getSiteId() + "");
        String realPath = HttpUtils.getRealPath(request, bannerPath);

        SystemUtils.isNotExistCreate(realPath);

        String timeFileName = SystemUtils.timeFileName(file.getOriginalFilename());
        try {
            file.transferTo(new File(realPath + "/" + timeFileName));
        } catch (IOException e) {
            LOGGER.error("Banner图片添加失败，错误：{}",e.getMessage());
            return ImmutableMap.of("status","0","message",getMessage("banner.uploaderror.message"));
        }
        return ImmutableMap.of("status","1","message",getMessage("banner.uploadsuccess.message"),
                "filePath",(bannerPath + "/" + timeFileName),"contentPath", HttpUtils.getBasePath(request));
    }

    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ImmutableMap<String,String> bannerDelete(Long[] bannerIds,HttpSession session){
        try {
            if(bannerIds == null || bannerIds.length == 0) {
                LOGGER.warn("要删除Banner的ID为空！");
                return ImmutableMap.of("status","0","message",getMessage("banner.deletefailed.message"));
            }
            List<Banner> banners = bannerService.findAll(bannerIds);
            String realPath = session.getServletContext().getRealPath("");
            List<File> deleteFiles = Lists.newArrayList();
            File deleteFile;
            for(Banner banner : banners){
                if(banner.getBannerPic() == null || "".equals(banner.getBannerPic())) continue;
                deleteFile = new File(realPath + banner.getBannerPic());
                deleteFiles.add(deleteFile);
            }
            bannerService.deleteInBatch(banners);
            deleteBannerRes(deleteFiles);
        } catch (Exception e) {
            LOGGER.error("Banner信息删除失败，失败原因：{}",e.getMessage());
            return ImmutableMap.of("status","0","message",getMessage("banner.deletefailed.message"));
        }
        LOGGER.info("Banner信息删除成功，ID为{}",StringUtils.join(bannerIds,","));
        return ImmutableMap.of("status","1","message",getMessage("banner.deletesuccess.message"));
    }

    private void deleteBannerRes(List<File> files){
        for(File file : files){
            if(!file.exists()) continue;
            file.delete();
        }
    }
}

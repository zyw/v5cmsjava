package cn.v5cn.v5cms.controller;

import cn.v5cn.v5cms.entity.wrapper.FileInfo;
import cn.v5cn.v5cms.entity.wrapper.ZTreeFileNode;
import cn.v5cn.v5cms.entity.wrapper.ZTreeNode;
import cn.v5cn.v5cms.util.PropertyUtils;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static cn.v5cn.v5cms.util.MessageSourceHelper.getMessage;

/**
 * Created by ZXF-PC1 on 2015/7/1.
 */
@Controller
@RequestMapping("/manager/resource")
public class ResourceController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceController.class);

    @RequestMapping(value = "/list",method = {RequestMethod.GET,RequestMethod.POST})
    public String resourceView(String path,HttpServletRequest request,ModelMap modelMap) throws IOException {
        String resPath = PropertyUtils.getValue("tpl.res.path").or("/res/front");
        String realResPath = request.getSession().getServletContext().getRealPath(resPath);
        if(path == null){
            List<FileInfo> fileInfos = fileInfos(new File(realResPath),realResPath);
            modelMap.put("files",fileInfos);
            modelMap.put("path","/");
            modelMap.put("fileName","资源根目录");
            return "resource/resource_list";
        }
        File file = new File(realResPath + path);
        if(file.isFile()){
            String extension = FilenameUtils.getExtension(file.getName());

            if("js".equalsIgnoreCase(extension) || "css".equalsIgnoreCase(extension)){
                String fileContent = FileUtils.readFileToString(file);
                modelMap.addAttribute("extension",extension);
                modelMap.addAttribute("content",fileContent);
                modelMap.addAttribute("fileid",path);
                modelMap.addAttribute("fileName",file.getName());
                modelMap.addAttribute("editor","yes");
            }else if("png".equalsIgnoreCase(extension) || "jpg".equalsIgnoreCase(extension) || "gif".equalsIgnoreCase(extension)){
                String webPath = (request.getContextPath() + resPath + path).replace("\\", "/");
                modelMap.addAttribute("editor","no");
                modelMap.addAttribute("fileName",file.getName());
                modelMap.addAttribute("webPath",webPath);
            }else{
                modelMap.addAttribute("editor","noview");
            }

            return "resource/resource_open";
        }else{
            List<FileInfo> fileInfos = fileInfos(file,realResPath);
            modelMap.put("files", fileInfos);
            modelMap.put("path",path);
            modelMap.put("fileName",file.getName());
            return "resource/resource_list";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/save/file",method = RequestMethod.POST)
    public ImmutableMap<String,Object> saveFile(String resourceContent,String fileid,HttpServletRequest request){
        String resPath = PropertyUtils.getValue("tpl.res.path").or("/res/front");
        String realResPath = request.getSession().getServletContext().getRealPath(resPath);
        File file = new File(realResPath + fileid);
        try {
            FileUtils.write(file,resourceContent);
        } catch (IOException e) {
            LOGGER.error("代码更新异常：{}", e.getMessage());
            return ImmutableMap.<String, Object>of("status","0","message", getMessage("code.updatefailed.message"));
        }
        return ImmutableMap.<String, Object>of("status","1","message", getMessage("code.updatesuccess.message"));
    }

    @ResponseBody
    @RequestMapping(value = "/create/folder",method = RequestMethod.POST)
    public ImmutableMap<String,Object> createFolder(String pathUri,String folderName,HttpServletRequest request){
        String resPath = PropertyUtils.getValue("tpl.res.path").or("/res/front");
        String realResPath = request.getSession().getServletContext().getRealPath(resPath);
        File file = new File(realResPath + pathUri + "/" + folderName);
        if(file.exists()){
            return ImmutableMap.<String, Object>of("status","0","message", getMessage("folder.folderexist.message"));
        }else{
            if(file.mkdirs()){
                return ImmutableMap.<String, Object>of("status","1","message", getMessage("folder.createsuccess.message"));
            }else{
                return ImmutableMap.<String, Object>of("status","0","message", getMessage("folder.createfailed.message"));
            }
        }
    }

    @ResponseBody
    @RequestMapping(value = "/rename/file",method = RequestMethod.POST)
    public ImmutableMap<String,Object> renameFile(String pathUri,String folderName,HttpServletRequest request){
        String resPath = PropertyUtils.getValue("tpl.res.path").or("/res/front");
        String realResPath = request.getSession().getServletContext().getRealPath(resPath);
        File file = new File(realResPath + pathUri);// + "/" + folderName
        String oldName = file.getName();
        boolean result = file.renameTo(new File(StringUtils.remove(file.getAbsolutePath(), oldName) + folderName));
        if(result){
            return ImmutableMap.<String, Object>of("status","1","message", getMessage("file.renamesuccess.message"));
        }
        return ImmutableMap.<String, Object>of("status","0","message", getMessage("file.renamefailed.message"));
    }

    @ResponseBody
    @RequestMapping(value = "/delete/file",method = RequestMethod.POST)
    public ImmutableMap<String,Object> deleteFile(String pathUris,HttpServletRequest request){
        String resPath = PropertyUtils.getValue("tpl.res.path").or("/res/front");
        String realResPath = request.getSession().getServletContext().getRealPath(resPath);
        List<String> pathUriList = Splitter.on(",").splitToList(pathUris);

        List<Boolean> result = Lists.newArrayList();

        for(String pathUri : pathUriList){
            File file = new File(realResPath + pathUri);
            if(file.isFile()){
                if(file.delete()){
                    result.add(Boolean.TRUE);
                } else {
                    result.add(Boolean.FALSE);
                }
            } else {
                boolean b = deleteFolder(file);
                if(b){
                    result.add(Boolean.TRUE);
                } else {
                    result.add(Boolean.FALSE);
                }
            }
        }
        if(!result.contains(Boolean.FALSE)){
            return ImmutableMap.<String, Object>of("status","1","message", getMessage("file.deletesuccess.message"));
        }else{
            return ImmutableMap.<String, Object>of("status","0","message", getMessage("file.deletefailed.message"));
        }
    }

    @ResponseBody
    @RequestMapping(value = "/tree/json",method = RequestMethod.POST)
    public ZTreeNode resourceTree(HttpServletRequest request){
        String resPath = PropertyUtils.getValue("tpl.res.path").or("/res/front");
        ZTreeFileNode rootNode = new ZTreeFileNode("资源树","/",true);
        String realResPath = request.getSession().getServletContext().getRealPath(resPath);

        File resFile = new File(realResPath);
        List<ZTreeFileNode> nodeList = fileNdoes(resFile, realResPath);
        rootNode.setChildren(nodeList);
        return rootNode;
    }

    @ResponseBody
    @RequestMapping(value = "/res/upload",method = RequestMethod.POST)
    public ImmutableMap<String,Object> uploadRes(MultipartHttpServletRequest multipartFile,String uploadUri,HttpServletRequest request){
        String resPath = PropertyUtils.getValue("tpl.res.path").or("/res/front");
        String realResPath = request.getSession().getServletContext().getRealPath(resPath);

        List<MultipartFile> files = multipartFile.getFiles("file");
        try {
            for(MultipartFile file : files){
                file.transferTo(new File(realResPath + uploadUri + File.separator + file.getOriginalFilename()));
            }
        } catch (IOException e) {
            LOGGER.error("上传资源出现异常：{}", e.getMessage());
            return ImmutableMap.<String, Object>of("status", "0", "message", getMessage("res.uploadfailed.message"));
        }

        return ImmutableMap.<String,Object>of("status","1","message",getMessage("res.uploadsuccess.message"));
    }

    /**
     * 资源树加载
     * */
    private List<ZTreeFileNode> fileNdoes(File file,String basePath){
        List<ZTreeFileNode> nodeList = Lists.newArrayList();
        ZTreeFileNode fileNode;
        if(file.isFile()){
            fileNode = new ZTreeFileNode();
            fileNode.setName(file.getName());
            fileNode.setFileUri(StringUtils.remove(file.getAbsolutePath(), basePath));
            nodeList.add(fileNode);

            return nodeList;
        }
        File[] files = file.listFiles();
        for(File temp : files){
            fileNode = new ZTreeFileNode();
            fileNode.setName(temp.getName());
            fileNode.setFileUri(StringUtils.remove(temp.getAbsolutePath(), basePath));
            fileNode.setOrder(2);
            if(temp.isDirectory()){
                fileNode.setOrder(1);
                fileNode.setChildren(fileNdoes(temp,basePath));
            }
            nodeList.add(fileNode);
        }
        //对资源进行排序文件夹显示在上面，文件显示在下面
        Collections.sort(nodeList, new Comparator<ZTreeFileNode>() {
            @Override
            public int compare(ZTreeFileNode o1, ZTreeFileNode o2) {
                if (o1.getOrder() == 1) {
                    return -1;
                } else if (o1.getOrder() == 2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        return nodeList;
    }

    /**
     * 文件信息初始化
     * */
    private List<FileInfo> fileInfos(File file,String basePath){
        List<FileInfo> result = Lists.newArrayList();
        FileInfo fileInfo;

        File[] files = file.listFiles();
        for(File temp : files){
            fileInfo = new FileInfo();
            fileInfo.setId(StringUtils.remove(temp.getAbsolutePath(), basePath));
            fileInfo.setName(temp.getName());
            fileInfo.setModifyDate(new DateTime(temp.lastModified()).toString("yyyy-MM-dd HH:mm:ss"));
            long fileSize;
            if(temp.isDirectory()){
                fileSize = directorySize(temp);
            } else {
                fileSize = temp.length();
            }
            double size = fileSize / 1024.0;
            fileInfo.setSize(String.format("%.2f", size) + "KB");
            if(size > 1024.0){
                size = size / 1024;
                fileInfo.setSize(String.format("%.2f",size) + "MB");
            }

            fileInfo.setType(temp.isFile()?"文件":"文件夹");
            result.add(fileInfo);
        }

        return result;
    }

    /**
     * 文件夹大小
     * */
    private long directorySize(File file){
        long result = 0L;
        File[] files = file.listFiles();
        for(File f : files){
            if(f.isDirectory()){
                result += directorySize(f);
            } else {
                result += f.length();
            }
        }
        return result;
    }


    /**
     * 循环删除文件夹
     * */
    private boolean deleteFolder(File file) {
        List<Boolean> result = Lists.newArrayList();
        File[] files = file.listFiles();
        for(File f : files){
            if(f.isFile()){
                result.add(f.delete());
            } else {
                result.add(deleteFolder(f));
            }
        }
        if(!result.contains(Boolean.FALSE)){
            return file.delete();
        }
        return false;
    }
}

package cn.v5cn.v5cms.controller;

import cn.v5cn.v5cms.entity.wrapper.FileInfo;
import cn.v5cn.v5cms.entity.wrapper.ZTreeFileNode;
import cn.v5cn.v5cms.entity.wrapper.ZTreeNode;
import cn.v5cn.v5cms.util.PropertyUtils;
import com.google.common.collect.Lists;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ZXF-PC1 on 2015/7/1.
 */
@Controller
@RequestMapping("/manager/resource")
public class ResourceController {

    @RequestMapping(value = "/list",method = {RequestMethod.GET,RequestMethod.POST})
    public String resourceView(String path,HttpServletRequest request,ModelMap modelMap) throws IOException {
        String resPath = PropertyUtils.getValue("resource.path").or("/res/front");
        String realResPath = request.getSession().getServletContext().getRealPath(resPath);
        if(path == null){
            List<FileInfo> fileInfos = fileInfos(new File(realResPath));
            modelMap.put("files",fileInfos);
            return "resource/resource_list";
        }
        File file = new File(realResPath + path);
        if(file.isFile()){
            String extension = FilenameUtils.getExtension(file.getName());

            if("js".equalsIgnoreCase(extension) || "css".equalsIgnoreCase(extension)){
                String fileContent = FileUtils.readFileToString(file);
                modelMap.addAttribute("extension",extension);
                modelMap.addAttribute("content",fileContent);
                modelMap.addAttribute("editor","yes");
            }else{
                String webPath = (request.getContextPath() + resPath + path).replace("\\", "/");
                modelMap.addAttribute("editor","no");
                modelMap.addAttribute("fileName",file.getName());
                modelMap.addAttribute("webPath",webPath);
            }

            return "resource/resource_open";
        }else{
            List<FileInfo> fileInfos = fileInfos(file);
            modelMap.put("files", fileInfos);
            return "resource/resource_list";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/tree/json",method = RequestMethod.POST)
    public ZTreeNode resourceTree(HttpServletRequest request){
        String resPath = PropertyUtils.getValue("resource.path").or("/res/front");
        ZTreeFileNode rootNode = new ZTreeFileNode("资源树","/",true);
        String realResPath = request.getSession().getServletContext().getRealPath(resPath);

        File resFile = new File(realResPath);
        List<ZTreeFileNode> nodeList = fileNdoes(resFile, realResPath);
        rootNode.setChildren(nodeList);
        return rootNode;
    }

    private List<ZTreeFileNode> fileNdoes(File file,String basePath){
        List<ZTreeFileNode> nodeList = Lists.newArrayList();
        ZTreeFileNode fileNode = null;
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

    private List<FileInfo> fileInfos(File file){
        List<FileInfo> result = Lists.newArrayList();
        FileInfo fileInfo = null;
        /*if(file.isFile()){
            fileInfo = new FileInfo();
            fileInfo.setName(file.getName());
            fileInfo.setModifyDate(new DateTime(file.lastModified()).toString("yyyy-MM-dd HH:mm:ss"));
            fileInfo.setSize((file.length() / 1024 / 1024) + "");
            fileInfo.setType("文件");
            result.add(fileInfo);
        }else{
            File[] files = file.listFiles();
            for(File temp : files){
                fileInfo = new FileInfo();
                fileInfo.setName(temp.getName());
                fileInfo.setModifyDate(new DateTime(temp.lastModified()).toString("yyyy-MM-dd HH:mm:ss"));
                fileInfo.setSize((temp.length() / 1024 / 1024) + "M");
                fileInfo.setType(temp.isFile()?"文件":"文件夹");
                result.add(fileInfo);
            }
        }*/

        File[] files = file.listFiles();
        for(File temp : files){
            fileInfo = new FileInfo();
            fileInfo.setName(temp.getName());
            fileInfo.setModifyDate(new DateTime(temp.lastModified()).toString("yyyy-MM-dd HH:mm:ss"));
            //fileInfo.setSize((temp.length() / 1024 / 1024) + "M");
            double size = temp.length()/1024/1024;
            fileInfo.setSize(size + "M");
            fileInfo.setType(temp.isFile()?"文件":"文件夹");
            result.add(fileInfo);
        }

        return result;
    }
}

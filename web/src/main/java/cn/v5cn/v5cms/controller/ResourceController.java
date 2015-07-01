package cn.v5cn.v5cms.controller;

import cn.v5cn.v5cms.entity.wrapper.ZTreeNode;
import cn.v5cn.v5cms.util.PropertyUtils;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * Created by ZXF-PC1 on 2015/7/1.
 */
@Controller
@RequestMapping("/manager/resource")
public class ResourceController {

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String resourceView(){
        return "resource/resource_list";
    }

    @ResponseBody
    @RequestMapping(value = "/tree/json",method = RequestMethod.POST)
    public ZTreeNode resourceTree(HttpServletRequest request){
        String resPath = PropertyUtils.getValue("resource.path").or("/res/front");
        ZTreeNode rootNode = new ZTreeNode(0L,"资源树");
        String realResPath = request.getSession().getServletContext().getRealPath(resPath);
        System.out.println(realResPath+"======================");
        File[] resFiles = new File(realResPath).listFiles();
        List<ZTreeNode> nodeList = Lists.newArrayList();
        for(int i  = 0; i < resFiles.length; i++){
            nodeList.add(new ZTreeNode((i+1L),resFiles[i].getName()));
        }
        rootNode.setChildren(nodeList);
        return rootNode;
    }
}

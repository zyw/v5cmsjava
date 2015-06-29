package cn.v5cn.v5cms.action;

import cn.v5cn.v5cms.biz.SystemResBiz;
import cn.v5cn.v5cms.entity.SystemRes;
import cn.v5cn.v5cms.entity.wrapper.ZTreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by ZXF-PC1 on 2015/6/23.
 */
@Controller
@RequestMapping("/manager/res")
public class SystemResAction {

    private static final Logger LOGGER = LoggerFactory.getLogger(SystemResAction.class);

    @Autowired
    private SystemResBiz systemResBiz;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String resList(ModelMap modelMap){
        List<SystemRes> systemResList = systemResBiz.findOrderByPidsAndId();
        modelMap.addAttribute("reses",systemResList);
        return "userauth/res_list";
    }

    @ResponseBody
    @RequestMapping(value = "/tree/json",method = RequestMethod.POST)
    public List<ZTreeNode> columnTree(){
        List<ZTreeNode> treeNodes = systemResBiz.buildTreeNode(0L);
        LOGGER.debug("treeNodes: " + treeNodes);
        return treeNodes;
    }
}

package cn.v5cn.v5cms.action;

import cn.v5cn.v5cms.biz.SystemUserBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ZXF-PC1 on 2015/6/18.
 */
@Controller
@RequestMapping("/manager/user")
public class SystemUserAction {
    @Autowired
    private SystemUserBiz systemUserBiz;
}

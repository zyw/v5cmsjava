package cn.v5cn.v5cms.action;

import cn.v5cn.v5cms.biz.SiteBiz;
import cn.v5cn.v5cms.entity.Site;
import cn.v5cn.v5cms.util.SystemConstant;
import com.google.common.collect.ImmutableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by ZYW on 2014/5/30.
 */
@Controller
@RequestMapping("/manager")
public class IndexAction {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexAction.class);
    @Autowired
    private SiteBiz siteBiz;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(HttpSession session){
        ImmutableList<Site> resultBiz = siteBiz.findRunableSite(1);
        Site temp = resultBiz.size() == 0 ? new Site(): resultBiz.get(0);
        session.setAttribute(SystemConstant.SITE_SESSION_KEY,temp);
        LOGGER.info("站点信息初始化成功！");
        return "backstage/index";
    }
}

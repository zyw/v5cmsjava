package cn.v5cn.v5cms.action;

import cn.v5cn.v5cms.biz.SiteBiz;
import cn.v5cn.v5cms.entity.Site;
import cn.v5cn.v5cms.util.SystemConstant;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Longs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

        LOGGER.info("站点信息初始化成功！");
        return "backstage/index";
    }

    @RequestMapping(value="/switch/site/{siteId}",method = RequestMethod.GET)
    public String switchSite(@PathVariable Long siteId,HttpSession session){
        ImmutableList<Site> resultBiz = (ImmutableList<Site>)session.getAttribute(SystemConstant.SITES_SESSION_KEY);
        if(resultBiz != null){
            for(Site site : resultBiz){
                if(Longs.compare(site.getSiteId(),siteId) == 0){
                    LOGGER.info("站点切换成功，切换的站点名称:{}",site.getSiteName());
                    session.setAttribute(SystemConstant.SITE_SESSION_KEY,site);
                    break;
                }else{
                    LOGGER.info("站点切换失败，没有找到ID为{}的站点。",siteId);
                }
            }
        }
        return "redirect:/manager/index";
    }
}

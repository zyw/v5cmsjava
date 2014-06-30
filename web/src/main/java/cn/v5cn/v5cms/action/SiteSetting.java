package cn.v5cn.v5cms.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Properties;

/**
 * Created by ZYW on 2014/6/29.
 */
@Controller
@RequestMapping("/manager")
public class SiteSetting {

    @Autowired
    private Properties proper;

    @RequestMapping(value = "/siteInfo",method = RequestMethod.GET)
    public String siteInfo(){
        return "backstage/siteInfo";
    }
}

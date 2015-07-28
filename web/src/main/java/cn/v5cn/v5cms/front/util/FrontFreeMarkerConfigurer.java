package cn.v5cn.v5cms.front.util;

import cn.v5cn.v5cms.front.freemarker.ColumnDirective;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;

/**
 * Created by ZXF-PC1 on 2015/7/28.
 */
public class FrontFreeMarkerConfigurer extends FreeMarkerConfigurer {

//    @Autowired
//    private V5CMSDirectives v5cmsDirectives;

    @Autowired
    private ColumnDirective columnDirective;

    @Override
    public void afterPropertiesSet() throws IOException, TemplateException {
        super.afterPropertiesSet();
        this.getConfiguration().setSharedVariable("column",columnDirective);
    }
}

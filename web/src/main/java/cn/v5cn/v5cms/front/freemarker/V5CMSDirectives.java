package cn.v5cn.v5cms.front.freemarker;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ZXF-PC1 on 2015/7/28.
 */
@Component
public class V5CMSDirectives extends SimpleHash {

    @Autowired
    private ColumnDirective columnDirective;

    public V5CMSDirectives(){
        super(new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_23).build());
        put("column",columnDirective);
    }
}

package cn.v5cn.v5cms.front.freemarker;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.SimpleHash;

/**
 * Created by ZXF-PC1 on 2015/7/28.
 */
public class V5CMSDirectives extends SimpleHash {

    public V5CMSDirectives() {
        super(new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_23).build());

        put("column", new ColumnDirective());

        put("content",new ContentDirective());

        put("stickContent",new StickContentDirective());

        put("banner",new BannerDirective());
    }
}

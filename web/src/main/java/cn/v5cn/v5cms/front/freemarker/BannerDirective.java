package cn.v5cn.v5cms.front.freemarker;

import cn.v5cn.v5cms.entity.Banner;
import cn.v5cn.v5cms.front.util.SpringContextsUtil;
import cn.v5cn.v5cms.service.BannerService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by zxf on 15/10/26.
 */
public class BannerDirective implements TemplateDirectiveModel {

    private BannerService bannerService;

    private static final String PARAM_NAME_MAXSIZE = "maxSize";

    public BannerDirective() {
        bannerService = SpringContextsUtil.getTypeBean("bannerService", BannerService.class);
    }

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
            throws TemplateException, IOException {
        int maxSize = 0;

        Iterator paramIter = params.entrySet().iterator();
        while (paramIter.hasNext()) {
            Map.Entry ent = (Map.Entry) paramIter.next();

            String paramName = (String) ent.getKey();
            TemplateModel paramValue = (TemplateModel) ent.getValue();

            if(paramName.equals(PARAM_NAME_MAXSIZE)) {
                if (!(paramValue instanceof TemplateNumberModel)) {
                    throw new TemplateModelException(
                            "The \"" + PARAM_NAME_MAXSIZE + "\" parameter "
                                    + "must be a number.");
                }
                maxSize = ((TemplateNumberModel) paramValue).getAsNumber().intValue();

                if (maxSize < 0) {
                    throw new TemplateModelException(
                            "The \"" + PARAM_NAME_MAXSIZE + "\" parameter "
                                    + "can't be negative.");
                }
            } else {
                throw new TemplateModelException(
                        "Unsupported parameter: " + paramName);
            }
        }

        Page<Banner> banners = bannerService.findBannerByMaxSize(maxSize);
        env.setVariable("banners", new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_22).build().wrap(banners.getContent()));

        if(body != null){
            body.render(env.getOut());
        }
    }
}

package cn.v5cn.v5cms.front.freemarker;

import cn.v5cn.v5cms.entity.Content;
import cn.v5cn.v5cms.front.util.SpringContextsUtil;
import cn.v5cn.v5cms.service.ContentService;
import freemarker.core.Environment;
import freemarker.template.*;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by zyw on 16/2/14.
 */
public class StickContentDirective implements TemplateDirectiveModel {

    private ContentService contentService;

    private static final String PARAM_NAME_COLID = "colId";

    public StickContentDirective(){
        contentService = SpringContextsUtil.getTypeBean("contentService", ContentService.class);
    }

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        long colId = 0;
        Iterator paramIter = params.entrySet().iterator();
        while (paramIter.hasNext()) {
            Map.Entry ent = (Map.Entry) paramIter.next();

            String paramName = (String) ent.getKey();
            TemplateModel paramValue = (TemplateModel) ent.getValue();

            if (paramName.equals(PARAM_NAME_COLID)) {
                if (!(paramValue instanceof TemplateNumberModel)) {
                    throw new TemplateModelException(
                            "The \"" + PARAM_NAME_COLID + "\" parameter "
                                    + "must be a number.");
                }
                colId = ((TemplateNumberModel) paramValue).getAsNumber().longValue();

                if (colId < 0) {
                    throw new TemplateModelException(
                            "The \"" + PARAM_NAME_COLID + "\" parameter "
                                    + "can't be negative.");
                }
            } else {
                throw new TemplateModelException(
                        "Unsupported parameter: " + paramName);
            }
            List<Content> stickContents = contentService.findStickContents(colId);
            env.setVariable("stickContents", new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_22).build().wrap(stickContents));

            if(body != null){
                body.render(env.getOut());
            }
        }
    }
}

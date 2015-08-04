package cn.v5cn.v5cms.front.freemarker;

import cn.v5cn.v5cms.entity.Content;
import cn.v5cn.v5cms.front.util.SpringContextsUtil;
import cn.v5cn.v5cms.service.ContentService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by zyw on 15/8/4.
 */
public class ContentDirective implements TemplateDirectiveModel {

    private ContentService contentService;

    private static final String PARAM_NAME_COLID = "colId";

    private static final String PARAM_NAME_CURRENTPAGE = "currentPage";

    private static final String PARAM_NAME_MAXSIZE = "maxSize";

    public ContentDirective(){
        contentService = SpringContextsUtil.getTypeBean("contentService",ContentService.class);
    }

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
            throws TemplateException, IOException {
        long colId = 0;
        int currentPage = 0;
        int maxSize = 0;

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
            } else if(paramName.equals(PARAM_NAME_CURRENTPAGE)){
                if (!(paramValue instanceof TemplateNumberModel)) {
                    throw new TemplateModelException(
                            "The \"" + PARAM_NAME_CURRENTPAGE + "\" parameter "
                                    + "must be a number.");
                }
                currentPage = ((TemplateNumberModel) paramValue).getAsNumber().intValue();

                if (currentPage < 0) {
                    throw new TemplateModelException(
                            "The \"" + PARAM_NAME_CURRENTPAGE + "\" parameter "
                                    + "can't be negative.");
                }
            } else if(paramName.equals(PARAM_NAME_MAXSIZE)) {
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

        Page<Content> contentPage = contentService.findContentPageable(colId, currentPage, maxSize);
        env.setVariable("pageContent", new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_22).build().wrap(contentPage));

        if(body != null){
            body.render(env.getOut());
        }
    }
}

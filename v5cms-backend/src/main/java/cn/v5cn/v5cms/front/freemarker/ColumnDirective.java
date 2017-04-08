package cn.v5cn.v5cms.front.freemarker;

import cn.v5cn.v5cms.entity.Column;
import cn.v5cn.v5cms.front.util.SpringContextsUtil;
import cn.v5cn.v5cms.service.ColumnService;
import freemarker.core.Environment;
import freemarker.template.*;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by ZXF-PC1 on 2015/7/28.
 * 栏目Freemarker指令
 */
public class ColumnDirective implements TemplateDirectiveModel {

    private ColumnService columnService;

    private static final String PARAM_NAME_PARENTID = "parentId";

    private static final String PARAM_NAME_SITEID = "siteId";

    private static final String PARAM_NAME_MAXSIZE = "maxSize";

    public ColumnDirective(){
        columnService = SpringContextsUtil.getTypeBean("columnService", ColumnService.class);
    }

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
            throws TemplateException, IOException {

        long parentId = 0;
        long siteId = 0;
        int maxSize = 0;

        Iterator paramIter = params.entrySet().iterator();
        while (paramIter.hasNext()) {
            Map.Entry ent = (Map.Entry) paramIter.next();

            String paramName = (String) ent.getKey();
            TemplateModel paramValue = (TemplateModel) ent.getValue();

            if (paramName.equals(PARAM_NAME_PARENTID)) {
                if (!(paramValue instanceof TemplateNumberModel)) {
                    throw new TemplateModelException(
                            "The \"" + PARAM_NAME_PARENTID + "\" parameter "
                                    + "must be a number.");
                }
                parentId = ((TemplateNumberModel) paramValue).getAsNumber().longValue();

                if (parentId < 0) {
                    throw new TemplateModelException(
                            "The \"" + PARAM_NAME_PARENTID + "\" parameter "
                                    + "can't be negative.");
                }
            } else if(paramName.equals(PARAM_NAME_SITEID)){
                if (!(paramValue instanceof TemplateNumberModel)) {
                    throw new TemplateModelException(
                            "The \"" + PARAM_NAME_SITEID + "\" parameter "
                                    + "must be a number.");
                }
                siteId = ((TemplateNumberModel) paramValue).getAsNumber().longValue();

                if (siteId < 0) {
                    throw new TemplateModelException(
                            "The \"" + PARAM_NAME_SITEID + "\" parameter "
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

        List<Column> columns = columnService.findByParentId(parentId,siteId,maxSize);
        env.setVariable("columns", new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_22).build().wrap(columns));

        if(body != null){
            body.render(env.getOut());
        }

    }
}

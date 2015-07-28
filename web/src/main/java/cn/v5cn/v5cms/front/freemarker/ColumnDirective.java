package cn.v5cn.v5cms.front.freemarker;

import cn.v5cn.v5cms.entity.Column;
import cn.v5cn.v5cms.service.ColumnService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by ZXF-PC1 on 2015/7/28.
 * 栏目Freemarker指令
 */
@Component
public class ColumnDirective implements TemplateDirectiveModel {

    @Autowired
    private ColumnService columnService;

    private static final String PARAM_NAME_PARENTID = "parentId";

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
            throws TemplateException, IOException {

        long parentId = 0;

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
            } else {
                throw new TemplateModelException(
                        "Unsupported parameter: " + paramName);
            }
        }
        List<Column> columns = columnService.findByParentId(parentId);
        env.setVariable("columns", new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_22).build().wrap(columns));
        if(body != null){
            body.render(env.getOut());
        }

    }
}

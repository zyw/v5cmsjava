package cn.v5cn.v5cms.util;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.Properties;

/**
 * Created by ZYW on 2014/7/4.
 * 利用Spring读取Properties文件的帮助类
 * 在Spring配置文件中配置，代码如下：
 * <bean id="propertyConfigurer" class="cn.v5cn.v5cms.util.PropertyUtils">
 *    <property name="locations">
 *       <list>
 *          <value>classpath:sys_constant.properties</value>
 *       </list>
 *    </property>
 * </bean>
 * 在java代码中就可以使用PropertyUtils.getValue(key)返回配置文件中的值
 */
public class PropertyUtils extends PropertyPlaceholderConfigurer {

    private static ImmutableMap<String, String> propertyMap;

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        propertyMap = Maps.fromProperties(props);

    }
    public static Optional<String> getValue(String name){
        String value = propertyMap.get(name);
        if (Strings.isNullOrEmpty(value)) {
            return Optional.absent();
        }
        return Optional.of(value);
    }
}

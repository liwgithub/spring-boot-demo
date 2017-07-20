package cn.baiding.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by BaiDing on 2017/7/19.
 *
 * @Component 把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>
 * @ConfigurationProperties 可以将同类的自定义配置信息自动封装成实体类
 * 默认从application.properties中读取属性
 * 若是自定义属性不存在于application.properties属性文件中，
 * 而是在自定义的配置文件如current.constant.properties
 * 那么详细情况见于 com.baiding.common.model.FoShanCallBackUrl
 * 简单来说 只不过多添加个 @PropertiesSource注解来指定配置文件所在
 * @PropertySource ("classpath:config/current.constant.properties")
 *
 */
@Component
@ConfigurationProperties(prefix = "jun")
public class UserProperty {
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

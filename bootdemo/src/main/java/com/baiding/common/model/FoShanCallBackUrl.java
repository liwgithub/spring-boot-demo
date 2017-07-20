package com.baiding.common.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by BaiDing on 2017/7/19.
 * @PropertySource 注解当前类，参数为对应的配置文件路径，这种方式加载配置文件
 */

@PropertySource("classpath:config/current.constant.properties")
@ConfigurationProperties(prefix = "foshan.callback")
@Component
public class FoShanCallBackUrl {

    private String accountOutUrl;
    private String accountResumeUrl;
    private String changePWDUrl;

    public String getAccountOutUrl() {
        return accountOutUrl;
    }

    public void setAccountOutUrl(String accountOutUrl) {
        this.accountOutUrl = accountOutUrl;
    }

    public String getAccountResumeUrl() {
        return accountResumeUrl;
    }

    public void setAccountResumeUrl(String accountResumeUrl) {
        this.accountResumeUrl = accountResumeUrl;
    }

    public String getChangePWDUrl() {
        return changePWDUrl;
    }

    public void setChangePWDUrl(String changePWDUrl) {
        this.changePWDUrl = changePWDUrl;
    }
}

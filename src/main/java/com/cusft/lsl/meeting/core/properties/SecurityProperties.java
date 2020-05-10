package com.cusft.lsl.meeting.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author Long
 * @Date 2020/4/23 10:34
 */

@ConfigurationProperties(prefix = "meeting.security")
@EnableConfigurationProperties(SecurityProperties.class)
//括号内填出现问题的类名
public class SecurityProperties {

    private BrowserProperties browser =new BrowserProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }
}

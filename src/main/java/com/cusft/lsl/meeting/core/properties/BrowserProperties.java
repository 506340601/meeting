package com.cusft.lsl.meeting.core.properties;

/**
 * @author Long
 * @Date 2020/4/23 10:35
 */
public class BrowserProperties {

    private String loginPage="/logIn.html";

    //枚举
    private LoginType loginType =LoginType.REDIRECT;

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }
}

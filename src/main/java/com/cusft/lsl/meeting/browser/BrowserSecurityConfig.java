package com.cusft.lsl.meeting.browser;

import com.cusft.lsl.meeting.browser.authentication.MeetingAuthenticationFailureHandler;
import com.cusft.lsl.meeting.browser.authentication.MeetingAuthenticationSuccessHandler;
import com.cusft.lsl.meeting.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Long
 * @Date 2020/4/21 18:14
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    //注入自定义的成功处理器
    @Autowired
    private MeetingAuthenticationSuccessHandler meetingAuthenticationSuccessHandler;

    //注入自定义的失败处理器
    @Autowired
    private MeetingAuthenticationFailureHandler meetingAuthenticationFailureHandler;

    //
    @Autowired
    private SecurityProperties securityProperties;


    //加一个密码加密用的PasswordEncoder
    @Bean
    public  PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.formLogin()
                .loginPage("/authentication/require")
                .loginProcessingUrl("/authentication/form")
                .successHandler(meetingAuthenticationSuccessHandler)
                .failureHandler(meetingAuthenticationFailureHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/authentication/require",
                        securityProperties.getBrowser().getLoginPage()).permitAll()
                .antMatchers("/res/**").permitAll()
                .antMatchers("/emp/add/**").permitAll()
                .antMatchers("/register.html").permitAll()
                .anyRequest()
                .authenticated()
        .and()
        .csrf().disable();
    }
    /**
     * 认证信息管理
     * spring5中摒弃了原有的密码存储格式，官方把spring security的密码存储格式改了
     *  这样配置可以在浏览器前端登录，但是取密码的时候就不能确定有无问题！！！
     * @param long
     * @throws Exception
     */
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication() //认证信息存储到内存中
//                .passwordEncoder(passwordEncoder())
//                .withUser("user").password(passwordEncoder().encode("123456")).roles("ADMIN");
//    }
//
//    private PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}

package com.cusft.lsl.meeting.browser;

import com.cusft.lsl.meeting.core.properties.SecurityProperties;
import com.cusft.lsl.meeting.support.SimpleResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 访问的身份认证
 *
 * @author Long
 * @Date 2020/4/23 1:11
 */
@RestController
public class BrowserSecurityController {

    //日志打印请求
    private Logger logger= LoggerFactory.getLogger(getClass());

    //查询请求类型
    private RequestCache requestCache=new HttpSessionRequestCache();

    //工具跳转
    private RedirectStrategy redirectStrategy=new DefaultRedirectStrategy();

    //注入
    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 当需要身份认证时跳转到这里
     *@return {@link String}
     *@throws
     *@author Long
     *@date 2020/4/23 1:14
     * @param {@link java.lang.String}
     */
    @RequestMapping("/authentication/require")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public SimpleResponse requriedAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {

        SavedRequest savedRequest=requestCache.getRequest(request,response);

        if (savedRequest !=null){
            String targetUrl =savedRequest.getRedirectUrl();
            logger.info("引发跳转的请求是："+targetUrl);

            if(StringUtils.endsWithIgnoreCase(targetUrl,".html")){
                redirectStrategy.sendRedirect(request,response,securityProperties.getBrowser().getLoginPage());
            }
        }
        return new SimpleResponse("访问的服务需要身份认证，请引导用户到登录页");
    }
}

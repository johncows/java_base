package com.kk.security.brower;

import com.kk.security.brower.pojo.WebStatus;
import com.kk.security.brower.properties.SecurityProperties;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class SecurityController {

    @Autowired
    private Logger logger;

    private RequestCache requestCache = new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy =  new DefaultRedirectStrategy();


    @Autowired
    private SecurityProperties securityProperties;

    @RequestMapping("/authentication/required")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public Object requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {
//      引发跳转的请求
        SavedRequest savedRequest = requestCache.getRequest(request, response);

        if(savedRequest.getRedirectUrl()!=null){
            String loginPage = securityProperties.getBrowser().getLoginPage();
            logger.info(loginPage+"---------");
            String redirectUrl = savedRequest.getRedirectUrl();
            logger.info("引发跳转的url为"+redirectUrl);
            if(redirectUrl.endsWith(".html")){
                redirectStrategy.sendRedirect(request,response,loginPage);
            }
        }


        return new WebStatus("需要身份验证 请引导登录");
    }


}

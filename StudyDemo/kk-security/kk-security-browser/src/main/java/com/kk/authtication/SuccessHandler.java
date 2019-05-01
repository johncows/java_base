package com.kk.authtication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kk.security.brower.LoginType;
import com.kk.security.brower.properties.SecurityProperties;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private Logger logger;

    @Autowired
    private SecurityProperties securityProperties;

    //    springMvc自动注册
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        logger.info("success Login");
        if (!LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())) {
            super.onAuthenticationSuccess(request, response, authentication);
        }
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(authentication));
    }
}

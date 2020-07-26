package com.kk.intercept;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Parameter;
import java.util.Date;

@Component
public class TimeIntercept implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("进入拦截器方法中");
        httpServletRequest.setAttribute("start", new Date().getTime());
        HandlerMethod handlerMethod = (HandlerMethod) o;
        System.out.println("handlerMethod.getMethod().getName() = " + handlerMethod.getMethod().getName());
        Parameter[] parameters = handlerMethod.getMethod().getParameters();
        for (Parameter parameter : parameters) {
            System.out.println("parameter.getName() = " + parameter.getName());
        }
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("无异常处理后执行该方法");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("在拦截器看来 该处理耗时" + (new Date().getTime() - (long) httpServletRequest.getAttribute("start")) + "毫秒");
    }
}

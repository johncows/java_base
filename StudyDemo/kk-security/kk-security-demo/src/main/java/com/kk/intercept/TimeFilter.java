package com.kk.intercept;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

@Component
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器已被初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("进入过滤器方法中");
        long start = new Date().getTime();

        String name = servletRequest.getParameter("name");
        System.out.println("name = " + name);


        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("在过滤器看来 该处理耗时"+(new Date().getTime()-start)+"毫秒");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器已被销毁");
    }
}

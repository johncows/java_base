package com.kk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.Filter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private Filter timeFilter;

    @Autowired
    private HandlerInterceptor timeIntercept;
    /**
     * 注册第三方过滤器 可采用Bean注册
     * 注意 在配置类中配置拦截器后 会自动关闭Springboot默认拦截器属性(拦截所有)
     * @return
     */
    @Bean
    public FilterRegistrationBean FilterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(timeFilter);
        filterRegistrationBean.addUrlPatterns("/time");
        return filterRegistrationBean;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeIntercept).addPathPatterns("/time");
    }
}

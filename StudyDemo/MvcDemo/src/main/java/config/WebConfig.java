package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("com.kk.controller")
public class WebConfig extends WebMvcConfigurerAdapter {




    //    配置jsp视图解析器
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/jsp/");
        internalResourceViewResolver.setSuffix(".jsp");
        internalResourceViewResolver.setExposeContextBeansAsAttributes(true);
//        解析jstl
        internalResourceViewResolver.setViewClass(JstlView.class);
        return internalResourceViewResolver;
    }



    //    静态资源处理
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        /*
        该代码表示 要求dispatcherServlet将对静态资源的请求转发到Servlet容器中默认的Servlet上
        而不是由dispatcherServlet来处理
        */
        configurer.enable();
    }



//  配置多媒体处理器 默认缓存容器
    @Bean
    public MultipartResolver multipartResolver1(){
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setDefaultEncoding("utf-8");
        commonsMultipartResolver.setMaxUploadSize(54800);
        return commonsMultipartResolver;
    }

    /*
           多媒体处理器 始于Spring3.1
           该处理器无参数配置(属性配置在dispatcherServlet)
           必须配置缓存位置!!!!

     */
//    @Bean
    public MultipartResolver multipartResolver2(){
        StandardServletMultipartResolver resolver  = new StandardServletMultipartResolver();
        return resolver;
    }













}

package config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/*
       容器会在servlet3.0环境下
       去查找实现 ServletContainerInitializer的接口类 并用它来配置Servlet容器
       Spring提供了实现 SpringServletContainerInitializer
       同时该实现类会去查找实现了AbstractAnnotationConfigDispatcherServletInitializer接口类
       将配置任务交给实现类
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

//    加载SpringMvc中DispatcherServlet 配置文件
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        FilterRegistration.Dynamic filter = servletContext.addFilter("characterEncodingFilter", CharacterEncodingFilter.class);
        filter.setInitParameter("encoding","utf-8");
        filter.addMappingForUrlPatterns(null,false,"/*");
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"*.action"};
    }
}

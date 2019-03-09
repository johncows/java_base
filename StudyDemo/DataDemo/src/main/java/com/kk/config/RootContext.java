package com.kk.config;

import com.mchange.v2.c3p0.jboss.C3P0PooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.annotation.Resource;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.awt.image.DirectColorModel;
import java.sql.DriverManager;

@Configuration
@ComponentScan(value="com.kk")
public class RootContext {


//    配置数据源 (不建议)
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/springData?serverTimezone=GMT%2B8");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("root");
        return driverManagerDataSource;
    }


//  配置数据连接池
    @Bean
    public C3P0PooledDataSource c3P0PooledDataSource() throws Exception {
        C3P0PooledDataSource c3P0PooledDataSource = new C3P0PooledDataSource();
        c3P0PooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
        c3P0PooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/springData?serverTimezone=GMT%2B8");
        c3P0PooledDataSource.setUser("root");
        c3P0PooledDataSource.setPassword("root");
        return c3P0PooledDataSource;
    }


//    配置jdbc模板类对象
    @Bean
    public JdbcOperations jdbcTemplate(DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }








}

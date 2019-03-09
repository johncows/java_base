package com.kk;

import com.kk.Advice.PayAdvice1;
import com.kk.Advice.PayAdvice1Simple;
import com.kk.Advice.PayAdvicePram;
import com.kk.Pojo.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class ConcertConfig {


    public PayAdvice1 payAdvice() {
        return new PayAdvice1();
    }

    public PayAdvice1Simple payAdvice1Simple() {
        return new PayAdvice1Simple();
    }

    public PayAdvicePram payAdvicePram() {
        return new PayAdvicePram();
    }


    @Bean
    public Product product() {
        return new Product("充气娃娃", 360);
    }


}

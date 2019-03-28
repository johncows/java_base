package com.kk.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@RestController
public class AsyncController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("order1")
    public Callable<String> order(){
        logger.info("主线程开始");
        Callable<String> result = new Callable<String>(){
            @Override
            public String call() throws Exception {
                logger.info("副线程开始");
                Thread.sleep(2000);
                logger.info("副线程结束");
                return "下单完成";
            }
        };
        logger.info("主线程结束");
        return result;
    }



}

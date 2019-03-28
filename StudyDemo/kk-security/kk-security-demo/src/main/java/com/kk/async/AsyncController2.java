package com.kk.async;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
public class AsyncController2 {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

    @GetMapping("order2")
    public DeferredResult<String> order() {
        logger.error("进入主线程");
        String random = RandomStringUtils.randomNumeric(8);
        mockQueue.setPlaceOrder(random);

        DeferredResult<String> result = new DeferredResult<>();
        deferredResultHolder.getMap().put(random,result);

        logger.error("退出主线程");
        return result;
    }


}

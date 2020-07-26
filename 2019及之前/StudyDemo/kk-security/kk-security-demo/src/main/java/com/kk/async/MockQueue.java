package com.kk.async;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Data
@Component
public class MockQueue {

    private String placeOrder;
    private String completeOrder;

    private Logger logger = LoggerFactory.getLogger(getClass());


    public void setPlaceOrder(String placeOrder) {

        new Thread(() -> {
            logger.info("接到下单请求----" + placeOrder);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.completeOrder = placeOrder;
            logger.info("下单请求处理完毕-----" + placeOrder);
        }).start();

    }
}

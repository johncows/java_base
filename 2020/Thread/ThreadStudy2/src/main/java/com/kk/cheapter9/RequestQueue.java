package com.kk.cheapter9;

import java.util.LinkedList;

public class RequestQueue {

    private final LinkedList<Request> queue = new LinkedList();


    // 消费资源
    public Request getRequest(){
        synchronized (queue){
            while (queue.size()<=0){
                try {
                    // 阻塞期间 打断即退出循环
                    queue.wait();
                } catch (InterruptedException e) {
                    break;
                }
            }
            
        }
        return queue.removeFirst();
    }

    // 放置资源
    public void putRequest(Request request){
        synchronized (queue){
            queue.addLast(request);
            queue.notifyAll();
        }
    }
}

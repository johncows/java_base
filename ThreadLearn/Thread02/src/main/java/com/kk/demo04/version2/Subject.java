package com.kk.demo04.version2;



/**
 * @author KK
 * @create 2019-05-22 21:08
 * 
 *  通知类接口
 * 
 **/


public interface Subject {



//    添加观察者
    void attach(Observer observer);
    
//    删除观察者
    void detach(Observer observer);
    
//    唤醒所有
    void notifyObserver();

    void setCurrentStatus(String currentStatus);

    String  getCurrentStatus();
    
}

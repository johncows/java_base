package com.kk.demo01;

/**
 * @author KK
 * @create 2019-05-18 20:35
 *
 * 懒汉式单例 + double check
 * 优点 可以懒加载 线程安全
 * 缺点 可能会导致空指针异常
 * 原因 由于虚拟机的重排序
 *
 **/
public class SingletonObject04 {

    private static SingletonObject04 instance ;

    private SingletonObject04(){
        
    }

    public  static SingletonObject04 getInstance(){

        if(instance==null){
            synchronized (SingletonObject04.class) {
                if (instance == null) {
                    instance = new SingletonObject04();
                }
            }
        }
        return SingletonObject04.instance;
    }


}

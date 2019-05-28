package com.kk.demo05;


/**
 * @author KK
 * @create 2019-05-23 16:44
 **/
public abstract class ObservableRunnable implements Runnable {

//    观察者对象
    protected LifeCycleListener listener;

    public ObservableRunnable(LifeCycleListener listener) {
        this.listener = listener;
    }

    protected void notifyChange(RunnableEvent runnableEvent){
        listener.onEvent(runnableEvent);
    }


}

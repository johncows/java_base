package com.kk.demo05;

import java.util.List;

/**
 * @author KK
 * @create 2019-05-23 16:52
 **/
public class ThreadLifeCycleListener implements LifeCycleListener {

    private final static Object LOCK = new Object();

    public void concurrentQuery(List<String> ids){
        if(ids==null||ids.isEmpty())
            return;


        ids.stream().forEach(id-> new Thread(new ObservableRunnable(this) {
            @Override
            public void run() {
                try {
                notifyChange(new RunnableEvent(RunnableState.RUNNING,Thread.currentThread(),null));
                System.out.println("query for this id "+id);
                int i = 1/0;
                notifyChange(new RunnableEvent(RunnableState.DONE,Thread.currentThread(),null));
                Thread.sleep(1_000L);
                } catch (InterruptedException e) {
                    notifyChange(new RunnableEvent(RunnableState.ERROR,Thread.currentThread(),null));
                }
            }
        }).start());
    }



    @Override
    public void onEvent(RunnableEvent runnableEvent) {
        synchronized (LOCK){
            System.out.println("the runnable["+runnableEvent.getThread().getName()+"] data changed and state is "+runnableEvent.getState());
            if(runnableEvent.getCause()!=null){
                System.out.println("the runnable["+runnableEvent.getThread().getName()+"] process filled ");
            }
        }

    }
}

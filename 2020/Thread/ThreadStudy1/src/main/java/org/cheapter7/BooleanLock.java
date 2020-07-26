package org.cheapter7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public class BooleanLock implements Lock {


    // true indicated the lock can be get
    // false indicated the lock can not be get
    private boolean initValue;

    private Thread currentThread ;



    // 仅仅起到的是监控  的作用
    private Collection<Thread> blockedCollection = new ArrayList<>();



    public BooleanLock(boolean initValue) {
        this.initValue = initValue;
    }

    @Override
    public synchronized void lock() throws InterruptedException {
        while (initValue){
            blockedCollection.add(Thread.currentThread());
            this.wait();
        }
        Optional.of(Thread.currentThread().getName()+" get the lock ").ifPresent(System.out::println);
        boolean remove = blockedCollection.remove(Thread.currentThread());
        System.out.println("从队列中移除锁 "+ (remove?"成功":"失败"));
        this.initValue = !initValue;
        this.currentThread = Thread.currentThread();
    }

    @Override
    public synchronized void lock(long mills) throws InterruptedException, TimeOutException {
        if(mills<=0){
            lock();
        return;
    }

        this.currentThread = Thread.currentThread();
        long endTime = System.currentTimeMillis()+mills;

        while (initValue){
            if(System.currentTimeMillis()<endTime) {
                blockedCollection.add(Thread.currentThread());
                this.wait(mills);
            }else {
                throw new TimeOutException("已经超时了，抱歉");
            }
        }
        Optional.of(Thread.currentThread().getName()+" get the lock ").ifPresent(System.out::println);
        boolean remove = blockedCollection.remove(Thread.currentThread());
        System.out.println("从队列中移除锁 "+ (remove?"成功":"失败"));
        this.initValue = !initValue;
    }

    @Override
    public synchronized void unlock() {
        if(this.currentThread == Thread.currentThread()){
            Optional.of(Thread.currentThread().getName()+" release the lock ").ifPresent(System.out::println);
            this.initValue = !initValue;
            this.notifyAll();
        }
    }

    @Override
    public Collection<Thread> getBlockedThread() {
        return Collections.unmodifiableCollection(blockedCollection);
    }

    @Override
    public int getBlockedSize() {
        return blockedCollection.size();
    }
}

package com.kk.demo11;


import java.util.*;

public class BooleanLock implements MyLock {

//   The initValue is true indicated the Lock have be get
//   The initValue is false indicated the Lock is free ,Other Thread Can be Get it

    private boolean initValue;

    private Collection<Thread> blockThreadCollection = new LinkedList<>() ;

    /**
     *  为防止锁的混乱 每次获得锁都更新一次获取锁的线程
     *
     */
    private Thread currentThread;


    public BooleanLock(boolean initValue) {
        this.initValue = initValue;
    }

    /**
     * unLock
     * 1.判断是否为当前加锁的线程 是? 继续执行
     * 2.将flag 置false
     * 3.唤醒所有该锁上的线程 进行争抢执行权
     */
    @Override
    public synchronized void unLock() {
        if(this.currentThread != Thread.currentThread()) {
            return ;
        }
        this.initValue = false;
        System.out.println(Thread.currentThread().getName() + " release the lock monitor");
        this.notifyAll();
    }


    /**
     * 普通锁
     * 1.判断是否为当前加锁的线程 是? 继续等待 否? 拿锁 置位
     * 2.等待下 会阻塞在while循环中 等待唤醒
     * 3.唤醒后 继续抢占锁 如抢占到 拿锁 置位 否则继续阻塞
     * @throws InterruptedException
     */
    @Override
    public synchronized void lock() throws InterruptedException {
        while (initValue) {
            blockThreadCollection.add(Thread.currentThread());
            this.wait();
        }
        System.out.println(Thread.currentThread().getName() + " get the lock monitor");
        this.initValue = true;
        this.currentThread = Thread.currentThread();
    }






    /**
     * 限时锁
     * 1.对传递的毫秒参数进行校验 并获取倒计时
     * 2.判断是否为当前加锁的线程 是? 继续等待 否? 拿锁 置位
     * 2.等待下 会阻塞在while循环中 等待唤醒或时间已到 自动唤醒
     * 3.唤醒后 当前时间作比较 超时 抛出异常 放弃该任务
     * 4.否则继续抢占锁 如抢占到 拿锁 置位 否则继续阻塞
     * @throws InterruptedException
     */
    @Override
    public synchronized void lock(long mills) throws InterruptedException, TimeoutException {
        if(mills<0) {
            lock();
        }
        long hasRemainTime = mills;
        long endTime = System.currentTimeMillis()+mills;
        while(initValue){
            if(hasRemainTime<0){
                throw new TimeoutException(Thread.currentThread().getName()+"等待超时 放弃该任务");
            }
            blockThreadCollection.add(Thread.currentThread());
            this.wait(hasRemainTime);
            hasRemainTime = endTime - System.currentTimeMillis();
        }
        System.out.println(Thread.currentThread().getName() + " get the lock monitor");
        this.initValue = true;
        this.currentThread = Thread.currentThread();
    }



    @Override
    public Collection<Thread> getBlockThread() {
        return blockThreadCollection;
    }


    public int getBlockSize() {
        return getBlockThread().size();
    }

}

package com.kk.cheapter8;

public class AsyncFuture<T> implements Future<T> {

    private volatile boolean done = false;

    private T result;

    @Override
    public void done(T result) {
        synchronized (this) {
            this.result = result;
            // 正常执行情况下设置标志位
            this.done = true;
            // 针对get方法中存在方法阻塞
            this.notifyAll();
        }
    }

    @Override
    public T get() throws InterruptedException {
        synchronized (this) {
            while (!done) {
                this.wait();
            }
        }
        return result;
    }
}

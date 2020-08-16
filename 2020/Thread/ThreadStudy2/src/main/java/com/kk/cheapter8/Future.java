package com.kk.cheapter8;


/**
 * 该接口是持有着未来的凭据
 */
public interface Future<T> {
    T get() throws InterruptedException;
    void done(T t);
}

package com.kk.cheapter8;

public interface Future<T> {

    T get();

    boolean isDone();

}

package com.kk.cheapter10;

public interface Completable<T> {
    void complete(T t);
    void exception(Exception canse);
}

package com.kk.cheapter10;

public interface Future<T> {

    T get();

    boolean isDone();

    void setCompletable(Completable<T> completable);

    Completable<T> getCompletable();
}

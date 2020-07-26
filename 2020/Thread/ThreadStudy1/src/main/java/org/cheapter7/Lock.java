package org.cheapter7;

import java.util.Collection;

public interface Lock {


    void lock() throws InterruptedException;

    void lock(long miles) throws InterruptedException,TimeOutException;

    void unlock();

    Collection<Thread> getBlockedThread();

    int getBlockedSize();

}

class TimeOutException extends RuntimeException{
    public TimeOutException(String message) {
        super(message);
    }
}
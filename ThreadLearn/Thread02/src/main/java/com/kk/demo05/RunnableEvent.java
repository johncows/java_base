package com.kk.demo05;

/**
 * @author KK
 * @create 2019-05-23 17:22
 **/
public class RunnableEvent {

    private final RunnableState state;
    private final Thread thread;
    private final Throwable cause;

    public RunnableEvent(RunnableState state, Thread thread, Throwable cause) {
        this.state = state;
        this.thread = thread;
        this.cause = cause;
    }

    public RunnableState getState() {
        return state;
    }

    public Thread getThread() {
        return thread;
    }

    public Throwable getCause() {
        return cause;
    }

}

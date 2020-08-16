package com.kk.cheapter5;

public abstract class ObservableRunnable implements Runnable{

    final protected LifeCycleListener listener;

    public ObservableRunnable(LifeCycleListener listener) {
        this.listener = listener;
    }

    protected void notifyChange(final RunnableEvent runnableEvent){
        listener.onEvent(runnableEvent);
    }


    public enum RunnableState{
        RUNNING,ERROR,DONE;
    }

    public static class RunnableEvent{
        private final RunnableState runnableState;
        private final Thread thread;
        private final Throwable cause;

        public RunnableState getRunnableState() {
            return runnableState;
        }

        public Thread getThread() {
            return thread;
        }

        public Throwable getCause() {
            return cause;
        }

        public RunnableEvent(RunnableState runnableState, Thread thread, Throwable cause) {
            this.runnableState = runnableState;
            this.thread = thread;
            this.cause = cause;
        }
    }


}

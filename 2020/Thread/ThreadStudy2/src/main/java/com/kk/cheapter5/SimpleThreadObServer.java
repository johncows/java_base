package com.kk.cheapter5;

import java.util.List;
import java.util.Optional;

public class SimpleThreadObServer implements LifeCycleListener {

    private final Object LOCK = new Object();

    public void concurrentQuery(List<String> ids) {
        if (ids == null || "".equals(ids)) {
            return;
        }

        ids.stream().forEach(id -> {
            new Thread(new ObservableRunnable(this) {
                @Override
                public void run() {
                    try {
                        notifyChange(new RunnableEvent(RunnableState.RUNNING, Thread.currentThread(), null));
                        Optional.of("query for the id " + id).ifPresent(System.out::println);
                        Thread.sleep(10_000);
                        if(id == "3"){
                            throw new RuntimeException("嘟嘟嘟 出现了不可逆转的错误");
                        }
                        notifyChange(new RunnableEvent(RunnableState.DONE, Thread.currentThread(), null));
                    } catch (Throwable e) {
                        notifyChange(new RunnableEvent(RunnableState.ERROR, Thread.currentThread(), e));
                    }
                }
            }, id).start();
        });

    }

    @Override
    public void onEvent(ObservableRunnable.RunnableEvent runnableEvent) {
        synchronized (LOCK) {
            System.out.printf("the runnale state is %s and the Exception is %s for Thread %s\n",
                    runnableEvent.getRunnableState(), runnableEvent.getCause(), runnableEvent.getThread().getName());
        }
    }
}

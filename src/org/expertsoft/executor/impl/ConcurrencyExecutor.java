package org.expertsoft.executor.impl;

import org.expertsoft.executor.Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wladek on 1/24/17.
 */
public class ConcurrencyExecutor implements Executor {
    private final ExecutorService executorService;

    public ConcurrencyExecutor(){
        executorService = Executors.newSingleThreadScheduledExecutor();
    }

    @Override
    public void execute(Runnable task) {
        executorService.execute(task);
    }
}

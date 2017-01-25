package org.expertsoft.executor.impl;

import org.expertsoft.executor.Executor;
import org.expertsoft.executor.TaskAccess;
import org.expertsoft.executor.thread.ExecuteThread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by wladek on 1/24/17.
 */
public class ExecutorSynchronousQueueImpl implements Executor, TaskAccess {
    private final BlockingQueue<Runnable> queueOfTasks;
    private final ExecuteThread executeThread;

    public ExecutorSynchronousQueueImpl(){
        queueOfTasks = new SynchronousQueue<Runnable>();
        executeThread = new ExecuteThread(this);
        executeThread.start();
    }

    public Runnable getNextTask(){
        try {
            return queueOfTasks.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }

    public void execute(Runnable task){
        try {
            queueOfTasks.put(task);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        executeThread.myNotify();
    }
}

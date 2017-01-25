package org.expertsoft.executor.thread;

import org.expertsoft.executor.TaskAccess;

/**
 * Created by wladek on 1/13/17.
 */
public class ExecuteThread extends Thread {

    private final TaskAccess executor;
    private final Object lock;

    public ExecuteThread(TaskAccess executor){
        super();
        this.lock = new Object();
        this.executor = executor;
    }

    @Override
    public void run(){
        while(true){
            try{
                Runnable task = executor.getNextTask();
                if (task != null) {
                    task.run();
                } else {
                    synchronized (lock){
                        lock.wait();
                    }
                }
            }catch (Exception e){
                System.out.println("error in the task");
            }
        }
    }

    public void myNotify(){
        synchronized (lock) {
            lock.notify();
        }
    }
}

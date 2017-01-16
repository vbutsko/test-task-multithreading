package org.expertsoft.executor;

import java.util.Queue;

/**
 * Created by wladek on 1/16/17.
 */
public class ExecuteTask implements Runnable {

    private final Queue<String> messages;
    private final String message;

    public ExecuteTask(Queue<String> messages, String message){
        this.messages = messages;
        this.message = message;
    }

    @Override
    public void run() {
        synchronized (messages){
            messages.add(message);
        }
    }
}

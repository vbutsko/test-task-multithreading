package org.expertsoft.logger;

import org.expertsoft.executor.Executor;
import org.expertsoft.executor.impl.ExecutorImpl;
import org.expertsoft.logger.runnable.LogRunnable;


/**
 * Created by wladek on 1/13/17.
 */
public class Logger {
    private final Executor executor;
    private final String fileName;

    public Logger(String fileName){
        super();
        this.fileName = fileName;
        executor = new ExecutorImpl();
    }

    public void logMessage(String message){
        executor.execute(createLogRunnable(message));
    }

    private LogRunnable createLogRunnable(String message){
        return new LogRunnable(fileName, message);
    }
}

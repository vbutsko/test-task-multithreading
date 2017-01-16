package org.expertsoft.logger;

import org.expertsoft.executor.Executor;
import org.expertsoft.executor.impl.ExecutorImpl;
import org.expertsoft.logger.runnable.LogRunnable;
import java.io.File;

/**
 * Created by wladek on 1/13/17.
 */
public class Logger {
    private final Executor executor;
    private String fileName;
    private File file;

    protected Logger(){
        super();
        this.file = null;
        this.fileName = null;
        executor = new ExecutorImpl();
    }

    public Logger(String fileName){
        this();
        this.fileName = fileName;
    }

    public Logger(File file){
        this();
        this.file = file;
    }

    public void logMessage(String message){
        executor.execute(createLogRunnable(message));
    }

    private LogRunnable createLogRunnable(String message){
        if(fileName != null) {
            return new LogRunnable(fileName, message);
        }else if(file != null){
            return new LogRunnable(file, message);
        }else{
            return null;
        }
    }
}

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


    public Logger(String fileName){
        this(new ExecutorImpl(), fileName);
    }

    public Logger(Executor executor, String fileName){
        this(executor, fileName, null);
    }

    public Logger(File file){
        this(new ExecutorImpl(), file);
    }

    public Logger(Executor executor, File file){
        this(executor, null, file);
    }

    protected Logger(Executor executor, String fileName, File file){
        super();
        this.executor = executor;
        this.fileName = fileName;
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

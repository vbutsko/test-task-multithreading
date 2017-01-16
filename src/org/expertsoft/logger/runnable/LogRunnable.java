package org.expertsoft.logger.runnable;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

/**
 * Created by wladek on 1/13/17.
 */
public class LogRunnable implements Runnable {

    private String fileName;
    private String message;
    private File file;

    protected LogRunnable(String message){
        super();
        this.message = message;
        this.file = null;
        this.fileName = null;
    }

    public LogRunnable(String fileName, String message) {
        this(message);
        this.fileName = fileName;
    }
    public LogRunnable(File file, String message){
        this(message);
        this.file = file;
    }
    @Override
    public void run() {
        FileWriter fileWriter = null;
        try {
            if(fileName != null) {
                fileWriter = new FileWriter(fileName, true);
            }else{
                fileWriter = new FileWriter(file, true);
            }
            fileWriter.write(message+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

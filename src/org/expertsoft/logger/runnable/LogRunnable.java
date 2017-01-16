package org.expertsoft.logger.runnable;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by wladek on 1/13/17.
 */
public class LogRunnable implements Runnable {

    private String fileName;
    private String message;
    public LogRunnable(String fileName, String message) {
        super();
        this.fileName = fileName;
        this.message = message;
    }

    @Override
    public void run() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName, true);
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

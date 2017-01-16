package org.expertsoft;

import org.expertsoft.logger.Logger;

/**
 * Created by wladek on 1/13/17.
 */
public class Main {


    public static void main(String args[]){
        Logger logger = new Logger("myFile.txt");
        logger.logMessage("Task 1");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.logMessage("Task 2");

    }

}

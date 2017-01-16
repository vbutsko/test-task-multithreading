package org.expertsoft.logger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * Created by wladek on 1/16/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class LoggerTest {
    private Logger logger;
    private File file;
    private final String FILENAME = "testFile";
    private final String message1 = "message 1";
    private final String message2 = "message 2";

    @Before
    public void setUp(){
        file = new File(FILENAME);
        file.delete();
        file = new File(FILENAME);
        logger = new Logger(file);
    }

    @Test
    public void testLogger() throws FileNotFoundException {
        int num1 = 100, num2 = 100;
        Runnable thread1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < num1; i++) {
                    logger.logMessage(message1);
                }
            }
        };
        Runnable thread2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < num2; i++) {
                    logger.logMessage(message2);
                }
            }
        };
        thread1.run();
        thread2.run();

        Scanner scanner = new Scanner(file);
        int numLines = 0;
        while(scanner.hasNextLine()){
            scanner.nextLine();
            numLines++;
        }

        Assert.assertEquals(num1 + num2, numLines);
    }
}

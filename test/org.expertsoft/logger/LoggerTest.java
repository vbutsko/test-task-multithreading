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
    private final String FILENAME = "testFile";
    private final String message1 = "message 1";
    private final String message2 = "message 2";
    private final String message3 = "message 3";
    private final String message4 = "message 4";

    @Before
    public void setUp(){
        logger = new Logger(FILENAME);
    }

    @Test
    public void testLogger() throws FileNotFoundException {
        logger.logMessage(message1);
        logger.logMessage(message2);
        logger.logMessage(message3);
        logger.logMessage(message4);
        String temp1 = null, temp2 = null, temp3 = null, temp4 = null;
        Scanner scanner = new Scanner(new File(FILENAME));
        while(scanner.hasNextLine()){
            temp1 = temp2;
            temp2 = temp3;
            temp3 = temp4;
            temp4 = scanner.nextLine();
        }
        Assert.assertEquals(temp1, message1);
        Assert.assertEquals(temp2, message2);
        Assert.assertEquals(temp3, message3);
        Assert.assertEquals(temp4, message4);
    }
}

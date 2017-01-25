package org.expertsoft.executor.impl;

import org.expertsoft.executor.Executor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wladek on 1/16/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class DefaultExecutorTest {
    private Executor executor;
    private ExecuteTask task1, task2, task3;
    private Queue<String> queue;
    private String mes1, mes2, mes3;
    @Before
    public void setUp() {
        mes1 = "mes1";
        mes2 = "mes2";
        mes3 = "mes3";
        executor = new DefaultExecutor();
        queue = new LinkedList<>();
        task1 = new ExecuteTask(queue, mes1);
        task2 = new ExecuteTask(queue, mes2);
        task3 = new ExecuteTask(queue, mes3);
    }

    @Test
    public void testExecute(){
        int num1 = 100, num2 = 100;
        Runnable thread1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < num1; i++) {
                    executor.execute(task1);
                }
            }
        };
        Runnable thread2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < num2; i++) {
                    executor.execute(task2);
                }
            }
        };
        thread1.run();
        thread2.run();

        Assert.assertEquals(num1 + num2, queue.size());
    }
}

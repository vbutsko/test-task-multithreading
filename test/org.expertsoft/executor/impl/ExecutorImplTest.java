package org.expertsoft.executor.impl;

import org.expertsoft.executor.ExecuteTask;
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
public class ExecutorImplTest {
    private Executor executor;
    private ExecuteTask task1, task2, task3;
    private Queue<String> queue;
    private String mes1, mes2, mes3;
    @Before
    public void setUp() {
        mes1 = "mes1";
        mes2 = "mes2";
        mes3 = "mes3";
        executor = new ExecutorImpl();
        queue = new LinkedList<>();
        task1 = new ExecuteTask(queue, mes1);
        task2 = new ExecuteTask(queue, mes2);
        task3 = new ExecuteTask(queue, mes3);
    }

    @Test
    public void testExecute(){
        executor.execute(task1);
        executor.execute(task2);
        executor.execute(task3);
        Assert.assertEquals(mes1, queue.poll());
        Assert.assertEquals(mes2, queue.poll());
        Assert.assertEquals(mes3, queue.poll());

        executor.execute(task3);
        executor.execute(task2);
        executor.execute(task1);
        Assert.assertEquals(mes3, queue.poll());
        Assert.assertEquals(mes2, queue.poll());
        Assert.assertEquals(mes1, queue.poll());
    }

}

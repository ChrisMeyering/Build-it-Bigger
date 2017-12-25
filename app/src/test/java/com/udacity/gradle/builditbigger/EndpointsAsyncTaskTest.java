package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.text.TextUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by chris on 12/25/17.
 */
@RunWith(JUnit4.class)
public class EndpointsAsyncTaskTest implements EndpointsAsyncTask.EndpointsAsyncTaskListener{
    public static final int TIMEOUT_DURATION_SECONDS = 10;
    String result = null;
    CountDownLatch signal;

    @Before
    public void setUp() {
        signal = new CountDownLatch(1);
    }


    @Test
    public void testResponseNotNul() {

        EndpointsAsyncTask task = new EndpointsAsyncTask(null);
        task.execute();
        try {
            signal.await(TIMEOUT_DURATION_SECONDS,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            result = task.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        assertNotNull("Query timed out", result);
        assertFalse("result is empty", TextUtils.isEmpty(result));

    }

    @Override
    public void onComplete(String joke) {
        this.result = joke;
        signal.countDown();
    }
}
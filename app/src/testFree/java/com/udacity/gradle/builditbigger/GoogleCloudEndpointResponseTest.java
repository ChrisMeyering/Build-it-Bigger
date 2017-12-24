package com.udacity.gradle.builditbigger;


import android.test.AndroidTestCase;
import android.test.ApplicationTestCase;
import android.text.TextUtils;
import android.util.Log;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by chris on 12/22/17.
 */
    public class GoogleCloudEndpointResponseTest extends AndroidTestCase implements EndpointsAsyncTask.EndpointsAsyncTaskListener {
    String result = null;
    CountDownLatch signal = null;
    private static final int TIME_TO_WAIT = 10;

    @Override
    protected void setUp() throws Exception {
        signal = new CountDownLatch(1);
    }

    @Override
    protected void tearDown() throws Exception {
        signal.countDown();
    }


    public void testJoke() throws InterruptedException {
        System.out.println("testing...");
        EndpointsAsyncTask task = new EndpointsAsyncTask(getContext(), null);
        task.setListner();
        task.execute();
        signal.await();
        /*try {
            result = task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/
        assertFalse (result.isEmpty());

        /*
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(getContext(), null);
        endpointsAsyncTask.execute();
        try {
            result = endpointsAsyncTask.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        signal.await(TIME_TO_WAIT, TimeUnit.SECONDS);

        assertNotNull(result);


        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(getContext(), null);
        endpointsAsyncTask.execute();
        try {
            result = endpointsAsyncTask.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result);
        assert (!result.isEmpty());
        */
    }

    @Override
    public void onComplete(String joke) {
        result = joke;
        signal.countDown();
    }
}
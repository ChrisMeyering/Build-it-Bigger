package com.udacity.gradle.builditbigger;


/**
 * Created by chris on 12/22/17.
 */

public class GoogleCloudEndpointResponseTest {
  /*
    String result = null;
    CountDownLatch signal = null;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        signal = new CountDownLatch(1);
    }


    public void testJoke() throws InterruptedException {
        System.out.println("testing...");
        assertNotNull(null);
        try {
            runTestOnUiThread(new Runnable() {
                @Override
                public void run() {
                    EndpointsAsyncTask task = new EndpointsAsyncTask(getInstrumentation().getTargetContext(), null);
                    task.setListner();
                    task.execute();
                    try {
                        result = task.get();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    assertNotNull(null);

                }
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        signal.await();
//        try {
//            result = task.get();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
        System.out.println(result);
        assertNotNull(result);
        assertFalse (result.isEmpty());
        signal = new CountDownLatch(1);

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

    }

    @Override
    public void onComplete(String joke) {
        result = joke;
        signal.countDown();
    }
    */
}
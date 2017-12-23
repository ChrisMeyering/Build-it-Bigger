package com.udacity.gradle.builditbigger;


import android.test.AndroidTestCase;

/**
 * Created by chris on 12/22/17.
 */
public class GoogleCloudEndpointResponseTest extends AndroidTestCase {

    public void tellJoke() throws Exception {
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(getContext(), null);
        endpointsAsyncTask.execute();
        String result = null;
        try {
            result = endpointsAsyncTask.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result);
        assert (!result.isEmpty());
    }

}
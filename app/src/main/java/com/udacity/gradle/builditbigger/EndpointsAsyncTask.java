package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.joker.chris.Joker;
import com.joker.chris.androidjokes.JokeActivity;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.builditbigger.backend.myApi.model.MyBean;

import java.io.IOException;

/**
 * Created by chris on 12/20/17.
 */

public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    public static final String TAG = EndpointsAsyncTask.class.getSimpleName();
    private Context context;
    private ProgressBar progressBar;
    private static MyApi myApi = null;
    private EndpointsAsyncTaskListener listener = null;

    public interface EndpointsAsyncTaskListener {
        void onComplete(String joke);
    }

    public EndpointsAsyncTask(Context context, ProgressBar progressBar) {
        System.out.println("EndpointsAsyncTask constructor");
        this.context = context;
        this.progressBar = progressBar;
    }

    public void setListner() {
        this.listener = (EndpointsAsyncTaskListener) context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        System.out.println("onPreExecute");
        if (progressBar != null) {
            progressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected String doInBackground(Void... voids) {
        if (myApi == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl(context.getString(R.string.api_url))
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
            myApi = builder.build();
        }
        System.out.println("doInBackground");
        try {
            return myApi.makeJoke(new MyBean()).execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String s) {

        System.out.println("onPostExecute");
        if (progressBar != null) {
            progressBar.setVisibility(View.INVISIBLE);
        }
        if (listener != null) {
            listener.onComplete(s);
        }
        tellJoke(s);
    }

    @Override
    protected void onCancelled() {
        if (listener != null){
            listener.onComplete(null);
        }
    }

    public void tellJoke(String s) {
        Intent intent = new Intent(context, JokeActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, s);
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
        context.startActivity(intent);
    }
}

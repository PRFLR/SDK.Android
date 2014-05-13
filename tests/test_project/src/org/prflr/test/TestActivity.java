package org.prflr.test;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import org.prflr.sdk.PRFLR;

public class TestActivity extends Activity {
    private static final String TAG = "Test";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new InitTask().execute();

    }

    /* Initializing PRFLR. Should be done in separate thread, as we are receiving server's IP and opening connection. */
    private class InitTask extends AsyncTask<Void, Void, Void> {

        @Override protected Void doInBackground(Void... voids) {
            PRFLR.init(TestActivity.this);
            return null;
        }

        @Override protected void onPostExecute(Void aVoid) {
            // Chaining calls.
            new SomeLongTask().execute();
        }
    }

    /* Doing something with all the things we've got now. */
    private class SomeLongTask extends AsyncTask<Void, Void, Void> {

        @Override protected void onPreExecute() {
            /* Let's set up the timer... */
            PRFLR.begin("TestTimer");
            Log.v(TAG, "Started!");
        }

        @Override protected Void doInBackground(Void... voids) {
            /* ...then do something difficult... */
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return null;
        }

        @Override protected void onPostExecute(Void aVoid) {
            /* ...and then send the timer to prflr.org. Easy. */
            PRFLR.end("TestTimer", "success");
            Log.v(TAG, "Finished and sent!");
        }

    }

}

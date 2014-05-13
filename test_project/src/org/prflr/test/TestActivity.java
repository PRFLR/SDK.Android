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

        PRFLR.init(this);
        new SomeLongTask().execute();

    }

    /* Doing something with all the things we've got now. */
    private class SomeLongTask extends AsyncTask<Void, Void, Void> {

        @Override protected void onPreExecute() {
            /* Let's set up the timer... */
            PRFLR.begin("TestTimer1");
            PRFLR.begin("TestTimer2");
            PRFLR.begin("TestTimer3");
            PRFLR.begin("TestTimer4");
            PRFLR.begin("TestTimer5");
            PRFLR.begin("TestTimer6");
            PRFLR.begin("TestTimer7");
            PRFLR.begin("TestTimer8");
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
            PRFLR.end("TestTimer1", "success");
            PRFLR.end("TestTimer2", "success");
            PRFLR.end("TestTimer3", "success");
            PRFLR.end("TestTimer4", "success");
            PRFLR.end("TestTimer5", "success");
            PRFLR.end("TestTimer6", "success");
            PRFLR.end("TestTimer7", "success");
            PRFLR.end("TestTimer8", "success");
            Log.v(TAG, "Finished and sent!");
        }

    }

}

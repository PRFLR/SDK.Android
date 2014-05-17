package org.prflr.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;


public final class PRFLR {

    private static final String TAG = "PRFLR";


    /**
     * Initializes PRFLR.
     */
    public static void init(Context c) {

        if (PRFLRSender.initialized()) {
            Log.w(TAG, "Already initialized!");
            return;
        }

        try {

            Log.d(TAG, "Initializing PRFLR.");

            PackageManager pm = c.getPackageManager();
            assert pm != null;

            String version = pm.getPackageInfo(c.getPackageName(), 0).versionName;

            ApplicationInfo inf = pm.getApplicationInfo(c.getPackageName(), PackageManager.GET_META_DATA);

            String apiKey = inf.metaData.getString("org.prflr.apikey");

            String source = version + "." +getDeviceName();
            PRFLRSender.init(source, apiKey);

        } catch (Exception e) {
            Log.e(TAG, "Initialization error", e);
        }

    }

    /**
     * Sets maximum amount of idle timers. Timer storage will be cleared
     */
    public static void setOveflowCounter(int value) {
        PRFLRSender.setOverflowCount(value);
    }

    public static void begin(String timerName) {
        try {
            PRFLRSender sender = PRFLRSender.getInstance();
            if (sender != null)
                sender.begin(timerName);
        } catch (Exception e) {
            Log.e(TAG, "Error while executing begin()", e);
        }
    }

    public static void end(String timerName) {
        try {
            PRFLRSender sender = PRFLRSender.getInstance();
            if (sender != null)
                sender.end(timerName);
        } catch (Exception e) {
            Log.e(TAG, "Error while executing end()", e);
        }
    }

    public static void end(String timerName, String info) {
        try {
            PRFLRSender sender = PRFLRSender.getInstance();
            if (sender != null)
                sender.end(timerName, info);
        } catch (Exception e) {
            Log.e(TAG, "Error while executing end()", e);
        }
    }

    private static String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        String version = Build.VERSION.RELEASE;

        if (model.startsWith(manufacturer)) {
            return model + version;
        } else {
            return manufacturer + model + version;
        }
    }
}

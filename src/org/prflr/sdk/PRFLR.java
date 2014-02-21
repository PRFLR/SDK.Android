package org.prflr.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;


public final class PRFLR{
    private PRFLR() {
    }

    public static void init(Context c){
        if(PRFLRSender.init) return;
        Log.d("PRFLR", "Init");
        try {
            PackageManager pm = c.getPackageManager();
            String version = pm.getPackageInfo(c.getPackageName(), 0).versionName;
            ApplicationInfo  inf = pm.getApplicationInfo(c.getPackageName(), PackageManager.GET_META_DATA);
            String apiKey = inf.metaData.getString("org.prflr.apikey");
            String source = getDeviceName() + " " + version;
            PRFLRSender.init(source, apiKey);
        } catch (Exception e) {
            Log.d("PRFLR", e.toString());
        }
    }

    public static void setOveflowCounter(int value) {
        PRFLRSender.overflowCount = value;
    }

    public static void begin(String timerName) {
        try {
            PRFLRSender.begin(timerName);
        } catch (Exception e) {
            Log.d("PRFLR", e.toString());
        }
    }

    public static void end(String timerName) {
        try {
            PRFLRSender.end(timerName);
        } catch (Exception e) {
            Log.d("PRFLR", e.toString());
        }
    }

    public static void end(String timerName, String info) {
        try {
            PRFLRSender.end(timerName, info);
        } catch (Exception e) {
            Log.d("PRFLR", e.toString());
        }
    }
    private static String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        String version = Build.VERSION.RELEASE;
        if (model.startsWith(manufacturer)) {
            return model + " " + version;
        } else {
            return manufacturer + " " + model + " " + version;
        }
    }
}

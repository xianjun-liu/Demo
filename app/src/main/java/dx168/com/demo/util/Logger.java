package dx168.com.demo.util;

import android.util.Log;

/**
 * Created by lxj on 17/2/17.
 */

public class Logger {
    private static boolean debugOn = false;
    protected static final String TAG = "logger";

    public Logger() {
    }

    public static void d(String message) {
        d("logger", message);
    }

    public static void v(String message) {
        v("logger", message);
    }

    public static void e(String message) {
        e("logger", message);
    }

    public static void d(String tag, String message) {
        if(isDebugOn()) {
            Log.d(tag, message);
        }

    }

    public static void v(String tag, String message) {
        if(isDebugOn()) {
            Log.v(tag, message);
        }

    }

    public static void e(String tag, String message) {
        if(isDebugOn()) {
            Log.e(tag, message);
        }

    }

    public static boolean isDebugOn() {
        return debugOn;
    }

    public static void setDebugOn(boolean debugOn) {
        debugOn = debugOn;
    }
}

package com.debut.uniqueid;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.provider.Settings.Secure;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/**
 * UniqueIdPlugin
 */
public class UniqueIdPlugin implements MethodCallHandler {
    /**
     * Plugin registration.
     */

    private final Activity activity;

    private UniqueIdPlugin(Activity activity) {
        this.activity = activity;
    }

    public static void registerWith(Registrar registrar) {
        final MethodChannel channel = new MethodChannel(registrar.messenger(), "unique_id");
        channel.setMethodCallHandler(new UniqueIdPlugin(registrar.activity()));
    }

    @TargetApi(Build.VERSION_CODES.CUPCAKE)
    @SuppressLint("HardwareIds")
    @Override
    public void onMethodCall(MethodCall call, Result result) {
        if (call.method.equals("getID")) {
            result.success(Secure.getString(activity.getContentResolver(), Secure.ANDROID_ID));
        } else {
            result.notImplemented();
        }
    }
}

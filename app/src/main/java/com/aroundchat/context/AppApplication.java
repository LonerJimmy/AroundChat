package com.aroundchat.context;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;

import com.aroundchat.network.Network;

import java.util.HashMap;

import okhttp3.OkHttpClient;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppApplication extends Application {

    private static AppApplication mInstance;

    public static AppApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        if (isMainProcess()) {
            onMainApplicationCreate();
        }
    }

    private void onMainApplicationCreate() {
        HashMap<String, String> urls = new HashMap<>();
        urls.put("picture", "http://werwrwe");

        new Network.Builder(mInstance)
                .addAlphaUrl(urls)
//                .setCallAdapterFactory()
                .setConverterFactory(GsonConverterFactory.create())
                .setHttpClientBuilder(new OkHttpClient.Builder())
                .build();
    }

    public boolean isMainProcess() {
        return getPackageName().equals(getCurrentProcessName());
    }

    public String getCurrentProcessName() {
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        if (activityManager == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo processInfo : activityManager
                .getRunningAppProcesses()) {
            if (processInfo.pid == android.os.Process.myPid()) {
                return processInfo.processName;
            }
        }
        return null;
    }
}

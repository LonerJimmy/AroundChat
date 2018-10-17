package com.aroundchat.network;

import android.app.Application;

import com.aroundchat.context.AppApplication;

import java.util.HashMap;
import java.util.LinkedHashMap;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {

    private static volatile Network sInstance;

    private OkHttpClient mOkHttpClient;

    private Converter.Factory mConverterFactory;

    private CallAdapter.Factory mCallAdapterFactory;

    private HashMap<String, String> mUrls;

    public static Network getInstance() {
        if (sInstance == null) {
            throw new IllegalStateException("TalarisNet has not be initialized!!!");
        }
        return sInstance;
    }

    private static Network init(OkHttpClient.Builder httpClientBuilder, Converter.Factory converterFactory, CallAdapter.Factory callAdapterFactory, Application application, HashMap<String, String> urls) {
        sInstance = new Network(httpClientBuilder, converterFactory, callAdapterFactory, application, urls);
        return sInstance;
    }

    private Network(OkHttpClient.Builder httpClientBuilder, Converter.Factory converterFactory, CallAdapter.Factory callAdapterFactory, Application application, HashMap<String, String> urls) {
//        changeEnvManager = new ChangeEnvManager(application, envMap, defaultEnv);
        mOkHttpClient = httpClientBuilder.build();
        if (converterFactory != null) {
            mConverterFactory = converterFactory;
        } else {
            mConverterFactory = GsonConverterFactory.create();
        }
        mCallAdapterFactory = callAdapterFactory;
        mUrls = urls;
    }

    public Retrofit getRetrofit(String key) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(getUrl(key))
                .client(mOkHttpClient)
                .addConverterFactory(mConverterFactory);
        if (mCallAdapterFactory != null) {
            builder.addCallAdapterFactory(mCallAdapterFactory);
        }
        return builder.build();
    }

    private String getUrl(String key) {
        return mUrls.get(key);
    }

    public static class Builder {

        private AppApplication mApplication;

        private OkHttpClient.Builder mHttpClientBuilder;

        private Converter.Factory mConverterFactory;

        private CallAdapter.Factory mCallAdapterFactory;

        private LinkedHashMap<String, HashMap<String, String>> mEnvMap;

        public Builder(AppApplication appApplication) {
            mApplication = appApplication;
            mEnvMap = new LinkedHashMap<>();
        }

        /**
         * 设置 HttpClientBuilder
         *
         * @param httpClientBuilder {@link  okhttp3.OkHttpClient.Builder }
         */
        public Builder setHttpClientBuilder(OkHttpClient.Builder httpClientBuilder) {
            mHttpClientBuilder = httpClientBuilder;
            return this;
        }

        public Builder setConverterFactory(Converter.Factory factory) {
            mConverterFactory = factory;
            return this;
        }

        public Builder setCallAdapterFactory(CallAdapter.Factory callAdapterFactory) {
            mCallAdapterFactory = callAdapterFactory;
            return this;
        }

        public Builder addAlphaUrl(HashMap<String, String> url) {
            mEnvMap.put("alpha", url);
            return this;
        }

        public Network build() {
            return Network.init(mHttpClientBuilder, mConverterFactory, mCallAdapterFactory, mApplication, mEnvMap.get("alpha"));
        }

    }
//
//    private Network() {
//        retrofit = new Retrofit.Builder()
//                //使用自定义的mGsonConverterFactory
//                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl("http://apis.baidu.com/txapi/")
//                .build();
//    }
}

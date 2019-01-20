package com.bwie.gejuan.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者：gj
 * 时间：20190120
 * 请求的网络数据及日志拦截器
 */
public class NetworkManager {
    public static NetworkManager mInstance;
    private Retrofit retrofit;

    public static NetworkManager mInstance(){
        if(mInstance==null){
            mInstance = new NetworkManager();
        }
        return mInstance;
    }
    private NetworkManager(){//单例模式
        init();
    }

    private void init() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);//自定义日志拦截器

        OkHttpClient okHttpClient = new OkHttpClient();//自定义okhttp
        okHttpClient.newBuilder().addInterceptor(httpLoggingInterceptor)
                .connectTimeout(60,TimeUnit.SECONDS)
                .readTimeout(60,TimeUnit.SECONDS)
                .writeTimeout(60,TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()//retrofit
                .baseUrl("http://www.zhaoapi.cn/")
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public <T> T create(final Class<T> service) {
        return retrofit.create(service);
    }
}

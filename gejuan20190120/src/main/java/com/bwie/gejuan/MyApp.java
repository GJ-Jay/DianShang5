package com.bwie.gejuan;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * 作者：gj
 * 时间：20190120
 * 初始化Fresco
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration build = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader instance = ImageLoader.getInstance();
        instance.init(build);
        Fresco.initialize(this);//初始化fresco
    }
}

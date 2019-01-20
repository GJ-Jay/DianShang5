package com.bwie.gejuan.presenter;

import com.bwie.gejuan.bean.Result;
import com.bwie.gejuan.core.DataCall;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：gj
 * 时间：20190120
 * P层基类
 */
public abstract class BasePresenter {
    DataCall dataCall;//回调接口
    private boolean running;

    public BasePresenter(DataCall dataCall) {
        this.dataCall = dataCall;
    }

    public abstract Observable observable(Object...args);

    public void request(Object...args){
        if(running){
            return;
        }
        running = true;
        observable(args).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Result>() {
                    @Override
                    public void accept(Result result) throws Exception {
                        running = false;
                        dataCall.success(result);
                    }
                }, new Consumer<Result>() {
                    @Override
                    public void accept(Result result) throws Exception {
                        running = false;
                        dataCall.fail(result);
                    }
                });
    }

    public void unBind(){
        dataCall = null;
    }
    public boolean isRunning(){
        return running;
    }
}

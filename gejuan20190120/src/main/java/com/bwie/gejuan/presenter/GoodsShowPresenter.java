package com.bwie.gejuan.presenter;

import com.bwie.gejuan.core.DataCall;
import com.bwie.gejuan.http.IRequest;
import com.bwie.gejuan.http.NetworkManager;

import io.reactivex.Observable;
/**
 * 作者：gj
 * 时间：20190120
 * 商品详情请求数据P层
 */
public class GoodsShowPresenter extends BasePresenter{

    public GoodsShowPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    public Observable observable(Object... args) {
        IRequest iRequest = NetworkManager.mInstance().create(IRequest.class);
        return iRequest.getShowGoods((long)args[0]);
    }
}

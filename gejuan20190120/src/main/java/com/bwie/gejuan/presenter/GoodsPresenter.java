package com.bwie.gejuan.presenter;

import com.bwie.gejuan.core.DataCall;
import com.bwie.gejuan.http.IRequest;
import com.bwie.gejuan.http.NetworkManager;

import io.reactivex.Observable;

/**
 * 作者：gj
 * 时间：20190120
 * P层
 */
public class GoodsPresenter extends BasePresenter{

    /*private int page = 1;
    public int getPage(){
        return page;
    }*/

    public GoodsPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    public Observable observable(Object... args) {
        IRequest iRequest = NetworkManager.mInstance().create(IRequest.class);
        return iRequest.getgoods();
        /*boolean refresh = (boolean) args[0];
        if(refresh){
            page=1;
        }else {
            page++;
        }*/
    }
}

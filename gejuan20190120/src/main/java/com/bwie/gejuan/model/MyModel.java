package com.bwie.gejuan.model;

import com.bwie.gejuan.http.IRequest;
import com.bwie.gejuan.http.NetworkManager;
/**
 * 作者：gj
 * 时间：20190120
 * M层
 */
public class MyModel {
    public static IRequest get(){
        IRequest iRequest = NetworkManager.mInstance().create(IRequest.class);
        return iRequest;
    }
}

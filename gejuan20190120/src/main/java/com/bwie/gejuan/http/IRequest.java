package com.bwie.gejuan.http;

import com.bwie.gejuan.bean.Goods;
import com.bwie.gejuan.bean.Result;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 作者：gj
 * 时间：20190120
 * 请求数据接口
 */
public interface IRequest {

    //商品列表
    @GET("product/searchProducts?keywords=笔记本&page=1")
    Observable<Result<List<Goods>>> getgoods();

    //商品详情
    @GET("product/getProductDetail")
    Observable<Result<List<Goods>>> getShowGoods(@Query("pid")long pid);
}

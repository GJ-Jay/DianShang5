package com.bwie.gejuan.core;

import com.bwie.gejuan.bean.Result;

/**
 * 作者：gj
 * 时间：20190120
 * 自定义接口
 */
public interface DataCall<T> {
    void success(T result);
    void fail(Result result);
}

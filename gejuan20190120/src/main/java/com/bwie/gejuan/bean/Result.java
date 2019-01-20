package com.bwie.gejuan.bean;
/**
 * 作者：gj
 * 时间：20190120
 * 结果类
 */
public class Result<T> {
    private String msg;
    private String code;
    private T data;//list
    private String page;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}

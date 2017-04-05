package com.ethan.domain;

/**
 * Created by Ethan L X Gu on 30/03/2017.
 */
public class Result<T> {

    // error code
    private Integer code;

    // error info
    private String msg;

    // the real info
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(final Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(final String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(final T data) {
        this.data = data;
    }
}

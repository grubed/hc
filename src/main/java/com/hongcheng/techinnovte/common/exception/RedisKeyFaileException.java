package com.hongcheng.techinnovte.common.exception;

public class RedisKeyFaileException extends Exception {
    private String msg;
    public RedisKeyFaileException() {
        this.msg = "可能已过期";
    }
    public String getErrMsg() {
        return this.msg;
    }
}

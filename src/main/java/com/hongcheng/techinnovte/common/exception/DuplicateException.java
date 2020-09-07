package com.hongcheng.techinnovte.common.exception;


public class DuplicateException extends Exception {
    private String msg;
    public DuplicateException() {
        this.msg = "数据重复";
    }
    public String getErrMsg() {
        return this.msg;
    }
}
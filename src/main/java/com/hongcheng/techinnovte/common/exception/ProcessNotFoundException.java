package com.hongcheng.techinnovte.common.exception;

import lombok.Data;

@Data
public class ProcessNotFoundException extends Exception{
    private String msg;
    public ProcessNotFoundException() {
        this.msg = "流程不存在";
    }
    public String getErrMsg() {
        return this.msg;
    }
}
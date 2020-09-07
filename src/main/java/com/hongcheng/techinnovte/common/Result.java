package com.hongcheng.techinnovte.common;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hongcheng.techinnovte.common.constants.ErrorEnum;
import lombok.Data;

@Data
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Result<T> {

    public static final int CODE_SUCCESS = 0;
    public static final int CODE_FAILED = 1;
    public static final int CODE_ERROR = -1;
    public static final int CODE_HEADER_ERROR = -2;

    private int code;
    private String msg;
    private T data;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static Result getSuccess() {
        Result result = new Result();
        result.code = CODE_SUCCESS;
        result.msg = "success";
        return result;
    }

    public static Result getSuccess(Object obj) {
        Result result = new Result();
        result.code = CODE_SUCCESS;
        result.msg = "success";
        result.data = obj;
        return result;
    }

    public static Result getSuccess(String msg) {
        Result result = new Result();
        result.code = CODE_SUCCESS;
        result.msg = msg;
        return result;
    }
    
    public static Result getFail(String msg) {
        Result result = new Result();
        result.code = CODE_FAILED;
        result.msg = msg;
        return result;
    }
    public static Result getFail(Integer code, String msg) {
        Result result = new Result();
        result.code = code;
        result.msg = msg;
        return result;
    }
    public static Result getFail(ErrorEnum errorEnum) {
        Result result = new Result();
        result.code = errorEnum.getErrorCode();
        result.msg = errorEnum.getErrorMsg();
        return result;
    }
    public static Result getHeaderFail(String msg) {
        Result result = new Result();
        result.code = CODE_HEADER_ERROR;
        result.msg = msg;
        return result;
    }

}

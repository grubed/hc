package com.hongcheng.techinnovte.common.exception;

import lombok.Data;

@Data
public class OldPasswordErrorException extends Exception{
    private String msg = "旧密码验证失败";
}

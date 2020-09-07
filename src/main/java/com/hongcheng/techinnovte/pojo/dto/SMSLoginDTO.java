package com.hongcheng.techinnovte.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SMSLoginDTO {
    @ApiModelProperty("手机号")
    private String mobile;
    @ApiModelProperty("验证码")
    private String code;
}

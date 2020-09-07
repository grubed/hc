package com.hongcheng.techinnovte.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserDTO {
    /**
     * 用户名
     */
    @ApiModelProperty("手机号")
    private String mobile;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;

    /**
     *
     */
    @ApiModelProperty("短信验证码")
    private String code;

    @ApiModelProperty("姓名")
    private String nickname;

    @ApiModelProperty("邮件")
    private String email;

    @ApiModelProperty("qq")
    private String qq;

    @ApiModelProperty("微信")
    private String wechart;
}

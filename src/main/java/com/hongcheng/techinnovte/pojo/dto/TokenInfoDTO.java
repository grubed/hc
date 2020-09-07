package com.hongcheng.techinnovte.pojo.dto;

import com.hongcheng.techinnovte.pojo.bean.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TokenInfoDTO {
    @ApiModelProperty("令牌")
    private String token;
    @ApiModelProperty("刷新令牌")
    private String refreshToken;
    @ApiModelProperty("用户信息")
    private User user;
}

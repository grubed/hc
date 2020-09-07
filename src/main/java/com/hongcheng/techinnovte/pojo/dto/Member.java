package com.hongcheng.techinnovte.pojo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Member {

    @ApiModelProperty("用户id")

    private Long custId;

    @ApiModelProperty("名称")

    private String custName;

    @ApiModelProperty("联系人")

    private String custContact;

    @ApiModelProperty("手机号")

    private String custPhone;

    @ApiModelProperty("成员类型")
    private String memberType;
}

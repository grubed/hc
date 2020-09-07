package com.hongcheng.techinnovte.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

import java.util.Date;

@Data
public class ApplyListDTO {
    private Long id;

    @ApiModelProperty("申请单类型")
    private String type;

    @ApiModelProperty("申请单类型中文")
    private String typeLabel;

    @ApiModelProperty("申请主体")
    private String name;

    @ApiModelProperty("申请单状态")
    private Integer sts;

    @ApiModelProperty("申请单状态中文")
    private String stsLabel;

    @ApiModelProperty("申请时间")
    private Date createTime;
}

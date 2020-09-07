package com.hongcheng.techinnovte.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AllianceInfoReqDTO {
    @ApiModelProperty("分联盟名称")
    private String namelike;
    @ApiModelProperty("sts")
    private Integer sts;
    @ApiModelProperty("第几页")
    private Integer page;
    @ApiModelProperty("每页多少条")
    private Integer rows;
}

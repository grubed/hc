package com.hongcheng.techinnovte.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CustTypeDTO {

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("名称代码")
    private String code;

    @ApiModelProperty("名称")
    private String name;
}

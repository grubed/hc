package com.hongcheng.techinnovte.pojo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PlatCustTypeDto {
	
	@ApiModelProperty("ID")
    private Long id;
	
    @ApiModelProperty("类型名称")
    private String name;

    @ApiModelProperty("推荐单位数")
    @JsonProperty("recom_num")
    private Long recomNum;

    @ApiModelProperty("描述")
    private String memo;
	
	@ApiModelProperty("IDS")
    private String ids;
	
    @ApiModelProperty("页码")
    private Long page = 1L;
    
    @ApiModelProperty("分页数")
    private Long rows = 10L;
}

package com.hongcheng.techinnovte.pojo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PlatDuesTypeDto {
	
	@ApiModelProperty("ID")
    private Long id;
	
    @ApiModelProperty("类型名称")
    private String name;

    @ApiModelProperty("缴费周期")
    @JsonProperty("period_num")
    private Integer periodNum;
    
    @ApiModelProperty("缴费单位")
    @JsonProperty("period_unit")
    private Integer periodUnit;
    
    @ApiModelProperty("缴费金额")
    private Integer amount;
    
    @ApiModelProperty("描述")
    private String memo;
	
	@ApiModelProperty("IDS")
    private String ids;
	
    @ApiModelProperty("页码")
    private Long page = 1L;
    
    @ApiModelProperty("分页数")
    private Long rows = 10L;
}

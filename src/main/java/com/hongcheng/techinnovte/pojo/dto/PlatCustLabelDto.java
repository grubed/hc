package com.hongcheng.techinnovte.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PlatCustLabelDto {
	
	@ApiModelProperty("ID")
    private Long id;
	
    @ApiModelProperty("标签名称")
    private String name;

    @ApiModelProperty("描述")
    private String memo;
	
	@ApiModelProperty("IDS")
    private String ids;
	
    @ApiModelProperty("页码")
    private Long page = 1L;
    
    @ApiModelProperty("分页数")
    private Long rows = 10L;
}

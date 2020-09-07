package com.hongcheng.techinnovte.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CustBaseDTO {

	@ApiModelProperty("ID")
    private Long id;
	
    @ApiModelProperty("客户名称")
    private String custname;

    @ApiModelProperty("状态")
    private String sts;
    
    @ApiModelProperty("页码")
    private Long page = 1L;
    
    @ApiModelProperty("分页数")
    private Long rows = 10L;
}

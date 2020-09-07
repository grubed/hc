package com.hongcheng.techinnovte.pojo.dto;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DataDTO<T> {
	
	@ApiModelProperty("记录总数")
    private Long total;
	
	@ApiModelProperty("页记录")
    private List<T> rows;
}

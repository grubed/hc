package com.hongcheng.techinnovte.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DictDTO {
    @ApiModelProperty("字典key")
    private String key;
    @ApiModelProperty("父节点值")
    private String parentlistvalue;
    @ApiModelProperty("是否选中")
    private Boolean selected;
    @ApiModelProperty("值")
    private String value;
    @ApiModelProperty("中文内容")
    private String content;
}

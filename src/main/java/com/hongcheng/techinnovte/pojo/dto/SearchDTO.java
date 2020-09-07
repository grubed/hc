package com.hongcheng.techinnovte.pojo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SearchDTO {
    @ApiModelProperty("名称")
    @JsonProperty("name_like")
    private String nameLike;

    @ApiModelProperty("状态")
    private Integer sts;

    @ApiModelProperty("第几页")
    private Integer page;

    @ApiModelProperty("每页多少条")
    private Integer rows;
}

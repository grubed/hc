package com.hongcheng.techinnovte.pojo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SponsorDTO {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("企业单位名称")
    @JsonProperty("cust_name")
    private String custName;

    /**
     * 统一社会信用代码
     */
    @ApiModelProperty("统一社会信用代码")
    @JsonProperty("cust_code")
    private String custCode;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;

    /**
     * 是否有效
     */
    @ApiModelProperty("是否有效")
    private Integer enabled;
}

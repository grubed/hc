package com.hongcheng.techinnovte.pojo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AllianceMemberSearchDTO {
    @ApiModelProperty("分联盟")
    @JsonProperty("alliance_name")
    private String allianceName;

    @ApiModelProperty("页")
    private BigDecimal page;

    @ApiModelProperty("数量")
    private BigDecimal rows;

}

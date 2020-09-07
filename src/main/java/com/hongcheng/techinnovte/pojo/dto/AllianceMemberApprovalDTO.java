package com.hongcheng.techinnovte.pojo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AllianceMemberApprovalDTO {
    @ApiModelProperty("状态")
    private String sts;

    @ApiModelProperty("审核理由")
    @JsonProperty("approval_opinion")
    private String approvalOpinion;

    @ApiModelProperty("id")
    private BigDecimal id;
}

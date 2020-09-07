package com.hongcheng.techinnovte.pojo.dto;

import com.hongcheng.techinnovte.common.enumeration.ApprovalEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ApprovalDTO {
    @ApiModelProperty("审批结果")
    private ApprovalEnum result;

    @ApiModelProperty("审核理由")
    private String approvalOpinion;

    @ApiModelProperty("id")
    private Long id;
}

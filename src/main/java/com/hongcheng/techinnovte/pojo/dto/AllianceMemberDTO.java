package com.hongcheng.techinnovte.pojo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AllianceMemberDTO {
    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("分联盟id")
    @JsonProperty("alliance_id")
    private BigDecimal allianceId;

    @ApiModelProperty("分联盟名")
    @JsonProperty("alliance_name")
    private String allianceName;
    /**
     * 单位ID
     */
    @ApiModelProperty("单位ID")
    @JsonProperty("cust_id")
    private BigDecimal custId;

    @ApiModelProperty("单位名")
    @JsonProperty("cust_name")
    private String custName;
    /**
     * 单位联系人
     */
    @ApiModelProperty("联系人")
    @JsonProperty("cust_contact")
    private String custContact;

    /**
     * 单位联系人电话
     */
    @ApiModelProperty("单位联系人电话")
    @JsonProperty("cust_phone")
    private String custPhone;

    /**
     * 申请表
     */
    @ApiModelProperty("申请表")
    @JsonProperty("apply_file")
    private String applyFile;


    /**
     * 加入理由
     */
    @ApiModelProperty("加入理由")
    @JsonProperty("join_reason")
    private String joinReason;

    @JsonProperty("member_type")
    private String memberType;


    private BigDecimal sts;

    private String stsname;

    @JsonProperty("approval_opinion")
    private String approvalOpinion;

    @JsonProperty("alliance_approval_user")
    private String allianceApprovalUser;

    @JsonProperty("apply_cust_loginname")
    private String applyCustLoginname;

    @JsonProperty("apply_filename")
    private String applyFilename;
}

package com.hongcheng.techinnovte.pojo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CreateAllianceInfoDTO {
    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("分联盟名称")
    private String name;

    /**
     * 描述
     */
    @ApiModelProperty("描述")
    private String memo;

    /**
     * 试点行业领域
     */
    @ApiModelProperty("试点行业领域")
    @JsonProperty("trade_name")
    private String tradeName;

    /**
     * 主牵头单位
     */
    @ApiModelProperty("主牵头单位")
    @JsonProperty("lead_cust_id")
    private BigDecimal leadCustId;

    @ApiModelProperty("主牵头单位名")
    @JsonProperty("lead_cust_name")
    private String leadCustName;

    @ApiModelProperty("主牵头单位联系人")
    @JsonProperty("contact_name")
    private String contactName;

    @ApiModelProperty("主牵头单位手机号")
    @JsonProperty("contact_phone")
    private String contactPhone;

    /**
     * 非会员成员单位个数
     */
    @ApiModelProperty("非会员成员单位个数")
    @JsonProperty("non_cust_count")
    private BigDecimal nonCustCount;

    /**
     * 非会员成员单位名称
     */
    @ApiModelProperty("非会员成员单位名称")
    @JsonProperty("non_cust_name")
    private String nonCustName;

    /**
     * 申请表
     */
    @ApiModelProperty("申请表")
    @JsonProperty("apply_file")
    private String applyFile;

    @ApiModelProperty("申请表文件")
    @JsonProperty("apply_filename")
    private String applyFileName;
    /**
     * 新联盟设置方案
     */
    @ApiModelProperty("新联盟设置方案")
    @JsonProperty("alliance_setting_scheme")
    private String allianceSettingScheme;

    @ApiModelProperty("新联盟设置方案文件")
    @JsonProperty("alliance_setting_schemename")
    private String allianceSettingSchemeName;
    /**
     * 分联盟章程
     */
    @ApiModelProperty("分联盟章程")
    private String rule;

    @ApiModelProperty("分联盟章程文件")
    @JsonProperty("rulename")
    private String ruleName;
    /**
     * 申请人账号
     */
    @ApiModelProperty("联系人电话")
    @JsonProperty("alliance_contact_phone")
    private String allianceContactPhone;

    /**
     * 状态
     */
    @ApiModelProperty("联系人")
    @JsonProperty("alliance_contact")
    private String allianceContact;

    @ApiModelProperty("牵头")
    private List<Member> memberList;

    @ApiModelProperty("会员成员单位")
    @JsonProperty("cust_name")
    private String custName;

    @ApiModelProperty("状态")
    private String sts;

    private String stsname;

    @ApiModelProperty("审核理由")
    @JsonProperty("approval_opinion")
    private String approvalOpinion;
}

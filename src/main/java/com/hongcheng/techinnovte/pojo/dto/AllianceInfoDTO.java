package com.hongcheng.techinnovte.pojo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AllianceInfoDTO {

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

    /**
     * 主牵头单位
     */
    @ApiModelProperty("主牵头单位名")
    @JsonProperty("lead_cust_name")
    private String leadCustName;
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
    @JsonProperty("apply_filename")
    private String applyFile;

    /**
     * 新联盟设置方案
     */
    @ApiModelProperty("新联盟设置方案")
    @JsonProperty("alliance_setting_schemename")
    private String allianceSettingScheme;

    /**
     * 分联盟章程
     */
    @ApiModelProperty("分联盟章程")
    @JsonProperty("rulename")
    private String rule;

    /**
     * 申请人账号
     */
    @ApiModelProperty("申请人账号")
    @JsonProperty("apply_cust_loginname")
    private String applyCustLoginname;

    /**
     * 状态
     */
    @ApiModelProperty("状态值")
    private BigDecimal sts;

    @ApiModelProperty("状态名")
    private String stsname;
    /**
     * 创建日期
     */
    @ApiModelProperty("创建日期")
    private Date createdate;

    @ApiModelProperty("更新时间")
    private Date updatedate;

    /**
     * 创建人ID
     */
    @ApiModelProperty("创建者")
    private Long createuserid;

    /**
     * 修改人ID
     */
    @ApiModelProperty("更新者")
    private Long updateuserid;

    /**
     * 是否有效
     */
    @ApiModelProperty("是否有效")
    private BigDecimal enabled;

    /**
     * 联系人
     */
    @ApiModelProperty("联系人")
    @JsonProperty("contact_name")
    private String contactName;

    /**
     * 联系电话
     */
    @ApiModelProperty("联系电话")
    @JsonProperty("contact_phone")
    private String contactPhone;

    /**
     * 成员数
     */
    @ApiModelProperty("成员数")
    @JsonProperty("member_count")
    private Integer memberCount;

    /**
     * 审批意见
     */
    @ApiModelProperty("审批意见")
    @JsonProperty("approval_opinion")
    private String approvalOpinion;

    @ApiModelProperty("外部联系人")
    @JsonProperty("alliance_contact")
    private String allianceContact;

    @ApiModelProperty("外部联系人电话")
    @JsonProperty("alliance_contact_phone")
    private String allianceContactPhone;

    @ApiModelProperty("当前用户是否加入成员")
    @JsonProperty("isApplyed")
    private String isApplyed;
}

package com.hongcheng.techinnovte.pojo.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 会员信息
 * </p>
 *
 * @author sj
 * @since 2020-06-28
 */
@Data
public class CustBaseDetailDTO{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    private Long id;
    
    @ApiModelProperty("客户名称")
    private String custname;

    @ApiModelProperty("单位简称")
    private String abbreviation;

    @ApiModelProperty("统一社会信用代码")
    private String creditcode;

    @ApiModelProperty("单位logo")
    private String logo;

    @ApiModelProperty("公众号")
    @JsonProperty("wechat_subscription")
    private String wechatSubscription;

    @ApiModelProperty("单位网址")
    private String website;

    @ApiModelProperty("注册时间")
    @JsonProperty("registration_date")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format="yyyy-MM-dd")
    private Date registrationDate;

    @ApiModelProperty("单位类型")
    private Long category;
    
    @ApiModelProperty("单位类型转义")
    private String categoryname;

    @ApiModelProperty("单位性质")
    private Long type;

    @ApiModelProperty("单位性质转义")
    private String typename;
    
    @ApiModelProperty("注册资本")
    @JsonProperty("registered_capital")
    private BigDecimal registeredCapital;

    @ApiModelProperty("资本币种")
    @JsonProperty("capital_currency")
    private String capitalCurrency;

    @ApiModelProperty("资本币种转义")
    @JsonProperty("capital_currencyname")
    private String capitalCurrencyname;
    
    @ApiModelProperty("总部_省")
    @JsonProperty("head_province")
    private Long headProvince;

    @ApiModelProperty("总部_省转义")
    @JsonProperty("head_provincename")
    private String headProvincename;
    
    @ApiModelProperty("总部_市")
    @JsonProperty("head_city")
    private Long headCity;

    @ApiModelProperty("总部_市转义")
    @JsonProperty("head_cityname")
    private String headCityname;
    
    @ApiModelProperty("总部_县")
    @JsonProperty("head_county")
    private Long headCounty;

    @ApiModelProperty("总部_县转义")
    @JsonProperty("head_countyname")
    private String headCountyname;
    
    @ApiModelProperty("总部_详细地址")
    @JsonProperty("head_addr")
    private String headAddr;

    @ApiModelProperty("浙江_总部_市")
    @JsonProperty("zj_head_city")
    private Long zjHeadCity;

    @ApiModelProperty("浙江_总部_市转义")
    @JsonProperty("zj_head_cityname")
    private String zjHeadCityname;
    
    @ApiModelProperty("浙江_总部_县")
    @JsonProperty("zj_head_county")
    private Long zjHeadCounty;
    
    @ApiModelProperty("浙江_总部_县转义")
    @JsonProperty("zj_head_countyname")
    private String zjHeadCountyname;

    @ApiModelProperty("浙江_总部_详细地址")
    @JsonProperty("zj_head_addr")
    private String zjHeadAddr;

    @ApiModelProperty("单位简介")
    private String memo;

    @ApiModelProperty("人员总数")
    @JsonProperty("employee_count")
    private Long employeeCount;

    @ApiModelProperty("核心研发人员数量")
    @JsonProperty("rd_count")
    private Long rdCount;

    @ApiModelProperty("是否高新技术企业")
    @JsonProperty("high_tech")
    private String highTech;

    @ApiModelProperty("是否高新技术企业转义")
    @JsonProperty("high_techname")
    private String highTechname;
    
    @ApiModelProperty("高新技术企业认定时间")
    @JsonProperty("high_tech_date")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date highTechDate;

    @ApiModelProperty("是否加入国家信创工委会及承担的相关工作")
    @JsonProperty("has_undertaken_work")
    private String hasUndertakenWork;

    @ApiModelProperty("是否加入国家信创工委会及承担的相关工作转义")
    @JsonProperty("has_undertaken_workname")
    private String hasUndertakenWorkname;
    
    @ApiModelProperty("承担的工作")
    @JsonProperty("undertaken_work")
    private String undertakenWork;

    @ApiModelProperty("是否建立科研创新平台")
    @JsonProperty("create_platform")
    private String createPlatform;

    @ApiModelProperty("是否建立科研创新平台转义")
    @JsonProperty("create_platformname")
    private String createPlatformname;
    
    @ApiModelProperty("科研创新平台名称")
    @JsonProperty("platform_name")
    private String platformName;

    @ApiModelProperty("参与起草制订标准情况")
    @JsonProperty("drafting_standard")
    private String draftingStandard;

    @ApiModelProperty("参与起草制订标准情况转义")
    @JsonProperty("drafting_standardname")
    private String draftingStandardname;
    
    @ApiModelProperty("起草标准名称")
    @JsonProperty("standard_name")
    private String standardName;

    @ApiModelProperty("负责人姓名")
    @JsonProperty("leader_name")
    private String leaderName;

    @ApiModelProperty("负责人职务")
    @JsonProperty("leader_position")
    private String leaderPosition;

    @ApiModelProperty("负责人邮箱")
    @JsonProperty("leader_email")
    private String leaderEmail;

    @ApiModelProperty("负责人手机")
    @JsonProperty("leader_phone")
    private String leaderPhone;

    @ApiModelProperty("联系人姓名")
    @JsonProperty("contact_name")
    private String contactName;

    @ApiModelProperty("联系人职务")
    @JsonProperty("contact_position")
    private String contactPosition;

    @ApiModelProperty("联系人邮箱")
    @JsonProperty("contact_email")
    private String contactEmail;

    @ApiModelProperty("联系人手机")
    @JsonProperty("contact_phone")
    private String contactPhone;

    @ApiModelProperty("发明专利数量")
    @JsonProperty("invention_patents_count")
    private Long inventionPatentsCount;

    @ApiModelProperty("实用新型专利数量")
    @JsonProperty("utility_patents_count")
    private Long utilityPatentsCount;

    @ApiModelProperty("外观专利数量")
    @JsonProperty("appearance_patents_count")
    private Long appearancePatentsCount;

    @ApiModelProperty("专利个数")
    @JsonProperty("patents_count")
    private Long patentsCount;

    @ApiModelProperty("软件著作权数量")
    @JsonProperty("software_copyrights_count")
    private Long softwareCopyrightsCount;

    @ApiModelProperty("有无产品进入国家信创目录")
    @JsonProperty("has_catalog_product")
    private String hasCatalogProduct;

    @ApiModelProperty("有无产品进入国家信创目录转义")
    @JsonProperty("has_catalog_productname")
    private String hasCatalogProductname;
    
    @ApiModelProperty("工作成果")
    @JsonProperty("work_result")
    private String workResult;

    @ApiModelProperty("下一步工作计划")
    @JsonProperty("next_plan")
    private String nextPlan;

    @ApiModelProperty("可与信创联盟会员单位共享合作的成果")
    @JsonProperty("share_result")
    private String shareResult;

    @ApiModelProperty("对信创联盟的诉求及未来工作的建议")
    @JsonProperty("demand_and_advice")
    private String demandAndAdvice;

    @ApiModelProperty("入会身份code")
    private String identity;
    
    @ApiModelProperty("入会身份")
    @JsonProperty("identity_name")
    private String identityName;
    
    @ApiModelProperty("创建日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdate;

    @ApiModelProperty("更新时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedate;

    @ApiModelProperty("状态")
    private Integer sts;

    @ApiModelProperty("状态转义")
    private String stsname;
    
    @ApiModelProperty("是否有效")
    private Integer enabled;

    @ApiModelProperty("会费类型")
    @JsonProperty("dues_type")
    private String duesType;

    @ApiModelProperty("会费类型转义")
    @JsonProperty("dues_type_name")
    private String duesTypeName;
    
    @ApiModelProperty("申请文件")
    @JsonProperty("apply_file")
    private String applyFile;

    @ApiModelProperty("申请文件名称")
    @JsonProperty("apply_file_name")
    private String applyFileName;
    
    @ApiModelProperty("统一信用代码文件")
    @JsonProperty("creditcode_file")
    private String creditcodeFile;

    @ApiModelProperty("统一信用代码文件名称")
    @JsonProperty("creditcode_file_name")
    private String creditcodeFileName;
    
    @ApiModelProperty("审批意见")
    @JsonProperty("approval_opinion")
    private String approvalOpinion;

    @ApiModelProperty("申请用户手机号")
    @JsonProperty("apply_custLoginname")
    private String applyCustLoginname;
    
    @ApiModelProperty("推荐单位")
    List<LhzxCustRecommend> recommendList;

    @ApiModelProperty("股东列表")
	List<LhzxCustShareholder> shareholderList;
}

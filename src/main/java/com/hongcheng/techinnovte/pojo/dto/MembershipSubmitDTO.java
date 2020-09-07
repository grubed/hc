package com.hongcheng.techinnovte.pojo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MembershipSubmitDTO {
    private String id;
    private String custname;
    private String abbreviation;
    private String logo;
    @JsonProperty("wechat_subscription")
    private String wechatSubscription;
    @JsonProperty("registration_date")
    private Date registrationDate;
    private String creditcode;
    private String website;
    @JsonProperty("has_undertaken_work")
    private String hasUndertakenWork;
    private String category;
    private String type;
    @JsonProperty("registered_capital")
    private String registeredCapital;
    @JsonProperty("capital_currency")
    private String capitalCurrency;
    @JsonProperty("head_province")
    private String headProvince;
    @JsonProperty("head_county")
    private String headCounty;
    @JsonProperty("head_city")
    private String headCity;
    @JsonProperty("head_addr")
    private String headAddr;
    @JsonProperty("zj_head_city")
    private String zjHeadCity;
    @JsonProperty("zj_head_county")
    private String zjHeadCounty;
    @JsonProperty("zj_head_addr")
    private String zjHeadAddr;
    @JsonProperty("high_tech_date")
    private Date highTechDate;
    private String memo;
    @JsonProperty("employee_count")
    private Integer employeeCount;
    @JsonProperty("rd_count")
    private Integer rdCount;
    @JsonProperty("high_tech")
    private String highTech;
    @JsonProperty("create_platform")
    private String createPlatform;
    @JsonProperty("drafting_standard")
    private String draftingStandard;
    @JsonProperty("platform_name")
    private String platformName;
    @JsonProperty("standard_name")
    private String standardName;
    @JsonProperty("undertaken_work")
    private String undertakenWork;
    @JsonProperty("leader_name")
    private String leaderName;
    @JsonProperty("leader_position")
    private String leaderPosition;
    @JsonProperty("leader_email")
    private String leaderEmail;
    @JsonProperty("leader_phone")
    private String leaderPhone;
    @JsonProperty("contact_name")
    private String contactName;
    @JsonProperty("contact_position")
    private String contactPosition;
    @JsonProperty("contact_email")
    private String contactEmail;
    @JsonProperty("contact_phone")
    private String contactPhone;
    @JsonProperty("invention_patents_count")
    private Integer inventionPatentsCount;
    @JsonProperty("utility_patents_count")
    private Integer utilityPatentsCount;
    @JsonProperty("appearance_patents_count")
    private Integer appearancePatentsCount;
    @JsonProperty("software_copyrights_count")
    private Integer softwareCopyrightsCount;
    @JsonProperty("patents_count")
    private Integer patentsCount;
    @JsonProperty("next_plan")
    private String nextPlan;
    @JsonProperty("share_result")
    private String shareResult;
    @JsonProperty("demand_and_advice")
    private String demandAndAdvice;

    @JsonProperty("HAS_CATALOG_PRODUCT")
    private String hasCatalogProduct;

    @JsonProperty("WORK_RESULT")
    private String workResult;

    private String identity;
    private List<RecommendDTO> recommendList;
    private List<ShareholdDTO> shareholdingList;
}

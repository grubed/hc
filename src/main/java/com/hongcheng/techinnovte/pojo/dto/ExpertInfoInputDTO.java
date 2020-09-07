package com.hongcheng.techinnovte.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class ExpertInfoInputDTO extends ExpertApply {

//    /**
//     * 姓名
//     */
//
//    private String name;
//
//    /**
//     * 身份证号码
//     */
//    @ApiModelProperty("身份证号码")
//
//    private String idNo;
//
//    /**
//     * 证件照文件
//     */
//    @ApiModelProperty("证件照文件")
//    private BigDecimal idFile;
//
//    /**
//     * 政治面貌
//     */
//    @ApiModelProperty("政治面貌")
//    private String politicalOrientation;
//
//    /**
//     * 籍贯
//     */
//    @ApiModelProperty("籍贯")
//    private String nativePlace;
//
//    /**
//     * 职称文件
//     */
//    @ApiModelProperty("职称文件")
//    private BigDecimal titleFile;
//
//    /**
//     * 学历
//     */
//    @ApiModelProperty("学历")
//    private String education;
//
//    /**
//     * 学历文件
//     */
//    @ApiModelProperty("学历文件")
//    private BigDecimal educationFile;
//
//    /**
//     * 学位
//     */
//    @ApiModelProperty("学位")
//    private String degree;
//
//    /**
//     * 学位文件
//     */
//    @ApiModelProperty("学位文件")
//    private BigDecimal degreeFile;
//
//    /**
//     * 执业资格
//     */
//    @ApiModelProperty("执业资格")
//    private String qualification;
//
//    /**
//     * 执业资格文件
//     */
//    @ApiModelProperty("执业资格文件")
//    private BigDecimal qualificationFile;
//
//    /**
//     * 最高学历毕业学校
//     */
//    @ApiModelProperty("最高学历毕业学校")
//    private String school;
//
//    /**
//     * 毕业专业
//     */
//    @ApiModelProperty("毕业专业")
//    private String major;
//
//    /**
//     * 是否在职
//     */
//    @ApiModelProperty("是否在职")
//    private String onJob;
//
//    /**
//     * 所在单位
//     */
//    @ApiModelProperty("所在单位")
//    private String unit;
//
//    /**
//     * 单位性质
//     */
//    @ApiModelProperty("单位性质")
//    private BigDecimal unitNature;
//
//
//    /**
//     * 单位地址_县
//     */
//    @ApiModelProperty("单位地址")
//    private Long unitAddress;
//
//    /**
//     * 单位地址_详细地址
//     */
//    @ApiModelProperty("单位地址_详细地址")
//    private String unitAddressDetail;
//
//    /**
//     * 最近职务
//     */
//    @ApiModelProperty("最近职务")
//    private String duties;
//
//    /**
//     * 通讯地址_省
//     */
//    @ApiModelProperty("通讯地址")
//    private Long postalAddress;
//
//    /**
//     * 通讯地址_详细地址
//     */
//    @ApiModelProperty("通讯地址")
//    private String postalAddressDetail;
//
//    /**
//     * 电子邮箱
//     */
//    @ApiModelProperty("电子邮箱")
//    private String email;
//
//    /**
//     * 固定电话
//     */
//    @ApiModelProperty("固定电话")
//    private String phone;
//
//    /**
//     * 移动电话
//     */
//    @ApiModelProperty("移动电话")
//    private String mobile;

    /**
     * 申请专家领域2
     */

    @ApiModelProperty("申请专家领域列表")
    // @BindEntityList(entity = DomainInfo.class, condition = "this.id = r_expert_apply_domain.expert_apply_id and r_expert_apply_domain.domain_id=id")
    private Set<Long> domainInfoList;
    private List<DomainInfo> domainList;
    @ApiModelProperty("工作经历")
    private List<WorkExperienceDTO> workExperience;
    /**
     * 业务能力和专长
     */
//    @ApiModelProperty("业务能力和专长")
//    private String abilityAndExpertise;
//
//    /**
//     * 担任其他组织机构专家情况
//     */
//    @ApiModelProperty("担任其他组织机构专家情况")
//    private String expertsInOtherOrg;
//
//    /**
//     * 性别
//     */
//    @ApiModelProperty("性别")
//    private Integer gender;
//
//    /**
//     * 出生年月
//     */
//    @ApiModelProperty("出生年月")
//    private Date birthday;
//
//    /**
//     * 职称
//     */
//    @ApiModelProperty("职称")
//    private String title;
//
//    /**
//     * 民族
//     */
//    @ApiModelProperty("民族")
//    private Long nation;
//
//
//
//    /**
//     * 申请表
//     */
//    @ApiModelProperty("申请表")
//    private String applyFile;

    @ApiModelProperty("担任其他组织机构专家情况")
    private List<ExpertsInOtherOrg> expertsInOtherOrganization;

    @ApiModelProperty("专业论文情况")
    private List<Paper> paper;

    @ApiModelProperty("著作、获奖情况")
    private List<Award> award;

    @ApiModelProperty("专利情况")
    private List<IPR> ipr;

    @ApiModelProperty("承担的课题基金")
    private List<ProjectFund> projectFund;

    private String genderName;


    private String nationName;
    private String politicalOrientationName;
    private String educationName;
    private String degreeName;
    private String unitNatureName;
    private String unitAddressProvinceName;
    private String unitAddressCityName;
    private String unitAddressCountyName;
    private String postalAddressProvinceName;
    private String postalAddressCityName;
    private String postalAddressCountyName;
    private String domain1Name;
    private String domain2Name;
    private String OnJobName;


}
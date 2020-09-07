package com.hongcheng.techinnovte.pojo.vo;

import com.diboot.core.binding.annotation.BindDict;
import com.diboot.core.binding.annotation.BindEntityList;
import com.diboot.core.binding.annotation.BindFieldList;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.hongcheng.techinnovte.entity.*;
import lombok.Data;

import java.util.List;

@Data
public class ExpertApplyVO extends ExpertApply {

    @BindDict(type = "CUST_NATURE", field = "unitNature")
    private String unitNatureLabel;

    @BindFieldList(entity = DomainInfo.class, field = "id", condition = "this.id = r_expert_apply_domain.expert_apply_id and r_expert_apply_domain.domain_id = id")
    private List<Long> domainInfoList;

    @BindFieldList(entity = DomainInfo.class, field = "name", condition = "this.id = r_expert_apply_domain.expert_apply_id and r_expert_apply_domain.domain_id = id")
    private List<String> domainInfoNameList;

    private String domainDesc;

    @BindEntityList(entity = ExpertApplyWorkExperience.class, condition = "this.id=expert_apply_id")
    private List<ExpertApplyWorkExperience> workExperience;

    /**
     * 业务能力和专长
     */




    /**
     * 担任其他组织机构专家情况
     */


    @BindEntityList(entity = ExpertApplyInOtherOrg.class, condition = "this.id=expert_apply_id")
    private List<ExpertApplyInOtherOrg> expertsInOtherOrganization;

    /**
     * 论文
     */

    @BindEntityList(entity = ExpertApplyPaper.class, condition = "this.id=expert_apply_id")
    private List<ExpertApplyPaper> paper;


    /**
     * 获奖
     */
    @BindEntityList(entity = ExpertApplyAward.class, condition = "this.id=expert_apply_id")
    private List<ExpertApplyAward> award;

    /**
     * 知识产权
     */
    @BindEntityList(entity = ExpertApplyIpr.class, condition = "this.id=expert_apply_id")
    private List<ExpertApplyIpr> ipr;


    /**
     * 承担的课题基金
     */
    @BindEntityList(entity = ExpertApplyProjectFund.class, condition = "this.id=expert_apply_id")
    private List<ExpertApplyProjectFund> projectFund;


    /**
     * 状态
     */
    @BindDict(type = "NORMAL_STS", field = "sts")
    private String stsLabel;

    @BindDict(type = "COMMON_PROVINCE", field = "unitAddressProvince")
    private String unitAddressProvinceLabel;

    @BindDict(type = "COMMON_CITY", field = "unitAddressCity")
    private String unitAddressCityLabel;

    @BindDict(type = "COMMON_COUNTY", field = "unitAddressCounty")
    private String unitAddressCountyLabel;

    @BindDict(type = "COMMON_PROVINCE", field = "postalAddressProvince")
    private String postalAddressProvinceLabel;

    @BindDict(type = "COMMON_CITY", field = "postalAddressCity")
    private String postalAddressCityLabel;

    @BindDict(type = "COMMON_COUNTY", field = "postalAddressCounty")
    private String postalAddressCountyLabel;

    @BindDict(type = "EDUCATION", field = "education")
    private String educationLabel;

    @BindDict(type = "DEGREE", field = "degree")
    private String degreeLabel;

    @BindDict(type = "COMMON_SEX", field = "gender")
    private String genderLabel;

    @BindDict(type = "POLITICAL_ORIENTATION", field = "politicalOrientation")
    private String politicalOrientationLabel;

    private String idFileLabel;

    private String titleFileLabel;

    private String educationFileLabel;

    private String degreeFileLabel;

    private String qualificationFileLabel;

    private String applyFileLabel;

    @BindEntityList(entity = Approval.class, condition = "this.id=type_id and approval.type='expert_apply'")
    private List<Approval> approvalList;
}

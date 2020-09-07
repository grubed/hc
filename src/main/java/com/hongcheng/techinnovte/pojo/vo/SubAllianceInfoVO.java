package com.hongcheng.techinnovte.pojo.vo;

import com.diboot.core.binding.annotation.BindDict;
import com.diboot.core.binding.annotation.BindEntityList;
import com.diboot.core.binding.annotation.BindField;
import com.diboot.core.binding.query.BindQuery;
import com.diboot.core.binding.query.Comparison;
import com.hongcheng.techinnovte.entity.*;
import lombok.Data;

import java.util.List;

@Data
public class SubAllianceInfoVO extends SubAllianceInfo {

    @BindEntityList(entity = SubAllianceMember.class, condition = "this.id=sub_alliance_id")
    private List<SubAllianceMember> memberIdList;

    private Integer memberCount;

    private Boolean isApplyed;

    @BindDict(type = "NORMAL_STS", field = "sts")
    private String stsLabel;

    @BindField(entity = CompanyInfo.class, field = "name", condition = "this.lead_cust_id=id")
    private String LeadCustName;

    private String ruleLabel;
    private String allianceSettingSchemeLabel;
    private String applyFileLabel;
}

package com.hongcheng.techinnovte.pojo.vo;

import com.diboot.core.binding.annotation.BindDict;
import com.diboot.core.binding.annotation.BindEntityList;
import lombok.Data;

import java.util.List;

@Data
public class SubAllianceApplyVO extends SubAllianceApply {


    @BindDict(type = "NORMAL_STS", field = "sts")
    private String stsLabel;

//    @BindField(entity = CompanyInfo.class, field = "name", condition = "this.lead_cust_id=id")
//    private String LeadCustName;

    private String ruleLabel;
    private String allianceSettingSchemeLabel;
    private String applyFileLabel;

    @BindEntityList(entity = Approval.class, condition = "this.id=type_id and approval.type='sub_alliance_apply'")
    private List<Approval> approvalList;
}

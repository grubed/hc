package com.hongcheng.techinnovte.pojo.vo;

import com.diboot.core.binding.annotation.BindDict;
import com.diboot.core.binding.annotation.BindField;
import lombok.Data;

@Data
public class SubAllianceMemberVO extends SubAllianceMember {

    @BindField(entity = CompanyInfo.class, field = "name", condition = "this.company_id=id")
    private String companyName;

    @BindField(entity = SubAllianceInfo.class, field = "name", condition = "this.sub_alliance_id=id")
    private String subAllianceName;

    @BindField(entity = SubAllianceInfo.class, field = "ALLIANCE_CONTACT", condition = "this.sub_alliance_id=id")
    private String allianceContact;

    @BindField(entity = SubAllianceInfo.class, field = "ALLIANCE_CONTACT_PHONE", condition = "this.sub_alliance_id=id")
    private String allianceContactPhone;

    @BindDict(type = "NORMAL_STS", field = "sts")
    private String stsLabel;
}

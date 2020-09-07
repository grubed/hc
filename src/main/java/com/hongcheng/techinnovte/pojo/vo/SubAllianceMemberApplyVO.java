package com.hongcheng.techinnovte.pojo.vo;

import com.diboot.core.binding.annotation.BindDict;
import com.diboot.core.binding.annotation.BindEntityList;
import com.diboot.core.binding.annotation.BindField;
import lombok.Data;

import java.util.List;

@Data
public class SubAllianceMemberApplyVO extends SubAllianceMemberApply {


    @BindDict(type = "NORMAL_STS", field = "sts")
    private String stsLabel;

    @BindEntityList(entity = Approval.class, condition = "this.id=type_id and approval.type='sub_alliance_member_apply'")
    private List<Approval> approvalList;

    @BindField(entity = SubAllianceInfo.class, field = "name", condition = "this.sub_alliance_info_id = id")
    private String subAllianceInfoName;

    private String applyFileLabel;

    private Boolean isApprove;
}

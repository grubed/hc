package com.hongcheng.techinnovte.pojo.vo;

import com.diboot.core.binding.query.BindQuery;
import com.diboot.core.binding.query.Comparison;
import lombok.Data;

@Data
public class RecommendCompanyVO extends CompanyInfo {

    @BindQuery(comparison = Comparison.EQ, entity = AllianceMember.class, field = "type", condition = "this.id=alliance_member.company_id")
    private String typeCode;

}

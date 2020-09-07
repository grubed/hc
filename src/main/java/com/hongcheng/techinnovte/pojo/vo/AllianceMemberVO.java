package com.hongcheng.techinnovte.pojo.vo;

import com.diboot.core.binding.annotation.BindEntity;
import com.diboot.core.binding.annotation.BindField;
import lombok.Data;

@Data
public class AllianceMemberVO extends AllianceMember {

    @BindEntity(entity = CompanyInfo.class, condition = "this.company_id=id")
    private CompanyInfo companyInfo;

    @BindField(field = "name",entity = PlatCustType.class,condition= "this.type = code")
    private String typeLabel;
}

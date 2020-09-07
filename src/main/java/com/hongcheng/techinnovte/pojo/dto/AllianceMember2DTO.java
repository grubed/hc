package com.hongcheng.techinnovte.pojo.dto;

import com.diboot.core.binding.query.BindQuery;
import com.diboot.core.binding.query.Comparison;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AllianceMember2DTO extends AllianceMember {
    @ApiModelProperty("名称")
    @BindQuery(comparison = Comparison.LIKE, entity = CompanyInfo.class, field = "name", condition = "this.company_id=id")
    private String nameLike;

    @ApiModelProperty("状态")
    @BindQuery(comparison = Comparison.EQ, field = "sts")
    private Integer status;


//    @BindQuery(comparison = Comparison.EQ, entity = AllianceMemberApply.class ,field = "user_id",condition = "this.apply_alliance_member_id=id")
//    private Long userId;
}

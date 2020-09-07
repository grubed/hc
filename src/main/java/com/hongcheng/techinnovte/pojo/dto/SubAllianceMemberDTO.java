package com.hongcheng.techinnovte.pojo.dto;

import com.diboot.core.binding.query.BindQuery;
import com.diboot.core.binding.query.Comparison;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SubAllianceMemberDTO extends SubAllianceMember {
    @ApiModelProperty("名称")
    @BindQuery(comparison = Comparison.LIKE, entity = SubAllianceInfo.class, field = "name",condition = "this.sub_alliance_id = id")
    private String nameLike;
}

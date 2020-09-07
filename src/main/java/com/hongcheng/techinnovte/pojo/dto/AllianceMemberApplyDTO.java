package com.hongcheng.techinnovte.pojo.dto;

import com.diboot.core.binding.query.BindQuery;
import com.diboot.core.binding.query.Comparison;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AllianceMemberApplyDTO extends AllianceMemberApply {
    @ApiModelProperty("名称")
    @BindQuery(comparison = Comparison.LIKE, field = "companyName")
    private String nameLike;

    @ApiModelProperty("状态")
    @BindQuery(comparison = Comparison.EQ, field = "sts")
    private Integer status;

    @ApiModelProperty("入会身份")
    @BindQuery(comparison = Comparison.IN, field = "identity")
    private String [] identityList;
}

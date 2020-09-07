package com.hongcheng.techinnovte.pojo.dto;

import com.diboot.core.binding.query.BindQuery;
import com.diboot.core.binding.query.Comparison;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SubAllianceApplyDTO extends SubAllianceApply {
    @ApiModelProperty("名称")
    @BindQuery(comparison = Comparison.LIKE, field = "name")
    private String nameLike;

    @ApiModelProperty("状态")
    @BindQuery(comparison = Comparison.EQ, field = "sts")
    private Integer status;

}


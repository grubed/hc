package com.hongcheng.techinnovte.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class ExpertApplyPageDTO {
    @ApiModelProperty("总数多少页")
    private Long total;

//    @ApiModelProperty("专家列表")
//    private List<ExpertApplyOutDTO> expertInfoDTOList;

    @ApiModelProperty("当前页")
    private Long page;
}

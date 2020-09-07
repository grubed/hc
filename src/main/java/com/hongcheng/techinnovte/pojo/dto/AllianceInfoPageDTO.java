package com.hongcheng.techinnovte.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class AllianceInfoPageDTO {
    @ApiModelProperty("总数多少页")
    private Long total;
    @ApiModelProperty("分联盟列表")
    private List<AllianceInfoDTO> allianceInfoDTOList;
    @ApiModelProperty("当前页")
    private Long page;
}

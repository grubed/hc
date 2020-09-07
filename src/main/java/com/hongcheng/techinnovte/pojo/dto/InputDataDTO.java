package com.hongcheng.techinnovte.pojo.dto;

import lombok.Data;

import java.util.List;

@Data
public class InputDataDTO {
    private String name;
    private Integer page;
    private Integer size;
    private List<InputConditionDTO> condition;
}

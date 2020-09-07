package com.hongcheng.techinnovte.pojo.dto;

import lombok.Data;

@Data
public class InputConditionDTO {
    private String table;
    private String rule;
    private String kind;
    private String value;
    private String logic;
}

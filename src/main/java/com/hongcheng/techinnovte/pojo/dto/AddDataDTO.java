package com.hongcheng.techinnovte.pojo.dto;

import lombok.Data;

import java.util.Map;

@Data
public class AddDataDTO {
    private String tableName;
    private Map<String, Object> data;
}

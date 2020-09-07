package com.hongcheng.techinnovte.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuDTO {
    private Integer id;
    private Integer farId;
    private String name;
    private String icon;
    private String type;
    private String text;
    private Integer level;
    private List<MenuDTO> children;
}

package com.hongcheng.techinnovte.pojo.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ShareholdDTO {
    private Long id;
    private String key;
    private String lb;
    private String name;
    private String moeny;
    private String nbili;
    private String shareholder_type;
    private String shareholder_typename;
    private BigDecimal contribution_amount;
    private BigDecimal shareholding_ratio;
}

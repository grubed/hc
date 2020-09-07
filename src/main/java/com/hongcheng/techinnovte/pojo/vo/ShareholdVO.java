package com.hongcheng.techinnovte.pojo.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ShareholdVO {
    private Long id;
    private String name;
    private String shareholderType;

    private String shareholderTypeLabel;
    private BigDecimal contributionAmount;
    private BigDecimal shareholdingRatio;
}

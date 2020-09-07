package com.hongcheng.techinnovte.pojo.dto;

import lombok.Data;

@Data
public class ExpertsInOtherOrg {
    /**
     * 机构名
     */
    private String orgName;
    /**
     * 级别
     */
    private String lvl;
    /**
     * 担任的职务
     */
    private String duties;

    private String lvlLabel;
}

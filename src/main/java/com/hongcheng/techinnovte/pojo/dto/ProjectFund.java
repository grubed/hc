package com.hongcheng.techinnovte.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProjectFund {
    private String name;
    /**
     * 开始日期
     */
    @JSONField(format="yyyy-MM-dd")
    private Date startDate;
    private String strStartDate;
    /**
     * 结束日期
     */
    private Date endDate;
    private String strEndDate;
    /**
     * 承担的工作
     */
    private String work;

    private String source;
    private BigDecimal amount;
    private String isConclusion;
    private String isConclusionLabel;
}

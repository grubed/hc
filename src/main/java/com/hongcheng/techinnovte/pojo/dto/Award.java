package com.hongcheng.techinnovte.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class Award {
    private String name;
    /**
     * 获奖日期
     */
    @JSONField(format="yyyy-MM-dd")
    private Date date;
    private String strDate;
    /**
     * 颁奖机构
     */
    private String orgName;
    private String article;
    private String rank;
}

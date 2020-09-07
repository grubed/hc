package com.hongcheng.techinnovte.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class Paper {
    private String name;
    /**
     *发表日期
     */
    @JSONField(format="yyyy-MM-dd")
    private Date date;
    private String strDate;
    /**
     *发表期刊、杂志、网站名
     */
    private String location;
    private String frequency;
    private String rank;
}

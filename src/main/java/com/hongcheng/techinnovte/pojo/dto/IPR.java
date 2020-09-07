package com.hongcheng.techinnovte.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class IPR {
    private String name;
    /**
     *获得日期
     */
    @JSONField(format="yyyy-MM-dd")
    private Date date;

    private String strDate;
    /**
     *知识产权号
     */
    private String code;
    private String  category;
    private String  isSell;
    private String rank;
    private String  isSellLabel;
    private String  categoryLabel;
}

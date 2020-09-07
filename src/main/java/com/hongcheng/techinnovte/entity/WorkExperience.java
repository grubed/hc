package com.hongcheng.techinnovte.entity;

import lombok.Data;

@Data
public class WorkExperience {
    /**
     * 开始日期
     */
    private String start_date;
    /**
     * 结束日期
     */
    private String end_date;
    /**
     * 单位
     */
    private String unit;
    /**
     * 工作岗位/职务
     */
    private String duties;

}

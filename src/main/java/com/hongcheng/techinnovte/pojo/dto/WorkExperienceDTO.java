package com.hongcheng.techinnovte.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class WorkExperienceDTO {
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
     * 单位
     */
    private String unit;
    /**
     * 工作岗位/职务
     */
    private String duties;


}

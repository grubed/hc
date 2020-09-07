package com.hongcheng.techinnovte.pojo.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.diboot.core.binding.annotation.BindDict;
import com.diboot.core.binding.annotation.BindEntity;
import com.diboot.core.binding.annotation.BindEntityList;
import com.hongcheng.techinnovte.entity.*;
import lombok.Data;

import java.util.List;

@Data
public class ExpertInfoVO extends ExpertInfo {

    @BindEntity(entity = HumanInfo.class, condition = "this.human_id=id")
    private HumanInfoVO humanInfoVO;



    @BindEntityList(entity = ExpertInfoWorkExperience.class, condition = "this.id=id")
    private List<ExpertInfoWorkExperience> expertInfoWorkExperiences;

    /**
     * 业务能力和专长
     */




    /**
     * 担任其他组织机构专家情况
     */


    @BindEntityList(entity = ExpertInfoInOtherOrg.class, condition = "this.id=id")
    private List<ExpertInfoInOtherOrg> expertInfoInOtherOrgs;

    /**
     * 论文
     */

    @BindEntityList(entity = ExpertInfoPaper.class, condition = "this.id=id")
    private List<ExpertInfoPaper> expertInfoPapers;


    /**
     * 获奖
     */
    @BindEntityList(entity = ExpertInfoAward.class, condition = "this.id=id")
    private List<ExpertInfoAward> expertInfoAwardList;

    /**
     * 知识产权
     */
    @BindEntityList(entity = ExpertInfoIpr.class, condition = "this.id=id")
    private List<ExpertInfoIpr> expertInfoIprList;


    /**
     * 承担的课题基金
     */
    @BindEntityList(entity = ExpertInfoProjectFund.class, condition = "this.id=id")
    private List<ExpertInfoProjectFund> expertInfoProjectFundList;


    /**
     * 状态
     */
    @BindDict(type = "NORMAL_STS", field = "sts")
    private String stsLabel;

    private String unitAddressProvinceLabel;
}

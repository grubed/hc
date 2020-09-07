package com.hongcheng.techinnovte.pojo.bean;

import com.hongcheng.techinnovte.pojo.dto.*;
import lombok.Data;

import java.util.List;

@Data
public class ExpertApplyFile {
    private String name;
    private String genderName;
    private String birthday;
    private String nationName;
    private String politicalOrientationName;
    private String nativePlace;
    private String title;
    private String educationName;
    private String degreeName;
    private String qualification;
    private String school;
    private String major;
    private String email;
    private String unit;
    private String unitNatureName;
    private String unitAddressProvinceName;
    private String unitAddressCityName;
    private String unitAddressCountyName;
    private String unitAddressDetail;
    private String duties;
    private String postalAddressProvinceName;
    private String postalAddressCityName;
    private String postalAddressCountyName;
    private String postalAddressDetail;
    private String phone;
    private String mobile;
    private String domain1Name;
    private String domain2Name;
    private List<WorkExperienceDTO> workExperience;
    private String abilityAndExpertise;
    private List<ExpertsInOtherOrg> expertsInOtherOrganization;
    private List<Paper> paper;
    private List<Award> award;
    private List<IPR> ipr;
    private List<ProjectFund> projectFund;
    private String idImg;
    private List<DomainInfo> domainList;
    private String onJob;
}

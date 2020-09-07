//package com.hongcheng.techinnovte.pojo.excel;
//
//import com.alibaba.excel.annotation.ExcelProperty;
//import com.diboot.file.excel.BaseExcelModel;
//import lombok.Data;
//
//import javax.validation.constraints.NotNull;
//
//@Data
//public class AllianceMemberModel extends BaseExcelModel {
//
//    @NotNull(message = "必须指定单位")
//    @ExcelProperty(value = "单位名称", index = 0)
//    private String orgName;
//
//    @NotNull(message = "入会身份不能为空")
//    @ExcelProperty(value = "入会身份", index = 1)
//    private String idLabel;
//
//    @NotNull(message = "联系人姓名")
//    @ExcelProperty(value = "联系人姓名", index = 2)
//    private String name;
//
//    @NotNull(message = "联系人手机")
//    @ExcelProperty(value = "联系手机", index = 3)
//    private String mobile;
//
//    @NotNull(message = "联系人邮箱")
//    @ExcelProperty(value = "联系人邮箱", index = 4)
//    private String email;
//
//    @ExcelProperty(value = "状态", index = 5)
//    private String stsLabel;
//
//}
//

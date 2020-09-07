//package com.hongcheng.techinnovte.pojo.excel;
//
//import com.diboot.core.binding.annotation.BindDict;
//import com.diboot.file.excel.BaseExcelModel;
//import com.hongcheng.techinnovte.entity.AllianceMemberApply;
//import lombok.Data;
//import org.hibernate.validator.constraints.Length;
//import com.alibaba.excel.annotation.ExcelProperty;
//import com.diboot.core.binding.annotation.BindDict;
//import com.diboot.file.excel.converter.DictConverter;
//import javax.validation.constraints.NotNull;
//
//@Data
//public class AllianceMemberApplyModel extends BaseExcelModel {
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
////    private Integer sts;
//
//    @ExcelProperty(value = "状态", index = 5)
//    private String stsLabel;
////    /**
////     * 绑定数据字典示例，如 导入显示值“男”转换为存储值“M”
////     */
////    @BindDict(type = "GENDER")
////    @ExcelProperty(value = "字典", index = 3, converter = DictConverter.class)
////    private String dict;
//}

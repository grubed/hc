//package com.hongcheng.techinnovte.controller;
//
//
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.hongcheng.techinnovte.common.Result;
//import com.hongcheng.techinnovte.pojo.dto.DictDTO;
//import com.hongcheng.techinnovte.service.IBizSysDdService;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiParam;
//
///**
// * <p>
// * 系统数据字典表 前端控制器
// * </p>
// *
// * @author sj
// * @since 2020-07-10
// */
////@Api(tags = "数据字典模块")
//@RestController
//public class BizSysDdController {
//
//    @Resource
//    private IBizSysDdService iBizSysDdService;
//
//    @GetMapping("/dict")
//    public Result<List<DictDTO>> getDD(@ApiParam(name = "key", value = "字典key", required = true) String key,
//                                       @ApiParam(name = "plistvalue", value = "父节点值",required = false) String plistvalue) {
//        return Result.getSuccess(iBizSysDdService.getDictList(key, plistvalue));
//    }
//
//    @GetMapping("/dict/init")
//    public Result<String> init(@ApiParam(name = "key", value = "字典key", required = false) String key) {
//        iBizSysDdService.dictinit(key);
//        return Result.getSuccess("字典刷新成功！");
//    }
//
//}

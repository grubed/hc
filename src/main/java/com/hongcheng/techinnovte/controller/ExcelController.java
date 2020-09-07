//package com.hongcheng.techinnovte.controller;
//
//import com.baomidou.mybatisplus.core.conditions.Wrapper;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.diboot.core.entity.Dictionary;
//import com.diboot.core.service.DictionaryService;
//import com.diboot.core.vo.JsonResult;
//import com.diboot.core.vo.KeyValue;
//import com.diboot.file.excel.listener.FixedHeadExcelListener;
//import com.hongcheng.techinnovte.entity.AllianceMember;
//import com.hongcheng.techinnovte.entity.AllianceMemberApply;
//import com.hongcheng.techinnovte.entity.PlatCustType;
//import com.hongcheng.techinnovte.pojo.excel.AllianceMemberApplyModel;
//import com.hongcheng.techinnovte.pojo.excel.AllianceMemberModel;
//import com.hongcheng.techinnovte.service.IAllianceMemberApplyService;
//import com.hongcheng.techinnovte.service.IAllianceMemberService;
//import com.hongcheng.techinnovte.service.ICompanyInfoService;
//import com.hongcheng.techinnovte.service.IPlatCustTypeService;
//import com.hongcheng.techinnovte.service.impl.PlatCustTypeServiceImpl;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import com.diboot.file.controller.BaseExcelFileController;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletResponse;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import com.diboot.file.util.ExcelHelper;
//import com.diboot.file.util.FileHelper;
//import com.diboot.file.util.HttpHelper;
//
//
//@RestController
//@RequestMapping("/excel")
//@Slf4j
//public class ExcelController extends BaseExcelFileController {
//
//    @Resource
//    private IAllianceMemberApplyService iAllianceMemberApplyService;
//
//    @Resource
//    private IAllianceMemberService iAllianceMemberService;
//
//
//    @Resource
//    private IPlatCustTypeService iPlatCustTypeService;
//
//    @Resource
//    private DictionaryService dictionaryService;
//
//    @Resource
//    private ICompanyInfoService iCompanyInfoService;
//    /**
//     * 预览excel数据
//     */
//    @PostMapping("/preview")
//    public JsonResult preview(@RequestParam("file") MultipartFile file) throws Exception {
//        return super.excelPreview(file);
//    }
//
//
//
//
//    /**
//     * 导出Excel
//     **/
//    @GetMapping("/exportAllianceMemberApply")
//    public JsonResult download(HttpServletResponse response) throws Exception {
//        String excelPath = FileHelper.getSystemTempDir() + "temp.xlsx";
//        // 构建结果
//        List<AllianceMemberApplyModel> dataList = buildData();
//        // 写入excel
//        ExcelHelper.writeData(excelPath, "入会申请", dataList);
//        // 导出
//        HttpHelper.downloadLocalFile(excelPath, "入会申请.xlsx", response);
//        return null;
//    }
//
//    /**
//     * 导出Excel
//     **/
//    @GetMapping("/exportAllianceMember")
//    public JsonResult downloadMember(HttpServletResponse response) throws Exception {
//        String excelPath = FileHelper.getSystemTempDir() + "temp.xlsx";
//        // 构建结果
//        List<AllianceMemberModel> dataList = buildAllianceMemberModelData();
//        // 写入excel
//        ExcelHelper.writeData(excelPath, "联盟成员", dataList);
//        // 导出
//        HttpHelper.downloadLocalFile(excelPath, "联盟成员.xlsx", response);
//        return null;
//    }
//
//    @Override
//    protected FixedHeadExcelListener getExcelDataListener() {
//        return null;
//    }
//    private List<AllianceMemberModel> buildAllianceMemberModelData(){
//        List<AllianceMemberModel> dataList = new ArrayList<>();
//        List<AllianceMember> allianceMemberList = iAllianceMemberService.getEntityList(new QueryWrapper());
////        Map<Long, Integer> mapAllianceMember = new HashMap<>();
////        for(AllianceMember allianceMember : allianceMemberList) {
////            mapAllianceMember.put(allianceMember.getApplyAllianceMemberId()., allianceMember.getSts());
////        }
//
//        List<PlatCustType> platCustTypeList = iPlatCustTypeService.list();
//        Map<String, String> map = new HashMap<>();
//        for(PlatCustType platCustType : platCustTypeList) {
//            map.put(platCustType.getCode(), platCustType.getName());
//        }
//        for(AllianceMember allianceMember : allianceMemberList) {
//            AllianceMemberModel model = new AllianceMemberModel();
//            AllianceMemberApply allianceMemberApply = iAllianceMemberApplyService.getEntity(allianceMember.getApplyAllianceMemberId());
//            if(allianceMemberApply != null ) {
//                model.setOrgName(allianceMemberApply.getCompanyName());
//
//                model.setIdLabel(map.get(allianceMemberApply.getIdentity()));
//                model.setName(allianceMemberApply.getContactName());
//                model.setEmail(allianceMemberApply.getContactEmail());
//                model.setMobile(allianceMemberApply.getContactPhone());
//                String sts = getContentByValue("NORMAL_STS", allianceMember.getSts().toString());
//                model.setStsLabel(sts);
//
//                dataList.add(model);
//            }
//        }
//
////        model.setDict("M"); //mock字典 导出时转换为显示值
//
//        return dataList;
//    }
//
//    /**
//     * 示例组装数据
//     * @return
//     */
//    private List<AllianceMemberApplyModel> buildData(){
//        List<AllianceMemberApplyModel> dataList = new ArrayList<>();
//        List<AllianceMemberApply> allianceMemberApplyList = iAllianceMemberApplyService.getEntityList(new QueryWrapper());
//        List<PlatCustType> platCustTypeList = iPlatCustTypeService.list();
//        Map<String, String> map = new HashMap<>();
//        for(PlatCustType platCustType : platCustTypeList) {
//            map.put(platCustType.getCode(), platCustType.getName());
//        }
//        for(AllianceMemberApply allianceMemberApply : allianceMemberApplyList) {
//            AllianceMemberApplyModel model = new AllianceMemberApplyModel();
//            model.setOrgName(allianceMemberApply.getCompanyName());
//            model.setIdLabel(map.get(allianceMemberApply.getIdentity()));
//            model.setName(allianceMemberApply.getContactName());
//            model.setEmail(allianceMemberApply.getContactEmail());
//            model.setMobile(allianceMemberApply.getContactPhone());
//            String sts = getContentByValue("NORMAL_STS", allianceMemberApply.getSts().toString());
//            model.setStsLabel(sts);
//            dataList.add(model);
//        }
//
////        model.setDict("M"); //mock字典 导出时转换为显示值
//
//        return dataList;
//    }
//
//    public String getContentByValue(String type, String value) {
//        QueryWrapper<Dictionary> wrapper2 = new QueryWrapper<>();
//        wrapper2.eq("type", type);
//        wrapper2.eq("item_value", value);
//        List<KeyValue> keyValueList = dictionaryService.getKeyValueList(wrapper2.select("item_name","item_value"));
//        if(keyValueList != null && keyValueList.size() > 0) {
//            return keyValueList.get(0).getK();
//        }
//        return null;
//    }
//}
//

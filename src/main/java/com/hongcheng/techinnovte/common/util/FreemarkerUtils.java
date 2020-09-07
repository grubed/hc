package com.hongcheng.techinnovte.common.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aspose.words.Document;
import com.aspose.words.SaveFormat;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreemarkerUtils {

    private static Logger logger = LoggerFactory.getLogger(FreemarkerUtils.class);

    private static String defaultCharacter = "UTF-8";
    private static Configuration cfg;

    private FreemarkerUtils() {
    }

    static {
        cfg = new Configuration();
        cfg.setDefaultEncoding(defaultCharacter);
        cfg.setTagSyntax(Configuration.AUTO_DETECT_TAG_SYNTAX);
    }

    public static void main(String[] args) throws IOException {
        //String formPath = "C:\\WorkSpace\\tech_innovate\\tech_innovate\\src\\cust_apply_tpl_v7.0.xml";

        Map map = new HashMap();
        map.put("custname","测试单位名称");
        map.put("abbreviation","测试简称");
        map.put("website","http://www.baidu.com");
        map.put("wechat_subscription","测试公众号");
        map.put("head_provincename","浙江省");
        map.put("head_cityname","杭州市");
        map.put("head_countyname","滨江区");
        map.put("zj_head_cityname","杭州市");
        map.put("zj_head_countyname","滨江区");
        map.put("zj_head_addr","高新软件园2号");
        map.put("leader_name","测试单位负责人");
        map.put("leader_position","测试负责人职务");
        map.put("leader_email","测试负责人邮箱");
        map.put("leader_phone","测试负责人手机");
        map.put("contact_name","测试联系人姓名");
        map.put("contact_position","测试联系人职务");
        map.put("contact_email","测试联系人邮箱");
        //map.put("contact_phone","测试联系人手机");

        map.put("categoryname","测评机构");
        map.put("category",101100L);
        map.put("typename","独立企业");
        map.put("type",200100L);

        //map.put("creditcode","1234567890123456");
        map.put("registration_date","2020-06-01");
        map.put("registered_capital",100000000D);
        map.put("capital_currencyname","人民币");
        map.put("employee_count",1000L);
        map.put("rd_count",500L);
        map.put("high_techname","是");
        map.put("high_tech","1");
        map.put("high_tech_date","2020-06-01");
        map.put("has_undertaken_work","1");
        map.put("undertaken_work","承担的工作承担的工作承担的工作承担的工作");
        map.put("create_platform","G,N");
        //map.put("patents_count",10L);
        map.put("invention_patents_count",1L);
        //map.put("utility_patents_count",2L);
        map.put("appearance_patents_count",3L);
        map.put("software_copyrights_count",3L);
        map.put("identity",3L);
        map.put("has_catalog_product","1");

//        List<CustRecommend> list = new ArrayList<>();
//
//        for (int i = 1; i < 4; i++) {
//            CustRecommend r = new CustRecommend();
//            r.setPhone("1333333333" + i);
//            r.setUsername("联系人" + i);
//            r.setCust_name("推荐单位" + i);
//            list.add(r);
//        }
//        map.put("recommendList",list);
//
//        List<CustShareholder> shareholdingList = new ArrayList<>();
//        for (int i = 1; i < 4; i++) {
//            CustShareholder s = new CustShareholder();
//            s.setName("股东名称" + i);
//            s.setShareholder_typename("股东类别" + i);
//            s.setShareholding_ratio(BigDecimal.valueOf(10 * i));
//            s.setContribution_amount(BigDecimal.valueOf(i * 10000000));
//            shareholdingList.add(s);
//        }
//        map.put("shareholdingList",shareholdingList);
//
//        test(map);

    }

    public static void test(Map<String,Object> map) {
        //String formPath = "C:\\WorkSpace\\tech_innovate\\tech_innovate\\src\\cust_apply_tpl_v7.0.bak.xml";
//        String formPath = "C:\\WorkSpace\\tech_innovate\\tech_innovate\\webapp\\exportTpl\\doc\\cust_apply_tpl_v7.0.xml";
//
//
//
//        File file = new File(formPath);
//        String fileName = "test.ftl";
//        try {
//            file = ResourceUtils.getFile(formPath);
////            file = new File()getClass().getClassLoader().getResource("lic").getFile();
////            ResourceFinder.getResourceAsStream("");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        DocumentHandler documentHandler = new DocumentHandler();
//        //保存路径
//        String savePath = file.getParent()+"\\test4.doc";
//        System.out.println("保存路径："+savePath);
//        documentHandler.createDoc(file.getParent(), file.getName(), savePath, map);
//        System.out.println("ok");
    }

    public static void processTemplate(String fromPath, Map<String, Object> map, Writer out ){
        try {
//            String webapp = ClassPathUtil.getWebAppPath(ExcelUtil.class);
            // 服务器存放地址
            String webapp = "/data/java/config";
                    //本地存放地址
            // String webapp = Thread.currentThread().getContextClassLoader().getResource("templates").getPath();
            int index = fromPath.lastIndexOf("/");

            String path = webapp;
            String name = "";
            if(index != -1){
                path += fromPath.substring(0,index);
                name = fromPath.substring(index+1);
            }else{
                name = fromPath;
            }

            cfg.setDirectoryForTemplateLoading(new File(path));
            Template template = cfg.getTemplate(name, defaultCharacter);
            template.process(map, out);
            out.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void export(String fromPath, Map<String, Object> map, String excelName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        ExportUtil.resHeader(request, response, excelName);
        PrintWriter out = response.getWriter();
        processTemplate(fromPath, map, out);
        if (out != null) {
            out.close();
        }
    }

    public static void exportDoc(String fromPath, Map<String,Object> map,String docName,HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("application/msword;charset=utf-8");
        ExportUtil.resHeader(request, response, docName);
        PrintWriter out = response.getWriter();
        processTemplate(fromPath,map,out);
        if(out != null){
            out.close();
        }
    }

    /**
     * 先根据freemarker模板生成doc文档 然后将doc文档转换成pdf文档下载
     */
    public static void exportPdf(String fromPath, Map<String, Object> map, String docName, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 验证License
        if (!AsposeUtil.wordsLicense()) {
            logger.error("验证License失败无法转换成pdf");
            return;
        }

//        // 得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
        String savePath = "./";
//        logger.debug("获取到的tmp文件夹路径==={}",savePath);
//        File tmpDir = new File(savePath);
//        // 判断上传文件的保存目录是否存在
//        if (!tmpDir.exists() && !tmpDir.isDirectory()) {
//            logger.debug(savePath + "目录不存在，需要创建。");
//            // 创建目录
//            tmpDir.mkdir();
//        }

       // String fileWriteTime = DateUtil.getCurrentDateString("yyyyMMddHHmmss");
        String fileWriteTime = new SimpleDateFormat("yyyyMMddkkmmss").format(new Date()) + ((int) (Math.random() * (100 - 1) + 1));

        String tmpFileName = savePath + "/" + docName + fileWriteTime + ".doc";
        logger.debug("临时文件名：==={}",tmpFileName);
        File docFile = new File(tmpFileName);
        if (!docFile.exists()) {
            docFile.createNewFile();
            logger.debug("临时文件创建成功。");
        }
        try(Writer docWriter = new FileWriter(docFile);){
            processTemplate(fromPath, map, docWriter);
        }
//        String userAgent = request.getHeader("User-Agent");
//        if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
//            docName = java.net.URLEncoder.encode(docName, "UTF-8");
//        } else {
//            // 非IE浏览器的处理：
//            docName = new String(docName.getBytes("UTF-8"), "ISO-8859-1");
//        }
//        response.setHeader("Content-disposition",String.format("attachment; filename=\"%s\"", docName));
//        response.setContentType("multipart/form-data");
//        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/pdf;charset=utf-8");
        ExportUtil.resHeader(request, response, docName);
        long old = System.currentTimeMillis();

        try (FileInputStream fileInputStream = new FileInputStream(docFile); OutputStream out = response.getOutputStream();) {
            // 注释掉设置字体路径的代码 如果生成的文件乱码 需要安装对应的字体
            //FontSettings fontSettings = new FontSettings();
            //fontSettings.setFontsFolder("/usr/share/fonts/", true);
            Document doc = new Document(fileInputStream);
            //doc.setFontSettings(fontSettings);
            doc.save(out, SaveFormat.PDF);
            long now = System.currentTimeMillis();
            logger.info("共耗时：" + ((now - old) / 1000.0) + "秒");
        }
        boolean delete = docFile.delete();
        if (!delete) {
            logger.warn("临时文件：[{}]删除失败，请手动删除", docFile.getAbsolutePath());
        }
    }

    /**
     * String docStr = FreemarkerUtils.process("service_interface_list.xml", result);
     * HttpServletResponse response = getResponse();
     * HttpServletRequest request = getRequest();
     * response.reset();
     * FreemarkerUtils.resHeader(request, response, getPara("export") + ".doc");
     * ServletOutputStream out = null;
     * try {
     * 	out = response.getOutputStream();
     * 	out.write(docStr.getBytes("UTF-8"));
     * 	out.flush();
     * 	out.close();
     * } catch (Exception ex) {
     * 	ex.printStackTrace();
     * }
     */
    /**
     * @desc freemarker模板替换
     * @param templatePath
     * @param dataMap
     * @return
     */
    public static String process(String templatePath, Map dataMap) {
        Template template = null;
        try {
            template = cfg.getTemplate(templatePath);
            StringWriter writer = new StringWriter();
            try {
                template.process(dataMap, writer);
                writer.flush();
            } finally {
                writer.close();
            }
            return writer.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

package com.hongcheng.techinnovte.common.util;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class ExportUtil {
	
	/**
	 * @desc 导出文件header设置
	 * @param request
	 * @param response
	 * @param fileName
	 */
	public static void resHeader(HttpServletRequest request,HttpServletResponse response, String fileName) {
	    try {
	        //中文文件名支持
	        String encodedfileName = null;
	        String agent = request.getHeader("USER-AGENT");
	        if(null != agent && (-1 != agent.indexOf("MSIE") || -1 != agent.indexOf("Trident") || -1 != agent.indexOf("Edge"))){//IE
	            encodedfileName = java.net.URLEncoder.encode(fileName,"UTF-8");
	        }else if(null != agent && -1 != agent.indexOf("Mozilla")){
	            encodedfileName = new String (fileName.getBytes("UTF-8"),"iso-8859-1");
	        }else{
	            encodedfileName = java.net.URLEncoder.encode(fileName,"UTF-8");
	        }
	        response.setContentType("application/octet-stream");
	        response.setHeader("Content-Disposition", "attachment; filename=" + encodedfileName);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	/**
	 * @desc 设置字体样式
	 * @param workbook
	 * @return
	 */
	private static HSSFCellStyle getHeadStyle(HSSFWorkbook workbook){
		HSSFCellStyle style = workbook.createCellStyle();
		//	生成一个字体
		HSSFFont font = workbook.createFont();
		//font.setFontName("宋体");								//	字体名字
		//font.setFontHeightInPoints((short)11); 				//	字体大小
		font.setColor(HSSFColor.DARK_BLUE.index);
		font.setBold(true);			//	加粗
		style.setWrapText(true);								//	自动换行
		style.setAlignment(HorizontalAlignment.CENTER);			//	水平居中
		style.setVerticalAlignment(VerticalAlignment.CENTER);//垂直对齐 
		//font.setItalic(true); //是否使用斜体
		//font.setStrikeout(true); //是否使用划线
		//	把字体应用到当前的样式
		style.setFont(font);
		
		return style;
	}
	
	/**
	 * @desc 设置表头标题
	 * @param sheet
	 * @param style
	 * @param header
	 * @param splitStr
	 */
	private static void createHeader(HSSFSheet sheet, HSSFCellStyle style, String[] header, String splitStr) {  
        //遍历创建单元格  
    	/*先将所有题头放进去*/
		HSSFRow row = null;
		for(int i = 0 ; i< header.length ; i++){
			row = sheet.createRow(i);
			String[] columns = header[i].split(splitStr);
			for(int j = 0 ; j < columns.length; j++){
				addCell(row, style, j, columns[j]);
			}
		} 
        //遍历合并单元格，如果是单表头则跳过  
        if(header.length>1){  
            int[][][] mergeDatas = parseHeader(header,splitStr);  
            for(int i=0;i<mergeDatas.length;i++){  
                int[][] mergeData = mergeDatas[i];  
                for(int j=0;j<mergeData.length;j++){  
                    int[] merges = mergeData[j];  
                    int mergesR = merges[1]-merges[0];  
                    int mergesC = merges[3]-merges[2];  
                    if(mergesR!=0||mergesC!=0){  
                        //合并单元格  
                        sheet.addMergedRegion(new CellRangeAddress(merges[0],merges[1],merges[2],merges[3]));  
                    }  
                }  
            }  
        }  
    } 
	
	private static int[][][] parseHeader(String[] headers, String splitStr){  
        //依据表头建立一个二维数组  
        String[][] doubleAry = new String[headers.length][];  
        //依据表头建立一个三维数组，用来保存合并单元格所需要的数据，单元格所需要的数据有四个，依次是开始合并的行，结束合并的行，开始合并的列，结束合并的列  
        //sheet.addMergedRegion(new CellRangeAddress(merges[0],merges[1],merges[2],merges[3]));  
        int[][][] rcs = new int[headers.length][][];  
        //遍历赋值  
        for(int i=0;i<headers.length;i++){  
            String[] header = headers[i].split(splitStr);  
            doubleAry[i] = header;  
            rcs[i] = new int[header.length][4];  
        }  
        //遍历二维数组  
        for(int i=0;i<doubleAry.length;i++){  
            String[] sub = doubleAry[i];  
            for(int j=0;j<sub.length;j++){  
                int sum = 0;//计算行标识  
                //计算i,j需要合并的行数  
                if(!sub[j].equals("null")){//如果单元格不为null  
                    for(int m=i;m<doubleAry.length;m++){  
                        String rs = doubleAry[m][j];  
                        if(rs.equals("null")){//如果单元格为null  
                            doubleAry[m][j] = "null2";//把null重赋值为null2，防止在计算列时交错了  
                            sum++;//个数加1  
                        }  
                    }  
                }  
                rcs[i][j][0] = i;//赋合并的开始行，当前行  
                rcs[i][j][1] = i+sum;//赋合并的结束行，当前行加上它下面为null的行数  
                int sum2 = 0;//计算列标识  
                //计算i,j需要合并的列数  
                if(!sub[j].equals("null")){//如果单元格不为null  
                    for(int m=j+1;m<doubleAry[i].length;m++){  
                        String rs = doubleAry[i][m];  
                        if(rs.equals("null")){//如果单元格为null  
                            sum2++;  
                        }else{  
                            break;//一定要break，不然会算错  
                        }  
                    }  
                }  
                rcs[i][j][2] = j;//赋合并的开始列，当前列  
                rcs[i][j][3] = j+sum2;//赋合并的结束列，当前列加上它右边为null的列数  
            }  
        }  
        return rcs;  
    }
	
	/**
	 * @desc 创建单元格
	 * @param row
	 * @param style
	 * @param index
	 * @param value
	 * @return
	 */
	public static HSSFCell addCell(HSSFRow row, HSSFCellStyle style, int index, String value){
		HSSFCell cell = row.createCell(index);
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);//指定单元格格式：数值、公式或字符串
        
        if(null != style){
			cell.setCellStyle(style);
		}
		cell.setCellValue(new HSSFRichTextString(String.valueOf(value)));
		
		return cell;
	}
	
	/**
	 * @desc excel导出
	 * @param response
	 * @param columns	cname/ename
	 * @param data
	 * @throws Exception
	 */
	public static void excel(HttpServletResponse response, List<Map> columns, List data) throws Exception{
		//参数校验
		if(null == columns || columns.size() <= 0 || null == data || data.size() <= 0) {
			return;
		}
		
		//创建工作簿
		HSSFWorkbook wb = new HSSFWorkbook();
		wb.getCreationHelper().createClientAnchor();
		HSSFSheet sheet = wb.createSheet("数据清单");
		sheet.setDefaultRowHeight((short)(15*20));
		HSSFCellStyle style = getHeadStyle(wb);
		
		/*题头*/
		String[] header = new String[1];
		StringBuilder first = new StringBuilder("序号");
		for(Map column : columns) {
			first.append(",").append(column.get("cname").toString());//cname
		}
		header[0] = first.toString(); 
		createHeader(sheet, style, header, ",");
		
		/*数据记录*/
		int dataStartRow = header.length;
		HSSFRow row = null;
		
		JSONArray jsondata = (JSONArray)JSON.toJSON(data);
		int datalen = jsondata.size();

		for(int j = dataStartRow ; j < dataStartRow + datalen; j++){//行
			int inx = j - dataStartRow;
			row = sheet.createRow(j);
			
			JSONObject rowdata = (JSONObject)jsondata.get(inx);//行数据
			
			addCell(row, style, 0, "" + (inx + 1));//添加
			HSSFCell cell = null;
			String celldata = "";
			Object columnkey;
			for(int k = 0 ; k < columns.size(); k++){//列
				columnkey = columns.get(k).get("ename");//ename
				if(columnkey != null) {
					celldata = rowdata.get(columnkey)==null ? "" : rowdata.get(columnkey).toString();
				}
				cell = addCell(row, null, (k + 1), celldata);
			}
		}
		OutputStream render = response.getOutputStream();
		wb.write(render);
	}
}
package com.hongcheng.techinnovte.common.util;

import java.io.InputStream;
import java.security.MessageDigest;

public class FileUtil {

	protected final static char hexDigits[] ={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
	
	/**
	 * @desc 文件md5码
	 * @param file
	 * @return
	 */
	public static String md5(InputStream file){
		String code = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] buffer = new byte[2048];
			int length = -1;
			while((length = file.read(buffer))!=-1){
				md.update(buffer,0,length);
			}
			byte[] b = md.digest();
			code = byteToHexString(b);
		}catch (Exception e) {
		}
		return code;
	}
	
	private static String byteToHexString(byte[] tmp){
		String s;
		char str[] = new char[16*2];
		int k = 0;
		for(int i = 0 ; i < 16 ; i++){
			byte byte0 = tmp[i];
			str[k++] = hexDigits[byte0 >>> 4 & 0xf];
			str[k++] = hexDigits[byte0 & 0xf];
		}
		return new String(str);
	}
	
	/**
	 * 获取文件目录的后缀名
	 * @param path
	 * @return
	 */
	public static String suffix(String path){
		return path.substring(path.lastIndexOf(".") + 1);
	}
	
	/**
	 * @desc 文件大小格式化
	 * @param size
	 * @return
	 */
	public static String format(long size) {
		long SIZE_KB = 1024;
		long SIZE_MB = SIZE_KB * 1024;
		long SIZE_GB = SIZE_MB * 1024;
		long SIZE_TB = SIZE_GB * 1024;
		if (size < SIZE_KB) {
			return String.format("%d B", (int) size);
		} else if (size < SIZE_MB) {
			return String.format("%.2f KB", (float) size / SIZE_KB);
		} else if (size < SIZE_GB) {
			return String.format("%.2f MB", (float) size / SIZE_MB);
		} else if (size < SIZE_TB) {
			return String.format("%.2f GB", (float) size / SIZE_GB);
		} else {
			return String.format("%.2f TB", (float) size / SIZE_TB);
		}
	}
}

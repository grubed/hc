package com.hongcheng.techinnovte.common.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ReflectUtil<E>{
	
	/**
	 * @desc 根据数据列表获取指定属性列表
	 * @param <E>
	 * @param dataObj	需要获取值的源
	 * @param field		属性名称 支持a.b.c
	 * @param target	返回列表元素类型
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static<E> List<E> getAttrListFromData(Object dataObj, String field, Class<E> target){
		List<E> result = new ArrayList<E>();
		
		List<Object> param = null;
		if(dataObj instanceof List) {
			param = (List)dataObj;
		}else {
			param = new ArrayList<Object>();
			param.add(dataObj);
		}
		
		for(Object obj: param) {
			try {
				result.add(target.cast(getValue(obj, field)));
			} catch (Exception e) {
				result.add(null);
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static Object getValue(Object obj, String fieldNames) throws Exception{
		String[] fieldNameArray = fieldNames.split("\\.");
		Object result = obj;
		for(String fieldName : fieldNameArray){
			//字段类类型field.getType().getClass();
			Field field = result.getClass().getDeclaredField(fieldName);
			if(null != field){
				if(field.isAccessible()){
					result = field.get(result);
				}else{
					field.setAccessible(true);
					result = field.get(result);
					field.setAccessible(false);
				}
			}
		}
		return result;
	}
}

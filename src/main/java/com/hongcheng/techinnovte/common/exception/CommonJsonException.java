package com.hongcheng.techinnovte.common.exception;

import com.alibaba.fastjson.JSONObject;
import com.hongcheng.techinnovte.common.Result;
import com.hongcheng.techinnovte.common.constants.ErrorEnum;
import com.hongcheng.techinnovte.common.util.CommonUtil;


/**
 * @author: hxy
 * @description: 本系统使用的自定义错误类
 * 比如在校验参数时,如果不符合要求,可以抛出此错误类
 * 拦截器可以统一拦截此错误,将其中json返回给前端
 * @date: 2017/10/24 10:29
 */
public class CommonJsonException extends RuntimeException {
	private Result resultJson;

	/**
	 * 调用时可以在任何代码处直接throws这个Exception,
	 * 都会统一被拦截,并封装好json返回给前台
	 *
	 * @param errorEnum 以错误的ErrorEnum做参数
	 */
	public CommonJsonException(ErrorEnum errorEnum) {
		this.resultJson = CommonUtil.errorJson(errorEnum);
	}

	public CommonJsonException(Result resultJson) {
		this.resultJson = resultJson;
	}

	public Result getResultJson() {
		return resultJson;
	}
}

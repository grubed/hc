package com.hongcheng.techinnovte.common.constants;

/**
 * @author: hxy
 * @date: 2017/10/24 10:16
 */
public enum ErrorEnum {
	/*
	 * 错误信息
	 * */
	E_400(400, "请求处理异常，请稍后再试"),
	E_500(500, "请求方式有误,请检查 GET/POST"),
	E_501(501, "请求路径不存在"),
	E_502(502, "权限不足"),
	E_10001(10001, "账户名/手机号或密码错误"),
	E_10002(10002, "手机号或验证码错误"),
	E_10008(10008, "角色删除失败,尚有用户属于此角色"),
	E_10009(10009, "账户已存在"),

	E_60001(60001, "文件上传失败"),
	
	E_70001(60001, "数据转换异常"),
	
	E_20011(20011, "登陆已过期,请重新登陆"),
	E_20021(20021, "该专家已经在联盟中申报，请确认信息。"),
	E_90003(90003, "缺少必填参数");

	private Integer errorCode;

	private String errorMsg;

	ErrorEnum(Integer errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

}
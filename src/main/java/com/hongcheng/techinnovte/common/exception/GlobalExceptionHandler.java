package com.hongcheng.techinnovte.common.exception;

import com.alibaba.fastjson.JSONObject;

import com.hongcheng.techinnovte.common.Result;
import com.hongcheng.techinnovte.common.constants.ErrorEnum;
import com.hongcheng.techinnovte.common.util.CommonUtil;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: hxy
 * @description: 统一异常拦截
 * @date: 2017/10/24 10:31
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());


	// 捕捉其他所有异常
	@ExceptionHandler(Exception.class)
	public Result globalException(HttpServletRequest request, Throwable ex) {
		return Result.getFail(getStatus(request).value(),
				"访问出错，无法访问: " + ex.getMessage());
	}

	private HttpStatus getStatus(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		if (statusCode == null) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return HttpStatus.valueOf(statusCode);
	}

//	@ExceptionHandler(value = Exception.class)
//	public Result defaultErrorHandler(HttpServletRequest req, Exception e) {
//		String errorPosition = "";
//		//如果错误堆栈信息存在
//		if (e.getStackTrace().length > 0) {
//			StackTraceElement element = e.getStackTrace()[0];
//			String fileName = element.getFileName() == null ? "未找到错误文件" : element.getFileName();
//			int lineNumber = element.getLineNumber();
//			errorPosition = fileName + ":" + lineNumber;
//		}
//		Result result = new Result();
//		result.setCode(ErrorEnum.E_400.getErrorCode());
//		result.setMsg(ErrorEnum.E_400.getErrorMsg());
//		JSONObject errorObject = new JSONObject();
//		errorObject.put("errorLocation", e.toString() + "    错误位置:" + errorPosition);
//		result.setData(errorObject);
//		logger.error("异常", e);
//		return result;
//	}

	/**
	 * GET/POST请求方法错误的拦截器
	 * 因为开发时可能比较常见,而且发生在进入controller之前,上面的拦截器拦截不到这个错误
	 * 所以定义了这个拦截器
	 */
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public Result httpRequestMethodHandler() {
		return Result.getFail(ErrorEnum.E_500.getErrorCode(), ErrorEnum.E_500.getErrorMsg());
	}

	/**
	 * 本系统自定义错误的拦截器
	 * 拦截到此错误之后,就返回这个类里面的json给前端
	 * 常见使用场景是参数校验失败,抛出此错,返回错误信息给前端
	 */
	@ExceptionHandler(CommonJsonException.class)
	public Result commonJsonExceptionHandler(CommonJsonException commonJsonException) {

		return commonJsonException.getResultJson();
	}

	/**
	 * 权限不足报错拦截
	 */
	@ExceptionHandler(ShiroException.class)
	public Result handle401() {
		return CommonUtil.errorJson(ErrorEnum.E_502);
	}

	@ExceptionHandler(AuthenticationException.class)
	public Result AuthenticationException() {
		return CommonUtil.errorJson(ErrorEnum.E_20011);
	}

	/**
	 * 未登录报错拦截
	 * 在请求需要权限的接口,而连登录都还没登录的时候,会报此错
	 */
	@ExceptionHandler(UnauthenticatedException.class)
	public Result unauthenticatedException() {
		return CommonUtil.errorJson(ErrorEnum.E_20011);
	}

	@ExceptionHandler(ExpertDuplicateException.class)
	public Result expertDuplicateException() {
		return CommonUtil.errorJson(ErrorEnum.E_20021);
	}
}

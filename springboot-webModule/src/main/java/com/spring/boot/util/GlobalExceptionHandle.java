package com.spring.boot.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理类,基于Springmvc
 * @author fengchao
 * @data 2017年6月21日
 */
@ControllerAdvice
public class GlobalExceptionHandle {

	/**
	 * 声明异常处理方法
	 * @author fengchao
	 * @data 2017年6月21日
	 */
	@ExceptionHandler(value=Exception.class)
	public void defaultException(HttpServletRequest request,Exception e){
		e.printStackTrace();
		System.out.println("GlobalException has a Exception");
	}
}

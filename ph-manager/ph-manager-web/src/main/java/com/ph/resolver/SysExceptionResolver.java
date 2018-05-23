package com.ph.resolver;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.ph.common.dto.ResponseCode;
import com.ph.common.dto.SysException;

public class SysExceptionResolver implements HandlerExceptionResolver {

	private MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, 
											Object handler, Exception ex) {
		SysException sysException = null;
		
		//如果抛出的是系统自定义异常则直接转换
		if(ex instanceof SysException){
			sysException = (SysException)ex;
		}else{
			//如果抛出的不是系统自定义异常则重新构造一个未知错误异常。
			if(ex instanceof NullPointerException) {
				sysException = new SysException("程序运行发生空指针异常!");
			} else if(ex instanceof ClassNotFoundException) {
				sysException = new SysException("程序类或方法没有发现!");
			} else if(ex instanceof ArithmeticException){
				sysException = new SysException("数学运算异常");
			} else if(ex instanceof ArrayIndexOutOfBoundsException ){
				sysException = new SysException("数组访问越界异常");
			}  else if(ex instanceof IllegalArgumentException ){
				sysException = new SysException("参数非法异常");
			} else if (ex instanceof IllegalAccessException ) {
				sysException = new SysException("当前方法没有调用相应对象的方法");
			}
		}
		Map<String, Object> map = new HashMap<>();
		map.put("code", ResponseCode.INTERNAL_FAIL);
		map.put("msg", sysException.getMessage());
		return new ModelAndView(jsonView, map);
	}
}
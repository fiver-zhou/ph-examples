package com.ph.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ph.context.SystemRequestContext;

/**
 * 通过过滤器在处理前注入request和session对象到ThreadLocal中, 并在结束时, 从ThreadLocal中移除这个对象
 * @author fiver
 */
public class SystemRequestFilter implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object obj) throws Exception {
		HttpServletRequest request = (HttpServletRequest)req;  
        SystemRequestContext.setRequest(request);
        SystemRequestContext.setSession(request.getSession());
        return true;
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		 SystemRequestContext.removeRequest();
		 SystemRequestContext.removeSession();
	}
}
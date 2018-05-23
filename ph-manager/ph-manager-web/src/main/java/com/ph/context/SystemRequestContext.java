package com.ph.context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SystemRequestContext {

	private static ThreadLocal<HttpServletRequest> httpRequest = new ThreadLocal<HttpServletRequest>();
	private static ThreadLocal<HttpSession> httpSession = new ThreadLocal<HttpSession>();
	
	public static void removeRequest() {
		httpRequest.remove();
	}
	public static HttpServletRequest getRequest() {
		return httpRequest.get();
	}
	public static void setRequest(HttpServletRequest _request) {
		httpRequest.set(_request);
	}
	
	public static void removeSession() {
		httpSession.remove();
	}
	public static HttpSession getSession() {
		return httpSession.get();
	}
	public static void setSession(HttpSession _session) {
		httpSession.set(_session);
	}
}
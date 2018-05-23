package com.ph.common.dto;

import java.io.Serializable;

/**
 * 自定义全局异常类
 */
public class SysException extends RuntimeException implements Serializable{

	private static final long serialVersionUID = 1361000171094574599L;
	
	public SysException() {
		super();
	}

	public SysException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public SysException(String msg) {
		super(msg);
	}

	public SysException(Throwable throwable) {
		super(throwable);
	}
}
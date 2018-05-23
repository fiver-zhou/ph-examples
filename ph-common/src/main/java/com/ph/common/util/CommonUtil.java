package com.ph.common.util;

import java.util.Collection;

public class CommonUtil {

	/**
	 * 判断一个对象(包括String、以及Collection下的各个子类集合) 是否为空, 为空则返回true, 否则会返回false
	 * @param obj
	 * @return
	 */
	public static boolean isEmpty(Object obj) {
		if(obj == null)
			return true;
		if(obj instanceof String) {
			if(((String)obj).equals("") )
				return true;
		}
		if(obj instanceof Collection<?>) {
			if(((Collection<?>)obj).size() <=0 )
				return true;
		}
		if(obj instanceof String[]) {
			if (((String[]) obj).length <= 0) {
				return true;
			}
		}
		if(obj instanceof Object[]) {
			if (((Object[]) obj).length <= 0) {
				return true;
			}
		}
		return false;
	}
}
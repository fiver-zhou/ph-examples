package com.ph.common.util;

public class UuidUtil {

	/**
	 * 获取全宇宙的唯一标识UUID
	 * @return
	 */
	public static String getUUID() {
		return SnowFlake.getInstance().nextId()+"";
//		return UUID.randomUUID().toString().replace("-", "");
	}
}
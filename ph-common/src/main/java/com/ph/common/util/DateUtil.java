package com.ph.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	/**
	 * 将指定日期按照指定的格式以字符串的形式进行返回
	 * @param pattern
	 * @param date
	 * @return
	 */
	public static String getDate(Date dateTime, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(dateTime);
	}
	
	/**
	 * 将当前时间按照参数指定的格式进行返回
	 * @param pattern	指定返回时间的格式
	 * @return
	 */
	public static String getDate(String pattern) {
		return getDate(new Date(), pattern);
	}
	
	/**
	 * 获取当前时间, 返回字符串, 格式：yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getDate() {
		return getDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 比较date1和date2的日期先后顺序关系 <br/>
	 * 		date1 > date2 形如 2019-01-01 > 2018-01-01 , 则返回+1 <br/>
	 * 		date1 = date2 形如 2018-01-01 < 2018-01-01 , 则返回0 <br/>
	 * 		date1 < date2 形如 2017-01-01 < 2018-01-01 , 则返回-1 <br/>
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int compareToDate(Date date1, Date date2) {
		if(date1.getTime() > date2.getTime()) {
			return 1;
		} else if (date1.getTime() == date2.getTime()) {
			return 0;
		} else {
			return -1;
		}
	}
}
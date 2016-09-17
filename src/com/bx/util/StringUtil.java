package com.bx.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @date 2016年4月6日 StringUtil.java
 * @author CZP
 * @parameter
 */
public class StringUtil {

	public static boolean isEmpty(String str) {
		if (str == null || "".equals(str)) {
			return true;
		} else {
			return false;
		}
	}

	public static String formatLike(String str) {
		if (StringUtil.isEmpty(str)) {
			return null;
		} else {
			return "%" + str + "%";
		}
	}

	public static boolean isNotEmpty(String str) {
		if (str != null && !"".equals(str)) {
			return true;
		} else {
			return false;
		}
	}

	public static String getCurrentDateString() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		return format.format(date);
	}

}

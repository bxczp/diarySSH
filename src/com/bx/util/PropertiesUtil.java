package com.bx.util;

import java.io.InputStream;
import java.util.Properties;

/**
 * @date 2016年4月6日 PropertiesUtil.java
 * @author CZP
 * @parameter
 */
public class PropertiesUtil {

	public static String getValue(String key) throws Exception {
		Properties properties = new Properties();
		InputStream inputStream = new PropertiesUtil().getClass().getResourceAsStream("/diary.properties");
		properties.load(inputStream);
		return properties.getProperty(key);
	}

	public static void main(String[] args) {
		try {
			System.out.println(PropertiesUtil.getValue("pageSize"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

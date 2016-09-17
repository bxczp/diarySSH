package com.bx.util;

import java.security.MessageDigest;
import sun.misc.BASE64Encoder;

/**
 * @date 2016年2月24日 MD5Util.java
 * @author CZP
 * @parameter
 */
// 使用MD5加密算法
public class MD5Util {
	public static String EncodeByMD5(String str) throws Exception {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		BASE64Encoder base64Encoder = new BASE64Encoder();
		return base64Encoder.encode(md5.digest(str.getBytes("UTF-8")));
	}

	public static void main(String[] args) throws Exception {
		System.out.println(EncodeByMD5("123456"));
	}
}

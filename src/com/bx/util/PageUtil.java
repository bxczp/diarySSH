package com.bx.util;

/**
 * @date 2016年4月6日 PageUtil.java
 * @author CZP
 * @parameter
 */
public class PageUtil {

	public static String genPagation(long totalNum, int currentPage, int pageSize) {
		long totalPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize + 1;
		StringBuffer pageCode = new StringBuffer();
		pageCode.append("<li><a href='main.action?page=1'>首页</a></li>");
		if (currentPage == 1) {
			pageCode.append("<li class='disabled'><a href='#'>上一页</a></li>");
		} else {
			pageCode.append("<li><a href='main.action?page=" + (currentPage - 1) + "'>上一页</a></li>");
		}

		for (int i = currentPage - 2; i <= currentPage + 2; i++) {
			if (i < 1 || i > totalPage) {
				continue;
			} else {
				pageCode.append("<li><a href='main.action?page=" + i + "'>" + i + "</a></li>");
			}
		}

		if (currentPage == totalPage) {
			pageCode.append("<li class='disabled'><a href='#'>下一页</a></li>");
		} else {
			pageCode.append("<li><a href='main.action?page=" + (currentPage + 1) + "'>下一页</a></li>");
		}
		pageCode.append("<li><a href='main.action?page=" + totalPage + "'>尾页</a></li>");

		return pageCode.toString();
	}

}

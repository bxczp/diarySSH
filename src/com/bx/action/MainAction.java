package com.bx.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.stereotype.Controller;

import com.bx.entity.Diary;
import com.bx.entity.DiaryType;
import com.bx.entity.PageBean;
import com.bx.service.DiaryService;
import com.bx.service.DiaryTypeService;
import com.bx.util.PageUtil;
import com.bx.util.PropertiesUtil;
import com.bx.util.StringUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.xerces.internal.util.DraconianErrorHandler;

/**
 * @date 2016年4月6日 MainAction.java
 * @author CZP
 * @parameter
 */
@Controller
public class MainAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	@Resource
	private DiaryService diaryService;
	@Resource
	private DiaryTypeService diaryTypeService;
	private String mainPage;
	private String page;
	private Diary s_diary;
	private Diary diary;
	private String diary_typeId;
	private String diary_releaseDataStr;
	private List<Diary> diaryList;
	private String pageCode;
	private String s_title;
	// all 来自主页 和 搜索框
	private String all;
	private List<DiaryType> diaryTypeCountList;
	private List<Diary> diaryCountList;

	public List<Diary> getDiaryCountList() {
		return diaryCountList;
	}

	public void setDiaryCountList(List<Diary> diaryCountList) {
		this.diaryCountList = diaryCountList;
	}

	@Override
	public String execute() throws Exception {
		s_diary = new Diary();
		if (StringUtil.isEmpty(page)) {
			page = "1";
		}
		HttpSession session = request.getSession();
		if (StringUtil.isNotEmpty(all)) {
			if (StringUtil.isNotEmpty(s_title)) {
				s_diary.setTitle(s_title);
				session.setAttribute("s_title", s_title);
			} else {
				session.removeAttribute("s_title");
			}
			session.removeAttribute("diary_releaseDataStr");
			session.removeAttribute("diary_typeId");
		} else {
			if (StringUtil.isNotEmpty(diary_releaseDataStr)) {
				s_diary.setReleaseDateStr(diary_releaseDataStr);
				session.setAttribute("diary_releaseDataStr", diary_releaseDataStr);
				session.removeAttribute("s_title");
				session.removeAttribute("diary_typeId");
			}
			if (StringUtil.isNotEmpty(diary_typeId)) {
				s_diary.setTypeId(Integer.parseInt(diary_typeId));
				session.setAttribute("diary_typeId", diary_typeId);
				session.removeAttribute("s_title");
				session.removeAttribute("diary_releaseDataStr");
			}
		}
		if (StringUtil.isEmpty(s_title) && session.getAttribute("s_title") != null) {
			s_title = (String) session.getAttribute("s_title");
			s_diary.setTitle(s_title);
		}
		if (StringUtil.isEmpty(diary_typeId) && session.getAttribute("diary_typeId") != null) {
			diary_typeId = (String) session.getAttribute("diary_typeId");
			s_diary.setTypeId(Integer.parseInt(diary_typeId));
		}
		if (StringUtil.isEmpty(diary_releaseDataStr) && session.getAttribute("diary_releaseDataStr") != null) {
			diary_releaseDataStr = (String) session.getAttribute("diary_releaseDataStr");
			s_diary.setReleaseDateStr(diary_releaseDataStr);
		}
		diaryTypeCountList = diaryTypeService.find();
		session.setAttribute("diaryTypeCountList", diaryTypeCountList);
		diaryCountList = diaryService.getListByDate();
		session.setAttribute("diaryCountList", diaryCountList);
		long totalNum = diaryService.getListCount(s_diary);
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("pageSize")));
		diaryList = diaryService.find(pageBean, s_diary);
		mainPage = "/diary/diaryList.jsp";
		pageCode = PageUtil.genPagation(totalNum, Integer.parseInt(page),
				Integer.parseInt(PropertiesUtil.getValue("pageSize")));
		return SUCCESS;
	}

	public List<Diary> getDiaryList() {
		return diaryList;
	}

	public void setDiaryList(List<Diary> diaryList) {
		this.diaryList = diaryList;
	}

	public String getMainPage() {
		return mainPage;
	}

	public void setMainPage(String mainPage) {
		this.mainPage = mainPage;
	}

	@Override
	public void setServletResponse(HttpServletResponse resp) {
		this.response = resp;
	}

	@Override
	public void setServletRequest(HttpServletRequest req) {
		this.request = req;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public Diary getS_diary() {
		return s_diary;
	}

	public void setS_diary(Diary s_diary) {
		this.s_diary = s_diary;
	}

	public Diary getDiary() {
		return diary;
	}

	public void setDiary(Diary diary) {
		this.diary = diary;
	}

	public String getDiary_typeId() {
		return diary_typeId;
	}

	public void setDiary_typeId(String diary_typeId) {
		this.diary_typeId = diary_typeId;
	}

	public String getDiary_releaseDataStr() {
		return diary_releaseDataStr;
	}

	public void setDiary_releaseDataStr(String diary_releaseDataStr) {
		this.diary_releaseDataStr = diary_releaseDataStr;
	}

	public String getPageCode() {
		return pageCode;
	}

	public void setPageCode(String pageCode) {
		this.pageCode = pageCode;
	}

	public String getS_title() {
		return s_title;
	}

	public void setS_title(String s_title) {
		this.s_title = s_title;
	}

	public String getAll() {
		return all;
	}

	public void setAll(String all) {
		this.all = all;
	}

	public List<DiaryType> getDiaryTypeCountList() {
		return diaryTypeCountList;
	}

	public void setDiaryTypeCountList(List<DiaryType> diaryTypeCountList) {
		this.diaryTypeCountList = diaryTypeCountList;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

}

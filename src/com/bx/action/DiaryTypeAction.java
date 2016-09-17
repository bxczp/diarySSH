package com.bx.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.bx.entity.DiaryType;
import com.bx.service.DiaryTypeService;
import com.bx.util.StringUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @date 2016年4月8日 DiaryTypeAction.java
 * @author CZP
 * @parameter
 */
@Controller
public class DiaryTypeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<DiaryType> diaryTypeList;
	private String mainPage;
	private DiaryType diaryType;
	private String diaryTypeId;
	@Resource
	private DiaryTypeService diaryTypeService;

	public String list() {
		diaryTypeList = diaryTypeService.find();
		mainPage = "/diaryType/diaryTypeList.jsp";
		return "list";
	}

	public String preSave() {
		if (StringUtil.isNotEmpty(diaryTypeId)) {
			diaryType = diaryTypeService.getDiaryTypeById(Integer.parseInt(diaryTypeId));
		}
		mainPage = "/diaryType/diaryTypeAve.jsp";
		return "preSave";
	}

	public String save() {
		diaryTypeService.update(diaryType);
		mainPage = "/diaryType/diaryTypeList.jsp";
		return "save";
	}

	public String delete() {
		diaryType = diaryTypeService.getDiaryTypeById(Integer.parseInt(diaryTypeId));
		diaryTypeService.delete(diaryType);
		return "save";
	}

	public List<DiaryType> getDiaryTypeList() {
		return diaryTypeList;
	}

	public void setDiaryTypeList(List<DiaryType> diaryTypeList) {
		this.diaryTypeList = diaryTypeList;
	}

	public String getMainPage() {
		return mainPage;
	}

	public void setMainPage(String mainPage) {
		this.mainPage = mainPage;
	}

	public DiaryType getDiaryType() {
		return diaryType;
	}

	public void setDiaryType(DiaryType diaryType) {
		this.diaryType = diaryType;
	}

	public String getDiaryTypeId() {
		return diaryTypeId;
	}

	public void setDiaryTypeId(String diaryTypeId) {
		this.diaryTypeId = diaryTypeId;
	}

}

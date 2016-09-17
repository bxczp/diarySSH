package com.bx.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.bx.entity.Diary;
import com.bx.entity.DiaryType;
import com.bx.service.DiaryService;
import com.bx.service.DiaryTypeService;
import com.bx.util.StringUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @date 2016年4月6日 DiaryAction.java
 * @author CZP
 * @parameter
 */
@Controller
public class DiaryAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private DiaryService diaryService;
	@Resource
	private DiaryTypeService diaryTypeService;
	private String diaryId;
	private Diary diary;
	private String mainPage;

	public String show() {
		diary = diaryService.getDiaryById(Integer.parseInt(diaryId));
		diary.setTypeName(diaryTypeService.getDiaryTypeById(diary.getTypeId()).getTypeName());
		mainPage = "/diary/diaryShow.jsp";
		return "show";
	}

	public String preSave() {
		if (StringUtil.isNotEmpty(diaryId)) {
			diary = diaryService.getDiaryById(Integer.parseInt(diaryId));
			diary.setTypeName(diaryTypeService.getDiaryTypeById(diary.getTypeId()).getTypeName());
		}
		mainPage = "/diary/diarySave.jsp";
		return "preSave";
	}

	public String save() {
		if (StringUtil.isNotEmpty(diaryId)) {
			diaryService.update(diary);
		} else {
			diary.setReleaseDate(new Date());
			diaryService.add(diary);
		}
		return "save";
	}

	public String delete() {
		diary = diaryService.getDiaryById(Integer.parseInt(diaryId));
		diaryService.delete(diary);
		return "delete";
	}

	public String getDiaryId() {
		return diaryId;
	}

	public void setDiaryId(String diaryId) {
		this.diaryId = diaryId;
	}

	public Diary getDiary() {
		return diary;
	}

	public void setDiary(Diary diary) {
		this.diary = diary;
	}

	public String getMainPage() {
		return mainPage;
	}

	public void setMainPage(String mainPage) {
		this.mainPage = mainPage;
	}

}

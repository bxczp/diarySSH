package com.bx.service;

import java.util.List;

import com.bx.entity.Diary;
import com.bx.entity.PageBean;

/**
 * @date 2016年4月1日 DiaryService.java
 * @author CZP
 * @parameter
 */
public interface DiaryService {

	public List<Diary> find(PageBean pageBean, Diary s_diary);

	public long getListCount(Diary s_diary);

	public List<Diary> getListByDate();

	public Diary getDiaryById(Integer id);

	public void update(Diary diary);

	public void add(Diary diary);

	public void delete(Diary diary);

}

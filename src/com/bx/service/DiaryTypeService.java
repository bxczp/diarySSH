package com.bx.service;

import java.util.List;

import com.bx.entity.DiaryType;

/**
 * @date 2016年4月1日 DiaryTypeService.java
 * @author CZP
 * @parameter
 */
public interface DiaryTypeService {

	public List<DiaryType> find();

	public DiaryType getDiaryTypeById(int id);

	public void update(DiaryType diaryType);

	public void delete(DiaryType diaryType);

}

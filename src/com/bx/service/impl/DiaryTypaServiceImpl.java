package com.bx.service.impl;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bx.dao.BaseDAO;
import com.bx.entity.DiaryType;
import com.bx.service.DiaryTypeService;

/**
 * @date 2016年4月6日 DiaryTypaServiceImpl.java
 * @author CZP
 * @parameter
 */
@Service("diaryTypeService")
public class DiaryTypaServiceImpl implements DiaryTypeService {

	@Resource
	private BaseDAO<DiaryType> baseDAO;

	@Override
	public List<DiaryType> find() {
		StringBuffer hql = new StringBuffer();
		List<Object> param = new LinkedList<>();
		hql.append("select new DiaryType(dt.diaryTypeId,dt.typeName,count(*)) from DiaryType dt,Diary d where d.typeId=dt.diaryTypeId group by dt.typeName ");
		return baseDAO.find(hql.toString(), param);
	}

	@Override
	public DiaryType getDiaryTypeById(int id) {
		return baseDAO.get(DiaryType.class, id);
	}

	@Override
	public void update(DiaryType diaryType) {
		baseDAO.merge(diaryType);
	}

	@Override
	public void delete(DiaryType diaryType) {
		baseDAO.delete(diaryType);
	}

}

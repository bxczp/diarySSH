package com.bx.service.impl;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bx.dao.BaseDAO;
import com.bx.dao.impl.BaseDAOImpl;
import com.bx.entity.Diary;
import com.bx.entity.PageBean;
import com.bx.service.DiaryService;
import com.bx.util.StringUtil;

/**
 * @date 2016年4月6日 DairyServiceImpl.java
 * @author CZP
 * @parameter
 */
@Service("diaryService")
public class DiaryServiceImpl implements DiaryService {

	@Resource
	private BaseDAO<Diary> baseDAO;

	@Override
	public List<Diary> find(PageBean pageBean, Diary s_diary) {
		StringBuffer hql = new StringBuffer();
		List<Object> param = new LinkedList<>();
		// 要写 select d 返回的是 List<Diary>
		// 不写select d 的话 返回的是 List<Diary,DiaryType>
		// hql.append(" from Diary d,DiaryType t where d.typeId=t.diaryTypeId
		// ");
		hql.append("select d from Diary d,DiaryType t where d.typeId=t.diaryTypeId ");
		if (s_diary != null) {
			if (StringUtil.isNotEmpty(s_diary.getTitle())) {
				hql.append(" and d.title like ?");
				param.add(StringUtil.formatLike(s_diary.getTitle()));
			}
			if (s_diary.getTypeId() != -1) {
				hql.append(" and d.typeId= " + s_diary.getTypeId());
			}
			if (StringUtil.isNotEmpty(s_diary.getReleaseDateStr())) {
				String str = s_diary.getReleaseDateStr().split("年")[0]
						+ s_diary.getReleaseDateStr().split("年")[1].split("月")[0];
				// str = StringUtil.formatLike(str);
				hql.append(" and DATE_FORMAT(d.releaseDate,'%Y%m') like " + "'" + str + "'");
			}
		}
		hql.append(" order by d.releaseDate desc");
		if (pageBean != null) {
			return baseDAO.find(hql.toString(), param, pageBean);
		} else {
			return baseDAO.find(hql.toString(), param);
		}
	}

	@Override
	public long getListCount(Diary s_diary) {
		StringBuffer hql = new StringBuffer();
		List<Object> param = new LinkedList<>();
		hql.append("select count(*) from Diary d,DiaryType t where d.typeId=t.diaryTypeId ");
		if (s_diary != null) {
			if (StringUtil.isNotEmpty(s_diary.getTitle())) {
				hql.append(" and d.title like ?");
				param.add(StringUtil.formatLike(s_diary.getTitle()));
			}
			if (s_diary.getTypeId() != -1) {
				hql.append(" and d.typeId= " + s_diary.getTypeId());
			}
			if (StringUtil.isNotEmpty(s_diary.getReleaseDateStr())) {
				String str = s_diary.getReleaseDateStr().split("年")[0]
						+ s_diary.getReleaseDateStr().split("年")[1].split("月")[0];
				hql.append(" and DATE_FORMAT(d.releaseDate,'%Y%m') like " + "'" + str + "'");
			}
		}
		return baseDAO.count(hql.toString(), param);
	}

	@Override
	public List<Diary> getListByDate() {
		StringBuffer hql = new StringBuffer(
				"select new Diary(d.diaryId,DATE_FORMAT(releaseDate,'%Y年%m月'),count(*)) from Diary d group by DATE_FORMAT(releaseDate,'%Y年%m月') ORDER BY DATE_FORMAT(releaseDate,'%Y年%m月') DESC");
		List<Object> params = new LinkedList<>();
		return baseDAO.find(hql.toString(), params);
	}

	@Override
	public Diary getDiaryById(Integer id) {
		return baseDAO.get(Diary.class, id);
	}

	@Override
	public void update(Diary diary) {
		baseDAO.merge(diary);
	}

	@Override
	public void add(Diary diary) {
		baseDAO.merge(diary);
	}

	@Override
	public void delete(Diary diary) {
		baseDAO.delete(diary);
	}

}

package com.bx.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @date 2016年2月26日 DiaryType.java
 * @author CZP
 * @parameter
 */
@Entity
@Table(name = "t_diaryType")
public class DiaryType {
	private int diaryTypeId;
	private String typeName;
	private long diaryCount;// 每个类别的日记数
	

	public DiaryType() {
		super();
	}

	public DiaryType(int diaryTypeId, String typeName, long diaryCount) {
		super();
		this.diaryTypeId = diaryTypeId;
		this.typeName = typeName;
		this.diaryCount = diaryCount;
	}

	@Id
	@GeneratedValue(generator = "_native")
	@GenericGenerator(name = "_native", strategy = "native")
	public int getDiaryTypeId() {
		return diaryTypeId;
	}

	public void setDiaryTypeId(int diaryTypeId) {
		this.diaryTypeId = diaryTypeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public long getDiaryCount() {
		return diaryCount;
	}

	public void setDiaryCount(long diaryCount) {
		this.diaryCount = diaryCount;
	}

}

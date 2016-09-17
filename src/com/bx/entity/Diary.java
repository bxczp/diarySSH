package com.bx.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @date 2016年2月25日 Diary.java
 * @author CZP
 * @parameter
 */

@Entity
@Table(name = "t_diary")
public class Diary {
	// 主键
	private int diaryId;
	private String title;
	private String content;
	// 日记类别 若没有则为-1
	private int typeId = -1;
	private Date releaseDate;
	// string类型的日期格式
	private String releaseDateStr;
	// 日记数
	private int diaryCount;
	private String typeName;

	
	public Diary(int diaryId, String releaseDateStr, long diaryCount) {
		super();
		this.diaryId = diaryId;
		this.releaseDateStr = releaseDateStr;
		this.diaryCount = (int) diaryCount;
	}

	public Diary() {
		super();
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getContent() {
		return content;
	}

	public int getDiaryCount() {
		return diaryCount;
	}

	// 注解 设置在getter方法上
	@Id
	@GeneratedValue(generator = "_native")
	@GenericGenerator(name = "_native", strategy = "native")
	public int getDiaryId() {
		return diaryId;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public String getReleaseDateStr() {
		return releaseDateStr;
	}

	public String getTitle() {
		return title;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setDiaryCount(int diaryCount) {
		this.diaryCount = diaryCount;
	}

	public void setDiaryId(int diaryId) {
		this.diaryId = diaryId;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public void setReleaseDateStr(String releaseDateStr) {
		this.releaseDateStr = releaseDateStr;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

}

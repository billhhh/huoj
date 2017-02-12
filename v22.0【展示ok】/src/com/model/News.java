package com.model;

import java.sql.Timestamp;

/**
 * News entity. @author MyEclipse Persistence Tools
 */

public class News implements java.io.Serializable {

	// Fields

	private Integer newsId;
	private String userId;
	private String title;
	private String content;
	private Timestamp time;
	private Short importance;
	private String defunct;

	// Constructors

	/** default constructor */
	public News() {
	}

	/** full constructor */
	public News(Integer newsId, String userId, String title, String content,
			Timestamp time, Short importance, String defunct) {
		this.newsId = newsId;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.time = time;
		this.importance = importance;
		this.defunct = defunct;
	}

	// Property accessors

	public Integer getNewsId() {
		return this.newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public Short getImportance() {
		return this.importance;
	}

	public void setImportance(Short importance) {
		this.importance = importance;
	}

	public String getDefunct() {
		return this.defunct;
	}

	public void setDefunct(String defunct) {
		this.defunct = defunct;
	}

}
package com.model;

/**
 * Topic entity. @author MyEclipse Persistence Tools
 */

public class Topic implements java.io.Serializable {

	// Fields

	private Integer tid;
	private String title;
	private Integer status;
	private Integer topLevel;
	private Integer cid;
	private Integer pid;
	private String authorId;

	// Constructors

	/** default constructor */
	public Topic() {
	}

	/** minimal constructor */
	public Topic(String title, Integer status, Integer topLevel, Integer pid,
			String authorId) {
		this.title = title;
		this.status = status;
		this.topLevel = topLevel;
		this.pid = pid;
		this.authorId = authorId;
	}

	/** full constructor */
	public Topic(String title, Integer status, Integer topLevel, Integer cid,
			Integer pid, String authorId) {
		this.title = title;
		this.status = status;
		this.topLevel = topLevel;
		this.cid = cid;
		this.pid = pid;
		this.authorId = authorId;
	}

	// Property accessors

	public Integer getTid() {
		return this.tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getTopLevel() {
		return this.topLevel;
	}

	public void setTopLevel(Integer topLevel) {
		this.topLevel = topLevel;
	}

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getAuthorId() {
		return this.authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

}
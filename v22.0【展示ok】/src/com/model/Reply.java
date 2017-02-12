package com.model;

import java.sql.Timestamp;

/**
 * Reply entity. @author MyEclipse Persistence Tools
 */

public class Reply implements java.io.Serializable {

	// Fields

	private Integer rid;
	private String authorId;
	private Timestamp time;
	private String content;
	private Integer topicId;
	private Integer status;
	private String ip;

	// Constructors

	/** default constructor */
	public Reply() {
	}

	/** full constructor */
	public Reply(String authorId, Timestamp time, String content,
			Integer topicId, Integer status, String ip) {
		this.authorId = authorId;
		this.time = time;
		this.content = content;
		this.topicId = topicId;
		this.status = status;
		this.ip = ip;
	}

	// Property accessors

	public Integer getRid() {
		return this.rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getAuthorId() {
		return this.authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getTopicId() {
		return this.topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
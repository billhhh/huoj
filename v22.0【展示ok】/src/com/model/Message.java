package com.model;

import java.sql.Timestamp;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */

public class Message implements java.io.Serializable {

	// Fields

	private Integer messageId;
	private Integer problemId;
	private Integer parentId;
	private Integer threadId;
	private Integer depth;
	private Integer orderNum;
	private String userId;
	private String title;
	private String content;
	private Timestamp inDate;
	private String defunct;

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** minimal constructor */
	public Message(Integer messageId, Integer problemId, Integer parentId,
			Integer threadId, Integer depth, Integer orderNum, String userId,
			String title, String defunct) {
		this.messageId = messageId;
		this.problemId = problemId;
		this.parentId = parentId;
		this.threadId = threadId;
		this.depth = depth;
		this.orderNum = orderNum;
		this.userId = userId;
		this.title = title;
		this.defunct = defunct;
	}

	/** full constructor */
	public Message(Integer messageId, Integer problemId, Integer parentId,
			Integer threadId, Integer depth, Integer orderNum, String userId,
			String title, String content, Timestamp inDate, String defunct) {
		this.messageId = messageId;
		this.problemId = problemId;
		this.parentId = parentId;
		this.threadId = threadId;
		this.depth = depth;
		this.orderNum = orderNum;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.inDate = inDate;
		this.defunct = defunct;
	}

	// Property accessors

	public Integer getMessageId() {
		return this.messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public Integer getProblemId() {
		return this.problemId;
	}

	public void setProblemId(Integer problemId) {
		this.problemId = problemId;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getThreadId() {
		return this.threadId;
	}

	public void setThreadId(Integer threadId) {
		this.threadId = threadId;
	}

	public Integer getDepth() {
		return this.depth;
	}

	public void setDepth(Integer depth) {
		this.depth = depth;
	}

	public Integer getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
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

	public Timestamp getInDate() {
		return this.inDate;
	}

	public void setInDate(Timestamp inDate) {
		this.inDate = inDate;
	}

	public String getDefunct() {
		return this.defunct;
	}

	public void setDefunct(String defunct) {
		this.defunct = defunct;
	}

}
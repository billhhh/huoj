package com.model;

import java.sql.Timestamp;

/**
 * Mail entity. @author MyEclipse Persistence Tools
 */

public class Mail implements java.io.Serializable {

	// Fields

	private Integer mailId;
	private String toUser;
	private String fromUser;
	private String title;
	private String content;
	private Boolean newMail;
	private Short reply;
	private Timestamp inDate;
	private String defunct;

	// Constructors

	/** default constructor */
	public Mail() {
	}

	/** minimal constructor */
	public Mail(Integer mailId, String toUser, String fromUser, String title,
			Boolean newMail, String defunct) {
		this.mailId = mailId;
		this.toUser = toUser;
		this.fromUser = fromUser;
		this.title = title;
		this.newMail = newMail;
		this.defunct = defunct;
	}

	/** full constructor */
	public Mail(Integer mailId, String toUser, String fromUser, String title,
			String content, Boolean newMail, Short reply, Timestamp inDate,
			String defunct) {
		this.mailId = mailId;
		this.toUser = toUser;
		this.fromUser = fromUser;
		this.title = title;
		this.content = content;
		this.newMail = newMail;
		this.reply = reply;
		this.inDate = inDate;
		this.defunct = defunct;
	}

	// Property accessors

	public Integer getMailId() {
		return this.mailId;
	}

	public void setMailId(Integer mailId) {
		this.mailId = mailId;
	}

	public String getToUser() {
		return this.toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	public String getFromUser() {
		return this.fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
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

	public Boolean getNewMail() {
		return this.newMail;
	}

	public void setNewMail(Boolean newMail) {
		this.newMail = newMail;
	}

	public Short getReply() {
		return this.reply;
	}

	public void setReply(Short reply) {
		this.reply = reply;
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
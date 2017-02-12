package com.model;

import java.sql.Timestamp;

/**
 * Contest entity. @author MyEclipse Persistence Tools
 */

public class Contest implements java.io.Serializable {

	// Fields

	private Integer contestId;
	private String title;
	private Timestamp startTime;
	private Timestamp endTime;
	private String defunct;
	private String description;
	private Short private_;
	private Short langmask;
	private String privateornot;
	
	

	// Constructors

	public String getPrivateornot() {
		return privateornot;
	}

	public void setPrivateornot() {
		if(this.private_==0)
			this.privateornot = "Public";
		
		else
			this.privateornot = "Private";
	}

	/** default constructor */
	public Contest() {
	}

	/** minimal constructor */
	public Contest(String defunct, Short private_, Short langmask) {
		this.defunct = defunct;
		this.private_ = private_;
		this.langmask = langmask;
		setPrivateornot();
	}

	/** full constructor */
	public Contest(String title, Timestamp startTime, Timestamp endTime,
			String defunct, String description, Short private_, Short langmask) {
		this.title = title;
		this.startTime = startTime;
		this.endTime = endTime;
		this.defunct = defunct;
		this.description = description;
		this.private_ = private_;
		this.langmask = langmask;
		setPrivateornot();
	}

	// Property accessors

	public Integer getContestId() {
		return this.contestId;
	}

	public void setContestId(Integer contestId) {
		this.contestId = contestId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getDefunct() {
		return this.defunct;
	}

	public void setDefunct(String defunct) {
		this.defunct = defunct;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Short getPrivate_() {
		return this.private_;
	}

	public void setPrivate_(Short private_) {
		this.private_ = private_;
		setPrivateornot();
	}

	public Short getLangmask() {
		return this.langmask;
	}

	public void setLangmask(Short langmask) {
		this.langmask = langmask;
	}

}
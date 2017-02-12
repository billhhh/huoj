package com.model;

import java.sql.Timestamp;

/**
 * Acmsubmit entity. @author MyEclipse Persistence Tools
 */

public class Acmsubmit implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userId;
	private Integer prombleId;
	private Timestamp submitTime;
	private Integer ojId;
	private String submitMethod;
	private String submitType;
	private Integer period;
	private String ojName;
	private String name;
	private String ojLink;
	private Integer teamId;
	private Timestamp recordTime;

	// Constructors

	/** default constructor */
	public Acmsubmit() {
	}

	/** full constructor */
	public Acmsubmit(String userId, Integer prombleId, Timestamp submitTime,
			Integer ojId, String submitMethod, String submitType,
			Integer period, String ojName, String name, String ojLink,
			Integer teamId, Timestamp recordTime) {
		this.userId = userId;
		this.prombleId = prombleId;
		this.submitTime = submitTime;
		this.ojId = ojId;
		this.submitMethod = submitMethod;
		this.submitType = submitType;
		this.period = period;
		this.ojName = ojName;
		this.name = name;
		this.ojLink = ojLink;
		this.teamId = teamId;
		this.recordTime = recordTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getPrombleId() {
		return this.prombleId;
	}

	public void setPrombleId(Integer prombleId) {
		this.prombleId = prombleId;
	}

	public Timestamp getSubmitTime() {
		return this.submitTime;
	}

	public void setSubmitTime(Timestamp submitTime) {
		this.submitTime = submitTime;
	}

	public Integer getOjId() {
		return this.ojId;
	}

	public void setOjId(Integer ojId) {
		this.ojId = ojId;
	}

	public String getSubmitMethod() {
		return this.submitMethod;
	}

	public void setSubmitMethod(String submitMethod) {
		this.submitMethod = submitMethod;
	}

	public String getSubmitType() {
		return this.submitType;
	}

	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}

	public Integer getPeriod() {
		return this.period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public String getOjName() {
		return this.ojName;
	}

	public void setOjName(String ojName) {
		this.ojName = ojName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOjLink() {
		return this.ojLink;
	}

	public void setOjLink(String ojLink) {
		this.ojLink = ojLink;
	}

	public Integer getTeamId() {
		return this.teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public Timestamp getRecordTime() {
		return this.recordTime;
	}

	public void setRecordTime(Timestamp recordTime) {
		this.recordTime = recordTime;
	}

}
package com.model;

/**
 * Acmotheroj entity. @author MyEclipse Persistence Tools
 */

public class Acmotheroj implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userId;
	private Integer ojId;
	private String user;
	private String password;
	private Integer period;
	private String ojName;

	// Constructors

	/** default constructor */
	public Acmotheroj() {
	}

	/** full constructor */
	public Acmotheroj(String userId, Integer ojId, String user,
			String password, Integer period, String ojName) {
		this.userId = userId;
		this.ojId = ojId;
		this.user = user;
		this.password = password;
		this.period = period;
		this.ojName = ojName;
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

	public Integer getOjId() {
		return this.ojId;
	}

	public void setOjId(Integer ojId) {
		this.ojId = ojId;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
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

}
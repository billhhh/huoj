package com.model;

/**
 * Acmteam entity. @author MyEclipse Persistence Tools
 */

public class Acmteam implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userId;
	private Integer teamId;
	private Integer period;
	private String name;

	// Constructors

	/** default constructor */
	public Acmteam() {
	}

	/** full constructor */
	public Acmteam(String userId, Integer teamId, Integer period, String name) {
		this.userId = userId;
		this.teamId = teamId;
		this.period = period;
		this.name = name;
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

	public Integer getTeamId() {
		return this.teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public Integer getPeriod() {
		return this.period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
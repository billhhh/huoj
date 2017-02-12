package com.model;

/**
 * Acmsetotheroj entity. @author MyEclipse Persistence Tools
 */

public class Acmsetotheroj implements java.io.Serializable {

	// Fields

	private Integer ojId;
	private String ojName;
	private String ojLink;

	// Constructors

	/** default constructor */
	public Acmsetotheroj() {
	}

	/** full constructor */
	public Acmsetotheroj(String ojName, String ojLink) {
		this.ojName = ojName;
		this.ojLink = ojLink;
	}

	// Property accessors

	public Integer getOjId() {
		return this.ojId;
	}

	public void setOjId(Integer ojId) {
		this.ojId = ojId;
	}

	public String getOjName() {
		return this.ojName;
	}

	public void setOjName(String ojName) {
		this.ojName = ojName;
	}

	public String getOjLink() {
		return this.ojLink;
	}

	public void setOjLink(String ojLink) {
		this.ojLink = ojLink;
	}

}
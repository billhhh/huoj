package com.model;

/**
 * Loginlog entity. @author MyEclipse Persistence Tools
 */

public class Loginlog implements java.io.Serializable {

	// Fields

	private LoginlogId id;

	// Constructors

	/** default constructor */
	public Loginlog() {
	}

	/** full constructor */
	public Loginlog(LoginlogId id) {
		this.id = id;
	}

	// Property accessors

	public LoginlogId getId() {
		return this.id;
	}

	public void setId(LoginlogId id) {
		this.id = id;
	}

}
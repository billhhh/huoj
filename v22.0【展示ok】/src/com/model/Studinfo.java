package com.model;

/**
 * Studinfo entity. @author MyEclipse Persistence Tools
 */

public class Studinfo implements java.io.Serializable {

	// Fields

	private StudinfoId id;

	// Constructors

	/** default constructor */
	public Studinfo() {
	}

	/** full constructor */
	public Studinfo(StudinfoId id) {
		this.id = id;
	}

	// Property accessors

	public StudinfoId getId() {
		return this.id;
	}

	public void setId(StudinfoId id) {
		this.id = id;
	}

}
package com.model;

/**
 * Attend entity. @author MyEclipse Persistence Tools
 */

public class Attend implements java.io.Serializable {

	// Fields

	private AttendId id;

	// Constructors

	/** default constructor */
	public Attend() {
	}

	/** full constructor */
	public Attend(AttendId id) {
		this.id = id;
	}

	// Property accessors

	public AttendId getId() {
		return this.id;
	}

	public void setId(AttendId id) {
		this.id = id;
	}

}
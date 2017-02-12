package com.model;

/**
 * Table1 entity. @author MyEclipse Persistence Tools
 */

public class Table1 implements java.io.Serializable {

	// Fields

	private Table1Id id;

	// Constructors

	/** default constructor */
	public Table1() {
	}

	/** full constructor */
	public Table1(Table1Id id) {
		this.id = id;
	}

	// Property accessors

	public Table1Id getId() {
		return this.id;
	}

	public void setId(Table1Id id) {
		this.id = id;
	}

}
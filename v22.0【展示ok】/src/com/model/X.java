package com.model;

/**
 * X entity. @author MyEclipse Persistence Tools
 */

public class X implements java.io.Serializable {

	// Fields

	private String doc;

	// Constructors

	/** default constructor */
	public X() {
	}

	/** full constructor */
	public X(String doc) {
		this.doc = doc;
	}

	// Property accessors

	public String getDoc() {
		return this.doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

}
package com.model;

/**
 * Baomingbak entity. @author MyEclipse Persistence Tools
 */

public class Baomingbak implements java.io.Serializable {

	// Fields

	private BaomingbakId id;

	// Constructors

	/** default constructor */
	public Baomingbak() {
	}

	/** full constructor */
	public Baomingbak(BaomingbakId id) {
		this.id = id;
	}

	// Property accessors

	public BaomingbakId getId() {
		return this.id;
	}

	public void setId(BaomingbakId id) {
		this.id = id;
	}

}
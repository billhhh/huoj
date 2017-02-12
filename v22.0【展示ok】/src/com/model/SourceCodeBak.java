package com.model;

/**
 * SourceCodeBak entity. @author MyEclipse Persistence Tools
 */

public class SourceCodeBak implements java.io.Serializable {

	// Fields

	private SourceCodeBakId id;

	// Constructors

	/** default constructor */
	public SourceCodeBak() {
	}

	/** full constructor */
	public SourceCodeBak(SourceCodeBakId id) {
		this.id = id;
	}

	// Property accessors

	public SourceCodeBakId getId() {
		return this.id;
	}

	public void setId(SourceCodeBakId id) {
		this.id = id;
	}

}
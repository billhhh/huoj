package com.model;

/**
 * Compileinfo entity. @author MyEclipse Persistence Tools
 */

public class Compileinfo implements java.io.Serializable {

	// Fields

	private Integer solutionId;
	private String error;

	// Constructors

	/** default constructor */
	public Compileinfo() {
	}

	/** minimal constructor */
	public Compileinfo(Integer solutionId) {
		this.solutionId = solutionId;
	}

	/** full constructor */
	public Compileinfo(Integer solutionId, String error) {
		this.solutionId = solutionId;
		this.error = error;
	}

	// Property accessors

	public Integer getSolutionId() {
		return this.solutionId;
	}

	public void setSolutionId(Integer solutionId) {
		this.solutionId = solutionId;
	}

	public String getError() {
		return this.error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
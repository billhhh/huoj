package com.model;

/**
 * SourceCode entity. @author MyEclipse Persistence Tools
 */

public class SourceCode implements java.io.Serializable {

	// Fields

	private Integer solutionId;
	private String source;

	// Constructors

	/** default constructor */
	public SourceCode() {
	}

	/** minimal constructor */
	public SourceCode(Integer solutionId) {
		this.solutionId = solutionId;
	}

	/** full constructor */
	public SourceCode(Integer solutionId, String source) {
		this.solutionId = solutionId;
		this.source = source;
	}

	// Property accessors

	public Integer getSolutionId() {
		return this.solutionId;
	}

	public void setSolutionId(Integer solutionId) {
		this.solutionId = solutionId;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

}
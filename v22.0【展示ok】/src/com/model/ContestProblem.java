package com.model;

/**
 * ContestProblem entity. @author MyEclipse Persistence Tools
 */

public class ContestProblem implements java.io.Serializable {

	// Fields

	private ContestProblemId id;

	// Constructors

	/** default constructor */
	public ContestProblem() {
	}

	/** full constructor */
	public ContestProblem(ContestProblemId id) {
		this.id = id;
	}

	// Property accessors

	public ContestProblemId getId() {
		return this.id;
	}

	public void setId(ContestProblemId id) {
		this.id = id;
	}

}
package com.model;

/**
 * Sim entity. @author MyEclipse Persistence Tools
 */

public class Sim implements java.io.Serializable {

	// Fields

	private Integer SId;
	private Integer simSId;
	private Integer sim;

	// Constructors

	/** default constructor */
	public Sim() {
	}

	/** minimal constructor */
	public Sim(Integer SId) {
		this.SId = SId;
	}

	/** full constructor */
	public Sim(Integer SId, Integer simSId, Integer sim) {
		this.SId = SId;
		this.simSId = simSId;
		this.sim = sim;
	}

	// Property accessors

	public Integer getSId() {
		return this.SId;
	}

	public void setSId(Integer SId) {
		this.SId = SId;
	}

	public Integer getSimSId() {
		return this.simSId;
	}

	public void setSimSId(Integer simSId) {
		this.simSId = simSId;
	}

	public Integer getSim() {
		return this.sim;
	}

	public void setSim(Integer sim) {
		this.sim = sim;
	}

}
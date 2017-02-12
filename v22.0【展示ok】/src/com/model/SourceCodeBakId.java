package com.model;

/**
 * SourceCodeBakId entity. @author MyEclipse Persistence Tools
 */

public class SourceCodeBakId implements java.io.Serializable {

	// Fields

	private Integer solutionId;
	private String source;

	// Constructors

	/** default constructor */
	public SourceCodeBakId() {
	}

	/** full constructor */
	public SourceCodeBakId(Integer solutionId, String source) {
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SourceCodeBakId))
			return false;
		SourceCodeBakId castOther = (SourceCodeBakId) other;

		return ((this.getSolutionId() == castOther.getSolutionId()) || (this
				.getSolutionId() != null && castOther.getSolutionId() != null && this
				.getSolutionId().equals(castOther.getSolutionId())))
				&& ((this.getSource() == castOther.getSource()) || (this
						.getSource() != null && castOther.getSource() != null && this
						.getSource().equals(castOther.getSource())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getSolutionId() == null ? 0 : this.getSolutionId()
						.hashCode());
		result = 37 * result
				+ (getSource() == null ? 0 : this.getSource().hashCode());
		return result;
	}

}
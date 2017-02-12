package com.model;

/**
 * ContestProblemId entity. @author MyEclipse Persistence Tools
 */

public class ContestProblemId implements java.io.Serializable {

	// Fields

	private Integer problemId;
	private Integer contestId;
	private String title;
	private Integer num;

	// Constructors

	/** default constructor */
	public ContestProblemId() {
	}

	/** minimal constructor */
	public ContestProblemId(Integer problemId, String title, Integer num) {
		this.problemId = problemId;
		this.title = title;
		this.num = num;
	}

	/** full constructor */
	public ContestProblemId(Integer problemId, Integer contestId, String title,
			Integer num) {
		this.problemId = problemId;
		this.contestId = contestId;
		this.title = title;
		this.num = num;
	}

	// Property accessors

	public Integer getProblemId() {
		return this.problemId;
	}

	public void setProblemId(Integer problemId) {
		this.problemId = problemId;
	}

	public Integer getContestId() {
		return this.contestId;
	}

	public void setContestId(Integer contestId) {
		this.contestId = contestId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ContestProblemId))
			return false;
		ContestProblemId castOther = (ContestProblemId) other;

		return ((this.getProblemId() == castOther.getProblemId()) || (this
				.getProblemId() != null && castOther.getProblemId() != null && this
				.getProblemId().equals(castOther.getProblemId())))
				&& ((this.getContestId() == castOther.getContestId()) || (this
						.getContestId() != null
						&& castOther.getContestId() != null && this
						.getContestId().equals(castOther.getContestId())))
				&& ((this.getTitle() == castOther.getTitle()) || (this
						.getTitle() != null && castOther.getTitle() != null && this
						.getTitle().equals(castOther.getTitle())))
				&& ((this.getNum() == castOther.getNum()) || (this.getNum() != null
						&& castOther.getNum() != null && this.getNum().equals(
						castOther.getNum())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getProblemId() == null ? 0 : this.getProblemId().hashCode());
		result = 37 * result
				+ (getContestId() == null ? 0 : this.getContestId().hashCode());
		result = 37 * result
				+ (getTitle() == null ? 0 : this.getTitle().hashCode());
		result = 37 * result
				+ (getNum() == null ? 0 : this.getNum().hashCode());
		return result;
	}

}
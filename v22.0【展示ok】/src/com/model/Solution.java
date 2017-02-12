package com.model;

import java.sql.Timestamp;

/**
 * Solution entity. @author MyEclipse Persistence Tools
 */

public class Solution implements java.io.Serializable {

	// Fields

	private Integer solutionId;
	private Integer problemId;
	private String userId;
	private Integer time;
	private Integer memory;
	private Timestamp inDate;
	private String className;
	private Short result;
	private Short language;
	private String ip;
	private Integer contestId;
	private Short valid;
	private Short num;
	private Integer codeLength;
	private Timestamp judgetime;

	// Constructors

	/** default constructor */
	public Solution() {
	}

	/** minimal constructor */
	public Solution(Integer problemId, String userId, Integer time,
			Integer memory, Timestamp inDate, String className, Short result,
			Short language, String ip, Short valid, Short num,
			Integer codeLength) {
		this.problemId = problemId;
		this.userId = userId;
		this.time = time;
		this.memory = memory;
		this.inDate = inDate;
		this.className = className;
		this.result = result;
		this.language = language;
		this.ip = ip;
		this.valid = valid;
		this.num = num;
		this.codeLength = codeLength;
	}

	/** full constructor */
	public Solution(Integer problemId, String userId, Integer time,
			Integer memory, Timestamp inDate, String className, Short result,
			Short language, String ip, Integer contestId, Short valid,
			Short num, Integer codeLength, Timestamp judgetime) {
		this.problemId = problemId;
		this.userId = userId;
		this.time = time;
		this.memory = memory;
		this.inDate = inDate;
		this.className = className;
		this.result = result;
		this.language = language;
		this.ip = ip;
		this.contestId = contestId;
		this.valid = valid;
		this.num = num;
		this.codeLength = codeLength;
		this.judgetime = judgetime;
	}

	// Property accessors

	public Integer getSolutionId() {
		return this.solutionId;
	}

	public void setSolutionId(Integer solutionId) {
		this.solutionId = solutionId;
	}

	public Integer getProblemId() {
		return this.problemId;
	}

	public void setProblemId(Integer problemId) {
		this.problemId = problemId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getTime() {
		return this.time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public Integer getMemory() {
		return this.memory;
	}

	public void setMemory(Integer memory) {
		this.memory = memory;
	}

	public Timestamp getInDate() {
		return this.inDate;
	}

	public void setInDate(Timestamp inDate) {
		this.inDate = inDate;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Short getResult() {
		return this.result;
	}

	public void setResult(Short result) {
		this.result = result;
	}

	public Short getLanguage() {
		return this.language;
	}

	public void setLanguage(Short language) {
		this.language = language;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getContestId() {
		return this.contestId;
	}

	public void setContestId(Integer contestId) {
		this.contestId = contestId;
	}

	public Short getValid() {
		return this.valid;
	}

	public void setValid(Short valid) {
		this.valid = valid;
	}

	public Short getNum() {
		return this.num;
	}

	public void setNum(Short num) {
		this.num = num;
	}

	public Integer getCodeLength() {
		return this.codeLength;
	}

	public void setCodeLength(Integer codeLength) {
		this.codeLength = codeLength;
	}

	public Timestamp getJudgetime() {
		return this.judgetime;
	}

	public void setJudgetime(Timestamp judgetime) {
		this.judgetime = judgetime;
	}

}
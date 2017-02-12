package com.model;

public class JudgeContext {
	private int language;
	private int problem_id;
	private int solution_id;
	private String source;
	private String user_id;
	private int time_limit;
	private int memory_limit;
	
	public int getTime_limit() {
		return time_limit;
	}

	public void setTime_limit(int time_limit) {
		this.time_limit = time_limit;
	}

	public int getMemory_limit() {
		return memory_limit;
	}

	public void setMemory_limit(int memory_limit) {
		this.memory_limit = memory_limit;
	}

	public int getLanguage() {
		return language;
	}

	public int getProblem_id() {
		return problem_id;
	}

	public int getSolution_id() {
		return solution_id;
	}
	public String getSource() {
		return source;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setLanguage(int language) {
		this.language = language;
	}

	public void setProblem_id(int problem_id) {
		this.problem_id = problem_id;
	}

	public void setSolution_id(int solution_id) {
		this.solution_id = solution_id;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

}

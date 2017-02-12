package com.model;

public class StatusList {
	private int solution_id;
	private String user_id;
	private int problem_id;
	private int result;
	private int memory;
	private int time;
	private int language;
	private String in_date;

	public int getSolution_id() {
		return solution_id;
	}

	public void setSolution_id(int solution_id) {
		this.solution_id = solution_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getProblem_id() {
		return problem_id;
	}

	public void setProblem_id(int problem_id) {
		this.problem_id = problem_id;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getLanguage() {
		return language;
	}

	public void setLanguage(int language) {
		this.language = language;
	}

	public String getIn_date() {
		return in_date;
	}

	public void setIn_date(String in_date) {
		this.in_date = in_date;
	}

}

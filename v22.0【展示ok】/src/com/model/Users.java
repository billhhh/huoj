package com.model;

import java.sql.Timestamp;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private String userId;
	private String email;
	private Integer submit;
	private Integer solved;
	private String defunct;
	private String ip;
	private Timestamp accesstime;
	private Integer volume;
	private Integer language;
	private String password;
	private Timestamp regTime;
	private String nick;
	private String school;

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(String userId, String defunct, String ip, Integer volume,
			Integer language, String password, String nick, String school) {
		this.userId = userId;
		this.defunct = defunct;
		this.ip = ip;
		this.volume = volume;
		this.language = language;
		this.password = password;
		this.nick = nick;
		this.school = school;
	}

	/** full constructor */
	public Users(String userId, String email, Integer submit, Integer solved,
			String defunct, String ip, Timestamp accesstime, Integer volume,
			Integer language, String password, Timestamp regTime, String nick,
			String school) {
		this.userId = userId;
		this.email = email;
		this.submit = submit;
		this.solved = solved;
		this.defunct = defunct;
		this.ip = ip;
		this.accesstime = accesstime;
		this.volume = volume;
		this.language = language;
		this.password = password;
		this.regTime = regTime;
		this.nick = nick;
		this.school = school;
	}

	// Property accessors

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getSubmit() {
		return this.submit;
	}

	public void setSubmit(Integer submit) {
		this.submit = submit;
	}

	public Integer getSolved() {
		return this.solved;
	}

	public void setSolved(Integer solved) {
		this.solved = solved;
	}

	public String getDefunct() {
		return this.defunct;
	}

	public void setDefunct(String defunct) {
		this.defunct = defunct;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Timestamp getAccesstime() {
		return this.accesstime;
	}

	public void setAccesstime(Timestamp accesstime) {
		this.accesstime = accesstime;
	}

	public Integer getVolume() {
		return this.volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public Integer getLanguage() {
		return this.language;
	}

	public void setLanguage(Integer language) {
		this.language = language;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getRegTime() {
		return this.regTime;
	}

	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}

	public String getNick() {
		return this.nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getSchool() {
		return this.school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

}
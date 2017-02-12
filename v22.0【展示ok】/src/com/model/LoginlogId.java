package com.model;

import java.sql.Timestamp;

/**
 * LoginlogId entity. @author MyEclipse Persistence Tools
 */

public class LoginlogId implements java.io.Serializable {

	// Fields

	private String userId;
	private String password;
	private String ip;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public LoginlogId() {
	}

	/** minimal constructor */
	public LoginlogId(String userId) {
		this.userId = userId;
	}

	/** full constructor */
	public LoginlogId(String userId, String password, String ip, Timestamp time) {
		this.userId = userId;
		this.password = password;
		this.ip = ip;
		this.time = time;
	}

	// Property accessors

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof LoginlogId))
			return false;
		LoginlogId castOther = (LoginlogId) other;

		return ((this.getUserId() == castOther.getUserId()) || (this
				.getUserId() != null && castOther.getUserId() != null && this
				.getUserId().equals(castOther.getUserId())))
				&& ((this.getPassword() == castOther.getPassword()) || (this
						.getPassword() != null
						&& castOther.getPassword() != null && this
						.getPassword().equals(castOther.getPassword())))
				&& ((this.getIp() == castOther.getIp()) || (this.getIp() != null
						&& castOther.getIp() != null && this.getIp().equals(
						castOther.getIp())))
				&& ((this.getTime() == castOther.getTime()) || (this.getTime() != null
						&& castOther.getTime() != null && this.getTime()
						.equals(castOther.getTime())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result
				+ (getPassword() == null ? 0 : this.getPassword().hashCode());
		result = 37 * result + (getIp() == null ? 0 : this.getIp().hashCode());
		result = 37 * result
				+ (getTime() == null ? 0 : this.getTime().hashCode());
		return result;
	}

}
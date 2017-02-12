package com.model;

/**
 * Online entity. @author MyEclipse Persistence Tools
 */

public class Online implements java.io.Serializable {

	// Fields

	private String hash;
	private String ip;
	private String ua;
	private String refer;
	private Integer lastmove;
	private Integer firsttime;
	private String uri;

	// Constructors

	/** default constructor */
	public Online() {
	}

	/** minimal constructor */
	public Online(String hash, String ip, String ua, Integer lastmove) {
		this.hash = hash;
		this.ip = ip;
		this.ua = ua;
		this.lastmove = lastmove;
	}

	/** full constructor */
	public Online(String hash, String ip, String ua, String refer,
			Integer lastmove, Integer firsttime, String uri) {
		this.hash = hash;
		this.ip = ip;
		this.ua = ua;
		this.refer = refer;
		this.lastmove = lastmove;
		this.firsttime = firsttime;
		this.uri = uri;
	}

	// Property accessors

	public String getHash() {
		return this.hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUa() {
		return this.ua;
	}

	public void setUa(String ua) {
		this.ua = ua;
	}

	public String getRefer() {
		return this.refer;
	}

	public void setRefer(String refer) {
		this.refer = refer;
	}

	public Integer getLastmove() {
		return this.lastmove;
	}

	public void setLastmove(Integer lastmove) {
		this.lastmove = lastmove;
	}

	public Integer getFirsttime() {
		return this.firsttime;
	}

	public void setFirsttime(Integer firsttime) {
		this.firsttime = firsttime;
	}

	public String getUri() {
		return this.uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

}
package com.model;

/**
 * Baoming entity. @author MyEclipse Persistence Tools
 */

public class Baoming implements java.io.Serializable {

	// Fields

	private String nb;
	private String nm;
	private String clas;
	private String xueyuan;
	private String iphone;
	private String qq;
	private String emai;
	private Integer ad;
	private String intro;
	private String ti;
	private String sex;

	// Constructors

	/** default constructor */
	public Baoming() {
	}

	/** full constructor */
	public Baoming(String nb, String nm, String clas, String xueyuan,
			String iphone, String qq, String emai, Integer ad, String intro,
			String ti, String sex) {
		this.nb = nb;
		this.nm = nm;
		this.clas = clas;
		this.xueyuan = xueyuan;
		this.iphone = iphone;
		this.qq = qq;
		this.emai = emai;
		this.ad = ad;
		this.intro = intro;
		this.ti = ti;
		this.sex = sex;
	}

	// Property accessors

	public String getNb() {
		return this.nb;
	}

	public void setNb(String nb) {
		this.nb = nb;
	}

	public String getNm() {
		return this.nm;
	}

	public void setNm(String nm) {
		this.nm = nm;
	}

	public String getClas() {
		return this.clas;
	}

	public void setClas(String clas) {
		this.clas = clas;
	}

	public String getXueyuan() {
		return this.xueyuan;
	}

	public void setXueyuan(String xueyuan) {
		this.xueyuan = xueyuan;
	}

	public String getIphone() {
		return this.iphone;
	}

	public void setIphone(String iphone) {
		this.iphone = iphone;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmai() {
		return this.emai;
	}

	public void setEmai(String emai) {
		this.emai = emai;
	}

	public Integer getAd() {
		return this.ad;
	}

	public void setAd(Integer ad) {
		this.ad = ad;
	}

	public String getIntro() {
		return this.intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getTi() {
		return this.ti;
	}

	public void setTi(String ti) {
		this.ti = ti;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
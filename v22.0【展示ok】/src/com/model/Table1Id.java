package com.model;

/**
 * Table1Id entity. @author MyEclipse Persistence Tools
 */

public class Table1Id implements java.io.Serializable {

	// Fields

	private String number;
	private String name;
	private String class_;
	private String xueyuan;
	private String iphone;
	private String qq;
	private String email;
	private Integer ad;
	private String introduction;
	private String time;

	// Constructors

	/** default constructor */
	public Table1Id() {
	}

	/** full constructor */
	public Table1Id(String number, String name, String class_, String xueyuan,
			String iphone, String qq, String email, Integer ad,
			String introduction, String time) {
		this.number = number;
		this.name = name;
		this.class_ = class_;
		this.xueyuan = xueyuan;
		this.iphone = iphone;
		this.qq = qq;
		this.email = email;
		this.ad = ad;
		this.introduction = introduction;
		this.time = time;
	}

	// Property accessors

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClass_() {
		return this.class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAd() {
		return this.ad;
	}

	public void setAd(Integer ad) {
		this.ad = ad;
	}

	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Table1Id))
			return false;
		Table1Id castOther = (Table1Id) other;

		return ((this.getNumber() == castOther.getNumber()) || (this
				.getNumber() != null && castOther.getNumber() != null && this
				.getNumber().equals(castOther.getNumber())))
				&& ((this.getName() == castOther.getName()) || (this.getName() != null
						&& castOther.getName() != null && this.getName()
						.equals(castOther.getName())))
				&& ((this.getClass_() == castOther.getClass_()) || (this
						.getClass_() != null && castOther.getClass_() != null && this
						.getClass_().equals(castOther.getClass_())))
				&& ((this.getXueyuan() == castOther.getXueyuan()) || (this
						.getXueyuan() != null && castOther.getXueyuan() != null && this
						.getXueyuan().equals(castOther.getXueyuan())))
				&& ((this.getIphone() == castOther.getIphone()) || (this
						.getIphone() != null && castOther.getIphone() != null && this
						.getIphone().equals(castOther.getIphone())))
				&& ((this.getQq() == castOther.getQq()) || (this.getQq() != null
						&& castOther.getQq() != null && this.getQq().equals(
						castOther.getQq())))
				&& ((this.getEmail() == castOther.getEmail()) || (this
						.getEmail() != null && castOther.getEmail() != null && this
						.getEmail().equals(castOther.getEmail())))
				&& ((this.getAd() == castOther.getAd()) || (this.getAd() != null
						&& castOther.getAd() != null && this.getAd().equals(
						castOther.getAd())))
				&& ((this.getIntroduction() == castOther.getIntroduction()) || (this
						.getIntroduction() != null
						&& castOther.getIntroduction() != null && this
						.getIntroduction().equals(castOther.getIntroduction())))
				&& ((this.getTime() == castOther.getTime()) || (this.getTime() != null
						&& castOther.getTime() != null && this.getTime()
						.equals(castOther.getTime())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getNumber() == null ? 0 : this.getNumber().hashCode());
		result = 37 * result
				+ (getName() == null ? 0 : this.getName().hashCode());
		result = 37 * result
				+ (getClass_() == null ? 0 : this.getClass_().hashCode());
		result = 37 * result
				+ (getXueyuan() == null ? 0 : this.getXueyuan().hashCode());
		result = 37 * result
				+ (getIphone() == null ? 0 : this.getIphone().hashCode());
		result = 37 * result + (getQq() == null ? 0 : this.getQq().hashCode());
		result = 37 * result
				+ (getEmail() == null ? 0 : this.getEmail().hashCode());
		result = 37 * result + (getAd() == null ? 0 : this.getAd().hashCode());
		result = 37
				* result
				+ (getIntroduction() == null ? 0 : this.getIntroduction()
						.hashCode());
		result = 37 * result
				+ (getTime() == null ? 0 : this.getTime().hashCode());
		return result;
	}

}
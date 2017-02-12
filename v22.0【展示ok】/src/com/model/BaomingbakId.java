package com.model;

/**
 * BaomingbakId entity. @author MyEclipse Persistence Tools
 */

public class BaomingbakId implements java.io.Serializable {

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
	public BaomingbakId() {
	}

	/** full constructor */
	public BaomingbakId(String nb, String nm, String clas, String xueyuan,
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof BaomingbakId))
			return false;
		BaomingbakId castOther = (BaomingbakId) other;

		return ((this.getNb() == castOther.getNb()) || (this.getNb() != null
				&& castOther.getNb() != null && this.getNb().equals(
				castOther.getNb())))
				&& ((this.getNm() == castOther.getNm()) || (this.getNm() != null
						&& castOther.getNm() != null && this.getNm().equals(
						castOther.getNm())))
				&& ((this.getClas() == castOther.getClas()) || (this.getClas() != null
						&& castOther.getClas() != null && this.getClas()
						.equals(castOther.getClas())))
				&& ((this.getXueyuan() == castOther.getXueyuan()) || (this
						.getXueyuan() != null && castOther.getXueyuan() != null && this
						.getXueyuan().equals(castOther.getXueyuan())))
				&& ((this.getIphone() == castOther.getIphone()) || (this
						.getIphone() != null && castOther.getIphone() != null && this
						.getIphone().equals(castOther.getIphone())))
				&& ((this.getQq() == castOther.getQq()) || (this.getQq() != null
						&& castOther.getQq() != null && this.getQq().equals(
						castOther.getQq())))
				&& ((this.getEmai() == castOther.getEmai()) || (this.getEmai() != null
						&& castOther.getEmai() != null && this.getEmai()
						.equals(castOther.getEmai())))
				&& ((this.getAd() == castOther.getAd()) || (this.getAd() != null
						&& castOther.getAd() != null && this.getAd().equals(
						castOther.getAd())))
				&& ((this.getIntro() == castOther.getIntro()) || (this
						.getIntro() != null && castOther.getIntro() != null && this
						.getIntro().equals(castOther.getIntro())))
				&& ((this.getTi() == castOther.getTi()) || (this.getTi() != null
						&& castOther.getTi() != null && this.getTi().equals(
						castOther.getTi())))
				&& ((this.getSex() == castOther.getSex()) || (this.getSex() != null
						&& castOther.getSex() != null && this.getSex().equals(
						castOther.getSex())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getNb() == null ? 0 : this.getNb().hashCode());
		result = 37 * result + (getNm() == null ? 0 : this.getNm().hashCode());
		result = 37 * result
				+ (getClas() == null ? 0 : this.getClas().hashCode());
		result = 37 * result
				+ (getXueyuan() == null ? 0 : this.getXueyuan().hashCode());
		result = 37 * result
				+ (getIphone() == null ? 0 : this.getIphone().hashCode());
		result = 37 * result + (getQq() == null ? 0 : this.getQq().hashCode());
		result = 37 * result
				+ (getEmai() == null ? 0 : this.getEmai().hashCode());
		result = 37 * result + (getAd() == null ? 0 : this.getAd().hashCode());
		result = 37 * result
				+ (getIntro() == null ? 0 : this.getIntro().hashCode());
		result = 37 * result + (getTi() == null ? 0 : this.getTi().hashCode());
		result = 37 * result
				+ (getSex() == null ? 0 : this.getSex().hashCode());
		return result;
	}

}
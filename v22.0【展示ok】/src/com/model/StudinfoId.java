package com.model;

/**
 * StudinfoId entity. @author MyEclipse Persistence Tools
 */

public class StudinfoId implements java.io.Serializable {

	// Fields

	private String xh;
	private String xb;
	private String xm;
	private String bm;
	private String xy;

	// Constructors

	/** default constructor */
	public StudinfoId() {
	}

	/** full constructor */
	public StudinfoId(String xh, String xb, String xm, String bm, String xy) {
		this.xh = xh;
		this.xb = xb;
		this.xm = xm;
		this.bm = bm;
		this.xy = xy;
	}

	// Property accessors

	public String getXh() {
		return this.xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}

	public String getXb() {
		return this.xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}

	public String getXm() {
		return this.xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getBm() {
		return this.bm;
	}

	public void setBm(String bm) {
		this.bm = bm;
	}

	public String getXy() {
		return this.xy;
	}

	public void setXy(String xy) {
		this.xy = xy;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StudinfoId))
			return false;
		StudinfoId castOther = (StudinfoId) other;

		return ((this.getXh() == castOther.getXh()) || (this.getXh() != null
				&& castOther.getXh() != null && this.getXh().equals(
				castOther.getXh())))
				&& ((this.getXb() == castOther.getXb()) || (this.getXb() != null
						&& castOther.getXb() != null && this.getXb().equals(
						castOther.getXb())))
				&& ((this.getXm() == castOther.getXm()) || (this.getXm() != null
						&& castOther.getXm() != null && this.getXm().equals(
						castOther.getXm())))
				&& ((this.getBm() == castOther.getBm()) || (this.getBm() != null
						&& castOther.getBm() != null && this.getBm().equals(
						castOther.getBm())))
				&& ((this.getXy() == castOther.getXy()) || (this.getXy() != null
						&& castOther.getXy() != null && this.getXy().equals(
						castOther.getXy())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getXh() == null ? 0 : this.getXh().hashCode());
		result = 37 * result + (getXb() == null ? 0 : this.getXb().hashCode());
		result = 37 * result + (getXm() == null ? 0 : this.getXm().hashCode());
		result = 37 * result + (getBm() == null ? 0 : this.getBm().hashCode());
		result = 37 * result + (getXy() == null ? 0 : this.getXy().hashCode());
		return result;
	}

}
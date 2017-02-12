package com.model;

/**
 * AttendId entity. @author MyEclipse Persistence Tools
 */

public class AttendId implements java.io.Serializable {

	// Fields

	private String userId;
	private Integer contestId;
	private Integer accepts;
	private Integer penalty;
	private Integer ATime;
	private Integer AWrongSubmits;
	private Integer BTime;
	private Integer BWrongSubmits;
	private Integer CTime;
	private Integer CWrongSubmits;
	private Integer DTime;
	private Integer DWrongSubmits;
	private Integer ETime;
	private Integer EWrongSubmits;
	private Integer FTime;
	private Integer FWrongSubmits;
	private Integer GTime;
	private Integer GWrongSubmits;
	private Integer HTime;
	private Integer HWrongSubmits;
	private Integer ITime;
	private Integer IWrongSubmits;
	private Integer JTime;
	private Integer JWrongSubmits;
	private Integer KTime;
	private Integer KWrongSubmits;
	private Integer LTime;
	private Integer LWrongSubmits;
	private Integer MTime;
	private Integer MWrongSubmits;
	private Integer NTime;
	private Integer NWrongSubmits;
	private Integer OTime;
	private Integer OWrongSubmits;
	private String nick;

	// Constructors

	/** default constructor */
	public AttendId() {
	}

	/** minimal constructor */
	public AttendId(String userId, Integer contestId, String nick) {
		this.userId = userId;
		this.contestId = contestId;
		this.nick = nick;
	}

	/** full constructor */
	public AttendId(String userId, Integer contestId, Integer accepts,
			Integer penalty, Integer ATime, Integer AWrongSubmits,
			Integer BTime, Integer BWrongSubmits, Integer CTime,
			Integer CWrongSubmits, Integer DTime, Integer DWrongSubmits,
			Integer ETime, Integer EWrongSubmits, Integer FTime,
			Integer FWrongSubmits, Integer GTime, Integer GWrongSubmits,
			Integer HTime, Integer HWrongSubmits, Integer ITime,
			Integer IWrongSubmits, Integer JTime, Integer JWrongSubmits,
			Integer KTime, Integer KWrongSubmits, Integer LTime,
			Integer LWrongSubmits, Integer MTime, Integer MWrongSubmits,
			Integer NTime, Integer NWrongSubmits, Integer OTime,
			Integer OWrongSubmits, String nick) {
		this.userId = userId;
		this.contestId = contestId;
		this.accepts = accepts;
		this.penalty = penalty;
		this.ATime = ATime;
		this.AWrongSubmits = AWrongSubmits;
		this.BTime = BTime;
		this.BWrongSubmits = BWrongSubmits;
		this.CTime = CTime;
		this.CWrongSubmits = CWrongSubmits;
		this.DTime = DTime;
		this.DWrongSubmits = DWrongSubmits;
		this.ETime = ETime;
		this.EWrongSubmits = EWrongSubmits;
		this.FTime = FTime;
		this.FWrongSubmits = FWrongSubmits;
		this.GTime = GTime;
		this.GWrongSubmits = GWrongSubmits;
		this.HTime = HTime;
		this.HWrongSubmits = HWrongSubmits;
		this.ITime = ITime;
		this.IWrongSubmits = IWrongSubmits;
		this.JTime = JTime;
		this.JWrongSubmits = JWrongSubmits;
		this.KTime = KTime;
		this.KWrongSubmits = KWrongSubmits;
		this.LTime = LTime;
		this.LWrongSubmits = LWrongSubmits;
		this.MTime = MTime;
		this.MWrongSubmits = MWrongSubmits;
		this.NTime = NTime;
		this.NWrongSubmits = NWrongSubmits;
		this.OTime = OTime;
		this.OWrongSubmits = OWrongSubmits;
		this.nick = nick;
	}

	// Property accessors

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getContestId() {
		return this.contestId;
	}

	public void setContestId(Integer contestId) {
		this.contestId = contestId;
	}

	public Integer getAccepts() {
		return this.accepts;
	}

	public void setAccepts(Integer accepts) {
		this.accepts = accepts;
	}

	public Integer getPenalty() {
		return this.penalty;
	}

	public void setPenalty(Integer penalty) {
		this.penalty = penalty;
	}

	public Integer getATime() {
		return this.ATime;
	}

	public void setATime(Integer ATime) {
		this.ATime = ATime;
	}

	public Integer getAWrongSubmits() {
		return this.AWrongSubmits;
	}

	public void setAWrongSubmits(Integer AWrongSubmits) {
		this.AWrongSubmits = AWrongSubmits;
	}

	public Integer getBTime() {
		return this.BTime;
	}

	public void setBTime(Integer BTime) {
		this.BTime = BTime;
	}

	public Integer getBWrongSubmits() {
		return this.BWrongSubmits;
	}

	public void setBWrongSubmits(Integer BWrongSubmits) {
		this.BWrongSubmits = BWrongSubmits;
	}

	public Integer getCTime() {
		return this.CTime;
	}

	public void setCTime(Integer CTime) {
		this.CTime = CTime;
	}

	public Integer getCWrongSubmits() {
		return this.CWrongSubmits;
	}

	public void setCWrongSubmits(Integer CWrongSubmits) {
		this.CWrongSubmits = CWrongSubmits;
	}

	public Integer getDTime() {
		return this.DTime;
	}

	public void setDTime(Integer DTime) {
		this.DTime = DTime;
	}

	public Integer getDWrongSubmits() {
		return this.DWrongSubmits;
	}

	public void setDWrongSubmits(Integer DWrongSubmits) {
		this.DWrongSubmits = DWrongSubmits;
	}

	public Integer getETime() {
		return this.ETime;
	}

	public void setETime(Integer ETime) {
		this.ETime = ETime;
	}

	public Integer getEWrongSubmits() {
		return this.EWrongSubmits;
	}

	public void setEWrongSubmits(Integer EWrongSubmits) {
		this.EWrongSubmits = EWrongSubmits;
	}

	public Integer getFTime() {
		return this.FTime;
	}

	public void setFTime(Integer FTime) {
		this.FTime = FTime;
	}

	public Integer getFWrongSubmits() {
		return this.FWrongSubmits;
	}

	public void setFWrongSubmits(Integer FWrongSubmits) {
		this.FWrongSubmits = FWrongSubmits;
	}

	public Integer getGTime() {
		return this.GTime;
	}

	public void setGTime(Integer GTime) {
		this.GTime = GTime;
	}

	public Integer getGWrongSubmits() {
		return this.GWrongSubmits;
	}

	public void setGWrongSubmits(Integer GWrongSubmits) {
		this.GWrongSubmits = GWrongSubmits;
	}

	public Integer getHTime() {
		return this.HTime;
	}

	public void setHTime(Integer HTime) {
		this.HTime = HTime;
	}

	public Integer getHWrongSubmits() {
		return this.HWrongSubmits;
	}

	public void setHWrongSubmits(Integer HWrongSubmits) {
		this.HWrongSubmits = HWrongSubmits;
	}

	public Integer getITime() {
		return this.ITime;
	}

	public void setITime(Integer ITime) {
		this.ITime = ITime;
	}

	public Integer getIWrongSubmits() {
		return this.IWrongSubmits;
	}

	public void setIWrongSubmits(Integer IWrongSubmits) {
		this.IWrongSubmits = IWrongSubmits;
	}

	public Integer getJTime() {
		return this.JTime;
	}

	public void setJTime(Integer JTime) {
		this.JTime = JTime;
	}

	public Integer getJWrongSubmits() {
		return this.JWrongSubmits;
	}

	public void setJWrongSubmits(Integer JWrongSubmits) {
		this.JWrongSubmits = JWrongSubmits;
	}

	public Integer getKTime() {
		return this.KTime;
	}

	public void setKTime(Integer KTime) {
		this.KTime = KTime;
	}

	public Integer getKWrongSubmits() {
		return this.KWrongSubmits;
	}

	public void setKWrongSubmits(Integer KWrongSubmits) {
		this.KWrongSubmits = KWrongSubmits;
	}

	public Integer getLTime() {
		return this.LTime;
	}

	public void setLTime(Integer LTime) {
		this.LTime = LTime;
	}

	public Integer getLWrongSubmits() {
		return this.LWrongSubmits;
	}

	public void setLWrongSubmits(Integer LWrongSubmits) {
		this.LWrongSubmits = LWrongSubmits;
	}

	public Integer getMTime() {
		return this.MTime;
	}

	public void setMTime(Integer MTime) {
		this.MTime = MTime;
	}

	public Integer getMWrongSubmits() {
		return this.MWrongSubmits;
	}

	public void setMWrongSubmits(Integer MWrongSubmits) {
		this.MWrongSubmits = MWrongSubmits;
	}

	public Integer getNTime() {
		return this.NTime;
	}

	public void setNTime(Integer NTime) {
		this.NTime = NTime;
	}

	public Integer getNWrongSubmits() {
		return this.NWrongSubmits;
	}

	public void setNWrongSubmits(Integer NWrongSubmits) {
		this.NWrongSubmits = NWrongSubmits;
	}

	public Integer getOTime() {
		return this.OTime;
	}

	public void setOTime(Integer OTime) {
		this.OTime = OTime;
	}

	public Integer getOWrongSubmits() {
		return this.OWrongSubmits;
	}

	public void setOWrongSubmits(Integer OWrongSubmits) {
		this.OWrongSubmits = OWrongSubmits;
	}

	public String getNick() {
		return this.nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AttendId))
			return false;
		AttendId castOther = (AttendId) other;

		return ((this.getUserId() == castOther.getUserId()) || (this
				.getUserId() != null && castOther.getUserId() != null && this
				.getUserId().equals(castOther.getUserId())))
				&& ((this.getContestId() == castOther.getContestId()) || (this
						.getContestId() != null
						&& castOther.getContestId() != null && this
						.getContestId().equals(castOther.getContestId())))
				&& ((this.getAccepts() == castOther.getAccepts()) || (this
						.getAccepts() != null && castOther.getAccepts() != null && this
						.getAccepts().equals(castOther.getAccepts())))
				&& ((this.getPenalty() == castOther.getPenalty()) || (this
						.getPenalty() != null && castOther.getPenalty() != null && this
						.getPenalty().equals(castOther.getPenalty())))
				&& ((this.getATime() == castOther.getATime()) || (this
						.getATime() != null && castOther.getATime() != null && this
						.getATime().equals(castOther.getATime())))
				&& ((this.getAWrongSubmits() == castOther.getAWrongSubmits()) || (this
						.getAWrongSubmits() != null
						&& castOther.getAWrongSubmits() != null && this
						.getAWrongSubmits()
						.equals(castOther.getAWrongSubmits())))
				&& ((this.getBTime() == castOther.getBTime()) || (this
						.getBTime() != null && castOther.getBTime() != null && this
						.getBTime().equals(castOther.getBTime())))
				&& ((this.getBWrongSubmits() == castOther.getBWrongSubmits()) || (this
						.getBWrongSubmits() != null
						&& castOther.getBWrongSubmits() != null && this
						.getBWrongSubmits()
						.equals(castOther.getBWrongSubmits())))
				&& ((this.getCTime() == castOther.getCTime()) || (this
						.getCTime() != null && castOther.getCTime() != null && this
						.getCTime().equals(castOther.getCTime())))
				&& ((this.getCWrongSubmits() == castOther.getCWrongSubmits()) || (this
						.getCWrongSubmits() != null
						&& castOther.getCWrongSubmits() != null && this
						.getCWrongSubmits()
						.equals(castOther.getCWrongSubmits())))
				&& ((this.getDTime() == castOther.getDTime()) || (this
						.getDTime() != null && castOther.getDTime() != null && this
						.getDTime().equals(castOther.getDTime())))
				&& ((this.getDWrongSubmits() == castOther.getDWrongSubmits()) || (this
						.getDWrongSubmits() != null
						&& castOther.getDWrongSubmits() != null && this
						.getDWrongSubmits()
						.equals(castOther.getDWrongSubmits())))
				&& ((this.getETime() == castOther.getETime()) || (this
						.getETime() != null && castOther.getETime() != null && this
						.getETime().equals(castOther.getETime())))
				&& ((this.getEWrongSubmits() == castOther.getEWrongSubmits()) || (this
						.getEWrongSubmits() != null
						&& castOther.getEWrongSubmits() != null && this
						.getEWrongSubmits()
						.equals(castOther.getEWrongSubmits())))
				&& ((this.getFTime() == castOther.getFTime()) || (this
						.getFTime() != null && castOther.getFTime() != null && this
						.getFTime().equals(castOther.getFTime())))
				&& ((this.getFWrongSubmits() == castOther.getFWrongSubmits()) || (this
						.getFWrongSubmits() != null
						&& castOther.getFWrongSubmits() != null && this
						.getFWrongSubmits()
						.equals(castOther.getFWrongSubmits())))
				&& ((this.getGTime() == castOther.getGTime()) || (this
						.getGTime() != null && castOther.getGTime() != null && this
						.getGTime().equals(castOther.getGTime())))
				&& ((this.getGWrongSubmits() == castOther.getGWrongSubmits()) || (this
						.getGWrongSubmits() != null
						&& castOther.getGWrongSubmits() != null && this
						.getGWrongSubmits()
						.equals(castOther.getGWrongSubmits())))
				&& ((this.getHTime() == castOther.getHTime()) || (this
						.getHTime() != null && castOther.getHTime() != null && this
						.getHTime().equals(castOther.getHTime())))
				&& ((this.getHWrongSubmits() == castOther.getHWrongSubmits()) || (this
						.getHWrongSubmits() != null
						&& castOther.getHWrongSubmits() != null && this
						.getHWrongSubmits()
						.equals(castOther.getHWrongSubmits())))
				&& ((this.getITime() == castOther.getITime()) || (this
						.getITime() != null && castOther.getITime() != null && this
						.getITime().equals(castOther.getITime())))
				&& ((this.getIWrongSubmits() == castOther.getIWrongSubmits()) || (this
						.getIWrongSubmits() != null
						&& castOther.getIWrongSubmits() != null && this
						.getIWrongSubmits()
						.equals(castOther.getIWrongSubmits())))
				&& ((this.getJTime() == castOther.getJTime()) || (this
						.getJTime() != null && castOther.getJTime() != null && this
						.getJTime().equals(castOther.getJTime())))
				&& ((this.getJWrongSubmits() == castOther.getJWrongSubmits()) || (this
						.getJWrongSubmits() != null
						&& castOther.getJWrongSubmits() != null && this
						.getJWrongSubmits()
						.equals(castOther.getJWrongSubmits())))
				&& ((this.getKTime() == castOther.getKTime()) || (this
						.getKTime() != null && castOther.getKTime() != null && this
						.getKTime().equals(castOther.getKTime())))
				&& ((this.getKWrongSubmits() == castOther.getKWrongSubmits()) || (this
						.getKWrongSubmits() != null
						&& castOther.getKWrongSubmits() != null && this
						.getKWrongSubmits()
						.equals(castOther.getKWrongSubmits())))
				&& ((this.getLTime() == castOther.getLTime()) || (this
						.getLTime() != null && castOther.getLTime() != null && this
						.getLTime().equals(castOther.getLTime())))
				&& ((this.getLWrongSubmits() == castOther.getLWrongSubmits()) || (this
						.getLWrongSubmits() != null
						&& castOther.getLWrongSubmits() != null && this
						.getLWrongSubmits()
						.equals(castOther.getLWrongSubmits())))
				&& ((this.getMTime() == castOther.getMTime()) || (this
						.getMTime() != null && castOther.getMTime() != null && this
						.getMTime().equals(castOther.getMTime())))
				&& ((this.getMWrongSubmits() == castOther.getMWrongSubmits()) || (this
						.getMWrongSubmits() != null
						&& castOther.getMWrongSubmits() != null && this
						.getMWrongSubmits()
						.equals(castOther.getMWrongSubmits())))
				&& ((this.getNTime() == castOther.getNTime()) || (this
						.getNTime() != null && castOther.getNTime() != null && this
						.getNTime().equals(castOther.getNTime())))
				&& ((this.getNWrongSubmits() == castOther.getNWrongSubmits()) || (this
						.getNWrongSubmits() != null
						&& castOther.getNWrongSubmits() != null && this
						.getNWrongSubmits()
						.equals(castOther.getNWrongSubmits())))
				&& ((this.getOTime() == castOther.getOTime()) || (this
						.getOTime() != null && castOther.getOTime() != null && this
						.getOTime().equals(castOther.getOTime())))
				&& ((this.getOWrongSubmits() == castOther.getOWrongSubmits()) || (this
						.getOWrongSubmits() != null
						&& castOther.getOWrongSubmits() != null && this
						.getOWrongSubmits()
						.equals(castOther.getOWrongSubmits())))
				&& ((this.getNick() == castOther.getNick()) || (this.getNick() != null
						&& castOther.getNick() != null && this.getNick()
						.equals(castOther.getNick())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result
				+ (getContestId() == null ? 0 : this.getContestId().hashCode());
		result = 37 * result
				+ (getAccepts() == null ? 0 : this.getAccepts().hashCode());
		result = 37 * result
				+ (getPenalty() == null ? 0 : this.getPenalty().hashCode());
		result = 37 * result
				+ (getATime() == null ? 0 : this.getATime().hashCode());
		result = 37
				* result
				+ (getAWrongSubmits() == null ? 0 : this.getAWrongSubmits()
						.hashCode());
		result = 37 * result
				+ (getBTime() == null ? 0 : this.getBTime().hashCode());
		result = 37
				* result
				+ (getBWrongSubmits() == null ? 0 : this.getBWrongSubmits()
						.hashCode());
		result = 37 * result
				+ (getCTime() == null ? 0 : this.getCTime().hashCode());
		result = 37
				* result
				+ (getCWrongSubmits() == null ? 0 : this.getCWrongSubmits()
						.hashCode());
		result = 37 * result
				+ (getDTime() == null ? 0 : this.getDTime().hashCode());
		result = 37
				* result
				+ (getDWrongSubmits() == null ? 0 : this.getDWrongSubmits()
						.hashCode());
		result = 37 * result
				+ (getETime() == null ? 0 : this.getETime().hashCode());
		result = 37
				* result
				+ (getEWrongSubmits() == null ? 0 : this.getEWrongSubmits()
						.hashCode());
		result = 37 * result
				+ (getFTime() == null ? 0 : this.getFTime().hashCode());
		result = 37
				* result
				+ (getFWrongSubmits() == null ? 0 : this.getFWrongSubmits()
						.hashCode());
		result = 37 * result
				+ (getGTime() == null ? 0 : this.getGTime().hashCode());
		result = 37
				* result
				+ (getGWrongSubmits() == null ? 0 : this.getGWrongSubmits()
						.hashCode());
		result = 37 * result
				+ (getHTime() == null ? 0 : this.getHTime().hashCode());
		result = 37
				* result
				+ (getHWrongSubmits() == null ? 0 : this.getHWrongSubmits()
						.hashCode());
		result = 37 * result
				+ (getITime() == null ? 0 : this.getITime().hashCode());
		result = 37
				* result
				+ (getIWrongSubmits() == null ? 0 : this.getIWrongSubmits()
						.hashCode());
		result = 37 * result
				+ (getJTime() == null ? 0 : this.getJTime().hashCode());
		result = 37
				* result
				+ (getJWrongSubmits() == null ? 0 : this.getJWrongSubmits()
						.hashCode());
		result = 37 * result
				+ (getKTime() == null ? 0 : this.getKTime().hashCode());
		result = 37
				* result
				+ (getKWrongSubmits() == null ? 0 : this.getKWrongSubmits()
						.hashCode());
		result = 37 * result
				+ (getLTime() == null ? 0 : this.getLTime().hashCode());
		result = 37
				* result
				+ (getLWrongSubmits() == null ? 0 : this.getLWrongSubmits()
						.hashCode());
		result = 37 * result
				+ (getMTime() == null ? 0 : this.getMTime().hashCode());
		result = 37
				* result
				+ (getMWrongSubmits() == null ? 0 : this.getMWrongSubmits()
						.hashCode());
		result = 37 * result
				+ (getNTime() == null ? 0 : this.getNTime().hashCode());
		result = 37
				* result
				+ (getNWrongSubmits() == null ? 0 : this.getNWrongSubmits()
						.hashCode());
		result = 37 * result
				+ (getOTime() == null ? 0 : this.getOTime().hashCode());
		result = 37
				* result
				+ (getOWrongSubmits() == null ? 0 : this.getOWrongSubmits()
						.hashCode());
		result = 37 * result
				+ (getNick() == null ? 0 : this.getNick().hashCode());
		return result;
	}

}
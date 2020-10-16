package org.epragati.vahan.sync.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;
@Entity
@Table(name ="vt_blacklist", schema = "vahan4")
@IdClass(BlackListIDClass.class)

public class BlackListDetailsDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5103516170284317519L;
	
	@Id
	@Column(name ="regn_no")
	private String regnNo;
	
	@Id
	@Column(name ="complain_dt")
	private Date complainDt;
	
	
	
	public BlackListDetailsDTO() { }
	
	public BlackListDetailsDTO(BlackListIDClass blackListIDClass) { 
		regnNo = blackListIDClass.getRegnNo();
		complainDt = blackListIDClass.getComplainDt();
		    }

	@Id
	@AttributeOverrides({
		@AttributeOverride(name = "regn_no",column = @Column(name="regn_no")),
		@AttributeOverride(name = "complainDt", column = @Column(name="complainDt"))
	})

	
	
	@Column(name ="state_cd")
	private String stateCd;
	
	@Column(name ="off_cd")
	private Integer offCd;
	
	@Column(name ="complain_type")
	private Integer complainType;
	
	@Column(name ="complain")
	private String complain;
	
	
	@Column(name ="entered_by")
	private String enteredBy;
	
	
	@Column(name ="nicsync")
	private boolean nicsync;
	
	@UpdateTimestamp
	@Temporal(value= TemporalType.TIMESTAMP)
	@Column(name ="last_dt",nullable =false)
	private Date lUpdate;
	
	
	
	/**
	 * @return the lUpdate
	 */
	public Date getlUpdate() {
		return lUpdate;
	}

	/**
	 * @param lUpdate the lUpdate to set
	 */
	public void setlUpdate(Date lUpdate) {
		this.lUpdate = lUpdate;
	}

	/**
	 * @return the nicsync
	 */
	public boolean isNicsync() {
		return nicsync;
	}

	/**
	 * @param nicsync the nicsync to set
	 */
	public void setNicsync(boolean nicsync) {
		this.nicsync = nicsync;
	}

	/**
	 * @return the stateCd
	 */
	public String getStateCd() {
		return stateCd;
	}

	/**
	 * @param stateCd the stateCd to set
	 */
	public void setStateCd(String stateCd) {
		this.stateCd = stateCd;
	}

	/**
	 * @return the offCd
	 */
	public Integer getOffCd() {
		return offCd;
	}

	/**
	 * @param offCd the offCd to set
	 */
	public void setOffCd(Integer offCd) {
		this.offCd = offCd;
	}

	/**
	 * @return the complainType
	 */
	public Integer getComplainType() {
		return complainType;
	}

	/**
	 * @param complainType the complainType to set
	 */
	public void setComplainType(Integer complainType) {
		this.complainType = complainType;
	}

	/**
	 * @return the complain
	 */
	public String getComplain() {
		return complain;
	}

	/**
	 * @param complain the complain to set
	 */
	public void setComplain(String complain) {
		this.complain = complain;
	}

	/**
	 * @return the enteredBy
	 */
	public String getEnteredBy() {
		return enteredBy;
	}

	/**
	 * @param enteredBy the enteredBy to set
	 */
	public void setEnteredBy(String enteredBy) {
		this.enteredBy = enteredBy;
	}

	/**
	 * @return the regnNo
	 */
	public String getRegnNo() {
		return regnNo;
	}

	/**
	 * @param regnNo the regnNo to set
	 */
	public void setRegnNo(String regnNo) {
		this.regnNo = regnNo;
	}

	/**
	 * @return the complainDt
	 */
	public Date getComplainDt() {
		return complainDt;
	}

	/**
	 * @param complainDt the complainDt to set
	 */
	public void setComplainDt(Date complainDt) {
		this.complainDt = complainDt;
	}

	
	
	
	
	
}

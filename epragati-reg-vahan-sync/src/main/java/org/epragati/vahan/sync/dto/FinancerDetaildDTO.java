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
@Table(name ="vt_hypth", schema = "vahan4")
@IdClass(FinancerIDCLass.class)
public class FinancerDetaildDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4773006961436447171L;
	
	@Id
	@Column(name ="state_cd")
	private String stateCd;
	@Id
	@Column(name ="off_cd")
	private Integer offCd;
	
	@Id
	@Column(name ="regn_no")
	private String regnNo;
	
	@Id
	@Column(name ="sr_no")
	private Integer srNo;
	
	
	public FinancerDetaildDTO() { }
	
	public FinancerDetaildDTO(FinancerIDCLass financerIDCLass) { 
		offCd = financerIDCLass.getOffCd();
		regnNo = financerIDCLass.getRegnNo();
		stateCd = financerIDCLass.getStateCd();
		    }
	@Id
	@AttributeOverrides({
		@AttributeOverride(name = "regn_no",column = @Column(name="regn_no")),
		@AttributeOverride(name = "off_cd", column = @Column(name="off_cd")),
		@AttributeOverride(name = "regn_no", column = @Column(name="regn_no"))
	})

	
	@Column(name ="hp_type")
	private String hpType;
	
	@Column(name ="fncr_name")
	private String fncrName;
	
	@Column(name ="fncr_add1")
	private String fncrAdd1;
	
	@Column(name ="fncr_district")
	private Integer fncrDistrict;
	
	@Column(name ="fncr_state")
	private String fncrState;

	
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
	 * @return the srNo
	 */
	public Integer getSrNo() {
		return srNo;
	}

	/**
	 * @param srNo the srNo to set
	 */
	public void setSrNo(Integer srNo) {
		this.srNo = srNo;
	}

	/**
	 * @return the hpType
	 */
	public String getHpType() {
		return hpType;
	}

	/**
	 * @param hpType the hpType to set
	 */
	public void setHpType(String hpType) {
		this.hpType = hpType;
	}

	/**
	 * @return the fncrName
	 */
	public String getFncrName() {
		return fncrName;
	}

	/**
	 * @param fncrName the fncrName to set
	 */
	public void setFncrName(String fncrName) {
		this.fncrName = fncrName;
	}

	/**
	 * @return the fncrAdd1
	 */
	public String getFncrAdd1() {
		return fncrAdd1;
	}

	/**
	 * @param fncrAdd1 the fncrAdd1 to set
	 */
	public void setFncrAdd1(String fncrAdd1) {
		this.fncrAdd1 = fncrAdd1;
	}

	/**
	 * @return the fncrDistrict
	 */
	public Integer getFncrDistrict() {
		return fncrDistrict;
	}

	/**
	 * @param fncrDistrict the fncrDistrict to set
	 */
	public void setFncrDistrict(Integer fncrDistrict) {
		this.fncrDistrict = fncrDistrict;
	}

	/**
	 * @return the fncrState
	 */
	public String getFncrState() {
		return fncrState;
	}

	/**
	 * @param fncrState the fncrState to set
	 */
	public void setFncrState(String fncrState) {
		this.fncrState = fncrState;
	}
	
	 
	
}

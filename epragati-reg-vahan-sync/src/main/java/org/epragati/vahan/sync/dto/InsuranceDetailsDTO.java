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
@Table(name ="vt_insurance", schema = "vahan4")
@IdClass(InsuranceIDCLass.class)
public class InsuranceDetailsDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8205675888571890913L;
	
	@Id
	@Column(name ="state_cd")
	private String stateCd;
	@Id
	@Column(name ="off_cd")
	private Integer offCd;
	
	@Id
	@Column(name ="regn_no")
	private String regnNo;
	
	
	
	public InsuranceDetailsDTO() { }
	
	public InsuranceDetailsDTO(InsuranceIDCLass insuranceIDCLass) { 
		offCd = insuranceIDCLass.getOffCd();
		regnNo = insuranceIDCLass.getRegnNo();
		stateCd = insuranceIDCLass.getStateCd();
		    }

	
	
	@Id
	@AttributeOverrides({
		@AttributeOverride(name = "regn_no",column = @Column(name="regn_no")),
		@AttributeOverride(name = "off_cd", column = @Column(name="off_cd")),
		@AttributeOverride(name = "state_cd", column = @Column(name="state_cd"))
	})
	
	
	@Column(name ="comp_cd")
	private Integer compCd;
	
	@Column(name ="ins_type")
	private Integer insType;
	
	@Column(name="ins_from")
	private Date insFrom;
	
	@Column(name ="ins_upto")
	private Date insUpto;
	
	@Column(name ="policy_no")
	private String policyNo;
	
	@Column(name ="idv")
	private Integer idv;
	
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
	 * @return the compCd
	 */
	public Integer getCompCd() {
		return compCd;
	}

	/**
	 * @param compCd the compCd to set
	 */
	public void setCompCd(Integer compCd) {
		this.compCd = compCd;
	}

	/**
	 * @return the insType
	 */
	public Integer getInsType() {
		return insType;
	}

	/**
	 * @param insType the insType to set
	 */
	public void setInsType(Integer insType) {
		this.insType = insType;
	}

	/**
	 * @return the insFrom
	 */
	public Date getInsFrom() {
		return insFrom;
	}

	/**
	 * @param insFrom the insFrom to set
	 */
	public void setInsFrom(Date insFrom) {
		this.insFrom = insFrom;
	}

	/**
	 * @return the insUpto
	 */
	public Date getInsUpto() {
		return insUpto;
	}

	/**
	 * @param insUpto the insUpto to set
	 */
	public void setInsUpto(Date insUpto) {
		this.insUpto = insUpto;
	}

	/**
	 * @return the policyNo
	 */
	public String getPolicyNo() {
		return policyNo;
	}

	/**
	 * @param policyNo the policyNo to set
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	/**
	 * @return the idv
	 */
	public Integer getIdv() {
		return idv;
	}

	/**
	 * @param idv the idv to set
	 */
	public void setIdv(Integer idv) {
		this.idv = idv;
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

	
	
	

}

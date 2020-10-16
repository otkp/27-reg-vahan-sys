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
@Table(name ="vt_fitness", schema = "vahan4")
@IdClass(FitnessIDClass.class)
public class FitnessDetailsDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1772707633303360046L;
	
	@Id
	@Column(name ="state_cd")
	private String stateCd;
	@Id
	@Column(name ="off_cd")
	private Integer offCd;
	
	@Id
	@Column(name ="regn_no")
	private String regnNo;

	
	@Column(name ="op_dt")
	private Date opDt;

	public FitnessDetailsDTO() { }
	
	public FitnessDetailsDTO(FitnessIDClass fitnessIDClass) { 
		offCd = fitnessIDClass.getOffCd();
		regnNo = fitnessIDClass.getRegnNo();
		stateCd = fitnessIDClass.getStateCd();
		    }

	
	
	@Id
	@AttributeOverrides({
		@AttributeOverride(name = "regn_no",column = @Column(name="regn_no")),
		@AttributeOverride(name = "off_cd", column = @Column(name="off_cd")),
		@AttributeOverride(name = "state_cd", column = @Column(name="state_cd"))
	})
	
	
	
	@Column(name ="fit_valid_to")
	private Date fitValidTo;
	
	@Column(name ="chasi_no")
	private String chasiNo;
	
	@Column(name ="fit_chk_dt")
	private Date fitChkDt;

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
	 * @return the fitChkDt
	 */
	public Date getFitChkDt() {
		return fitChkDt;
	}

	/**
	 * @param fitChkDt the fitChkDt to set
	 */
	public void setFitChkDt(Date fitChkDt) {
		this.fitChkDt = fitChkDt;
	}

	/**
	 * @return the chasiNo
	 */
	public String getChasiNo() {
		return chasiNo;
	}

	/**
	 * @param chasiNo the chasiNo to set
	 */
	public void setChasiNo(String chasiNo) {
		this.chasiNo = chasiNo;
	}

	/**
	 * @return the fitValidTo
	 */
	public Date getFitValidTo() {
		return fitValidTo;
	}

	/**
	 * @param fitValidTo the fitValidTo to set
	 */
	public void setFitValidTo(Date fitValidTo) {
		this.fitValidTo = fitValidTo;
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
	 * @return the opDt
	 */
	public Date getOpDt() {
		return opDt;
	}


	/**
	 * @param opDt the opDt to set
	 */
	public void setOpDt(Date opDt) {
		this.opDt = opDt;
	}
	
	

}

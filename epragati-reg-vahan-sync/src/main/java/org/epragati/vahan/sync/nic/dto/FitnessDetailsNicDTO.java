package org.epragati.vahan.sync.nic.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.epragati.vahan.sync.dto.FitnessIDClass;
@Entity
@Table(name ="vt_fitness", schema = "vahan4")
@IdClass(FitnessIDClass.class)
public class FitnessDetailsNicDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5789148023389468721L;

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

	public FitnessDetailsNicDTO() { }
	
	public FitnessDetailsNicDTO(FitnessIDClass fitnessIDClass) { 
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
	
	
}

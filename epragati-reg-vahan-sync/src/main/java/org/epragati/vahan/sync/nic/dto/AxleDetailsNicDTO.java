package org.epragati.vahan.sync.nic.dto;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.epragati.vahan.sync.dto.AxleDetailsIDCLass;

@Entity
@Table(name ="vt_axle", schema = "vahan4")
@IdClass(AxleDetailsIDCLass.class)
public class AxleDetailsNicDTO implements Serializable{

	
	 
	//*
	private static final long serialVersionUID = -3595452205069978557L;

	@Id
	@Column(name ="state_cd")
	private String stateCd;
	@Id
	@Column(name ="off_cd")
	private Integer offCd;
	
	@Id
	@Column(name ="regn_no")
	private String regnNo;
	
	public AxleDetailsNicDTO() { }
	
	
	public AxleDetailsNicDTO(AxleDetailsIDCLass axleDetailsIDCLass) { 
		offCd = axleDetailsIDCLass.getOffCd();
		regnNo = axleDetailsIDCLass.getRegnNo();
		stateCd = axleDetailsIDCLass.getStateCd();
		    }

	
	@Id
	@AttributeOverrides({
		@AttributeOverride(name = "regn_no",column = @Column(name="regn_no")),
		@AttributeOverride(name = "off_cd", column = @Column(name="off_cd")),
		@AttributeOverride(name = "state_cd", column = @Column(name="state_cd"))
	})
	
	@Column(name ="f_axle_descp")
	private String fAxleDescp;
	
	@Column(name ="r_axle_descp")
	private String rAxleDescp;
	
	@Column(name ="f_axle_weight")
	private Integer fAxleWeight;
	
	@Column(name ="r_axle_weight")
	private Integer rAxleWeight;
	
	@Column(name ="no_of_axles")
	private Integer noOfAxles;

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
	 * @return the fAxleDescp
	 */
	public String getfAxleDescp() {
		return fAxleDescp;
	}


	/**
	 * @param fAxleDescp the fAxleDescp to set
	 */
	public void setfAxleDescp(String fAxleDescp) {
		this.fAxleDescp = fAxleDescp;
	}


	/**
	 * @return the rAxleDescp
	 */
	public String getrAxleDescp() {
		return rAxleDescp;
	}


	/**
	 * @param rAxleDescp the rAxleDescp to set
	 */
	public void setrAxleDescp(String rAxleDescp) {
		this.rAxleDescp = rAxleDescp;
	}


	/**
	 * @return the fAxleWeight
	 */
	public Integer getfAxleWeight() {
		return fAxleWeight;
	}


	/**
	 * @param fAxleWeight the fAxleWeight to set
	 */
	public void setfAxleWeight(Integer fAxleWeight) {
		this.fAxleWeight = fAxleWeight;
	}


	/**
	 * @return the rAxleWeight
	 */
	public Integer getrAxleWeight() {
		return rAxleWeight;
	}


	/**
	 * @param rAxleWeight the rAxleWeight to set
	 */
	public void setrAxleWeight(Integer rAxleWeight) {
		this.rAxleWeight = rAxleWeight;
	}


	/**
	 * @return the noOfAxles
	 */
	public Integer getNoOfAxles() {
		return noOfAxles;
	}


	/**
	 * @param noOfAxles the noOfAxles to set
	 */
	public void setNoOfAxles(Integer noOfAxles) {
		this.noOfAxles = noOfAxles;
	}
	
	
	
}
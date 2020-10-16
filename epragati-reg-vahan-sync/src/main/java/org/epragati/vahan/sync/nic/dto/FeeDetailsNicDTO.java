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

import org.epragati.vahan.sync.dto.FeeDetailsIDCLass;
@Entity
@Table(name ="vt_fee", schema = "vahan4")
@IdClass(FeeDetailsIDCLass.class)
public class FeeDetailsNicDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7574366634865401051L;

	@Id
	@Column(name ="state_cd")
	private String stateCd;
	
	@Id
	@Column(name ="off_cd")
	private Integer offCd;
	
	@Id
	@Column(name ="rcpt_no")
	private String rcptNo;
	
	@Id
	@Column(name ="pur_cd")
	private Integer purCd;
	
	
	public FeeDetailsNicDTO() { }
	
	public FeeDetailsNicDTO(FeeDetailsIDCLass feeDetailsIDCLass) { 
		offCd = feeDetailsIDCLass.getOffCd();
		rcptNo = feeDetailsIDCLass.getRcptNo();
		stateCd = feeDetailsIDCLass.getStateCd();
		purCd = feeDetailsIDCLass.getPurCd();
		    }

	
	@Id
	@AttributeOverrides({
		@AttributeOverride(name = "regn_no",column = @Column(name="regn_no")),
		@AttributeOverride(name = "off_cd", column = @Column(name="off_cd")),
		@AttributeOverride(name = "rcpt_no", column = @Column(name="rcpt_no")),
		@AttributeOverride(name = "pur_cd", column = @Column(name="pur_cd"))
	})
	
	@Column(name ="payment_mode")
	private Integer paymentMode;
	
	@Column(name ="fees")
	private Long fees;
	
	@Column(name ="fine")
	private Integer fine;
	
	@Column(name ="regn_no")
	private String regnNo;
	
	
	@Column(name ="rcpt_dt")
	private Date rcptDt;
	
	@Column(name ="collected_by")
	private String collectedBy;


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
	 * @return the rcptNo
	 */
	public String getRcptNo() {
		return rcptNo;
	}

	/**
	 * @param rcptNo the rcptNo to set
	 */
	public void setRcptNo(String rcptNo) {
		this.rcptNo = rcptNo;
	}

	/**
	 * @return the purCd
	 */
	public Integer getPurCd() {
		return purCd;
	}

	/**
	 * @param purCd the purCd to set
	 */
	public void setPurCd(Integer purCd) {
		this.purCd = purCd;
	}

	/**
	 * @return the paymentMode
	 */
	public Integer getPaymentMode() {
		return paymentMode;
	}

	/**
	 * @param paymentMode the paymentMode to set
	 */
	public void setPaymentMode(Integer paymentMode) {
		this.paymentMode = paymentMode;
	}

	/**
	 * @return the fees
	 */
	public Long getFees() {
		return fees;
	}

	/**
	 * @param fees the fees to set
	 */
	public void setFees(Long fees) {
		this.fees = fees;
	}

	/**
	 * @return the fine
	 */
	public Integer getFine() {
		return fine;
	}

	/**
	 * @param fine the fine to set
	 */
	public void setFine(Integer fine) {
		this.fine = fine;
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
	 * @return the rcptDt
	 */
	public Date getRcptDt() {
		return rcptDt;
	}

	/**
	 * @param rcptDt the rcptDt to set
	 */
	public void setRcptDt(Date rcptDt) {
		this.rcptDt = rcptDt;
	}

	/**
	 * @return the collectedBy
	 */
	public String getCollectedBy() {
		return collectedBy;
	}

	/**
	 * @param collectedBy the collectedBy to set
	 */
	public void setCollectedBy(String collectedBy) {
		this.collectedBy = collectedBy;
	}
	
	
	
}

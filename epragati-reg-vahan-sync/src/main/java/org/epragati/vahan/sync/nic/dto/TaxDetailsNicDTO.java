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

import org.epragati.vahan.sync.dto.TaxDetailsIDCLass;
@Entity
@Table(name ="vt_tax", schema = "vahan4")
@IdClass(TaxDetailsIDCLass.class)
public class TaxDetailsNicDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 86241296827419971L;

	@Id
	@Column(name ="regn_no")
	private String regnNo;
	
	@Id
	@Column(name ="state_cd")
	private String stateCd;
	
	@Id
	@Column(name ="off_cd")
	private Integer offCd;
	
	@Id
	@Column(name ="pur_cd")
	private Integer purCd;
	
	
	public TaxDetailsNicDTO() { }
	
	public TaxDetailsNicDTO(TaxDetailsIDCLass taxDetailsIDCLass) { 
		offCd = taxDetailsIDCLass.getOffCd();
		regnNo = taxDetailsIDCLass.getRegnNo();
		stateCd = taxDetailsIDCLass.getStateCd();
		purCd = taxDetailsIDCLass.getPurCd();
		    }

	
	@Id
	@AttributeOverrides({
		@AttributeOverride(name = "regn_no",column = @Column(name="regn_no")),
		@AttributeOverride(name = "off_cd", column = @Column(name="off_cd")),
		@AttributeOverride(name = "state_cd", column = @Column(name="state_cd")),
		@AttributeOverride(name = "pur_cd", column = @Column(name="pur_cd"))
	})
	
	
	
	@Column(name ="tax_mode")
	private String taxMode;
	
	@Column(name ="payment_mode")
	private Integer paymentMode; 
	
	@Column(name ="tax_amt")
	private Long taxAmt;
	
	@Column(name ="tax_fine")
	private Integer taxFine;
	
	@Column(name ="rcpt_no")
	private String rcptNo;
	
	@Column(name ="rcpt_dt")
	private Date rcptDt;
	
	@Column(name ="tax_from")
	private Date taxFrom;
	
	@Column(name ="tax_upto")
	private Date taxUpto;
	
	@Column(name ="collected_by")
	private String collectedBy;

	

	public String getRegnNo() {
		return regnNo;
	}

	public void setRegnNo(String regnNo) {
		this.regnNo = regnNo;
	}

	public String getStateCd() {
		return stateCd;
	}

	public void setStateCd(String stateCd) {
		this.stateCd = stateCd;
	}

	public Integer getOffCd() {
		return offCd;
	}

	public void setOffCd(Integer offCd) {
		this.offCd = offCd;
	}

	public Integer getPurCd() {
		return purCd;
	}

	public void setPurCd(Integer purCd) {
		this.purCd = purCd;
	}

	public String getTaxMode() {
		return taxMode;
	}

	public void setTaxMode(String taxMode) {
		this.taxMode = taxMode;
	}

	public Integer getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(Integer paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Long getTaxAmt() {
		return taxAmt;
	}

	public void setTaxAmt(Long taxAmt) {
		this.taxAmt = taxAmt;
	}

	public Integer getTaxFine() {
		return taxFine;
	}

	public void setTaxFine(Integer taxFine) {
		this.taxFine = taxFine;
	}

	public String getRcptNo() {
		return rcptNo;
	}

	public void setRcptNo(String rcptNo) {
		this.rcptNo = rcptNo;
	}

	public Date getRcptDt() {
		return rcptDt;
	}

	public void setRcptDt(Date rcptDt) {
		this.rcptDt = rcptDt;
	}

	public Date getTaxFrom() {
		return taxFrom;
	}

	public void setTaxFrom(Date taxFrom) {
		this.taxFrom = taxFrom;
	}

	public Date getTaxUpto() {
		return taxUpto;
	}

	public void setTaxUpto(Date taxUpto) {
		this.taxUpto = taxUpto;
	}

	public String getCollectedBy() {
		return collectedBy;
	}

	public void setCollectedBy(String collectedBy) {
		this.collectedBy = collectedBy;
	}
}

package org.epragati.vahan.sync.nic.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name ="vt_noc", schema = "vahan4")
public class NocDetailsNicDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3144427064430222653L;

	@Id
	@Column(name ="appl_no")
	private String applicationNo;
	
	@Column(name ="state_cd")
	private String stateCode;
	
	@Column(name ="off_cd")
	private Integer offcieCode;
	
	@Column(name ="regn_no")
	private String prNo;
	
	@Column(name ="state_to")
	private String nocStateCode;
	
	@Column(name ="noc_no")
	private String nocNo;
	
	@Column(name ="noc_dt")
	private Date nocIssueDate;
	
	@Column(name ="op_dt")
	private Date nocDate;
	
	@Column(name ="rto_to")
	private String rto_to;
	
	@Column(name ="off_to")
	private Integer offTo;
	
	
	

	/**
	 * @return the rto_to
	 */
	public String getRto_to() {
		return rto_to;
	}

	/**
	 * @param rto_to the rto_to to set
	 */
	public void setRto_to(String rto_to) {
		this.rto_to = rto_to;
	}

	/**
	 * @return the offTo
	 */
	public Integer getOffTo() {
		return offTo;
	}

	/**
	 * @param offTo the offTo to set
	 */
	public void setOffTo(Integer offTo) {
		this.offTo = offTo;
	}

	/**
	 * @return the applicationNo
	 */
	public String getApplicationNo() {
		return applicationNo;
	}

	/**
	 * @param applicationNo the applicationNo to set
	 */
	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}

	/**
	 * @return the stateCode
	 */
	public String getStateCode() {
		return stateCode;
	}

	/**
	 * @param stateCode the stateCode to set
	 */
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	/**
	 * @return the offcieCode
	 */
	public Integer getOffcieCode() {
		return offcieCode;
	}

	/**
	 * @param offcieCode the offcieCode to set
	 */
	public void setOffcieCode(Integer offcieCode) {
		this.offcieCode = offcieCode;
	}

	/**
	 * @return the prNo
	 */
	public String getPrNo() {
		return prNo;
	}

	/**
	 * @param prNo the prNo to set
	 */
	public void setPrNo(String prNo) {
		this.prNo = prNo;
	}

	/**
	 * @return the nocStateCode
	 */
	public String getNocStateCode() {
		return nocStateCode;
	}

	/**
	 * @param nocStateCode the nocStateCode to set
	 */
	public void setNocStateCode(String nocStateCode) {
		this.nocStateCode = nocStateCode;
	}

	/**
	 * @return the nocNo
	 */
	public String getNocNo() {
		return nocNo;
	}

	/**
	 * @param nocNo the nocNo to set
	 */
	public void setNocNo(String nocNo) {
		this.nocNo = nocNo;
	}

	/**
	 * @return the nocIssueDate
	 */
	public Date getNocIssueDate() {
		return nocIssueDate;
	}

	/**
	 * @param nocIssueDate the nocIssueDate to set
	 */
	public void setNocIssueDate(Date nocIssueDate) {
		this.nocIssueDate = nocIssueDate;
	}

	/**
	 * @return the nocDate
	 */
	public Date getNocDate() {
		return nocDate;
	}

	/**
	 * @param nocDate the nocDate to set
	 */
	public void setNocDate(Date nocDate) {
		this.nocDate = nocDate;
	}
	
	
}

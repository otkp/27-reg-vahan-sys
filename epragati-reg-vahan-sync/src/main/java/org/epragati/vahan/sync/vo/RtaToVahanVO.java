package org.epragati.vahan.sync.vo;

import java.io.Serializable;

public class RtaToVahanVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5767091498817294333L;
	
	private Boolean isOwnerSync = Boolean.FALSE;
	
	private Boolean isAxleSync = Boolean.FALSE;
	
	private Boolean isInsuranceSync = Boolean.FALSE;
	
	private Boolean isTaxSync = Boolean.FALSE;
	
	private Boolean isFeeSync = Boolean.FALSE;
	
	private Boolean isFitnesSync = Boolean.FALSE;
	
	private Boolean isFinancerSync = Boolean.FALSE;
	
	private Boolean isNocSync = Boolean.FALSE;
	
	private Boolean isNocOwnerSync = Boolean.FALSE;
	
	private Boolean isBlackListSync = Boolean.FALSE;
	
	private String prNo;
	
	private String error;
	
	private Boolean isFixed=Boolean.FALSE;
	
	
	
	
	/**
	 * @return the isFixed
	 */
	public Boolean getIsFixed() {
		return isFixed;
	}

	/**
	 * @param isFixed the isFixed to set
	 */
	public void setIsFixed(Boolean isFixed) {
		this.isFixed = isFixed;
	}

	/**
	 * @return the isNocOwnerSync
	 */
	public Boolean getIsNocOwnerSync() {
		return isNocOwnerSync;
	}

	/**
	 * @param isNocOwnerSync the isNocOwnerSync to set
	 */
	public void setIsNocOwnerSync(Boolean isNocOwnerSync) {
		this.isNocOwnerSync = isNocOwnerSync;
	}

	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
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
	 * @return the isOwnerSync
	 */
	public Boolean getIsOwnerSync() {
		return isOwnerSync;
	}

	/**
	 * @param isOwnerSync the isOwnerSync to set
	 */
	public void setIsOwnerSync(Boolean isOwnerSync) {
		this.isOwnerSync = isOwnerSync;
	}

	/**
	 * @return the isAxleSync
	 */
	public Boolean getIsAxleSync() {
		return isAxleSync;
	}

	/**
	 * @param isAxleSync the isAxleSync to set
	 */
	public void setIsAxleSync(Boolean isAxleSync) {
		this.isAxleSync = isAxleSync;
	}

	/**
	 * @return the isNocSync
	 */
	public Boolean getIsNocSync() {
		return isNocSync;
	}

	/**
	 * @param isNocSync the isNocSync to set
	 */
	public void setIsNocSync(Boolean isNocSync) {
		this.isNocSync = isNocSync;
	}

	/**
	 * @return the isTaxSync
	 */
	public Boolean getIsTaxSync() {
		return isTaxSync;
	}

	/**
	 * @param isTaxSync the isTaxSync to set
	 */
	public void setIsTaxSync(Boolean isTaxSync) {
		this.isTaxSync = isTaxSync;
	}

	/**
	 * @return the isFeeSync
	 */
	public Boolean getIsFeeSync() {
		return isFeeSync;
	}

	/**
	 * @param isFeeSync the isFeeSync to set
	 */
	public void setIsFeeSync(Boolean isFeeSync) {
		this.isFeeSync = isFeeSync;
	}

	/**
	 * @return the isFitnesSync
	 */
	public Boolean getIsFitnesSync() {
		return isFitnesSync;
	}

	/**
	 * @param isFitnesSync the isFitnesSync to set
	 */
	public void setIsFitnesSync(Boolean isFitnesSync) {
		this.isFitnesSync = isFitnesSync;
	}

	/**
	 * @return the isInsuranceSync
	 */
	public Boolean getIsInsuranceSync() {
		return isInsuranceSync;
	}

	/**
	 * @param isInsuranceSync the isInsuranceSync to set
	 */
	public void setIsInsuranceSync(Boolean isInsuranceSync) {
		this.isInsuranceSync = isInsuranceSync;
	}

	/**
	 * @return the isBlackListSync
	 */
	public Boolean getIsBlackListSync() {
		return isBlackListSync;
	}

	/**
	 * @param isBlackListSync the isBlackListSync to set
	 */
	public void setIsBlackListSync(Boolean isBlackListSync) {
		this.isBlackListSync = isBlackListSync;
	}

	/**
	 * @return the isFinancerSync
	 */
	public Boolean getIsFinancerSync() {
		return isFinancerSync;
	}

	/**
	 * @param isFinancerSync the isFinancerSync to set
	 */
	public void setIsFinancerSync(Boolean isFinancerSync) {
		this.isFinancerSync = isFinancerSync;
	}
	
	
	
	

}

package org.epragati.vahan.sync.vo;

import java.io.Serializable;
import java.util.List;

import org.epragati.vahan.sync.nic.dto.AxleDetailsNicDTO;
import org.epragati.vahan.sync.nic.dto.BlackListDetailsNicDTO;
import org.epragati.vahan.sync.nic.dto.FeeDetailsNicDTO;
import org.epragati.vahan.sync.nic.dto.FinancerDetailsNicDTO;
import org.epragati.vahan.sync.nic.dto.FitnessDetailsNicDTO;
import org.epragati.vahan.sync.nic.dto.InsuranceDetailsNicDTO;
import org.epragati.vahan.sync.nic.dto.NocDetailsNicDTO;
import org.epragati.vahan.sync.nic.dto.NocOwnerDetailsNicDTO;
import org.epragati.vahan.sync.nic.dto.OwnerDetailsNicDTO;
import org.epragati.vahan.sync.nic.dto.TaxDetailsNicDTO;

public class OtsiToNicVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6659699713143109032L;
	
	List<OwnerDetailsNicDTO> ownerDetailsList;
	
	List<AxleDetailsNicDTO> axleDetailsList;
	
	List<InsuranceDetailsNicDTO> insuranceDetailsList;
	
	List<TaxDetailsNicDTO> taxDetailsList;
	
	List<FeeDetailsNicDTO> FeeDetailsList;
	
	List<FitnessDetailsNicDTO> FitnessDetailsList;
	
	List<FinancerDetailsNicDTO> FinancerDetailsList;
	
	List<NocDetailsNicDTO> NocDetailsList;
	
	List<NocOwnerDetailsNicDTO> NocOwnerDetailsList;
	
	List<BlackListDetailsNicDTO> BlackListDetailsList;

	/**
	 * @return the ownerDetailsList
	 */
	public List<OwnerDetailsNicDTO> getOwnerDetailsList() {
		return ownerDetailsList;
	}

	/**
	 * @param ownerDetailsList the ownerDetailsList to set
	 */
	public void setOwnerDetailsList(List<OwnerDetailsNicDTO> ownerDetailsList) {
		this.ownerDetailsList = ownerDetailsList;
	}

	/**
	 * @return the axleDetailsList
	 */
	public List<AxleDetailsNicDTO> getAxleDetailsList() {
		return axleDetailsList;
	}

	/**
	 * @param axleDetailsList the axleDetailsList to set
	 */
	public void setAxleDetailsList(List<AxleDetailsNicDTO> axleDetailsList) {
		this.axleDetailsList = axleDetailsList;
	}

	/**
	 * @return the insuranceDetailsList
	 */
	public List<InsuranceDetailsNicDTO> getInsuranceDetailsList() {
		return insuranceDetailsList;
	}

	/**
	 * @param insuranceDetailsList the insuranceDetailsList to set
	 */
	public void setInsuranceDetailsList(List<InsuranceDetailsNicDTO> insuranceDetailsList) {
		this.insuranceDetailsList = insuranceDetailsList;
	}

	/**
	 * @return the taxDetailsList
	 */
	public List<TaxDetailsNicDTO> getTaxDetailsList() {
		return taxDetailsList;
	}

	/**
	 * @param taxDetailsList the taxDetailsList to set
	 */
	public void setTaxDetailsList(List<TaxDetailsNicDTO> taxDetailsList) {
		this.taxDetailsList = taxDetailsList;
	}

	/**
	 * @return the feeDetailsList
	 */
	public List<FeeDetailsNicDTO> getFeeDetailsList() {
		return FeeDetailsList;
	}

	/**
	 * @param feeDetailsList the feeDetailsList to set
	 */
	public void setFeeDetailsList(List<FeeDetailsNicDTO> feeDetailsList) {
		FeeDetailsList = feeDetailsList;
	}

	/**
	 * @return the fitnessDetailsList
	 */
	public List<FitnessDetailsNicDTO> getFitnessDetailsList() {
		return FitnessDetailsList;
	}

	/**
	 * @param fitnessDetailsList the fitnessDetailsList to set
	 */
	public void setFitnessDetailsList(List<FitnessDetailsNicDTO> fitnessDetailsList) {
		FitnessDetailsList = fitnessDetailsList;
	}

	/**
	 * @return the financerDetailsList
	 */
	public List<FinancerDetailsNicDTO> getFinancerDetailsList() {
		return FinancerDetailsList;
	}

	/**
	 * @param financerDetailsList the financerDetailsList to set
	 */
	public void setFinancerDetailsList(List<FinancerDetailsNicDTO> financerDetailsList) {
		FinancerDetailsList = financerDetailsList;
	}

	/**
	 * @return the nocDetailsList
	 */
	public List<NocDetailsNicDTO> getNocDetailsList() {
		return NocDetailsList;
	}

	/**
	 * @param nocDetailsList the nocDetailsList to set
	 */
	public void setNocDetailsList(List<NocDetailsNicDTO> nocDetailsList) {
		NocDetailsList = nocDetailsList;
	}

	/**
	 * @return the nocOwnerDetailsList
	 */
	public List<NocOwnerDetailsNicDTO> getNocOwnerDetailsList() {
		return NocOwnerDetailsList;
	}

	/**
	 * @param nocOwnerDetailsList the nocOwnerDetailsList to set
	 */
	public void setNocOwnerDetailsList(List<NocOwnerDetailsNicDTO> nocOwnerDetailsList) {
		NocOwnerDetailsList = nocOwnerDetailsList;
	}

	/**
	 * @return the blackListDetailsList
	 */
	public List<BlackListDetailsNicDTO> getBlackListDetailsList() {
		return BlackListDetailsList;
	}

	/**
	 * @param blackListDetailsList the blackListDetailsList to set
	 */
	public void setBlackListDetailsList(List<BlackListDetailsNicDTO> blackListDetailsList) {
		BlackListDetailsList = blackListDetailsList;
	}

	
	
}

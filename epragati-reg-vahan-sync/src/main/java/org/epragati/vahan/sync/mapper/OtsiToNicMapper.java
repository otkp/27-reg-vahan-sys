package org.epragati.vahan.sync.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.epragati.common.mappers.BaseMapper;
import org.epragati.vahan.sync.dto.AxleDetailsDTO;
import org.epragati.vahan.sync.dto.BlackListDetailsDTO;
import org.epragati.vahan.sync.dto.FeeDetailsDTO;
import org.epragati.vahan.sync.dto.FinancerDetaildDTO;
import org.epragati.vahan.sync.dto.FitnessDetailsDTO;
import org.epragati.vahan.sync.dto.InsuranceDetailsDTO;
import org.epragati.vahan.sync.dto.NocDetailsDTO;
import org.epragati.vahan.sync.dto.NocOwnerDetailsDTO;
import org.epragati.vahan.sync.dto.OwnerDetailsDTO;
import org.epragati.vahan.sync.dto.TaxDetailsDTO;
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
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class OtsiToNicMapper extends BaseMapper<AxleDetailsDTO, AxleDetailsNicDTO>{

	@Override
	public AxleDetailsNicDTO convertEntity(AxleDetailsDTO dto) {
		AxleDetailsNicDTO axleDetailsNicDTO = new AxleDetailsNicDTO();
		BeanUtils.copyProperties(dto, axleDetailsNicDTO);
		return axleDetailsNicDTO;
	}
	
	public OwnerDetailsNicDTO convertOwnerDetails(OwnerDetailsDTO dto){
		OwnerDetailsNicDTO ownerDetailsNicDTO = new OwnerDetailsNicDTO();
		BeanUtils.copyProperties(dto, ownerDetailsNicDTO);
		return ownerDetailsNicDTO;		
	}
	
	public InsuranceDetailsNicDTO convertInsuranceDetails(InsuranceDetailsDTO dto){
		InsuranceDetailsNicDTO insuranceDetailsNicDTO = new InsuranceDetailsNicDTO();
		BeanUtils.copyProperties(dto, insuranceDetailsNicDTO);
		return insuranceDetailsNicDTO;		
	}
	
	public TaxDetailsNicDTO convertTaxDetails(TaxDetailsDTO dto){
		TaxDetailsNicDTO taxDetailsNicDTO = new TaxDetailsNicDTO();
		BeanUtils.copyProperties(dto, taxDetailsNicDTO);
		return taxDetailsNicDTO;		
	}
	public FeeDetailsNicDTO convertFeeDetails(FeeDetailsDTO dto){
		FeeDetailsNicDTO feeDetailsNicDTO = new FeeDetailsNicDTO();
		BeanUtils.copyProperties(dto, feeDetailsNicDTO);
		return feeDetailsNicDTO;		
	}
	
	public FitnessDetailsNicDTO convertFitnessDetails(FitnessDetailsDTO dto){
		FitnessDetailsNicDTO fitnessDetailsNicDTO = new FitnessDetailsNicDTO();
		BeanUtils.copyProperties(dto, fitnessDetailsNicDTO);
		return fitnessDetailsNicDTO;		
	}
	
	public FinancerDetailsNicDTO convertFinancerDetails(FinancerDetaildDTO dto){
		FinancerDetailsNicDTO financerDetailsNicDTO = new FinancerDetailsNicDTO();
		BeanUtils.copyProperties(dto, financerDetailsNicDTO);
		return financerDetailsNicDTO;		
	}
	
	public NocDetailsNicDTO convertNocDetails(NocDetailsDTO dto){
		NocDetailsNicDTO nocDetailsNicDTO = new NocDetailsNicDTO();
		BeanUtils.copyProperties(dto, nocDetailsNicDTO);
		return nocDetailsNicDTO;		
	}
	
	public NocOwnerDetailsNicDTO convertNocOwnerDetails(NocOwnerDetailsDTO dto){
		NocOwnerDetailsNicDTO nocOwnerDetailsNicDTO = new NocOwnerDetailsNicDTO();
		BeanUtils.copyProperties(dto, nocOwnerDetailsNicDTO);
		return nocOwnerDetailsNicDTO;		
	}
	
	public BlackListDetailsNicDTO convertBlackListDetails(BlackListDetailsDTO dto){
		BlackListDetailsNicDTO blackListDetailsNicDTO = new BlackListDetailsNicDTO();
		BeanUtils.copyProperties(dto, blackListDetailsNicDTO);
		return blackListDetailsNicDTO;		
	}
	
	public List<OwnerDetailsNicDTO> convertOwnerDetailsList(List<OwnerDetailsDTO> ownerDetailsList){
		return ownerDetailsList.stream().map(e -> convertOwnerDetails(e)).collect(Collectors.toList());
		
	}
	
	public List<AxleDetailsNicDTO> convertAxleDetailsList(List<AxleDetailsDTO> axleDetailsList){
		return axleDetailsList.stream().map(e -> convertEntity(e)).collect(Collectors.toList());
		
	}
	
	public List<InsuranceDetailsNicDTO> convertInsuranceDetailsList(List<InsuranceDetailsDTO> insuranceDetailsList){
		return insuranceDetailsList.stream().map(e -> convertInsuranceDetails(e)).collect(Collectors.toList());
		
	}
	
	public List<TaxDetailsNicDTO> convertTaxDetailsList(List<TaxDetailsDTO> taxDetailsList){
		return taxDetailsList.stream().map(e -> convertTaxDetails(e)).collect(Collectors.toList());
		
	}
	
	public List<FeeDetailsNicDTO> convertFeeDetailsList(List<FeeDetailsDTO> feeDetailsList){
		return feeDetailsList.stream().map(e -> convertFeeDetails(e)).collect(Collectors.toList());
		
	}
	
	public List<FitnessDetailsNicDTO> convertFitnessDetailsList(List<FitnessDetailsDTO> fitnessDetailsList){
		return fitnessDetailsList.stream().map(e -> convertFitnessDetails(e)).collect(Collectors.toList());
		
	}
	
	public List<FinancerDetailsNicDTO> convertFinancerDetailsList(List<FinancerDetaildDTO> financerDetailsList){
		return financerDetailsList.stream().map(e -> convertFinancerDetails(e)).collect(Collectors.toList());
		
	}
	
	public List<NocDetailsNicDTO> convertNocDetailsList(List<NocDetailsDTO> nocDetailsList){
		return nocDetailsList.stream().map(e -> convertNocDetails(e)).collect(Collectors.toList());
		
	}
	
	public List<NocOwnerDetailsNicDTO> convertNocOwnerDetailsList(List<NocOwnerDetailsDTO> nocOwnerDetailsList){
		return nocOwnerDetailsList.stream().map(e -> convertNocOwnerDetails(e)).collect(Collectors.toList());
		
	}
	
	public List<BlackListDetailsNicDTO> convertBlackListDetailsList(List<BlackListDetailsDTO> blackListDetailsList){
		return blackListDetailsList.stream().map(e -> convertBlackListDetails(e)).collect(Collectors.toList());
		
	}
}

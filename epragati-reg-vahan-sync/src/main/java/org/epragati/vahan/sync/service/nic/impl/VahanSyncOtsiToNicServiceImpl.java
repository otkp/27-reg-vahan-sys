package org.epragati.vahan.sync.service.nic.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.epragati.vahan.sync.nic.dao.AxleDetailsNicDAO;
import org.epragati.vahan.sync.nic.dao.BlackListDetailsNicDAO;
import org.epragati.vahan.sync.nic.dao.FeeDetailsNicDAO;
import org.epragati.vahan.sync.nic.dao.FinancerDetailsNicDAO;
import org.epragati.vahan.sync.nic.dao.FitnessDetailsNicDAO;
import org.epragati.vahan.sync.nic.dao.InsuranceDetailsNicDAO;
import org.epragati.vahan.sync.nic.dao.NocDetailsNicDAO;
import org.epragati.vahan.sync.nic.dao.NocOwnerDetailsNicDAO;
import org.epragati.vahan.sync.nic.dao.OwnerDetailsNicDAO;
import org.epragati.vahan.sync.nic.dao.TaxDetailsNicDAO;
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
import org.epragati.vahan.sync.nic.service.VahanSyncOtsiToNicService;
import org.epragati.vahan.sync.service.VahanSyncServcie;
import org.epragati.vahan.sync.vo.OtsiToNicVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class VahanSyncOtsiToNicServiceImpl implements VahanSyncOtsiToNicService {

	private static final Logger logger = LoggerFactory.getLogger(VahanSyncOtsiToNicServiceImpl.class);

	@Value("${vahan.service.data.axle.url:}")
	private String OtsiToNicSyncUrl;

	@Value("${vahan.otsi.nic.token.vahan:}")
	private String vahanSyncToken;

	@Autowired
	private AxleDetailsNicDAO axleDetailsNicDAO;

	@Autowired
	private OwnerDetailsNicDAO ownerDetailsNicDAO;

	@Autowired
	private InsuranceDetailsNicDAO insuranceDetailsNicDAO;

	@Autowired
	private TaxDetailsNicDAO taxDetailsNicDAO;

	@Autowired
	private FeeDetailsNicDAO feeDetailsNicDAO;

	@Autowired
	private FitnessDetailsNicDAO fitnessDetailsNicDAO;

	@Autowired
	private FinancerDetailsNicDAO financerDetailsNicDAO;

	@Autowired
	private NocDetailsNicDAO nocDetailsNicDAO;

	@Autowired
	private NocOwnerDetailsNicDAO nocOwnerDetailsNicDAO;

	@Autowired
	private BlackListDetailsNicDAO blackListDetailsNicDAO;

	@Autowired
	private VahanSyncServcie vahanSyncServcie;
	
	private static List<Integer> districtIds=new ArrayList<>();
	

	//@PostConstruct
	private static List<Integer> init() {
		Integer[] arr = { 553,554,545,548,547,552,549,550,542,544,543,546,551 };

		Collections.addAll(districtIds, arr);
		return districtIds;
	}

	@Override
	public void otsiToNicSync() {
		
		if(CollectionUtils.isEmpty(districtIds)){
			init();
		}
		
		
		for (int i = 0; i < 4000; i++) {
			long parentrStarTime = System.currentTimeMillis();
			logger.info("Office Codes: ,{}",districtIds);
			//ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
			districtIds.removeAll(Collections.singleton(null));
			if (CollectionUtils.isEmpty(districtIds)) {
				districtIds =init();
			}
			if (CollectionUtils.isNotEmpty(districtIds)) {
				districtIds.parallelStream().forEach(districtId -> {
					long starTime = System.currentTimeMillis();
					OtsiToNicVO otsiToNicVO = vahanSyncServcie.postvahandataotsitonic(districtId);
					if (null != otsiToNicVO) {
						int totalcount = otsiToNicVO.getOwnerDetailsList().size();
						saveForOtsiToNicSync(otsiToNicVO);
						logger.info(
								"postvahandataotsitonic Total exicution time: {}ms for districtId code:{} , total records: {}",
								(System.currentTimeMillis() - starTime), districtId, totalcount);
					} else {
						//officeIds.remove(officeId);
						if (CollectionUtils.isEmpty(districtIds)) {
							districtIds = init();
						}
						logger.info("No data found for districtId Code:{}", districtId);
					}
				
				});
			}
			//executor.shutdown();
			logger.info("Total exicution time: {}ms for all districtId, iterationCount: {} ", (System.currentTimeMillis() - parentrStarTime),
					i);
		}
	}

	public VahanSyncOtsiToNicServiceImpl() {
		super();
	}

	private void saveForOtsiToNicSync(OtsiToNicVO otsiToNicVO) {
		try {
			if (CollectionUtils.isNotEmpty(otsiToNicVO.getOwnerDetailsList())) {
				saveOwnerDetails(otsiToNicVO.getOwnerDetailsList());
			}
			if (CollectionUtils.isNotEmpty(otsiToNicVO.getAxleDetailsList())) {
			saveAxleDetails(otsiToNicVO.getAxleDetailsList());	
			}
			if (CollectionUtils.isNotEmpty(otsiToNicVO.getInsuranceDetailsList())) {
				saveInsurance(otsiToNicVO.getInsuranceDetailsList());
			}
			if (CollectionUtils.isNotEmpty(otsiToNicVO.getTaxDetailsList())) {
				saveTax(otsiToNicVO.getTaxDetailsList());
			}
			if (CollectionUtils.isNotEmpty(otsiToNicVO.getFeeDetailsList())) {
				saveFee(otsiToNicVO.getFeeDetailsList());
			}
			if (CollectionUtils.isNotEmpty(otsiToNicVO.getFitnessDetailsList())) {
				saveFitness(otsiToNicVO.getFitnessDetailsList());
			}
			if (CollectionUtils.isNotEmpty(otsiToNicVO.getFinancerDetailsList())) {
				saveFinancer(otsiToNicVO.getFinancerDetailsList());
			}
			if (CollectionUtils.isNotEmpty(otsiToNicVO.getNocDetailsList())) {
				saveNoc(otsiToNicVO.getNocDetailsList());
			}
			if (CollectionUtils.isNotEmpty(otsiToNicVO.getNocOwnerDetailsList())) {
				saveNocOwner(otsiToNicVO.getNocOwnerDetailsList());
			}
			if (CollectionUtils.isNotEmpty(otsiToNicVO.getBlackListDetailsList())) {
				saveBlack(otsiToNicVO.getBlackListDetailsList());
			}
		} catch (Exception e) {
			logger.debug("saveForOtsiToNicSync Exception :{} ",e);
		}
		
	}
	
	private String error(Exception e) {
		String cause = "";
		if (e.getCause() != null && e.getCause().getCause() != null) {
			cause = e.getCause().getCause().toString();
		}
		return "[" + cause + "]," + "[" + e.getMessage() + "]";
		
	}
	
	private void saveOwnerDetails(List<OwnerDetailsNicDTO> ownerDetailsList) {
		logger.info("saveOwnerDetails stated");
		boolean isOwnerSync = false;
		List<String> prNos = new ArrayList<String>();
		try {
			ownerDetailsNicDAO.save(ownerDetailsList);
			logger.info("saveOwnerDetails saved list");
			prNos.addAll(ownerDetailsList.stream().map(val -> val.getRegnNo()).collect(Collectors.toList()));
			logger.info("saveOwnerDetails saved list prnos size: {}",prNos.size());
		} catch (Exception e) {
			prNos.clear();
			logger.error("Exception occures while saving Owner And vehicle details:{}", e);
			for (OwnerDetailsNicDTO owner : ownerDetailsList) {
				try {
					ownerDetailsNicDAO.save(owner);
					prNos.add(owner.getRegnNo());
				} catch (Exception ex) {
					vahanSyncServcie.saveErrorTrackLog("VAHANSYNC", owner.getRegnNo(), error(ex), "OWNER");
					logger.error("Exception occures while saving Owner And vehicle details:{} , and with regnNo", e,
							owner.getRegnNo());
				}
			}
		}
		if (!isOwnerSync) {
			logger.info("isOwnerSync saved list prnos size: {}",prNos.size());
			vahanSyncServcie.updateFlagForOwnerAndVehicleDetails(prNos);
		}
		ownerDetailsList.clear();
		prNos.clear();
	}
	
	private void saveAxleDetails(List<AxleDetailsNicDTO> axleDetailsList) {
		boolean isaxleSync = false;
		List<String> prNos = new ArrayList<String>();
		try {
			axleDetailsNicDAO.save(axleDetailsList);
			prNos.addAll(axleDetailsList.stream()
					.map(val -> val.getRegnNo()).collect(Collectors.toList()));
		} catch (Exception e) {
			prNos.clear();
			logger.error("Exception occures while saving Axle details:{}", e);
			for (AxleDetailsNicDTO axle : axleDetailsList) {
				try {
					axleDetailsNicDAO.save(axle);
					prNos.add(axle.getRegnNo());
				} catch (Exception ex) {
					vahanSyncServcie.saveErrorTrackLog("VAHANSYNC", axle.getRegnNo(), error(ex), "AXLE");
					logger.error("Exception occures while saving Axle details:{} , and with regnNo", e,axle.getRegnNo());	
				}
		}
		}
		if (!isaxleSync) {
			vahanSyncServcie.updateFlagAxleDetails(prNos);
		}
		axleDetailsList.clear();
		prNos.clear();
	}
	
	private void saveInsurance(List<InsuranceDetailsNicDTO> insuranceList) {
		boolean isinsuranceSync = false;
		List<String> prNos = new ArrayList<String>();
		try {
			insuranceDetailsNicDAO.save(insuranceList);
			prNos.addAll(insuranceList.stream()
					.map(val -> val.getRegnNo()).collect(Collectors.toList()));
		} catch (Exception e) {
			prNos.clear();
			logger.info("Exception occures while saving Insurance details:{}", e);
			for (InsuranceDetailsNicDTO insurance : insuranceList) {
				try {
					insuranceDetailsNicDAO.save(insurance);
					prNos.add(insurance.getRegnNo());
				} catch (Exception ex) {
					vahanSyncServcie.saveErrorTrackLog("VAHANSYNC", insurance.getRegnNo(), error(ex), "INSURANCE");
					logger.error("Exception occures while saving Insurance details:{} , and with regnNo", e,insurance.getRegnNo());	
				}
		}
		}
		if (!isinsuranceSync) {
			vahanSyncServcie.updateFlagInsuranceDetails(prNos);
		}
		insuranceList.clear();
		prNos.clear();
	}
	
	private void saveTax(List<TaxDetailsNicDTO> taxList) {
		boolean istaxSync = false;
		List<String> prNos = new ArrayList<String>();
		try {
			taxDetailsNicDAO.save(taxList);
			prNos.addAll(taxList.stream()
					.map(val -> val.getRegnNo()).collect(Collectors.toList()));
		} catch (Exception e) {
			logger.error("Exception occures while saving Tax details:{}", e);
			//istaxSync = true;
			prNos.clear();
			for (TaxDetailsNicDTO tax : taxList) {
				try {
					taxDetailsNicDAO.save(tax);
					prNos.add(tax.getRegnNo());
				} catch (Exception ex) {
					vahanSyncServcie.saveErrorTrackLog("VAHANSYNC", tax.getRegnNo(), error(ex), "TAX");
					logger.error("Exception occures while saving Tax details:{} , and with regnNo", e,tax.getRegnNo());	
				}
		}
		}
		if (!istaxSync) {
			vahanSyncServcie.updateFlagTaxDetails(prNos);
		}
		taxList.clear();
		prNos.clear();
	}
	
	private void saveFee(List<FeeDetailsNicDTO> feeList) {
		boolean isFeeSync = false;
		List<String> prNos = new ArrayList<String>();
		try {
			feeDetailsNicDAO.save(feeList);
			prNos.addAll(feeList.stream()
					.map(val -> val.getRegnNo()).collect(Collectors.toList()));
		} catch (Exception e) {
			prNos.clear();
			logger.error("Exception occures while saving Fee details:{}", e);
			for (FeeDetailsNicDTO fee : feeList) {
				try {
					feeDetailsNicDAO.save(fee);
					prNos.add(fee.getRegnNo());
				} catch (Exception ex) {
					vahanSyncServcie.saveErrorTrackLog("VAHANSYNC", fee.getRegnNo(),error(ex), "FEE");
					logger.error("Exception occures while saving Fee details:{} , and with regnNo", e,fee.getRegnNo());	
				}
		}
		}
		if (!isFeeSync) {
			vahanSyncServcie.updateFlagFeeDetails(prNos);
		}
		feeList.clear();
		prNos.clear();
	}
	
	private void saveFitness(List<FitnessDetailsNicDTO> fitnessList) {
		boolean isFitnessSync = false;
		List<String> prNos = new ArrayList<String>();
		try {
			fitnessDetailsNicDAO.save(fitnessList);
			prNos.addAll(fitnessList.stream()
					.map(val -> val.getRegnNo()).collect(Collectors.toList()));
		} catch (Exception e) {
			prNos.clear();
			logger.error("Exception occures while saving Fitness details:{}", e);
			for (FitnessDetailsNicDTO fitness : fitnessList) {
				try {
					fitnessDetailsNicDAO.save(fitness);
					prNos.add(fitness.getRegnNo());
				} catch (Exception ex) {
					vahanSyncServcie.saveErrorTrackLog("VAHANSYNC", fitness.getRegnNo(), error(ex), "FITNESS");
					logger.error("Exception occures while saving Fitness details:{} , and with regnNo", e,fitness.getRegnNo());	
				}
		}
		}
		if (!isFitnessSync) {
			vahanSyncServcie.updateFlagFitnessDetails(prNos);
		}
		fitnessList.clear();
		prNos.clear();
	}
	
	private void saveFinancer(List<FinancerDetailsNicDTO> financerList) {
		boolean isFinancerSync = false;
		List<String> prNos = new ArrayList<String>();
		try {
			financerDetailsNicDAO.save(financerList);
			prNos.addAll(financerList.stream()
					.map(val -> val.getRegnNo()).collect(Collectors.toList()));
		} catch (Exception e) {
			prNos.clear();
			logger.error("Exception occures while saving Financer details:{}", e);
			//isFinancerSync = true;
			for (FinancerDetailsNicDTO financer : financerList) {
				try {
					financerDetailsNicDAO.save(financer);
					prNos.add(financer.getRegnNo());
				} catch (Exception ex) {
					vahanSyncServcie.saveErrorTrackLog("VAHANSYNC", financer.getRegnNo(), error(ex), "FINANCER");
					logger.error("Exception occures while saving Financer details:{} , and with regnNo", e,financer.getRegnNo());	
				}
		}
		}
		if (!isFinancerSync) {
			vahanSyncServcie.updateFlagFinancerDetails(prNos);
		}
		financerList.clear();
		prNos.clear();
	}
	
	private void saveNoc(List<NocDetailsNicDTO> nocList) {
		boolean isNocSync = false;
		List<String> prNos = new ArrayList<String>();
		try {
			nocDetailsNicDAO.save(nocList);
			prNos.addAll(nocList.stream()
					.map(val -> val.getPrNo()).collect(Collectors.toList()));
		} catch (Exception e) {
			prNos.clear();
			logger.error("Exception occures while saving Noc details:{}", e);
			//isNocSync = true;
			for (NocDetailsNicDTO noc : nocList) {
				try {
					nocDetailsNicDAO.save(noc);
					prNos.add(noc.getPrNo());
				} catch (Exception ex) {
					vahanSyncServcie.saveErrorTrackLog("VAHANSYNC", noc.getPrNo(), error(ex), "NOC");
					logger.error("Exception occures while saving Noc details:{} , and with regnNo", e,noc.getPrNo());	
				}
		}
		}
		if (!isNocSync) {
			vahanSyncServcie.updateFlagNocDetails(prNos);
		}
		nocList.clear();
		prNos.clear();
	}
	
	private void saveNocOwner(List<NocOwnerDetailsNicDTO> nocOwnerList) {
		boolean isNocOwnerSync = false;
		List<String> prNos = new ArrayList<String>();
		try {
			nocOwnerDetailsNicDAO.save(nocOwnerList);
			prNos.addAll(nocOwnerList.stream()
					.map(val -> val.getRegnNo()).collect(Collectors.toList()));
		} catch (Exception e) {
			logger.error("Exception occures while saving Noc Owner details:{}", e);
			//isNocOwnerSync = true;
			prNos.clear();
			for (NocOwnerDetailsNicDTO nocOwner : nocOwnerList) {
				try {
					nocOwnerDetailsNicDAO.save(nocOwner);
					prNos.add(nocOwner.getRegnNo());
				} catch (Exception ex) {
					vahanSyncServcie.saveErrorTrackLog("VAHANSYNC", nocOwner.getRegnNo(), error(ex), "NOCOWNER");
					logger.error("Exception occures while saving Noc Owner details:{} , and with regnNo", e,nocOwner.getRegnNo());	
				}
		}
		}
		if (!isNocOwnerSync) {
			vahanSyncServcie.updateFlagNocOwnerDetails(prNos);
		}
		nocOwnerList.clear();
	}
	
	private void saveBlack(List<BlackListDetailsNicDTO> blackList) {
		boolean isblackListSync = false;
		List<String> prNos = new ArrayList<String>();
		try {
			blackListDetailsNicDAO.save(blackList);
			prNos.addAll(blackList.stream()
					.map(val -> val.getRegnNo()).collect(Collectors.toList()));
		} catch (Exception e) {
			prNos.clear();
			logger.info("Exception occures while saving Noc Owner details:{}", e);
			//isblackListSync = true;
			for (BlackListDetailsNicDTO black : blackList) {
				try {
					blackListDetailsNicDAO.save(black);
					prNos.add(black.getRegnNo());
				} catch (Exception ex) {
					vahanSyncServcie.saveErrorTrackLog("VAHANSYNC", black.getRegnNo(), error(ex), "NOCOWNER");
					logger.error("Exception occures while saving Noc Owner details:{} , and with regnNo", e,black.getRegnNo());	
				}
		}
		}
		if (!isblackListSync) {
			vahanSyncServcie.updateFlagBlackListDetails(prNos);
		}
		blackList.clear();
	}
}

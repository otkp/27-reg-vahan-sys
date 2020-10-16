package org.epragati.vahan.sync.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.crypto.BadPaddingException;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.epragati.vahan.sync.dao.AxleDetailsDAO;
import org.epragati.vahan.sync.dao.BlackListDetailsDAO;
import org.epragati.vahan.sync.dao.ErrorTrackLogVahanSyncDAO;
import org.epragati.vahan.sync.dao.FeeDetailsDAO;
import org.epragati.vahan.sync.dao.FinancerDetaildDAO;
import org.epragati.vahan.sync.dao.FitnessDetailsDAO;
import org.epragati.vahan.sync.dao.InsuranceDetailsDAO;
import org.epragati.vahan.sync.dao.MasterDistrictDAO;
import org.epragati.vahan.sync.dao.MasterMakerDAO;
import org.epragati.vahan.sync.dao.MasterNormsDAO;
import org.epragati.vahan.sync.dao.NocDetailsDAO;
import org.epragati.vahan.sync.dao.NocOwnerDetailsDAO;
import org.epragati.vahan.sync.dao.OwnerDetailsDAO;
import org.epragati.vahan.sync.dao.TaxDetailsDAO;
import org.epragati.vahan.sync.dto.AxleDetailsDTO;
import org.epragati.vahan.sync.dto.BlackListDetailsDTO;
import org.epragati.vahan.sync.dto.ErrorTrackLogVahanSyncDTO;
import org.epragati.vahan.sync.dto.FeeDetailsDTO;
import org.epragati.vahan.sync.dto.FinancerDetaildDTO;
import org.epragati.vahan.sync.dto.FitnessDetailsDTO;
import org.epragati.vahan.sync.dto.InsuranceDetailsDTO;
import org.epragati.vahan.sync.dto.MasterDistrictDTO;
import org.epragati.vahan.sync.dto.MasterMakerDTO;
import org.epragati.vahan.sync.dto.MasterNormsDTO;
import org.epragati.vahan.sync.dto.NocDetailsDTO;
import org.epragati.vahan.sync.dto.NocOwnerDetailsDTO;
import org.epragati.vahan.sync.dto.OwnerDetailsDTO;
import org.epragati.vahan.sync.dto.TaxDetailsDTO;
import org.epragati.vahan.sync.mapper.OtsiToNicMapper;
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
import org.epragati.vahan.sync.service.VahanSyncServcie;
import org.epragati.vahan.sync.vo.OtsiToNicVO;
import org.epragati.vahan.sync.vo.RegVahanPortVO;
import org.epragati.vahan.sync.vo.RtaToVahanVO;
import org.epragati.vahan.sync.vo.UserToken;
import org.epragati.vahan.sync.vo.UserTokenResponceVO;
import org.epragati.vahan.sync.vo.UserTokenVO;
import org.epragati.vahan.sync.vo.VahanSyncResponceVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class VahanSyncServiceImpl implements VahanSyncServcie {

	private static final Logger logger = LoggerFactory.getLogger(VahanSyncServiceImpl.class);

	@Autowired
	OwnerDetailsDAO ownerDetailsDAO;

	@Value("${vahan.service.data.porting.url:}")
	private String aprtaUrl;

	@Value("${vahan.service.data.porting.vahan.url:}")
	private String vahanUrl;

	@Value("${vahan.service.token.vahan.url:}")
	private String tokenUrl;

	@Value("${vahan.username:}")
	private String username;

	@Value("${vahan.password:}")
	private String password;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private MasterDistrictDAO masterDistrictDAO;

	@Autowired
	private MasterMakerDAO masterMakerDAO;

	@Autowired
	private MasterNormsDAO masterNormsDAO;

	@Autowired
	private TaxDetailsDAO taxDetailsDAO;

	@Autowired
	private FeeDetailsDAO feeDetailsDAO;

	@Autowired
	private NocDetailsDAO nocDetailsDAO;

	@Autowired
	private InsuranceDetailsDAO insuranceDetailsDAO;

	@Autowired
	private FinancerDetaildDAO financerDetaildDAO;

	@Autowired
	private FitnessDetailsDAO fitnessDetailsDAO;

	@Autowired
	private BlackListDetailsDAO blackListDetailsDAO;

	@Autowired
	private AxleDetailsDAO axleDetailsDAO;

	@Autowired
	private NocOwnerDetailsDAO nocOwnerDetailsDAO;

	@Value("${vahan.otsi.nic.token.vahan:}")
	private String vahanSyncToken;

	@Autowired
	private OtsiToNicMapper otsiToNicMapper;
	
	@Autowired
	private ErrorTrackLogVahanSyncDAO errorTrackLogVahanSyncDAO;

	@Override
	public void rtaVahanDataPorting(Integer count) throws JsonParseException, JsonMappingException, IOException {

		for (int i = 0; i < 300000; i++) {
			long startTime = System.currentTimeMillis();
			// Integer count = 500;
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.add("Authorization", getTokenServices());
			HttpEntity<String> httpEntity = new HttpEntity<>(headers);
			Map<String, Integer> uriParams = null;
			if (count != null) {
				uriParams = new HashMap<>();
				uriParams.put("count", count);
			}
			UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(aprtaUrl).queryParam("count", count);
			logger.info("vahan Sync reg rest call at [{}] ms", startTime);
			ResponseEntity<String> response = restTemplate.exchange(builder.buildAndExpand(uriParams).toUri(),
					HttpMethod.GET, httpEntity, new ParameterizedTypeReference<String>() {
			});// vahansyncrecords
			logger.info(" vahan Sync reg rest call End Total excecution time: [{}]ms",
					(System.currentTimeMillis() - startTime));
			if (response.hasBody()) {
				ObjectMapper mapper = new ObjectMapper();
				VahanSyncResponceVO vahanSyncResponceVO = mapper.readValue(response.getBody(),
						VahanSyncResponceVO.class);
				List<RegVahanPortVO> regVahanPortVOList = vahanSyncResponceVO.getResult();
				if (CollectionUtils.isNotEmpty(regVahanPortVOList)) {
					long stTime = System.currentTimeMillis();
					// logger.info("vahan Sync for loop started call at [{}]
					// ms",stTime );
					List<RtaToVahanVO> rtaToVahanVOList = new ArrayList<RtaToVahanVO>();
					regVahanPortVOList.parallelStream().forEach(regVahanPortVO -> {
						saveForSetVahanSync(regVahanPortVO, rtaToVahanVOList);
					});
					vahansyncToRtaDataPorting(rtaToVahanVOList);
					logger.info("Total excecution time for vahan Sync Loop: {}ms ",
							(System.currentTimeMillis() - stTime));
					// logger.info("vahan sync bulk saving [{}]",
					// LocalDateTime.now());
					regVahanPortVOList.clear();
				} else {
					logger.info("no records aprta to vahan sync");
					break;
				}
			}
			logger.info("End vahansyncToRtaDataPorting Total excecution time: {} ms and records count:{}",
					(System.currentTimeMillis() - startTime), count);
		}
	}

	public void vahansyncToRtaDataPorting(List<RtaToVahanVO> rtaToVahanVOList) {
		long stTime = System.currentTimeMillis();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", getTokenServices());
		HttpEntity<List<RtaToVahanVO>> httpEntity = new HttpEntity<>(rtaToVahanVOList, headers);
		try {
			logger.info("vahan Sync vahansync to  rest call at [{}] ms", stTime);
			ResponseEntity<String> response = restTemplate.exchange(vahanUrl, HttpMethod.POST, httpEntity,
					String.class);
			if (response.hasBody() && response.getStatusCode().equals("Success")) {
				logger.info("Record saved vahansync successfully ");
			}
		} catch (Exception e) {
			logger.info("Record not saved in VahanSync [{}]", e);
		}
		logger.info("Total excecution time for vahansyncToRtaDataPorting: {}ms ",
				(System.currentTimeMillis() - stTime));
		rtaToVahanVOList.clear();
	}

	// @Transactional
	@Override
	public void saveForSetVahanSync(RegVahanPortVO regVahanPortVO, List<RtaToVahanVO> rtaToVahanVOList) {
		long stTime = System.currentTimeMillis();
		RtaToVahanVO rtaToVahanVO = new RtaToVahanVO();
		try {
			rtaToVahanVO.setPrNo(regVahanPortVO.getPrNo());
			rtaToVahanVO = saveForOwnerAndVehicleDetails(regVahanPortVO, rtaToVahanVO);
			rtaToVahanVO = saveForAxleDetails(regVahanPortVO, rtaToVahanVO);
			rtaToVahanVO = saveForInsuranceDetails(regVahanPortVO, rtaToVahanVO);
			rtaToVahanVO = saveForTaxDetails(regVahanPortVO, rtaToVahanVO);
			rtaToVahanVO = saveForFeeDetails(regVahanPortVO, rtaToVahanVO);
			if (regVahanPortVO.getIsFitness().equals(Boolean.TRUE)) {
				rtaToVahanVO = saveForFitnessDetails(regVahanPortVO, rtaToVahanVO);
			}
			if (regVahanPortVO.getIsFinancier().equals(Boolean.TRUE)) {
				rtaToVahanVO = saveForFinancerDetails(regVahanPortVO, rtaToVahanVO);
			}
			if (regVahanPortVO.getIsNocIssued().equals(Boolean.TRUE)) {
				rtaToVahanVO = saveForNocDetails(regVahanPortVO, rtaToVahanVO);
				rtaToVahanVO = saveForNocOwnerDetails(regVahanPortVO, rtaToVahanVO);
			}
			if (regVahanPortVO.getIsTheft().equals(Boolean.TRUE)) {
				rtaToVahanVO = saveForBlackListDetails(regVahanPortVO, rtaToVahanVO);
			}
			logger.info("Vahan sync ended time  [{}] with prNo number [{}] ", (System.currentTimeMillis() - stTime),
					regVahanPortVO.getPrNo());
		} catch (Exception e) {
			logger.error("vahansync expcetion with prNo :{} and Expcetion :{}", regVahanPortVO.getPrNo(), e);
			String cause = "";
			if (e.getCause() != null && e.getCause().getCause() != null) {
				cause = e.getCause().getCause().toString();
			}
			rtaToVahanVO.setError("[" + cause + "]," + "[" + e.getMessage() + "]");
		}
		rtaToVahanVOList.add(rtaToVahanVO);
		logger.info("Total excecution time for saveForSetVahanSync all tables : {}ms ",
				(System.currentTimeMillis() - stTime));
	}

	private RtaToVahanVO saveForOwnerAndVehicleDetails(RegVahanPortVO regVahanPortVO, RtaToVahanVO rtaToVahanVO) {
		long stTime = System.currentTimeMillis();
		OwnerDetailsDTO ownerDetailsDTO = new OwnerDetailsDTO();
		ownerDetailsDTO.setRegnNo(regVahanPortVO.getPrNo());
		ownerDetailsDTO.setStateCd(regVahanPortVO.getStateId());
		ownerDetailsDTO.setOffCd(regVahanPortVO.getOfficeCode());
		ownerDetailsDTO.setRegnDt(regVahanPortVO.getPrGeneratedDate());
		ownerDetailsDTO.setPurchaseDt(regVahanPortVO.getTrGeneratedDate());
		if (StringUtils.isNotEmpty(regVahanPortVO.getNameOfOwner()) && regVahanPortVO.getNameOfOwner().length() > 35) {
			ownerDetailsDTO.setOwnerName(StringUtils.left(regVahanPortVO.getNameOfOwner().trim(), 35));
		} else {
			ownerDetailsDTO.setOwnerName(regVahanPortVO.getNameOfOwner());
		}
		if (StringUtils.isNotEmpty(regVahanPortVO.getFatherName()) && regVahanPortVO.getFatherName().length() > 60) {
			ownerDetailsDTO.setfName(StringUtils.left(regVahanPortVO.getFatherName().trim(), 60));
		} else {
			ownerDetailsDTO.setfName(regVahanPortVO.getFatherName());
		}
		ownerDetailsDTO.setcAdd1(regVahanPortVO.getPresentAddress1().trim());
		if (StringUtils.isNotEmpty(regVahanPortVO.getPresentAddress2())) {
			ownerDetailsDTO.setcAdd2(regVahanPortVO.getPresentAddress2().trim());
		}
		if (StringUtils.isNotEmpty(regVahanPortVO.getPresentAddress3())) {
			ownerDetailsDTO.setcAdd3(regVahanPortVO.getPresentAddress3().trim());
		}
		ownerDetailsDTO.setcDistrict(regVahanPortVO.getPresentDistricCode());
		ownerDetailsDTO.setcPincode(regVahanPortVO.getPresentPostOfficeCode());
		ownerDetailsDTO.setOwnerSr(regVahanPortVO.getTowCount());
		if (StringUtils.isNotEmpty(regVahanPortVO.getStateId())) {
			ownerDetailsDTO.setpState(regVahanPortVO.getStateId());
		} else {
			ownerDetailsDTO.setpState(regVahanPortVO.getStateId());
		}
		if (regVahanPortVO.getPermanentDistricName() != null) {
			ownerDetailsDTO.setpDistrict(
					getDistrictCode(regVahanPortVO.getPermanentDistricName(), regVahanPortVO.getStateId()));
		} else {
			ownerDetailsDTO.setpDistrict(regVahanPortVO.getPresentDistricCode());
		}
		ownerDetailsDTO.setcState(regVahanPortVO.getStateId());
		ownerDetailsDTO.setpAdd1(regVahanPortVO.getPermanentAddress1().trim());
		if (StringUtils.isNotEmpty(regVahanPortVO.getPermanentAddress2())) {
			ownerDetailsDTO.setpAdd2(regVahanPortVO.getPermanentAddress1().trim());
		}
		if (StringUtils.isNotEmpty(regVahanPortVO.getPermanentAddress3())) {
			ownerDetailsDTO.setpAdd3(regVahanPortVO.getPermanentAddress3().trim());
		}
		ownerDetailsDTO.setpPincode(regVahanPortVO.getPermanentPostOfficeCode());
		ownerDetailsDTO.setOwnerCd(regVahanPortVO.getOwnerType());
		ownerDetailsDTO.setRegnType(regVahanPortVO.getTypeOfRegistration());
		ownerDetailsDTO.setVhClass(regVahanPortVO.getClassOfVehicle());
		ownerDetailsDTO.setChasiNo(regVahanPortVO.getChassisNumber());
		ownerDetailsDTO.setEngNo(regVahanPortVO.getEngineNumber());
		ownerDetailsDTO.setMaker(getMakersClass(regVahanPortVO.getMakersDesc()));
		ownerDetailsDTO.setMakerModel(deleteWhiteSpaces(regVahanPortVO.getMakersModel(), 30));
		ownerDetailsDTO.setBodyType(deleteWhiteSpaces(regVahanPortVO.getBodyTypeDesc(), 30));
		ownerDetailsDTO.setSeatCap(regVahanPortVO.getSeatingCapacity());
		ownerDetailsDTO.setUnldWt(regVahanPortVO.getUlw());
		ownerDetailsDTO.setGcw(regVahanPortVO.getGvw());
		ownerDetailsDTO.setLdWt(regVahanPortVO.getUlw());
		ownerDetailsDTO.setFuel(regVahanPortVO.getFuelType());
		ownerDetailsDTO.setColor(regVahanPortVO.getColor());
		ownerDetailsDTO.setManuMon(regVahanPortVO.getManufacturedMonth());
		ownerDetailsDTO.setManuYr(regVahanPortVO.getManufacturedYear());
		ownerDetailsDTO.setNorms(getNorms(regVahanPortVO.getNormsOfVehicle()));
		ownerDetailsDTO.setAcFitted('N');
		ownerDetailsDTO.setAudioFitted('N');
		ownerDetailsDTO.setVideoFitted('N');
		ownerDetailsDTO.setVchCatg(regVahanPortVO.getVehicleCategory());
		ownerDetailsDTO.setSaleAmt(regVahanPortVO.getInvoiceValue().intValue());
		ownerDetailsDTO.setRegnUpto(regVahanPortVO.getRegistrationValidity());
		ownerDetailsDTO.setImportedVch('N');
		ownerDetailsDTO.setStatus(regVahanPortVO.getNocIssuedOrNot());
		ownerDetailsDTO.setOpDt(regVahanPortVO.getTrGeneratedDate());
		ownerDetailsDTO.setNoCyl(regVahanPortVO.getNoOfCyl());
		ownerDetailsDTO.setDealerCd(regVahanPortVO.getDealerId());
		ownerDetailsDTO.setNicsync(false);
		if(regVahanPortVO.getIsFinancier()!=null&&regVahanPortVO.getIsFinancier()){
			ownerDetailsDTO.setHype(Boolean.TRUE);
		}else{
			ownerDetailsDTO.setHype(Boolean.FALSE);
		}
		if(regVahanPortVO.getFitnessValidUpto()!=null) {
			ownerDetailsDTO.setFitUpto(regVahanPortVO.getFitnessValidUpto());
		}else {
			ownerDetailsDTO.setFitUpto(regVahanPortVO.getRegistrationValidity());
		}
		ownerDetailsDAO.save(ownerDetailsDTO);
		ownerDetailsDTO = null;
		rtaToVahanVO.setIsOwnerSync(Boolean.TRUE);
		logger.info("Total excecution time for saveForOwnerAndVehicleDetails : {}ms with prNo{}",
				(System.currentTimeMillis() - stTime), regVahanPortVO.getPrNo());
		return rtaToVahanVO;

	}

	private RtaToVahanVO saveForTaxDetails(RegVahanPortVO regVahanPortVO, RtaToVahanVO rtaToVahanVO) {
		long stTime = System.currentTimeMillis();
		TaxDetailsDTO taxDetailsDTO = new TaxDetailsDTO();
		taxDetailsDTO.setRegnNo(regVahanPortVO.getPrNo());
		taxDetailsDTO.setOffCd(regVahanPortVO.getOfficeCode());
		taxDetailsDTO.setRcptNo(regVahanPortVO.getApplicationFormRefNum());
		// as per nic payment Collected mode default "4" bcz online Transaction
		taxDetailsDTO.setPaymentMode(4);
		// as per nic payment Collected mode default "1" bcz online Transaction
		// code
		// as per nic purCd Collected mode default "58" bcz online purCd
		taxDetailsDTO.setPurCd(58);
		taxDetailsDTO.setStateCd(regVahanPortVO.getStateId());
		taxDetailsDTO.setTaxAmt(regVahanPortVO.getTotalFee());
		taxDetailsDTO.setTaxFine(regVahanPortVO.getTaxFineAmount());
		taxDetailsDTO.setTaxFrom(regVahanPortVO.getTaxFromDate());
		taxDetailsDTO.setTaxUpto(regVahanPortVO.getTaxValidUpto());
		taxDetailsDTO.setTaxMode(regVahanPortVO.getTaxMode());
		// as per nic payment CollectedBy default "APRTA"
		taxDetailsDTO.setCollectedBy("APRTA");
		taxDetailsDTO.setRcptDt(regVahanPortVO.getTaxPaidDate());
		taxDetailsDTO.setNicsync(false);
		taxDetailsDAO.save(taxDetailsDTO);
		taxDetailsDTO = null;
		rtaToVahanVO.setIsTaxSync(Boolean.TRUE);
		logger.info("Total excecution time for saveForTaxDetails : {}ms with prNo{}",
				(System.currentTimeMillis() - stTime), regVahanPortVO.getPrNo());
		return rtaToVahanVO;

	}

	private RtaToVahanVO saveForFeeDetails(RegVahanPortVO regVahanPortVO, RtaToVahanVO rtaToVahanVO) {
		long stTime = System.currentTimeMillis();
		FeeDetailsDTO feeDetailsDTO = new FeeDetailsDTO();
		feeDetailsDTO.setRegnNo(regVahanPortVO.getPrNo());
		feeDetailsDTO.setOffCd(regVahanPortVO.getOfficeCode());
		// as per nic payment CollectedBy default "APRTA"
		feeDetailsDTO.setCollectedBy("APRTA");
		feeDetailsDTO.setFees(regVahanPortVO.getTotalFee());
		feeDetailsDTO.setFine(regVahanPortVO.getTaxFineAmount());
		feeDetailsDTO.setPurCd(regVahanPortVO.getPurposeCode());
		feeDetailsDTO.setRcptNo(regVahanPortVO.getApplicationFormRefNum());
		feeDetailsDTO.setRcptDt(regVahanPortVO.getPaymentResponseTime());
		feeDetailsDTO.setStateCd(regVahanPortVO.getStateId());
		feeDetailsDTO.setPaymentMode(4);
		feeDetailsDTO.setNicsync(false);
		feeDetailsDAO.save(feeDetailsDTO);
		feeDetailsDTO = null;
		rtaToVahanVO.setIsFeeSync(Boolean.TRUE);
		logger.info("Total excecution time for saveForFeeDetails : {}ms with prNo{}",
				(System.currentTimeMillis() - stTime), regVahanPortVO.getPrNo());
		return rtaToVahanVO;

	}

	private RtaToVahanVO saveForNocDetails(RegVahanPortVO regVahanPortVO, RtaToVahanVO rtaToVahanVO) {
		long stTime = System.currentTimeMillis();
		NocDetailsDTO nocDetailsDTO = new NocDetailsDTO();
		nocDetailsDTO.setApplicationNo(regVahanPortVO.getNocApplicatioNo());
		nocDetailsDTO.setNocDate(regVahanPortVO.getNocRtaIssueDate());
		nocDetailsDTO.setPrNo(regVahanPortVO.getPrNo());
		nocDetailsDTO.setNocIssueDate(regVahanPortVO.getNocRtaIssueDate());
		nocDetailsDTO.setNocStateCode(regVahanPortVO.getNocState());
		// as per nic APRTA team not have noc number so default "NA"
		nocDetailsDTO.setNocNo("NA");
		nocDetailsDTO.setStateCode(regVahanPortVO.getStateId());
		nocDetailsDTO.setOffcieCode(regVahanPortVO.getOfficeCode());
		nocDetailsDTO.setRto_to(regVahanPortVO.getNocRtaOfficeCode());
		nocDetailsDTO.setNicsync(false);
		nocDetailsDAO.save(nocDetailsDTO);
		nocDetailsDTO = null;
		rtaToVahanVO.setIsNocSync(Boolean.TRUE);
		logger.info("Total excecution time for saveForNocDetails : {}ms with prNo{}",
				(System.currentTimeMillis() - stTime), regVahanPortVO.getPrNo());
		return rtaToVahanVO;

	}

	private RtaToVahanVO saveForInsuranceDetails(RegVahanPortVO regVahanPortVO, RtaToVahanVO rtaToVahanVO) {
		long stTime = System.currentTimeMillis();
		InsuranceDetailsDTO insuranceDetailsDTO = new InsuranceDetailsDTO();
		insuranceDetailsDTO.setRegnNo(regVahanPortVO.getPrNo());
		insuranceDetailsDTO.setInsFrom(regVahanPortVO.getInsurancevalidFrom());
		insuranceDetailsDTO.setInsType(regVahanPortVO.getInsurancePolicyType());
		insuranceDetailsDTO.setInsUpto(regVahanPortVO.getInsurancevalidTO());
		insuranceDetailsDTO.setPolicyNo(regVahanPortVO.getInsurancePolicyNo());
		insuranceDetailsDTO.setOffCd(regVahanPortVO.getOfficeCode());
		insuranceDetailsDTO.setCompCd(regVahanPortVO.getInsuranceCompanyName());
		// as per nic idv code is default 0
		insuranceDetailsDTO.setIdv(0);
		insuranceDetailsDTO.setStateCd(regVahanPortVO.getStateId());
		insuranceDetailsDTO.setNicsync(false);
		insuranceDetailsDAO.save(insuranceDetailsDTO);
		insuranceDetailsDTO = null;
		rtaToVahanVO.setIsInsuranceSync(Boolean.TRUE);
		logger.info("Total excecution time for saveForInsuranceDetails : {}ms with prNo{}",
				(System.currentTimeMillis() - stTime), regVahanPortVO.getPrNo());
		return rtaToVahanVO;
	}

	private RtaToVahanVO saveForFinancerDetails(RegVahanPortVO regVahanPortVO, RtaToVahanVO rtaToVahanVO) {
		long stTime = System.currentTimeMillis();
		FinancerDetaildDTO financerDetaildDTO = new FinancerDetaildDTO();
		financerDetaildDTO.setOffCd(regVahanPortVO.getOfficeCode());
		financerDetaildDTO.setFncrName(StringUtils.left(regVahanPortVO.getFinanceName(), 35));
		financerDetaildDTO.setRegnNo(regVahanPortVO.getPrNo());
		financerDetaildDTO.setSrNo(1);
		financerDetaildDTO.setStateCd(regVahanPortVO.getStateId());
		if (regVahanPortVO.getFinanceAddress1() != null) {
			financerDetaildDTO.setFncrAdd1(regVahanPortVO.getFinanceAddress1());
		} else {
			financerDetaildDTO.setFncrAdd1("Andhra Pradesh");
		}
		financerDetaildDTO.setHpType("1");
		// financerDetaildDTO.setFncrAdd1("ANANTAPUR ,Andhra Pradesh");
		if (regVahanPortVO.getFinanceDistricCode() != null) {
			financerDetaildDTO.setFncrDistrict(regVahanPortVO.getFinanceDistricCode());
		} else {
			financerDetaildDTO.setFncrDistrict(0);
		}
		if (regVahanPortVO.getFinancestateId() != null) {
			financerDetaildDTO.setFncrState(regVahanPortVO.getFinancestateId());
		} else {
			financerDetaildDTO.setFncrState("AP");
		}
		financerDetaildDTO.setNicsync(false);
		financerDetaildDAO.save(financerDetaildDTO);
		financerDetaildDTO = null;
		rtaToVahanVO.setIsFinancerSync(Boolean.TRUE);
		logger.info("Total excecution time for saveForFinancerDetails : {}ms with prNo{}",
				(System.currentTimeMillis() - stTime), regVahanPortVO.getPrNo());
		return rtaToVahanVO;

	}

	private RtaToVahanVO saveForFitnessDetails(RegVahanPortVO regVahanPortVO, RtaToVahanVO rtaToVahanVO) {
		long stTime = System.currentTimeMillis();
		FitnessDetailsDTO fitnessDetailsDTO = new FitnessDetailsDTO();
		fitnessDetailsDTO.setOffCd(regVahanPortVO.getOfficeCode());
		fitnessDetailsDTO.setOpDt(regVahanPortVO.getFitnessinspectedDate());
		fitnessDetailsDTO.setRegnNo(regVahanPortVO.getPrNo());
		fitnessDetailsDTO.setStateCd(regVahanPortVO.getStateId());
		fitnessDetailsDTO.setChasiNo(regVahanPortVO.getChassisNumber());
		fitnessDetailsDTO.setFitChkDt(regVahanPortVO.getFitnessinspectedDate());
		fitnessDetailsDTO.setFitValidTo(regVahanPortVO.getFcValidity());
		fitnessDetailsDTO.setFitValidTo(regVahanPortVO.getFitnessValidUpto());
		fitnessDetailsDTO.setNicsync(false);
		fitnessDetailsDAO.save(fitnessDetailsDTO);
		fitnessDetailsDTO = null;
		rtaToVahanVO.setIsFitnesSync(Boolean.TRUE);
		logger.info("Total excecution time for saveForFitnessDetails : {}ms with prNo{}",
				(System.currentTimeMillis() - stTime), regVahanPortVO.getPrNo());
		return rtaToVahanVO;
	}

	private RtaToVahanVO saveForBlackListDetails(RegVahanPortVO regVahanPortVO, RtaToVahanVO rtaToVahanVO) {
		long stTime = System.currentTimeMillis();
		BlackListDetailsDTO blackListDetailsDTO = new BlackListDetailsDTO();
		blackListDetailsDTO.setComplainDt(regVahanPortVO.getFirDate());
		blackListDetailsDTO.setOffCd(regVahanPortVO.getOfficeCode());
		blackListDetailsDTO.setRegnNo(regVahanPortVO.getPrNo());
		blackListDetailsDTO.setStateCd(regVahanPortVO.getStateId());
		// as per nic default code 99
		blackListDetailsDTO.setComplainType(99);
		blackListDetailsDTO.setComplain(regVahanPortVO.getComplain());
		blackListDetailsDTO.setEnteredBy(regVahanPortVO.getComplainEnteredBy());
		blackListDetailsDTO.setNicsync(false);
		blackListDetailsDAO.save(blackListDetailsDTO);
		blackListDetailsDTO = null;
		rtaToVahanVO.setIsBlackListSync(Boolean.TRUE);
		logger.info("Total excecution time for saveForBlackListDetails : {}ms with prNo",
				(System.currentTimeMillis() - stTime), regVahanPortVO.getPrNo());
		return rtaToVahanVO;
	}

	private RtaToVahanVO saveForAxleDetails(RegVahanPortVO regVahanPortVO, RtaToVahanVO rtaToVahanVO) {
		long stTime = System.currentTimeMillis();
		AxleDetailsDTO axleDetailsDTO = new AxleDetailsDTO();
		axleDetailsDTO.setfAxleDescp(regVahanPortVO.getFrontAxleDesc());
		axleDetailsDTO.setfAxleWeight(regVahanPortVO.getFrontAxleWeight());
		axleDetailsDTO.setNoOfAxles(regVahanPortVO.getNoOfCyl());
		axleDetailsDTO.setOffCd(regVahanPortVO.getOfficeCode());
		axleDetailsDTO.setrAxleDescp(regVahanPortVO.getRearAxleDesc());
		axleDetailsDTO.setrAxleWeight(regVahanPortVO.getRearAxleWeight());
		axleDetailsDTO.setRegnNo(regVahanPortVO.getPrNo());
		axleDetailsDTO.setStateCd(regVahanPortVO.getStateId());
		axleDetailsDTO.setNicsync(false);
		axleDetailsDAO.save(axleDetailsDTO);
		axleDetailsDTO = null;
		rtaToVahanVO.setIsAxleSync(Boolean.TRUE);
		logger.info("Total excecution time for saveForAxleDetails : {}ms with prNo{}",
				(System.currentTimeMillis() - stTime), regVahanPortVO.getPrNo());
		return rtaToVahanVO;

	}

	private Integer getDistrictCode(String districtName, String StateCode) {
		try {
		Optional<MasterDistrictDTO> optionalMasterDistrictDTO = masterDistrictDAO.findByDescrAndStateCd(districtName,
				StateCode);
		if (optionalMasterDistrictDTO.isPresent()) {
			return optionalMasterDistrictDTO.get().getDistCd();
		}
		}catch(Throwable e) {
			logger.error("getDistrictCode Exception : {}" ,e);
		}
		return 0;
	}

	private Integer getMakersClass(String makerName) {
		try {
			Optional<MasterMakerDTO> optionalMasterDistrictDTO = masterMakerDAO.findByDescrLike(makerName);
			if (optionalMasterDistrictDTO.isPresent()) {
				return optionalMasterDistrictDTO.get().getCode();
			}
		} catch (Throwable e) {
			logger.error("getMakersClass Exception : {}", e);
		}
		return 9999;
	}

	private Integer getNorms(String norms) {
		try {
			Optional<MasterNormsDTO> optionalMasterDistrictDTO = masterNormsDAO.findByDescr(norms);
			if (optionalMasterDistrictDTO.isPresent()) {
				return optionalMasterDistrictDTO.get().getCode();
			}
		} catch (Throwable e) {
			logger.error("getNorms Exception : {}", e);
		}
		return 99;
	}

	private RtaToVahanVO saveForNocOwnerDetails(RegVahanPortVO regVahanPortVO, RtaToVahanVO rtaToVahanVO) {
		long stTime = System.currentTimeMillis();
		NocOwnerDetailsDTO nocOwnerDetailsDTO = new NocOwnerDetailsDTO();
		nocOwnerDetailsDTO.setRegnNo(regVahanPortVO.getPrNo());
		nocOwnerDetailsDTO.setRtoCd(regVahanPortVO.getOfficeCode().toString());
		nocOwnerDetailsDTO.setStateCd(regVahanPortVO.getStateId());
		nocOwnerDetailsDTO.setRegnDt(regVahanPortVO.getPrGeneratedDate());
		nocOwnerDetailsDTO.setPurchaseDt(regVahanPortVO.getTrGeneratedDate());
		nocOwnerDetailsDTO.setOwnerName(regVahanPortVO.getNameOfOwner());
		if (StringUtils.isNotEmpty(regVahanPortVO.getFatherName()) && regVahanPortVO.getFatherName().length() > 60) {
			nocOwnerDetailsDTO.setfName(StringUtils.left(regVahanPortVO.getFatherName().trim(), 60));
		} else {
			nocOwnerDetailsDTO.setfName(regVahanPortVO.getFatherName());
		}
		nocOwnerDetailsDTO.setcAdd1(regVahanPortVO.getPresentAddress1().trim());
		if (regVahanPortVO.getPresentAddress2() != null) {
			nocOwnerDetailsDTO.setcAdd2(regVahanPortVO.getPresentAddress2().trim());
		}
		nocOwnerDetailsDTO.setcDistrict(regVahanPortVO.getPresentDistricName());
		nocOwnerDetailsDTO.setcPincode(regVahanPortVO.getPresentPostOfficeCode().toString());
		nocOwnerDetailsDTO.setOwnerSr(regVahanPortVO.getTowCount());
		nocOwnerDetailsDTO.setpAdd1(regVahanPortVO.getPermanentAddress1().trim());
		if (regVahanPortVO.getPermanentAddress2() != null) {
			nocOwnerDetailsDTO.setpAdd2(regVahanPortVO.getPermanentAddress2().trim());
		}
		nocOwnerDetailsDTO.setpPincode(regVahanPortVO.getPermanentPostOfficeCode().toString());
		nocOwnerDetailsDTO.setRegnType(regVahanPortVO.getTypeOfRegistration());
		nocOwnerDetailsDTO.setVhClass(regVahanPortVO.getClassOfVehicle());
		nocOwnerDetailsDTO.setChasiNo(regVahanPortVO.getChassisNumber());
		nocOwnerDetailsDTO.setEngNo(regVahanPortVO.getEngineNumber());
		nocOwnerDetailsDTO.setMaker(getMakersClass(regVahanPortVO.getMakersDesc()));
		nocOwnerDetailsDTO.setMakerModel(deleteWhiteSpaces(regVahanPortVO.getMakersModel(), 30));
		// nocOwnerDetailsDTO.setBodyType(regVahanPortVO.getBodyTypeDesc());
		nocOwnerDetailsDTO.setSeatCap(regVahanPortVO.getSeatingCapacity());
		nocOwnerDetailsDTO.setUnldWt(regVahanPortVO.getUlw());
		nocOwnerDetailsDTO.setLdWt(regVahanPortVO.getUlw());
		nocOwnerDetailsDTO.setFuel(regVahanPortVO.getFuelType());
		nocOwnerDetailsDTO.setColor(regVahanPortVO.getColor());
		nocOwnerDetailsDTO.setManuMon(regVahanPortVO.getManufacturedMonth());
		nocOwnerDetailsDTO.setManuYr(regVahanPortVO.getManufacturedYear());
		nocOwnerDetailsDTO.setNorms(getNorms(regVahanPortVO.getNormsOfVehicle()));
		nocOwnerDetailsDTO.setAcFitted('N');
		nocOwnerDetailsDTO.setAudioFitted('N');
		nocOwnerDetailsDTO.setVideoFitted('N');
		nocOwnerDetailsDTO.setVchCatg(regVahanPortVO.getVehicleCategory());
		nocOwnerDetailsDTO.setSaleAmt(regVahanPortVO.getInvoiceValue().intValue());
		nocOwnerDetailsDTO.setOpDt(regVahanPortVO.getTrGeneratedDate());
		nocOwnerDetailsDTO.setNoCyl(regVahanPortVO.getNoOfCyl());
		nocOwnerDetailsDTO.setOwnerCd(regVahanPortVO.getOwnerType());
		nocOwnerDetailsDTO.setNicsync(false);
		nocOwnerDetailsDTO.setlUpdate(new Date());
		nocOwnerDetailsDAO.save(nocOwnerDetailsDTO);
		nocOwnerDetailsDTO = null;
		rtaToVahanVO.setIsNocOwnerSync(Boolean.TRUE);
		logger.info("Total excecution time for saveForNocOwnerDetails : {}ms with prNo{}",
				(System.currentTimeMillis() - stTime), regVahanPortVO.getPrNo());
		return rtaToVahanVO;
	}

	private String deleteWhiteSpaces(String input, Integer value) {
		return StringUtils.left(StringUtils.deleteWhitespace(input), value);

	}

	public String getTokenServices() {
		long stTime = System.currentTimeMillis();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		UserToken userToken = new UserToken();
		userToken.setUsername(username);
		userToken.setPassword(password);
		userToken.setIsUidsStatus(Boolean.FALSE);
		HttpEntity<UserToken> httpEntity = new HttpEntity<>(userToken, headers);
		try {
			ResponseEntity<String> response = restTemplate.exchange(tokenUrl, HttpMethod.POST, httpEntity,
					String.class);
			if (response.hasBody()) {
				ObjectMapper mapper = new ObjectMapper();
				UserTokenResponceVO userTokenResponceVO = mapper.readValue(response.getBody(),
						UserTokenResponceVO.class);
				logger.info("token UserTokenResponceVO  [{}] ", userTokenResponceVO);
				if(userTokenResponceVO.getResult()!=null){
					UserTokenVO userTokenVO = userTokenResponceVO.getResult();
					if(StringUtils.isNotEmpty(userTokenVO.getToken())){
						return userTokenVO.getToken();
					}else{
						throw new BadPaddingException("Token missing");
					}
				}
				
			}
		} catch (Exception e) {
			logger.error("token services Exception [{}]", e.getMessage());
		}
		logger.info("Total excecution time for token services: {}ms ", (System.currentTimeMillis() - stTime));
		return StringUtils.EMPTY;
	}

	@Override
	public OtsiToNicVO postvahandataotsitonic(Integer officeId) {
		OtsiToNicVO otsiToNicVO=null;
		try {
			otsiToNicVO= new OtsiToNicVO();
			Pair<List<OwnerDetailsNicDTO>, List<String>> result = ownerDetailsConversation(officeId);
			if(result.getFirst().isEmpty()){
				return null;
			}

			List<String> prNoList = result.getSecond();
			List<AxleDetailsNicDTO> axleDetailsNicList = axleDetailsConversation(prNoList);
			List<InsuranceDetailsNicDTO> insuranceNicList = insuranceDetailsConversation(prNoList);
			List<TaxDetailsNicDTO> taxDetailsNicList = taxDetailsConversation(prNoList);
			List<FeeDetailsNicDTO> feeDetailsNicList = feeDetailsConversation(prNoList);
			List<FitnessDetailsNicDTO> fitnessNicDetailsList = fitnessDetailsConversation(prNoList);
			List<FinancerDetailsNicDTO> financerDetailsNicList = financerDetailsConversation(prNoList);
			List<NocDetailsNicDTO> nocNicDetailsList = nocDetailsConversation(prNoList);
			List<NocOwnerDetailsNicDTO> nocOwnerDetailsNicList = nocOwnerDetailsConversation(prNoList);
			List<BlackListDetailsNicDTO> blackListDetailsNicList = blacklistDetailsConversation(prNoList);
			otsiToNicVO.setOwnerDetailsList(result.getFirst());
			otsiToNicVO.setAxleDetailsList(axleDetailsNicList);
			otsiToNicVO.setInsuranceDetailsList(insuranceNicList);
			otsiToNicVO.setTaxDetailsList(taxDetailsNicList);
			otsiToNicVO.setFeeDetailsList(feeDetailsNicList);
			otsiToNicVO.setFitnessDetailsList(fitnessNicDetailsList);
			otsiToNicVO.setFinancerDetailsList(financerDetailsNicList);
			otsiToNicVO.setNocDetailsList(nocNicDetailsList);
			otsiToNicVO.setNocOwnerDetailsList(nocOwnerDetailsNicList);
			otsiToNicVO.setBlackListDetailsList(blackListDetailsNicList);
			return otsiToNicVO;
		} catch (Exception e) {
			logger.error("Exception occures while getting data from OTSI server:{}", e);
		}
		return otsiToNicVO;
	}

	private Pair<List<OwnerDetailsNicDTO>, List<String>> ownerDetailsConversation(Integer districtId) {
		Pageable pageable = new PageRequest(0, 250);
		
		List<OwnerDetailsDTO> ownerDetailsList = ownerDetailsDAO.findByNicsyncFalseAndCDistrict(districtId,pageable);
		if(CollectionUtils.isNotEmpty(ownerDetailsList)){
		logger.info("ownerDetailsConversation districtId:{} and size:{} ", districtId,ownerDetailsList.size());
		List<String> prNoList = getPrNosList(ownerDetailsList);
		List<OwnerDetailsNicDTO> ownerNicDetailsList = otsiToNicMapper.convertOwnerDetailsList(ownerDetailsList);
		// logger.info("Owner details Converted To Nic");
		return Pair.of(ownerNicDetailsList, prNoList);
		}
		return Pair.of(Collections.emptyList(), Collections.emptyList());
	}

	private List<AxleDetailsNicDTO> axleDetailsConversation(List<String> prNoList) {
		List<AxleDetailsDTO> axleDetailsDTOList = axleDetailsQurey(prNoList);
		if (CollectionUtils.isNotEmpty(axleDetailsDTOList)) {
			 logger.info("axle details Converted To Nic");
			return otsiToNicMapper.convertAxleDetailsList(axleDetailsDTOList);
		}
		return Collections.emptyList();
	}

	private List<InsuranceDetailsNicDTO> insuranceDetailsConversation(List<String> prNoList) {
		List<InsuranceDetailsDTO> insuranceDetailsList = insuranceDetailsQurey(prNoList);
		if (CollectionUtils.isNotEmpty(insuranceDetailsList)) {
			// logger.info("insurance details Converted To Nic");
			return otsiToNicMapper.convertInsuranceDetailsList(insuranceDetailsList);
		}
		return Collections.emptyList();

	}

	private List<TaxDetailsNicDTO> taxDetailsConversation(List<String> prNoList) {
		List<TaxDetailsDTO> taxDetailsList = taxDetailsQurey(prNoList);
		if (CollectionUtils.isNotEmpty(taxDetailsList)) {
			// logger.info("tax details Converted To Nic");
			return otsiToNicMapper.convertTaxDetailsList(taxDetailsList);
		}
		return Collections.emptyList();
	}

	private List<FeeDetailsNicDTO> feeDetailsConversation(List<String> prNoList) {
		List<FeeDetailsDTO> feeDetailsList = feeDetailsQurey(prNoList);
		if (CollectionUtils.isNotEmpty(feeDetailsList)) {
			// logger.info("fee details Converted To Nic");
			return otsiToNicMapper.convertFeeDetailsList(feeDetailsList);
		}
		return Collections.emptyList();
	}

	private List<FitnessDetailsNicDTO> fitnessDetailsConversation(List<String> prNoList) {
		List<FitnessDetailsDTO> fitnessDetailsDTOList = fitnessQurey(prNoList);
		if (CollectionUtils.isNotEmpty(fitnessDetailsDTOList)) {
			// logger.info("fitness details Converted To Nic");
			return otsiToNicMapper.convertFitnessDetailsList(fitnessDetailsDTOList);
		}
		return Collections.emptyList();
	}

	private List<FinancerDetailsNicDTO> financerDetailsConversation(List<String> prNoList) {
		List<FinancerDetaildDTO> financerDetailsList = financerQurey(prNoList);
		if (CollectionUtils.isNotEmpty(financerDetailsList)) {
			// logger.info("financer details Converted To Nic");
			return otsiToNicMapper.convertFinancerDetailsList(financerDetailsList);
		}
		return Collections.emptyList();
	}

	private List<NocDetailsNicDTO> nocDetailsConversation(List<String> prNoList) {
		List<NocDetailsDTO> nocDetailsList = nocQurey(prNoList);
		if (CollectionUtils.isNotEmpty(nocDetailsList)) {
			// logger.info("noc details Converted To Nic");
			return otsiToNicMapper.convertNocDetailsList(nocDetailsList);
		}
		return Collections.emptyList();
	}

	private List<NocOwnerDetailsNicDTO> nocOwnerDetailsConversation(List<String> prNoList) {
		List<NocOwnerDetailsDTO> nocOwnerDetailsList = nocOwnerQurey(prNoList);
		if (CollectionUtils.isNotEmpty(nocOwnerDetailsList)) {
			// logger.info("noc owner details Converted To Nic");
			return otsiToNicMapper.convertNocOwnerDetailsList(nocOwnerDetailsList);
		}
		return Collections.emptyList();
	}

	private List<BlackListDetailsNicDTO> blacklistDetailsConversation(List<String> prNoList) {
		List<BlackListDetailsDTO> blackListDetailsList = blackListQurey(prNoList);
		if (CollectionUtils.isNotEmpty(blackListDetailsList)) {
			// logger.info("blacllist details Converted To Nic");
			return otsiToNicMapper.convertBlackListDetailsList(blackListDetailsList);
		}
		return Collections.emptyList();
	}

	@Override
	public void updateFlagForOwnerAndVehicleDetails(List<String> prNoList) {
		long stTime = System.currentTimeMillis();
		List<OwnerDetailsDTO> ownerDetailsDTOList = null;
		try {
			ownerDetailsDTOList = ownerDetailsDAO.findByRegnNoInAndNicsyncFalse(prNoList);
		} catch (Exception e) {
			logger.debug("updateFlagForOwnerAndVehicleDetails get for list Exception :{}", e);
		}
		if (CollectionUtils.isNotEmpty(ownerDetailsDTOList)) {
			ownerDetailsDTOList.stream().forEach(val -> {
				val.setNicsync(true);
				val.setlUpdate(new Date());
			});
			try {
				ownerDetailsDAO.save(ownerDetailsDTOList);
			} catch (Exception e) {
				logger.debug("updateFlagForOwnerAndVehicleDetails save for list  Exception :{}", e);
				for (OwnerDetailsDTO ownerDetailsDTO : ownerDetailsDTOList) {
					try {
						ownerDetailsDAO.save(ownerDetailsDTO);
					} catch (Exception exp) {
						logger.debug("updateFlagForOwnerAndVehicleDetails save for  Exception :{} and prNo:{}", exp,
								ownerDetailsDTO.getRegnNo());
					}
				}
			}
			logger.info("Total excecution time Owner details Nic flag updated :{} ms",
					(System.currentTimeMillis() - stTime));
			ownerDetailsDTOList.clear();
		}
	}

	@Override
	public void updateFlagAxleDetails(List<String> prNoList) {
		long stTime = System.currentTimeMillis();
		List<AxleDetailsDTO> axleDetailsDTOList = axleDetailsQurey(prNoList);
		if (CollectionUtils.isNotEmpty(axleDetailsDTOList)) {
			axleDetailsDTOList.stream().forEach(val -> {
				val.setNicsync(true);
				val.setlUpdate(new Date());
				});
			axleDetailsDAO.save(axleDetailsDTOList);
			logger.info("Total excecution time axle details Nic flag updated :{} ms", (System.currentTimeMillis() - stTime));
			axleDetailsDTOList.clear();
		}
	}

	@Override
	public void updateFlagInsuranceDetails(List<String> prNoList) {
		long stTime = System.currentTimeMillis();
		List<InsuranceDetailsDTO> insuranceDetailsDTOList = insuranceDetailsQurey(prNoList);
		if (CollectionUtils.isNotEmpty(insuranceDetailsDTOList)) {
			insuranceDetailsDTOList.stream().forEach(val -> val.setNicsync(true));
			insuranceDetailsDAO.save(insuranceDetailsDTOList);
			logger.info("Total excecution time insurance details Nic flag updated :{} ms ",
					(System.currentTimeMillis() - stTime));
			insuranceDetailsDTOList.clear();
		}
	}

	@Override
	public void updateFlagTaxDetails(List<String> prNoList) {
		long stTime = System.currentTimeMillis();
		List<TaxDetailsDTO> taxDetailsList = taxDetailsQurey(prNoList);
		if (CollectionUtils.isNotEmpty(taxDetailsList)) {
			taxDetailsList.stream().forEach(val -> val.setNicsync(true));
			taxDetailsDAO.save(taxDetailsList);
			logger.info("Total excecution time tax details Nic flag updated :{} ms", (System.currentTimeMillis() - stTime));
			taxDetailsList.clear();
		}
	}

	@Override
	public void updateFlagFeeDetails(List<String> prNoList) {
		long stTime = System.currentTimeMillis();
		List<FeeDetailsDTO> feeDetailsDTOList = feeDetailsQurey(prNoList);
		if (CollectionUtils.isNotEmpty(feeDetailsDTOList)) {
			feeDetailsDTOList.stream().forEach(val -> val.setNicsync(true));
			feeDetailsDAO.save(feeDetailsDTOList);
			logger.info("Total excecution time Fee details Nic flag updated :{} ms", (System.currentTimeMillis() - stTime));
			feeDetailsDTOList.clear();
		}
	}

	@Override
	public void updateFlagFitnessDetails(List<String> prNoList) {
		long stTime = System.currentTimeMillis();
		List<FitnessDetailsDTO> fitnessDetailsDTOList = fitnessQurey(prNoList);
		if (CollectionUtils.isNotEmpty(fitnessDetailsDTOList)) {
			fitnessDetailsDTOList.stream().forEach(val -> val.setNicsync(true));
			fitnessDetailsDAO.save(fitnessDetailsDTOList);
			logger.info("Total excecution time Fitness details Nic flag updated :{} ms",
					(System.currentTimeMillis() - stTime));
			fitnessDetailsDTOList.clear();
		}
	}

	@Override
	public void updateFlagFinancerDetails(List<String> prNoList) {
		long stTime = System.currentTimeMillis();
		List<FinancerDetaildDTO> financerDetaildDTOList = financerQurey(prNoList);
		if (CollectionUtils.isNotEmpty(financerDetaildDTOList)) {
			financerDetaildDTOList.stream().forEach(val -> val.setNicsync(true));
			financerDetaildDAO.save(financerDetaildDTOList);
			logger.info("Total excecution time Fitness details Nic flag updated :{} ms",
					(System.currentTimeMillis() - stTime));
			financerDetaildDTOList.clear();
		}
	}

	@Override
	public void updateFlagNocDetails(List<String> prNoList) {
		long stTime = System.currentTimeMillis();
		List<NocDetailsDTO> nocDetaildDTOList = nocQurey(prNoList);
		if (CollectionUtils.isNotEmpty(nocDetaildDTOList)) {
			nocDetaildDTOList.stream().forEach(val -> val.setNicsync(true));
			nocDetailsDAO.save(nocDetaildDTOList);
			logger.info("Total excecution time noc details Nic flag updated :{} ms", (System.currentTimeMillis() - stTime));
			nocDetaildDTOList.clear();
		}

	}

	@Override
	public void updateFlagNocOwnerDetails(List<String> prNoList) {
		long stTime = System.currentTimeMillis();
		List<NocOwnerDetailsDTO> nocOwnerDetailsDTOList = nocOwnerQurey(prNoList);
		if (CollectionUtils.isNotEmpty(nocOwnerDetailsDTOList)) {
			nocOwnerDetailsDTOList.stream().forEach(val -> val.setNicsync(true));
			nocOwnerDetailsDAO.save(nocOwnerDetailsDTOList);
			logger.info("Total excecution time noc Owner details Nic flag updated :{} ms",
					(System.currentTimeMillis() - stTime));
			nocOwnerDetailsDTOList.clear();
		}

	}

	@Override
	public void updateFlagBlackListDetails(List<String> prNoList) {
		long stTime = System.currentTimeMillis();
		List<BlackListDetailsDTO> blackListDetailsDTOList = blackListQurey(prNoList);
		if (CollectionUtils.isNotEmpty(blackListDetailsDTOList)) {
			blackListDetailsDTOList.stream().forEach(val -> val.setNicsync(true));
			blackListDetailsDAO.save(blackListDetailsDTOList);
			logger.info("Total excecution time Black List details Nic flag updated :{}ms",
					(System.currentTimeMillis() - stTime));
			blackListDetailsDTOList.clear();
		}

	}

	private List<AxleDetailsDTO> axleDetailsQurey(List<String> prNoList) {
		if (CollectionUtils.isNotEmpty(prNoList)) {
			List<AxleDetailsDTO> axleDetailsDTOList = axleDetailsDAO.findByRegnNoInAndNicsyncFalse(prNoList);
			if (CollectionUtils.isNotEmpty(axleDetailsDTOList)) {
				return axleDetailsDTOList;
			}
		}
		return Collections.emptyList();
	}

	private List<InsuranceDetailsDTO> insuranceDetailsQurey(List<String> prNoList) {
		if (CollectionUtils.isNotEmpty(prNoList)) {
			List<InsuranceDetailsDTO> insuranceDetailsDTOList = insuranceDetailsDAO
					.findByRegnNoInAndNicsyncFalse(prNoList);
			if (CollectionUtils.isNotEmpty(insuranceDetailsDTOList)) {
				return insuranceDetailsDTOList;
			}
		}
		return Collections.emptyList();
	}

	private List<TaxDetailsDTO> taxDetailsQurey(List<String> prNoList) {
		if (CollectionUtils.isNotEmpty(prNoList)) {
			List<TaxDetailsDTO> taxDetailsDTOList = taxDetailsDAO.findByRegnNoInAndNicsyncFalse(prNoList);
			if (CollectionUtils.isNotEmpty(taxDetailsDTOList)) {
				return taxDetailsDTOList;
			}
		}
		return Collections.emptyList();
	}

	private List<FeeDetailsDTO> feeDetailsQurey(List<String> prNoList) {
		if (CollectionUtils.isNotEmpty(prNoList)) {
			List<FeeDetailsDTO> feeDetailsDTOList = feeDetailsDAO.findByRegnNoInAndNicsyncFalse(prNoList);
			if (CollectionUtils.isNotEmpty(feeDetailsDTOList)) {
				return feeDetailsDTOList;
			}
		}
		return Collections.emptyList();
	}

	private List<FitnessDetailsDTO> fitnessQurey(List<String> prNoList) {
		if (CollectionUtils.isNotEmpty(prNoList)) {
			List<FitnessDetailsDTO> fitnessDetailsDTOList = fitnessDetailsDAO.findByRegnNoInAndNicsyncFalse(prNoList);
			if (CollectionUtils.isNotEmpty(fitnessDetailsDTOList)) {
				return fitnessDetailsDTOList;
			}
		}
		return Collections.emptyList();
	}

	private List<FinancerDetaildDTO> financerQurey(List<String> prNoList) {
		if (CollectionUtils.isNotEmpty(prNoList)) {
			List<FinancerDetaildDTO> financerDetaildDTOList = financerDetaildDAO
					.findByRegnNoInAndNicsyncFalse(prNoList);
			if (CollectionUtils.isNotEmpty(financerDetaildDTOList)) {
				return financerDetaildDTOList;
			}
		}
		return Collections.emptyList();
	}

	private List<NocDetailsDTO> nocQurey(List<String> prNoList) {
		if (CollectionUtils.isNotEmpty(prNoList)) {
			List<NocDetailsDTO> nocDetailsDTOList = nocDetailsDAO.findByPrNoInAndNicsyncFalse(prNoList);
			if (CollectionUtils.isNotEmpty(nocDetailsDTOList)) {
				return nocDetailsDTOList;
			}
		}
		return Collections.emptyList();
	}

	private List<NocOwnerDetailsDTO> nocOwnerQurey(List<String> prNoList) {
		if (CollectionUtils.isNotEmpty(prNoList)) {
			List<NocOwnerDetailsDTO> nocOwnerDetailsDTOList = nocOwnerDetailsDAO
					.findByRegnNoInAndNicsyncFalse(prNoList);
			if (CollectionUtils.isNotEmpty(nocOwnerDetailsDTOList)) {
				return nocOwnerDetailsDTOList;
			}
		}
		return Collections.emptyList();
	}

	private List<BlackListDetailsDTO> blackListQurey(List<String> prNoList) {
		if (CollectionUtils.isNotEmpty(prNoList)) {
			List<BlackListDetailsDTO> blackListDetailsDTOList = blackListDetailsDAO
					.findByRegnNoInAndNicsyncFalse(prNoList);
			if (CollectionUtils.isNotEmpty(blackListDetailsDTOList)) {
				return blackListDetailsDTOList;
			}
		}
		return Collections.emptyList();
	}

	@Override
	public void removeOneMonthData() {
		for (int i = 0; i < 30000; i++) {
			long startTime = System.currentTimeMillis();
		Pageable pageable = new PageRequest(0, 100);
		List<String> prNosList = ownerDetailsDAO.getOwnerDetailsNativeDate();
		if(CollectionUtils.isNotEmpty(prNosList)){
			List<OwnerDetailsDTO> ownerDetailslist =ownerDetailsDAO.findByNicsyncTrueAndRegnNoIn(prNosList,pageable);
			if(CollectionUtils.isNotEmpty(ownerDetailslist)){
				ownerDetailsDAO.delete(ownerDetailslist);
			}
			List<AxleDetailsDTO> axleDetailslist =axleDetailsDAO.findByNicsyncTrueAndRegnNoIn(prNosList,pageable);
			if(CollectionUtils.isNotEmpty(axleDetailslist)){
				axleDetailsDAO.delete(axleDetailslist);
			}
			List<InsuranceDetailsDTO> insuranceDetailslist =insuranceDetailsDAO.findByNicsyncTrueAndRegnNoIn(prNosList,pageable);
			if(CollectionUtils.isNotEmpty(insuranceDetailslist)){
				insuranceDetailsDAO.delete(insuranceDetailslist);
			}
			List<TaxDetailsDTO> taxDetailslist =taxDetailsDAO.findByNicsyncTrueAndRegnNoIn(prNosList,pageable);
			if(CollectionUtils.isNotEmpty(taxDetailslist)){
				taxDetailsDAO.delete(taxDetailslist);
			}
			List<FeeDetailsDTO> feeDetailslist =feeDetailsDAO.findByNicsyncTrueAndRegnNoIn(prNosList,pageable);
			if(CollectionUtils.isNotEmpty(feeDetailslist)){
				feeDetailsDAO.delete(feeDetailslist);
			}
			List<FitnessDetailsDTO> fitnesslist =fitnessDetailsDAO.findByNicsyncTrueAndRegnNoIn(prNosList,pageable);
			if(CollectionUtils.isNotEmpty(fitnesslist)){
				fitnessDetailsDAO.delete(fitnesslist);
			}
		}else{
			logger.info("no records to remove record");
			break;
		}
		logger.info("End removeOneMonthData Total time: {}ms for all districtIds, iterationCount: {} ",
				(System.currentTimeMillis() - startTime), i);
		}
		
	}
	
	private List<String> getPrNosList(List<OwnerDetailsDTO> ownerDetailslist) {
		return ownerDetailslist.stream().map(pr -> pr.getRegnNo()).collect(Collectors.toList());
	}

	
	public void removeOneMonthDataOne() {
		Date todayDate = new Date();
		Pageable pageable = new PageRequest(0, 100);
		List<OwnerDetailsDTO> ownerDetailslist = ownerDetailsDAO.findByNicsyncTrueAndLUpdateLessThanEqual(todayDate,pageable);
		if(CollectionUtils.isNotEmpty(ownerDetailslist)){
		List<String> prNolistOw = getPrNosList(ownerDetailslist);
		List<String> prNolistOwithHy = ownerDetailslist.stream().filter(hy -> hy.getHype()).collect(Collectors.toList()).stream().map(pr -> pr.getRegnNo()).collect(Collectors.toList());
		List<String> prNolistOwittNoc = ownerDetailslist.stream().filter(n -> n.getStatus().equals("N")).collect(Collectors.toList()).stream().map(pr -> pr.getRegnNo()).collect(Collectors.toList());
		logger.info("before owner prnos :{}", prNolistOw);
		List<AxleDetailsDTO> axleDetailslist = axleDetailsDAO.findByNicsyncTrueAndRegnNoInAndLUpdateLessThanEqual(prNolistOw, todayDate);
		if(CollectionUtils.isNotEmpty(axleDetailslist)){
			List<String> prNoAx= axleDetailslist.stream().map(pr -> pr.getRegnNo()).collect(Collectors.toList());
			logger.info("befroe axle prnos :{}", prNoAx);
			prNolistOw.retainAll(prNoAx);
			List<TaxDetailsDTO> taxDetailslist = taxDetailsDAO.findByNicsyncTrueAndRegnNoInAndLUpdateLessThanEqual(prNolistOw, todayDate);
			List<String> prNoTx= taxDetailslist.stream().map(pr -> pr.getRegnNo()).collect(Collectors.toList());
			prNolistOw.retainAll(prNoTx);
			List<FeeDetailsDTO> feeDetailslist = feeDetailsDAO.findByNicsyncTrueAndRegnNoInAndLUpdateLessThanEqual(prNolistOw, todayDate);
			List<String> prNoFee= feeDetailslist.stream().map(pr -> pr.getRegnNo()).collect(Collectors.toList());
			prNolistOw.retainAll(prNoFee);
			List<InsuranceDetailsDTO> insuranceDetailslist = insuranceDetailsDAO.findByNicsyncTrueAndRegnNoInAndLUpdateLessThanEqual(prNolistOw, todayDate);
			List<String> prNoIns= insuranceDetailslist.stream().map(pr -> pr.getRegnNo()).collect(Collectors.toList());
			prNolistOw.retainAll(prNoIns);
			List<FitnessDetailsDTO> fitnessDetailslist = fitnessDetailsDAO.findByNicsyncTrueAndRegnNoInAndLUpdateLessThanEqual(prNolistOw, todayDate);
			List<String> prNoFit= fitnessDetailslist.stream().map(pr -> pr.getRegnNo()).collect(Collectors.toList());
			prNolistOw.retainAll(prNoFit);// need to check transport
			if(CollectionUtils.isNotEmpty(prNolistOwithHy)){
				List<FinancerDetaildDTO> financerDetailslist = financerDetaildDAO.findByNicsyncTrueAndRegnNoInAndLUpdateLessThanEqual(prNolistOwithHy, todayDate);
				List<String> prNoHyp= financerDetailslist.stream().map(pr -> pr.getRegnNo()).collect(Collectors.toList());
				prNolistOwithHy.retainAll(prNoHyp);
			}
			if(CollectionUtils.isNotEmpty(prNolistOwittNoc)){
				List<NocDetailsDTO> nocDetails = nocDetailsDAO.findByNicsyncTrueAndPrNoInAndLUpdateLessThanEqual(prNolistOwittNoc, todayDate);
				List<NocOwnerDetailsDTO> nocOwnerDetailslist = nocOwnerDetailsDAO.findByNicsyncTrueAndRegnNoInAndLUpdateLessThanEqual(prNolistOwittNoc, todayDate);
				List<String> prNoNoc= nocDetails.stream().map(n -> n.getPrNo()).collect(Collectors.toList());
				List<String> prNoOwNoc= nocOwnerDetailslist.stream().map(no -> no.getRegnNo()).collect(Collectors.toList());
				prNolistOwittNoc.retainAll(prNoNoc);
				prNolistOwittNoc.retainAll(prNoOwNoc);
			}
		}
			//ownerDetailsDAO.delete(ownerDetailslist);
		}
		
	}
	
	@Override
	public void saveErrorTrackLog(String moduleCode, String prNo, String error, String context) {
		ErrorTrackLogVahanSyncDTO errorTrackLog = new ErrorTrackLogVahanSyncDTO();
		errorTrackLog.setError(error);
		errorTrackLog.setPr_no(prNo);
		errorTrackLog.setContext(context);
		errorTrackLog.setModule_code(moduleCode);
		errorTrackLog.setFixed(false);
		errorTrackLog.setCreated_dt(new Date());
		errorTrackLogVahanSyncDAO.save(errorTrackLog);
	}

}

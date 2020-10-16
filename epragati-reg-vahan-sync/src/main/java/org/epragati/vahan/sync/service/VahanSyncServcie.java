package org.epragati.vahan.sync.service;

import java.io.IOException;
import java.util.List;

import org.epragati.vahan.sync.vo.OtsiToNicVO;
import org.epragati.vahan.sync.vo.RegVahanPortVO;
import org.epragati.vahan.sync.vo.RtaToVahanVO;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
@Component
public interface VahanSyncServcie {

	void saveForSetVahanSync(RegVahanPortVO sarathiSyncVO,List<RtaToVahanVO> rtaToVahanVOList);

	
	void rtaVahanDataPorting(Integer count) throws JsonParseException, JsonMappingException, IOException;

	OtsiToNicVO postvahandataotsitonic(Integer officeId);

	void updateFlagForOwnerAndVehicleDetails(List<String> prNoList);

	void updateFlagAxleDetails(List<String> prNoList);

	void updateFlagInsuranceDetails(List<String> prNoList);

	void updateFlagTaxDetails(List<String> prNoList);

	void updateFlagFeeDetails(List<String> prNoList);

	void updateFlagFitnessDetails(List<String> prNoList);

	void updateFlagFinancerDetails(List<String> prNoList);

	void updateFlagNocDetails(List<String> prNoList);

	void updateFlagNocOwnerDetails(List<String> prNoList);

	void updateFlagBlackListDetails(List<String> prNoList);

	void removeOneMonthData();

	void saveErrorTrackLog(String moduleCode, String prNos, String error, String context);

}

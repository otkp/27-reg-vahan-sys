package org.epragati.vahan.sync.controller;

import org.epragati.constants.MessageKeys;
import org.epragati.exception.BadRequestException;
import org.epragati.util.AppMessages;
import org.epragati.util.GateWayResponse;
import org.epragati.vahan.sync.service.VahanSyncServcie;
import org.epragati.vahan.sync.service.impl.VahanSyncServiceImpl;
import org.epragati.vahan.sync.vo.OtsiToNicVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
public class VahanSyncController {
	
	@Autowired
	private VahanSyncServcie vahanSyncServcie;
	
	@Autowired
	private AppMessages appMessages;
	
	private static final Logger logger = LoggerFactory.getLogger(VahanSyncController.class);

	@Autowired
	VahanSyncServiceImpl vahanSyncServiceImpl;
	
	@GetMapping(path = "/getVahanOwnerDetailsForSave", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	private GateWayResponse<?> getVahanSyncData(@RequestParam("count") Integer count) {
		try {
			
			vahanSyncServcie.rtaVahanDataPorting(count);
			return new GateWayResponse<>(HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception occures while getting seeding {}", e.getMessage());
			return new GateWayResponse<>(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@GetMapping(path = "/getOtsiToNic", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public GateWayResponse<?> getOtsiToNicData(@RequestHeader("Authorization") String token) {
		try {
				OtsiToNicVO otsiToNicVO = vahanSyncServcie.postvahandataotsitonic(2);
				if (null != otsiToNicVO) {
					logger.debug("Vahan OTSI To NIC Sync List Found");
					return new GateWayResponse<>(HttpStatus.OK, otsiToNicVO, "Success");
			}
			return new GateWayResponse<String>(HttpStatus.NOT_FOUND, "Records Not Available");
		} catch (BadRequestException e) {
			logger.error("{}", e.getMessage());
			return new GateWayResponse<String>(HttpStatus.BAD_REQUEST, e.getMessage());
		} catch (NullPointerException e) {
			logger.error(appMessages.getLogMessage(MessageKeys.CITIZEN_SERVICE_COMBINATION_FAILURE), e);
			return new GateWayResponse<String>(HttpStatus.BAD_REQUEST,
					MessageKeys.CITIZEN_SERVICE_NULLPOINTER_EXCEPTION);
		} catch (Exception e) {
			logger.error(appMessages.getLogMessage(MessageKeys.CITIZEN_SERVICE_COMBINATION_FAILURE), e);
			return new GateWayResponse<String>(HttpStatus.SERVICE_UNAVAILABLE, e.getMessage());
		}
	}
	
	@GetMapping(path = "/removeOneMonthData", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public GateWayResponse<?> removeOneMonthData() {
		try {
			vahanSyncServcie.removeOneMonthData();
			return new GateWayResponse<>(HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception occures while getting seeding {}", e.getMessage());
			return new GateWayResponse<>(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
}

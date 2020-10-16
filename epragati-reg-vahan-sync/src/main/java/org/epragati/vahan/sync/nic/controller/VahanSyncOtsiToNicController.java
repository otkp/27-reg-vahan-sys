package org.epragati.vahan.sync.nic.controller;

import org.epragati.vahan.sync.nic.service.VahanSyncOtsiToNicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VahanSyncOtsiToNicController {

	private static final Logger logger = LoggerFactory.getLogger(VahanSyncOtsiToNicController.class);
	
	@Autowired
	private VahanSyncOtsiToNicService vahanSyncOtsiToNicService;
	
	
	@GetMapping(path="/getAxles", produces ={MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE})
	public  void AxleDetails(){
		try {
			logger.info("getAxles start");
			vahanSyncOtsiToNicService.otsiToNicSync();
		} catch (Exception e) {
			logger.error("Exception: {}",e);
		}
		
	}
}

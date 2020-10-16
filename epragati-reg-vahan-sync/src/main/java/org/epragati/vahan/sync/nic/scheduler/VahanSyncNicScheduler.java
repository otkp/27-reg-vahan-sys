package org.epragati.vahan.sync.nic.scheduler;

import java.time.LocalDateTime;

import org.epragati.vahan.sync.nic.service.VahanSyncOtsiToNicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class VahanSyncNicScheduler {

	private static final Logger logger = LoggerFactory.getLogger(VahanSyncNicScheduler.class);
	
	@Value("${Vahan.data.otsi.nic.posting.isEnable:}")
	private Boolean isVahanSyncNicEnable;
	
	@Autowired
	VahanSyncOtsiToNicService vahanSyncOtsiToNicService;
	
	@Scheduled(cron = "${vahan.otsi.nic.sync.data.posting}")
	public void vahanSync() {
		LocalDateTime startTime = LocalDateTime.now();
		LocalDateTime endTime = null;
		String error = null;
		Boolean isExecuteSucess = true;
		if (isVahanSyncNicEnable) {
			logger.info("vahan otsi to nic Sync scheduler starting at time [{}]", startTime);

			try {
				vahanSyncOtsiToNicService.otsiToNicSync();
			} catch (Exception ex) {
				error = ex.getMessage();
				isExecuteSucess = false;
				logger.error("Exception occured while Vahan Sync [{}] ", ex.getMessage());
			}
			endTime = LocalDateTime.now();
			logger.info("vahan otsi to nic Sync scheduler end at time [{}]", endTime);
		} else {
			endTime = LocalDateTime.now();
			isExecuteSucess = false;
			logger.info("vahan otsi to nic Sync scheduler is skiped at time [{}]", endTime);
		}
		logger.info("Vahan otsi to nic Sync scheduler started time [:"+ startTime + ", ended time :"+ endTime +
				", is Execute Sucess status :"+ isExecuteSucess + ", is error :"+ error + "]");
		
	}
	
}

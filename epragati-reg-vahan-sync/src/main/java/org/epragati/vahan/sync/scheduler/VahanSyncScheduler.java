package org.epragati.vahan.sync.scheduler;

import java.time.LocalDateTime;

import org.apache.commons.lang3.StringUtils;
import org.epragati.vahan.sync.service.VahanSyncServcie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
public class VahanSyncScheduler {
	private static final Logger logger = LoggerFactory.getLogger(VahanSyncScheduler.class);
	
	@Value("${Vahan.data.posting.isEnable:}")
	private Boolean isVahanSyncEnable;
	
	@Value("${vahan.count:50}")
	private Integer count;
	
	@Autowired
	VahanSyncServcie vahanSyncServcie;
	
	@Value("${vahan.data.remove.isEnable:}")
	private Boolean isVahanSyncRemoveEnable;
	
	@Scheduled(cron = "${Vahan.Sync.data.posting}")
	public void vahanSync() {
		LocalDateTime startTime = LocalDateTime.now();
		LocalDateTime endTime = null;
		String error = null;
		Boolean isExecuteSucess = true;
		if (isVahanSyncEnable) {
			logger.info("Vahan Sync scheduler starting at time [{}]", startTime);

			try {
				vahanSyncServcie.rtaVahanDataPorting(count);
			} catch (Exception ex) {
				error = ex.getMessage();
				isExecuteSucess = false;
				logger.error("Exception occured while Vahan Sync [{}] ", ex.getMessage());
			}
			endTime = LocalDateTime.now();
			logger.info("Vahan Sync scheduler end at time [{}]", endTime);
		} else {
			endTime = LocalDateTime.now();
			isExecuteSucess = false;
			logger.info("Vahan Sync scheduler is skiped at time [{}]", endTime);
		}
		logger.info("Vahan Sync scheduler started time :{} ,ended time :{}, is Execute Sucess status :{} ,is error :{}",
				startTime, endTime, isExecuteSucess, error);
		
	}
	
	
	@Scheduled(cron = "${vahan.Sync.data.remove}")
	public void removeOneMonthRecord() {
		LocalDateTime startTime = LocalDateTime.now();
		LocalDateTime endTime = null;
		String error = StringUtils.EMPTY;
		Boolean isExecuteSucess = true;
		if (isVahanSyncRemoveEnable) {
			logger.info("Vahan Sync remove one month records scheduler starting at time [{}]", startTime);

			try {
				vahanSyncServcie.removeOneMonthData();
			} catch (Exception ex) {
				error = ex.getMessage();
				isExecuteSucess = false;
				logger.error("Exception occured while Vahan Sync remove one month records [{}] ", ex.getMessage());
			}
			endTime = LocalDateTime.now();
			logger.info("Vahan Sync remove one month records scheduler end at time [{}]", endTime);
		} else {
			endTime = LocalDateTime.now();
			isExecuteSucess = false;
			logger.info("Vahan Sync remove one month records scheduler is skiped at time [{}]", endTime);
		}
		logger.info(
				"Vahan Sync remove one month records scheduler started time :{} ,ended time :{}, is Execute Sucess status :{} ,is error :{}",
				startTime, endTime, isExecuteSucess, error);

	}
}

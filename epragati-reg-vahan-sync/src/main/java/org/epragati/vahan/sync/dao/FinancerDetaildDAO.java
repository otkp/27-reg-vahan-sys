package org.epragati.vahan.sync.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.epragati.vahan.sync.dto.FinancerDetaildDTO;
import org.springframework.stereotype.Repository;
@Repository
public interface FinancerDetaildDAO extends BaseRepository<FinancerDetaildDTO, Serializable>{

	List<FinancerDetaildDTO> findByRegnNoInAndNicsyncFalse(List<String> prNoList);

	List<FinancerDetaildDTO> findByNicsyncTrueAndRegnNoInAndLUpdateLessThanEqual(List<String> prNolistOwithHy,
			Date todayDate);

}

package org.epragati.vahan.sync.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.epragati.vahan.sync.dto.InsuranceDetailsDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceDetailsDAO extends BaseRepository<InsuranceDetailsDTO, Serializable>{

	List<InsuranceDetailsDTO> findByRegnNoInAndNicsyncFalse(List<String> prNoList);

	List<InsuranceDetailsDTO> findByNicsyncTrueAndRegnNoInAndLUpdateLessThanEqual(List<String> prNolistOw,
			Date todayDate);

	List<InsuranceDetailsDTO> findByNicsyncTrueAndRegnNoIn(List<String> prNos,Pageable pageable);
}

package org.epragati.vahan.sync.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.epragati.vahan.sync.dto.FeeDetailsDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
@Repository
public interface FeeDetailsDAO extends BaseRepository<FeeDetailsDTO, Serializable>{

	List<FeeDetailsDTO> findByRegnNoInAndNicsyncFalse(List<String> prNoList);

	List<FeeDetailsDTO> findByNicsyncTrueAndRegnNoInAndLUpdateLessThanEqual(List<String> prNolistOw, Date todayDate);
	
	List<FeeDetailsDTO> findByNicsyncTrueAndRegnNoIn(List<String> prNos,Pageable pageable);

}

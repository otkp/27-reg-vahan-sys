package org.epragati.vahan.sync.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.epragati.vahan.sync.dto.FeeDetailsDTO;
import org.epragati.vahan.sync.dto.FitnessDetailsDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
@Repository
public interface FitnessDetailsDAO extends BaseRepository<FitnessDetailsDTO, Serializable>{

	List<FitnessDetailsDTO> findByRegnNoInAndNicsyncFalse(List<String> prNoList);

	List<FitnessDetailsDTO> findByNicsyncTrueAndRegnNoInAndLUpdateLessThanEqual(List<String> prNolistOw,
			Date todayDate);

	List<FitnessDetailsDTO> findByNicsyncTrueAndRegnNoIn(List<String> prNoList,Pageable pageable);
}

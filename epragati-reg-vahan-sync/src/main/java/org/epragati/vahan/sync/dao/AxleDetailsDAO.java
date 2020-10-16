package org.epragati.vahan.sync.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.epragati.vahan.sync.dto.AxleDetailsDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface AxleDetailsDAO extends BaseRepository<AxleDetailsDTO, Serializable>{

	List<AxleDetailsDTO> findByRegnNoInAndNicsyncFalse(List<String> prNoList);
	List<AxleDetailsDTO> findByNicsyncTrueAndRegnNoInAndLUpdateLessThanEqual(List<String> prNoList,Date lupdate);

	List<AxleDetailsDTO> findByNicsyncTrueAndRegnNoIn(List<String> prNos,Pageable pageable);
}

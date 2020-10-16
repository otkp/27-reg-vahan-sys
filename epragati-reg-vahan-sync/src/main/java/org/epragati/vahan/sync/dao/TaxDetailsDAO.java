package org.epragati.vahan.sync.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.epragati.vahan.sync.dto.TaxDetailsDTO;
import org.springframework.data.domain.Pageable;

public interface TaxDetailsDAO extends BaseRepository<TaxDetailsDTO, Serializable>{

	List<TaxDetailsDTO> findByRegnNoInAndNicsyncFalse(List<String> prNoList);

	List<TaxDetailsDTO> findByNicsyncTrueAndRegnNoInAndLUpdateLessThanEqual(List<String> prNolistOw, Date todayDate);

	List<TaxDetailsDTO> findByNicsyncTrueAndRegnNoIn(List<String> prNos,Pageable pageable);
}

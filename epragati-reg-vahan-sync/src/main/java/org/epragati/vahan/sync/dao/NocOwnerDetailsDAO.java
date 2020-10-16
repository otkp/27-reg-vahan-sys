package org.epragati.vahan.sync.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.epragati.vahan.sync.dto.NocOwnerDetailsDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface NocOwnerDetailsDAO extends BaseRepository<NocOwnerDetailsDTO, Serializable>{

	List<NocOwnerDetailsDTO> findByRegnNoInAndNicsyncFalse(List<String> prNoList);

	List<NocOwnerDetailsDTO> findByNicsyncTrueAndRegnNoInAndLUpdateLessThanEqual(List<String> prNolistOwittNoc,
			Date todayDate);

}

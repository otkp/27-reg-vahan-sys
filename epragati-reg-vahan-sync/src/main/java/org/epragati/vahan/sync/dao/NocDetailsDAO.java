package org.epragati.vahan.sync.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.epragati.vahan.sync.dto.InsuranceDetailsDTO;
import org.epragati.vahan.sync.dto.NocDetailsDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface NocDetailsDAO extends BaseRepository<NocDetailsDTO, Serializable>{

	List<NocDetailsDTO> findByPrNoInAndNicsyncFalse(List<String> prNoList);

	List<NocDetailsDTO> findByNicsyncTrueAndPrNoInAndLUpdateLessThanEqual(List<String> prNoList,Date todayDate);

}

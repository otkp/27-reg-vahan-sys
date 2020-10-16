package org.epragati.vahan.sync.dao;

import java.io.Serializable;
import java.util.List;

import org.epragati.vahan.sync.dto.BlackListDetailsDTO;
import org.springframework.stereotype.Repository;
@Repository
public interface BlackListDetailsDAO extends BaseRepository<BlackListDetailsDTO, Serializable>{

	List<BlackListDetailsDTO> findByRegnNoInAndNicsyncFalse(List<String> prNoList);

	
	
	

}

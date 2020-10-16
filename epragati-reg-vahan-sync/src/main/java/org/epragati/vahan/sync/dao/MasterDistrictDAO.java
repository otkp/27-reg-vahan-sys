package org.epragati.vahan.sync.dao;

import java.io.Serializable;
import java.util.Optional;

import org.epragati.vahan.sync.dto.MasterDistrictDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MasterDistrictDAO extends JpaRepository<MasterDistrictDTO, Serializable>{
	
	Optional<MasterDistrictDTO> findByDescrAndStateCd(String districtName, String StateCode);

}

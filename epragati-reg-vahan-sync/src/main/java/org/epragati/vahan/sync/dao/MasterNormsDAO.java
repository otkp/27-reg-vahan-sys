package org.epragati.vahan.sync.dao;

import java.io.Serializable;
import java.util.Optional;

import org.epragati.vahan.sync.dto.MasterNormsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MasterNormsDAO extends JpaRepository<MasterNormsDTO, Serializable>{
	
	Optional<MasterNormsDTO> findByDescr(String norms);

}

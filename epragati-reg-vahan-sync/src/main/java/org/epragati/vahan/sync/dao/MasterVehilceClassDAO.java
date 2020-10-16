package org.epragati.vahan.sync.dao;

import java.io.Serializable;
import java.util.Optional;

import org.epragati.vahan.sync.dto.MasterVehilceClassDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MasterVehilceClassDAO extends JpaRepository<MasterVehilceClassDTO, Serializable>{

	
	Optional<MasterVehilceClassDTO> findByDescr(String cov);

	Optional<MasterVehilceClassDTO> findByDescrLike(String cov);
}

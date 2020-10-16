package org.epragati.vahan.sync.dao;

import java.io.Serializable;
import java.util.Optional;

import org.epragati.vahan.sync.dto.MasterMakerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterMakerDAO extends JpaRepository<MasterMakerDTO, Serializable>{

	Optional<MasterMakerDTO> findByDescr(String makerName);

	Optional<MasterMakerDTO> findByDescrLike(String makerName);
	
}

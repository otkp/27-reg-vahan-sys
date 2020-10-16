package org.epragati.vahan.sync.dao;

import java.io.Serializable;

import org.epragati.vahan.sync.dto.MasterBodyDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MasterBodyDAO extends JpaRepository<MasterBodyDTO, Serializable>{

}

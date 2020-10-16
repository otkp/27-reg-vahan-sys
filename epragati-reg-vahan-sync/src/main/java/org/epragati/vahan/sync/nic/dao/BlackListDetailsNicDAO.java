package org.epragati.vahan.sync.nic.dao;

import java.io.Serializable;

import org.epragati.vahan.sync.dao.BaseRepository;
import org.epragati.vahan.sync.nic.dto.BlackListDetailsNicDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface BlackListDetailsNicDAO extends BaseRepository<BlackListDetailsNicDTO, Serializable>{

}

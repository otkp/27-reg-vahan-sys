package org.epragati.vahan.sync.dao;

import java.io.Serializable;

import org.epragati.vahan.sync.dto.ErrorTrackLogVahanSyncDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface ErrorTrackLogVahanSyncDAO extends BaseRepository<ErrorTrackLogVahanSyncDTO, Serializable>{

}

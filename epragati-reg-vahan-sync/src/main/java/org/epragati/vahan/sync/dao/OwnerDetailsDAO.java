package org.epragati.vahan.sync.dao;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.epragati.vahan.sync.dto.OwnerDetailsDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerDetailsDAO extends BaseRepository<OwnerDetailsDTO, Serializable>{

	List<OwnerDetailsDTO> findByNicsyncFalseAndOffCd(Integer offcd,Pageable pageable);

	List<OwnerDetailsDTO> findByRegnNoInAndNicsyncFalse(List<String> prNoList);

	List<OwnerDetailsDTO> findByNicsyncFalseAndCDistrict(Integer offcd,Pageable pageable);

	@Query(value = "SELECT * FROM vahan4.vt_owner As r WHERE " +
	        "r.nicsync=true and r.lUpdate BETWEEN ?1 AND ?2 ", nativeQuery = true)
	public List<OwnerDetailsDTO> getOwnerDetails();
	
	List<OwnerDetailsDTO> findByLUpdateIsBetween(LocalDateTime lupdateFrom,LocalDateTime lupdateTo);
	
	List<OwnerDetailsDTO> findByNicsyncTrueAndLUpdateLessThanEqual(Date lupdate,Pageable pageable);
	
	@Query(value = "select regn_no from vahan4.vt_owner where nicsync =true and regn_no in(select regn_no from vahan4.vt_axle where nicsync = true "
			+ "and regn_no in(select regn_no from vahan4.vt_insurance where nicsync = true and regn_no in"
			+ "(select regn_no from vahan4.vt_tax where nicsync = true and regn_no in(select regn_no from vahan4.vt_fee where nicsync =true)))) limit 100", nativeQuery = true)
	public List<String> getOwnerDetailsNative();
	
	
	@Query(value = "select regn_no from vahan4.vt_owner where nicsync =true and hype = false and status ='A' and last_dt <CURRENT_TIMESTAMP and regn_no in(select regn_no from vahan4.vt_axle where nicsync = true"
			+ " and last_dt<CURRENT_TIMESTAMP and regn_no in(select regn_no from vahan4.vt_insurance where nicsync = true and last_dt< CURRENT_TIMESTAMP and regn_no in"
			+ "(select regn_no from vahan4.vt_tax where nicsync = true and last_dt<CURRENT_TIMESTAMP and regn_no in(select regn_no from vahan4.vt_fee where nicsync =true and last_dt<CURRENT_TIMESTAMP + interval '1 hour'))))limit 100", nativeQuery = true)
	public List<String> getOwnerDetailsNativeDate();
	
	List<OwnerDetailsDTO> findByNicsyncTrueAndRegnNoIn(List<String> prNos,Pageable pageable);
	
}

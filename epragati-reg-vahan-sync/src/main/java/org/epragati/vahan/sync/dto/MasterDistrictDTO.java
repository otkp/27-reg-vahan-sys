package org.epragati.vahan.sync.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "tm_district", schema = "vahan4")
public class MasterDistrictDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2372578047013761456L;
	
	@Id
	@Column(name ="dist_cd")
	private Integer distCd;
	
	@Column(name ="descr")
	private String descr;
	
	@Column(name ="state_cd")
	private String stateCd;

	public Integer getDistCd() {
		return distCd;
	}

	public void setDistCd(Integer distCd) {
		this.distCd = distCd;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getStateCd() {
		return stateCd;
	}

	public void setStateCd(String stateCd) {
		this.stateCd = stateCd;
	}
	
	
}

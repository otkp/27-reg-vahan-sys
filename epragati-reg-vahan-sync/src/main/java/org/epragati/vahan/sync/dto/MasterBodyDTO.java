package org.epragati.vahan.sync.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="vm_bd_type", schema = "vahan4")
public class MasterBodyDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8341496772950061807L;
	
	@Id
	@Column(name ="bd_type_code")
	private String bdTypeCode;
	
	@Column(name ="descr")
	private String descr;
	
	@Column(name ="state_cd")
	private String stateCd;

	public String getBdTypeCode() {
		return bdTypeCode;
	}

	public void setBdTypeCode(String bdTypeCode) {
		this.bdTypeCode = bdTypeCode;
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

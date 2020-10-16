package org.epragati.vahan.sync.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="vm_norms", schema = "vahan4")
public class MasterNormsDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1504388990074474232L;

	@Id
	@Column(name ="code")
	private Integer code;
	
	@Column(name ="descr")
	private String descr;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}
	
	
	
}

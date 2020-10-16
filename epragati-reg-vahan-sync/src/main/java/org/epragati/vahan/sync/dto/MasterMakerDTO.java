package org.epragati.vahan.sync.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="vm_maker", schema = "vahan4")
public class MasterMakerDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5336390760773656157L;
	
	@Id
	@Column(name ="code")
	private Integer code;
	
	
	@Column(name ="descr")
	private String descr;
	
	@Column(name ="show_in_rto")
	private Boolean showInRto;

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

	public Boolean getShowInRto() {
		return showInRto;
	}

	public void setShowInRto(Boolean showInRto) {
		this.showInRto = showInRto;
	}
	
	

}

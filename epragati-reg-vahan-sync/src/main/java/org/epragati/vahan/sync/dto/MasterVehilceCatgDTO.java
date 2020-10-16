package org.epragati.vahan.sync.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name ="vm_vch_catg", schema = "vahan4")
public class MasterVehilceCatgDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6090308701313571235L;

	@Id
	@Column(name ="catg")
	private Integer catg;
	
	@Column(name ="catg_desc")
	private Integer catgDesc;

	public Integer getCatg() {
		return catg;
	}

	public void setCatg(Integer catg) {
		this.catg = catg;
	}

	public Integer getCatgDesc() {
		return catgDesc;
	}

	public void setCatgDesc(Integer catgDesc) {
		this.catgDesc = catgDesc;
	}
	
	
	
}

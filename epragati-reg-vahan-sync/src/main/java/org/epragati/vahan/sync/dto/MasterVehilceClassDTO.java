package org.epragati.vahan.sync.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name ="vm_vh_class", schema = "vahan4")
public class MasterVehilceClassDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 628715451507906944L;

	
	@Id
	@Column(name ="vh_class")
	private Integer vhClass;
	
	@Column(name ="descr")
	private String descr;
	
	@Column(name ="class_type")
	private Integer classType;
	
	@Column(name ="transport_catg")
	private String transportCatg;
	
	@Column(name ="convertible_classes")
	private String convertibleClasses;

	public Integer getVhClass() {
		return vhClass;
	}

	public void setVhClass(Integer vhClass) {
		this.vhClass = vhClass;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Integer getClassType() {
		return classType;
	}

	public void setClassType(Integer classType) {
		this.classType = classType;
	}

	public String getTransportCatg() {
		return transportCatg;
	}

	public void setTransportCatg(String transportCatg) {
		this.transportCatg = transportCatg;
	}

	public String getConvertibleClasses() {
		return convertibleClasses;
	}

	public void setConvertibleClasses(String convertibleClasses) {
		this.convertibleClasses = convertibleClasses;
	}
	
	
	
}

package org.epragati.vahan.sync.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class BlackListIDClass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2301603233270860282L;

	@Id
	@Column(name ="regn_no")
	private String regnNo;
	
	@Id
	@Column(name ="complain_dt")
	private Date complainDt;

	
	public BlackListIDClass() { }


	public BlackListIDClass(String regnNo, Date complainDt) {
		        this.complainDt = complainDt;
		        this.regnNo = regnNo;
		    }

	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(getRegnNo(),getComplainDt());
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BlackListIDClass other = (BlackListIDClass) obj;
		return Objects.equals(getComplainDt(), other.getComplainDt()) && 
				Objects.equals(getRegnNo(), other.getRegnNo());

	}
	
	
	
	
	
	
	
	/**
	 * @return the regnNo
	 */
	public String getRegnNo() {
		return regnNo;
	}

	/**
	 * @param regnNo the regnNo to set
	 */
	public void setRegnNo(String regnNo) {
		this.regnNo = regnNo;
	}

	/**
	 * @return the complainDt
	 */
	public Date getComplainDt() {
		return complainDt;
	}

	/**
	 * @param complainDt the complainDt to set
	 */
	public void setComplainDt(Date complainDt) {
		this.complainDt = complainDt;
	}
	
	
	
	
}

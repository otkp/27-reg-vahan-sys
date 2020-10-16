package org.epragati.vahan.sync.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class OwnerDetailsIDCLass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5797592006806828781L;
	
	@Id
	@Column(name ="state_cd")
	private String stateCd;
	
	@Id
	@Column(name ="off_cd")
	private Integer offCd;
	
	@Id
	@Column(name ="regn_no")
	private String regnNo;
	
	
	
	public OwnerDetailsIDCLass() { }


	public OwnerDetailsIDCLass(String stateCd, Integer offCd,String regnNo) {
		        this.stateCd = stateCd;
		        this.offCd = offCd;
		        this.regnNo = regnNo;
		    }


	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(getOffCd(), getRegnNo(),getStateCd());
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
		OwnerDetailsIDCLass other = (OwnerDetailsIDCLass) obj;
		return Objects.equals(getOffCd(), other.getOffCd()) && 
				Objects.equals(getRegnNo(), other.getRegnNo())&&
				Objects.equals(getStateCd(), other.getStateCd());

	}
	
	
	
	
	public String getStateCd() {
		return stateCd;
	}

	public void setStateCd(String stateCd) {
		this.stateCd = stateCd;
	}

	public Integer getOffCd() {
		return offCd;
	}

	public void setOffCd(Integer offCd) {
		this.offCd = offCd;
	}

	public String getRegnNo() {
		return regnNo;
	}

	public void setRegnNo(String regnNo) {
		this.regnNo = regnNo;
	}
	
	

}

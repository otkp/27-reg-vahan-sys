package org.epragati.vahan.sync.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Id;

public class FitnessIDClass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9207115893402158095L;
	
	@Id
	@Column(name ="state_cd")
	private String stateCd;
	@Id
	@Column(name ="off_cd")
	private Integer offCd;
	
	@Id
	@Column(name ="regn_no")
	private String regnNo;

	
	
	
	
	public FitnessIDClass() { }


	public FitnessIDClass(String stateCd, Integer offCd,String regnNo) {
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
		FitnessIDClass other = (FitnessIDClass) obj;
		return Objects.equals(getOffCd(), other.getOffCd()) && 
				Objects.equals(getRegnNo(), other.getRegnNo())&&
				Objects.equals(getStateCd(), other.getStateCd());

	}
	
	
	
	/**
	 * @return the stateCd
	 */
	public String getStateCd() {
		return stateCd;
	}

	/**
	 * @param stateCd the stateCd to set
	 */
	public void setStateCd(String stateCd) {
		this.stateCd = stateCd;
	}

	/**
	 * @return the offCd
	 */
	public Integer getOffCd() {
		return offCd;
	}

	/**
	 * @param offCd the offCd to set
	 */
	public void setOffCd(Integer offCd) {
		this.offCd = offCd;
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

	
	
	

}

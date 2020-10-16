package org.epragati.vahan.sync.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class FinancerIDCLass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -704241673032545966L;

	@Id
	@Column(name ="state_cd")
	private String stateCd;
	@Id
	@Column(name ="off_cd")
	private Integer offCd;
	
	@Id
	@Column(name ="regn_no")
	private String regnNo;
	
	@Id
	@Column(name ="sr_no")
	private Integer srNo;

	
	
	public FinancerIDCLass() { }


	public FinancerIDCLass(String stateCd, Integer offCd,String regnNo,Integer srNo) {
		        this.stateCd = stateCd;
		        this.offCd = offCd;
		        this.regnNo = regnNo;
		        this.srNo = srNo;
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
		FinancerIDCLass other = (FinancerIDCLass) obj;
		return Objects.equals(getOffCd(), other.getOffCd()) && 
				Objects.equals(getRegnNo(), other.getRegnNo())&&
				Objects.equals(getStateCd(), other.getStateCd())&&
				Objects.equals(getSrNo(),other.getSrNo());

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

	/**
	 * @return the srNo
	 */
	public Integer getSrNo() {
		return srNo;
	}

	/**
	 * @param srNo the srNo to set
	 */
	public void setSrNo(Integer srNo) {
		this.srNo = srNo;
	}
	
	
}

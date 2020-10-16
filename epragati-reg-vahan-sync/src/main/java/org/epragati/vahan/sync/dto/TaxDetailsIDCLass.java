package org.epragati.vahan.sync.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
@Embeddable
public class TaxDetailsIDCLass implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3964836814001442813L;
	
	
	@Id
	@Column(name ="regn_no")
	private String regnNo;
	
	@Id
	@Column(name ="state_cd")
	private String stateCd;
	
	@Id
	@Column(name ="off_cd")
	private Integer offCd;
	
	@Id
	@Column(name ="pur_cd")
	private Integer purCd;
	
	
	
	public TaxDetailsIDCLass() { }


	public TaxDetailsIDCLass(String stateCd, Integer offCd,String regnNo,Integer purCd) {
		        this.stateCd = stateCd;
		        this.offCd = offCd;
		        this.regnNo = regnNo;
		        this.purCd = purCd;
		    }

	
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(getOffCd(), getRegnNo(),getStateCd(),getPurCd());
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
		TaxDetailsIDCLass other = (TaxDetailsIDCLass) obj;
		return Objects.equals(getOffCd(), other.getOffCd()) && 
				Objects.equals(getRegnNo(), other.getRegnNo())&&
				Objects.equals(getStateCd(), other.getStateCd())&&
				Objects.equals(getPurCd(), other.getPurCd());

	}
	
	
	
	
	public String getRegnNo() {
		return regnNo;
	}

	public void setRegnNo(String regnNo) {
		this.regnNo = regnNo;
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

	public Integer getPurCd() {
		return purCd;
	}

	public void setPurCd(Integer purCd) {
		this.purCd = purCd;
	}
	
	

}

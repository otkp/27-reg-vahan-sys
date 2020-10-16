package org.epragati.vahan.sync.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class FeeDetailsIDCLass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4562761411408798260L;

	@Id
	@Column(name ="state_cd")
	private String stateCd;
	
	@Id
	@Column(name ="off_cd")
	private Integer offCd;
	
	@Id
	@Column(name ="rcpt_no")
	private String rcptNo;
	
	@Id
	@Column(name ="pur_cd")
	private Integer purCd;

	
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(getOffCd(), getRcptNo(),getStateCd(),getPurCd());
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
		FeeDetailsIDCLass other = (FeeDetailsIDCLass) obj;
		return Objects.equals(getOffCd(), other.getOffCd()) && 
				Objects.equals(getRcptNo(), other.getRcptNo())&&
				Objects.equals(getStateCd(), other.getStateCd())&&
				Objects.equals(getPurCd(), other.getPurCd());

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
	 * @return the rcptNo
	 */
	public String getRcptNo() {
		return rcptNo;
	}

	/**
	 * @param rcptNo the rcptNo to set
	 */
	public void setRcptNo(String rcptNo) {
		this.rcptNo = rcptNo;
	}

	/**
	 * @return the purCd
	 */
	public Integer getPurCd() {
		return purCd;
	}

	/**
	 * @param purCd the purCd to set
	 */
	public void setPurCd(Integer purCd) {
		this.purCd = purCd;
	}
	
	
	
}

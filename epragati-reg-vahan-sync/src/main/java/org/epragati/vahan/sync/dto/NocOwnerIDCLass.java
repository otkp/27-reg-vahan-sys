package org.epragati.vahan.sync.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class NocOwnerIDCLass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7598284021700727426L;
	
	@Id
	@Column(name ="regn_no")
	private String regnNo;
	
	@Id
	@Column(name ="state_cd")
	private String stateCd;
	
	@Id
	@Column(name ="rto_cd")
	private String rtoCd;
	
	
	public NocOwnerIDCLass() { }
	
	public NocOwnerIDCLass(String regnNo,String stateCd, String rtoCd){
		this.regnNo = regnNo;
		this.stateCd =stateCd;
		this.rtoCd = rtoCd;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(getRtoCd(), getRegnNo(),getStateCd());
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
		NocOwnerIDCLass other = (NocOwnerIDCLass) obj;
		return Objects.equals(getRtoCd(), other.getRtoCd()) && 
				Objects.equals(getRegnNo(), other.getRegnNo())&&
				Objects.equals(getStateCd(), other.getStateCd());

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
	 * @return the rtoCd
	 */
	public String getRtoCd() {
		return rtoCd;
	}

	/**
	 * @param rtoCd the rtoCd to set
	 */
	public void setRtoCd(String rtoCd) {
		this.rtoCd = rtoCd;
	}
	
	
	
	

}

package org.epragati.vahan.sync.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class ErrorTrackLogIDClass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9148753793750111950L;

	@Id
	@Column(name ="context")
	private String context;
	
	@Id
	@Column(name ="pr_no")
	private String pr_no;
	
	
	public ErrorTrackLogIDClass() { }


	public ErrorTrackLogIDClass(String context,String prNo) {
		        this.context = context;
		        this.pr_no = prNo;
		    }

	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(getContext(),getPr_no());
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
		ErrorTrackLogIDClass other = (ErrorTrackLogIDClass) obj;
		return Objects.equals(getPr_no(), other.getPr_no())&&
				Objects.equals(getContext(), other.getContext());
	}
	
	public String getContext() {
		return context;
	}


	public void setContext(String context) {
		this.context = context;
	}


	public String getPr_no() {
		return pr_no;
	}


	public void setPr_no(String pr_no) {
		this.pr_no = pr_no;
	}


	
}

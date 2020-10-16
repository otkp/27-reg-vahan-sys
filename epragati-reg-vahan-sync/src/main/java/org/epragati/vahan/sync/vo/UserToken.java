package org.epragati.vahan.sync.vo;

import java.io.Serializable;

public class UserToken implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5163452267239147809L;

	
	private String username;
	
	private String password;
	
	private Boolean isUidsStatus;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsUidsStatus() {
		return isUidsStatus;
	}

	public void setIsUidsStatus(Boolean isUidsStatus) {
		this.isUidsStatus = isUidsStatus;
	}
	
	
	
}

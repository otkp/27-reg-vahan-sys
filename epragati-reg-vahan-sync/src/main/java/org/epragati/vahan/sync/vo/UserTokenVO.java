package org.epragati.vahan.sync.vo;

import java.io.Serializable;
import java.util.List;

public class UserTokenVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1707741386868255566L;

	private String id;
	private String firstname;
	private String lastname;
	private String primaryRole;
	private List<String> additionalRoles;
	private String token;
	private String officeCode;
	private boolean isPasswordResetRequired;
	private String parentUserId;
	private boolean isParent;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPrimaryRole() {
		return primaryRole;
	}
	public void setPrimaryRole(String primaryRole) {
		this.primaryRole = primaryRole;
	}
	public List<String> getAdditionalRoles() {
		return additionalRoles;
	}
	public void setAdditionalRoles(List<String> additionalRoles) {
		this.additionalRoles = additionalRoles;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getOfficeCode() {
		return officeCode;
	}
	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}
	public boolean isPasswordResetRequired() {
		return isPasswordResetRequired;
	}
	public void setPasswordResetRequired(boolean isPasswordResetRequired) {
		this.isPasswordResetRequired = isPasswordResetRequired;
	}
	public String getParentUserId() {
		return parentUserId;
	}
	public void setParentUserId(String parentUserId) {
		this.parentUserId = parentUserId;
	}
	public boolean isParent() {
		return isParent;
	}
	public void setParent(boolean isParent) {
		this.isParent = isParent;
	}
	
	
}

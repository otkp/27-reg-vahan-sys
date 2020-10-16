package org.epragati.vahan.sync.vo;

import java.io.Serializable;

public class UserTokenResponceVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5801836581095616343L;
	//private Boolean status;
	
	private String status;

	private String httpStatus;

	private String message;

	private String errors;

	private String fieldErrors;
	
	private UserTokenVO result;
	
	

	public UserTokenVO getResult() {
		return result;
	}

	public void setResult(UserTokenVO result) {
		this.result = result;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrors() {
		return errors;
	}

	public void setErrors(String errors) {
		this.errors = errors;
	}

	public String getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(String fieldErrors) {
		this.fieldErrors = fieldErrors;
	}
	
	
	
}

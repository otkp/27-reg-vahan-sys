package org.epragati.vahan.sync.vo;

import java.util.List;

public class VahanSyncResponceVO {

	
	private String status;

	private String httpStatus;

	private String message;

	private String errors;

	private String fieldErrors;

	private List<RegVahanPortVO> result;

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

	public List<RegVahanPortVO> getResult() {
		return result;
	}

	public void setResult(List<RegVahanPortVO> result) {
		this.result = result;
	}
	
	
	
	
}

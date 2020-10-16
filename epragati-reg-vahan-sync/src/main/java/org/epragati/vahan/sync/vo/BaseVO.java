package org.epragati.vahan.sync.vo;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BaseVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String createdBy;
	private String modifiedBy;
	private String updatedBy;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	private LocalDateTime createdDate;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	private LocalDateTime modifiedDate;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	private LocalDateTime lUpdate;
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		if(createdDate!=null){
			this.createdDate = null;
		}
	}
	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(LocalDateTime modifiedDate) {
		if(modifiedDate!=null){
			this.modifiedDate = null;
		}
		
	}
	public LocalDateTime getlUpdate() {
		return lUpdate;
	}
	public void setlUpdate(LocalDateTime lUpdate) {
		if(lUpdate!=null){
			this.lUpdate = null;
		}
	}
	
}

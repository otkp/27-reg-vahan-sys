package org.epragati.vahan.sync.dto;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "error_logs", schema = "vahan4")
@IdClass(ErrorTrackLogIDClass.class)
public class ErrorTrackLogVahanSyncDTO {
	
	
	@UpdateTimestamp
	@Temporal(value= TemporalType.TIMESTAMP)
	@Column(name ="created_dt",nullable =false)
	private Date created_dt;
	
	@Column(name ="error")
	private String error;
	
	@Id
	@Column(name ="pr_no")
	private String pr_no;
	
	@Id
	@Column(name ="context")
	private String context;
	
	@Column(name ="module_code")
	private String module_code;
	
	@Column(name ="fixed")
	private boolean fixed;
	
	public ErrorTrackLogVahanSyncDTO() {
	}

	public ErrorTrackLogVahanSyncDTO(ErrorTrackLogIDClass errorTrackLogIDClass) {
		context = errorTrackLogIDClass.getContext();
		pr_no = errorTrackLogIDClass.getPr_no();
	}

	@Id
	@AttributeOverrides({ @AttributeOverride(name = "pr_no", column = @Column(name = "pr_no")),
			@AttributeOverride(name = "context", column = @Column(name = "context"))
			 })
	
	
	
	
	public String getError() {
		return error;
	}
	public Date getCreated_dt() {
		return created_dt;
	}

	public void setCreated_dt(Date created_dt) {
		this.created_dt = created_dt;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	public String getPr_no() {
		return pr_no;
	}

	public void setPr_no(String pr_no) {
		this.pr_no = pr_no;
	}

	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	
	public String getModule_code() {
		return module_code;
	}

	public void setModule_code(String module_code) {
		this.module_code = module_code;
	}

	public boolean isFixed() {
		return fixed;
	}
	public void setFixed(boolean fixed) {
		this.fixed = fixed;
	}
	
}

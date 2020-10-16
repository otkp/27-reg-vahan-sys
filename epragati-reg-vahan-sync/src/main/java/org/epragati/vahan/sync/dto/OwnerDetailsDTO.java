package org.epragati.vahan.sync.dto;

import java.io.Serializable;
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
@Table(name = "vt_owner", schema = "vahan4")
@IdClass(OwnerDetailsIDCLass.class)
public class OwnerDetailsDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7916185876532078232L;

	@Id
	@Column(name ="state_cd")
	private String stateCd;
	
	@Id
	@Column(name ="off_cd")
	private Integer offCd;
	
	@Id
	@Column(name ="regn_no")
	private String regnNo;
	
	public OwnerDetailsDTO() { }
	
	public OwnerDetailsDTO(OwnerDetailsIDCLass ownerDetailsIDCLass) { 
		offCd = ownerDetailsIDCLass.getOffCd();
		regnNo = ownerDetailsIDCLass.getRegnNo();
		stateCd = ownerDetailsIDCLass.getStateCd();
		    }

	
	@Id
	@AttributeOverrides({
		@AttributeOverride(name = "regn_no",column = @Column(name="regn_no")),
		@AttributeOverride(name = "off_cd", column = @Column(name="off_cd")),
		@AttributeOverride(name = "state_cd", column = @Column(name="state_cd"))
	})

	
	
	@Column(name ="regn_dt")
	private Date regnDt;
	
	@Column(name ="purchase_dt")
	private Date purchaseDt;
	
	@Column(name ="owner_sr")
	private Integer ownerSr;
	
	@Column(name ="owner_name")
	private String ownerName;
	
	@Column(name ="f_name")
	private String fName;
	
	@Column(name ="c_add1")
	private String cAdd1;
	
	@Column(name ="c_add2")
	private String cAdd2;
	
	@Column(name ="c_add3")
	private String cAdd3;
	
	@Column(name ="c_district")
	private Integer cDistrict;
	
	@Column(name ="c_pincode")
	private Integer cPincode;
	
	@Column(name ="c_state")
	private String cState;
	
	@Column(name ="p_add1")
	private String pAdd1;
	
	@Column(name ="p_add2")
	private String pAdd2;
	
	@Column(name ="p_add3")
	private String pAdd3;
	
	@Column(name ="p_district")
	private Integer pDistrict;
	
	@Column(name ="p_pincode")
	private Integer pPincode;
	
	@Column(name ="p_state")
	private String pState;
	
	@Column(name ="owner_cd")
	private Integer ownerCd;
	
	@Column(name ="regn_type")
	private Character regnType;
	@Column(name ="vh_class")
	private Integer vhClass;
	
	@Column(name ="chasi_no")
	private String chasiNo;
	
	@Column(name ="eng_no")
	private String engNo;
	
	@Column(name ="maker")
	private Integer maker;
	@Column(name ="maker_model")
	private String makerModel;
	
	@Column(name ="body_type")
	private String bodyType;
	
	@Column(name ="no_cyl")
	private Integer noCyl;
	
	@Column(name ="hp")
	private Integer hp;
	
	@Column(name ="seat_cap")
	private Integer seatCap;
	
	@Column(name ="unld_wt")
	private Integer unldWt;
	
	@Column(name ="ld_wt")
	private Integer ldWt;
	@Column(name ="gcw")
	private Integer gcw;
	@Column(name ="fuel")
	private Integer fuel;
	@Column(name ="color")
	private String color;
	@Column(name ="manu_mon")
	private Integer manuMon;
	@Column(name ="manu_yr")
	private Integer manuYr;
	
	@Column(name ="norms")
	private Integer norms;
	@Column(name ="ac_fitted")
	private Character acFitted;
	@Column(name ="audio_fitted")
	private Character audioFitted;
	@Column(name ="video_fitted")
	private Character  videoFitted;
	@Column(name ="vch_catg")
	private String vchCatg;
	@Column(name ="dealer_cd")
	private String dealerCd;
	
	@Column(name ="sale_amt")
	private Integer saleAmt;
	@Column(name ="regn_upto")
	private Date regnUpto;
	@Column(name ="fit_upto")
	private Date fitUpto;
	@Column(name ="imported_vch")
	private Character importedVch;
	@Column(name ="status")
	private Character status;
	@Column(name ="op_dt")
	private Date opDt;
	
	@Column(name ="nicsync")
	private boolean nicsync;
	 
	@UpdateTimestamp
	@Temporal(value= TemporalType.TIMESTAMP)
	@Column(name ="last_dt", nullable = false)
	private Date lUpdate;

	@Column(name ="hype")
	private Boolean Hype;
	

	/**
	 * @return the hype
	 */
	public Boolean getHype() {
		return Hype;
	}

	/**
	 * @param hype the hype to set
	 */
	public void setHype(Boolean hype) {
		Hype = hype;
	}

	/**
	 * @return the lUpdate
	 */
	public Date getlUpdate() {
		return lUpdate;
	}

	/**
	 * @param lUpdate the lUpdate to set
	 */
	public void setlUpdate(Date lUpdate) {
		this.lUpdate = lUpdate;
	}

	/**
	 * @return the nicsync
	 */
	public boolean isNicsync() {
		return nicsync;
	}

	/**
	 * @param nicsync the nicsync to set
	 */
	public void setNicsync(boolean nicsync) {
		this.nicsync = nicsync;
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
	public String getRegnNo() {
		return regnNo;
	}
	public void setRegnNo(String regnNo) {
		this.regnNo = regnNo;
	}
	public Date getRegnDt() {
		return regnDt;
	}
	public void setRegnDt(Date regnDt) {
		this.regnDt = regnDt;
	}
	public Date getPurchaseDt() {
		return purchaseDt;
	}
	public void setPurchaseDt(Date purchaseDt) {
		this.purchaseDt = purchaseDt;
	}
	public Integer getOwnerSr() {
		return ownerSr;
	}
	public void setOwnerSr(Integer ownerSr) {
		this.ownerSr = ownerSr;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getcAdd1() {
		return cAdd1;
	}
	public void setcAdd1(String cAdd1) {
		this.cAdd1 = cAdd1;
	}
	public String getcAdd2() {
		return cAdd2;
	}
	public void setcAdd2(String cAdd2) {
		this.cAdd2 = cAdd2;
	}
	public String getcAdd3() {
		return cAdd3;
	}
	public void setcAdd3(String cAdd3) {
		this.cAdd3 = cAdd3;
	}
	public Integer getcDistrict() {
		return cDistrict;
	}
	public void setcDistrict(Integer cDistrict) {
		this.cDistrict = cDistrict;
	}
	public Integer getcPincode() {
		return cPincode;
	}
	public void setcPincode(Integer cPincode) {
		this.cPincode = cPincode;
	}
	public String getcState() {
		return cState;
	}
	public void setcState(String cState) {
		this.cState = cState;
	}
	public String getpAdd1() {
		return pAdd1;
	}
	public void setpAdd1(String pAdd1) {
		this.pAdd1 = pAdd1;
	}
	public Integer getpDistrict() {
		return pDistrict;
	}
	public void setpDistrict(Integer pDistrict) {
		this.pDistrict = pDistrict;
	}
	public Integer getpPincode() {
		return pPincode;
	}
	public void setpPincode(Integer pPincode) {
		this.pPincode = pPincode;
	}
	public String getpState() {
		return pState;
	}
	public void setpState(String pState) {
		this.pState = pState;
	}
	public Integer getOwnerCd() {
		return ownerCd;
	}
	public void setOwnerCd(Integer ownerCd) {
		this.ownerCd = ownerCd;
	}
	public Character getRegnType() {
		return regnType;
	}
	public void setRegnType(Character regnType) {
		this.regnType = regnType;
	}
	public Integer getVhClass() {
		return vhClass;
	}
	public void setVhClass(Integer vhClass) {
		this.vhClass = vhClass;
	}
	public String getChasiNo() {
		return chasiNo;
	}
	public void setChasiNo(String chasiNo) {
		this.chasiNo = chasiNo;
	}
	public String getEngNo() {
		return engNo;
	}
	public void setEngNo(String engNo) {
		this.engNo = engNo;
	}
	public Integer getMaker() {
		return maker;
	}
	public void setMaker(Integer maker) {
		this.maker = maker;
	}
	public String getMakerModel() {
		return makerModel;
	}
	public void setMakerModel(String makerModel) {
		this.makerModel = makerModel;
	}
	public String getBodyType() {
		return bodyType;
	}
	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}
	public Integer getNoCyl() {
		return noCyl;
	}
	public void setNoCyl(Integer noCyl) {
		this.noCyl = noCyl;
	}
	public Integer getHp() {
		return hp;
	}
	public void setHp(Integer hp) {
		this.hp = hp;
	}
	public Integer getSeatCap() {
		return seatCap;
	}
	public void setSeatCap(Integer seatCap) {
		this.seatCap = seatCap;
	}
	public Integer getUnldWt() {
		return unldWt;
	}
	public void setUnldWt(Integer unldWt) {
		this.unldWt = unldWt;
	}
	public Integer getLdWt() {
		return ldWt;
	}
	public void setLdWt(Integer ldWt) {
		this.ldWt = ldWt;
	}
	public Integer getGcw() {
		return gcw;
	}
	public void setGcw(Integer gcw) {
		this.gcw = gcw;
	}
	public Integer getFuel() {
		return fuel;
	}
	public void setFuel(Integer fuel) {
		this.fuel = fuel;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Integer getManuMon() {
		return manuMon;
	}
	public void setManuMon(Integer manuMon) {
		this.manuMon = manuMon;
	}
	public Integer getManuYr() {
		return manuYr;
	}
	public void setManuYr(Integer manuYr) {
		this.manuYr = manuYr;
	}
	public Integer getNorms() {
		return norms;
	}
	public void setNorms(Integer norms) {
		this.norms = norms;
	}
	public Character getAcFitted() {
		return acFitted;
	}
	public void setAcFitted(Character acFitted) {
		this.acFitted = acFitted;
	}
	public Character getAudioFitted() {
		return audioFitted;
	}
	public void setAudioFitted(Character audioFitted) {
		this.audioFitted = audioFitted;
	}
	public Character getVideoFitted() {
		return videoFitted;
	}
	public void setVideoFitted(Character videoFitted) {
		this.videoFitted = videoFitted;
	}
	public String getVchCatg() {
		return vchCatg;
	}
	public void setVchCatg(String vchCatg) {
		this.vchCatg = vchCatg;
	}
	public String getDealerCd() {
		return dealerCd;
	}
	public void setDealerCd(String dealerCd) {
		this.dealerCd = dealerCd;
	}
	public Integer getSaleAmt() {
		return saleAmt;
	}
	public void setSaleAmt(Integer saleAmt) {
		this.saleAmt = saleAmt;
	}
	public Date getRegnUpto() {
		return regnUpto;
	}
	public void setRegnUpto(Date regnUpto) {
		this.regnUpto = regnUpto;
	}
	public Date getFitUpto() {
		return fitUpto;
	}
	public void setFitUpto(Date fitUpto) {
		this.fitUpto = fitUpto;
	}
	public Character getImportedVch() {
		return importedVch;
	}
	public void setImportedVch(Character importedVch) {
		this.importedVch = importedVch;
	}
	public Character getStatus() {
		return status;
	}
	public void setStatus(Character status) {
		this.status = status;
	}
	public Date getOpDt() {
		return opDt;
	}
	public void setOpDt(Date opDt) {
		this.opDt = opDt;
	}

	public String getpAdd2() {
		return pAdd2;
	}

	public void setpAdd2(String pAdd2) {
		this.pAdd2 = pAdd2;
	}

	public String getpAdd3() {
		return pAdd3;
	}

	public void setpAdd3(String pAdd3) {
		this.pAdd3 = pAdd3;
	}

}

package org.epragati.vahan.sync.nic.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.epragati.vahan.sync.dto.NocOwnerIDCLass;
import org.epragati.vahan.sync.dto.OwnerDetailsIDCLass;
@Entity
@Table(name ="vt_owner_noc", schema ="vahan4")
@IdClass(NocOwnerIDCLass.class)
public class NocOwnerDetailsNicDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1124527055178131235L;

	@Id
	@Column(name ="regn_no")
	private String regnNo;
	
	@Id
	@Column(name ="state_cd")
	private String stateCd;
	
	@Id
	@Column(name ="rto_cd")
	private String rtoCd;
	
	
	public NocOwnerDetailsNicDTO() { }
	
	public NocOwnerDetailsNicDTO(NocOwnerIDCLass nocOwnerIDCLass) { 
		rtoCd = nocOwnerIDCLass.getRtoCd();
		regnNo = nocOwnerIDCLass.getRegnNo();
		stateCd = nocOwnerIDCLass.getStateCd();
		    }

	
	@Id
	@AttributeOverrides({
		@AttributeOverride(name = "regn_no",column = @Column(name="regn_no")),
		@AttributeOverride(name = "rtoCd", column = @Column(name="rtoCd")),
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
	
	@Column(name ="pan_no")
	private String panNo;
	
	@Column(name ="f_name")
	private String fName;
	
	@Column(name ="c_add1")
	private String cAdd1;
	
	@Column(name ="c_add2")
	private String cAdd2;
	
	
	@Column(name ="c_city")
	private String cCity;
	
	@Column(name ="c_district")
	private String cDistrict;
	
	@Column(name ="c_pincode")
	private String cPincode;
	
	@Column(name ="p_add1")
	private String pAdd1;
	
	@Column(name ="p_add2")
	private String pAdd2;
	
	@Column(name ="p_city")
	private String pCity;
	
	@Column(name ="p_district")
	private String pDistrict;
	
	@Column(name ="p_pincode")
	private String pPincode;
	
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
	private String hp;
	
	@Column(name ="seat_cap")
	private Integer seatCap;
	
	@Column(name ="unld_wt")
	private Integer unldWt;
	
	@Column(name ="ld_wt")
	private Integer ldWt;
	
	@Column(name ="fuel")
	private Integer fuel;
	
	@Column(name ="color")
	private String color;
	
	@Column(name ="manu_mon")
	private Integer manuMon;
	
	@Column(name ="manu_yr")
	private Integer manuYr;
	
	@Column(name ="fit_dt")
	private Date fitDt;
	
	@Column(name ="norms")
	private Integer norms;
	
	@Column(name ="wheelbase")
	private String wheelbase;
	
	@Column(name ="cubic_cap")
	private String cubicCap;
	
	@Column(name ="ac_fitted")
	private Character acFitted;
	
	@Column(name ="audio_fitted")
	private Character audioFitted;
	
	@Column(name ="video_fitted")
	private Character videoFitted;
	
	@Column(name ="vch_purchase_as")
	private Character vchPurchaseAs;
	
	@Column(name ="vch_catg")
	private String vchCatg;
	
	@Column(name ="dealer_cd")
	private Integer dealerCd;
	
	@Column(name ="tax_opt")
	private String taxOpt;
	
	@Column(name ="atax_opt")
	private String ataxOpt;
	
	@Column(name="pvt_com")
	private String pvtCom;
	
	@Column(name ="sale_amt")
	private Integer saleAmt;
	
	@Column(name ="laser_code")
	private String laserCode;
	
	@Column(name ="op_dt")
	private Date opDt;
	
	@Column(name ="rcpt_no")
	private String rcptNo;
	
	@Column(name ="garage_add")
	private String garageAdd;

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

	/**
	 * @return the regnDt
	 */
	public Date getRegnDt() {
		return regnDt;
	}

	/**
	 * @param regnDt the regnDt to set
	 */
	public void setRegnDt(Date regnDt) {
		this.regnDt = regnDt;
	}

	/**
	 * @return the purchaseDt
	 */
	public Date getPurchaseDt() {
		return purchaseDt;
	}

	/**
	 * @param purchaseDt the purchaseDt to set
	 */
	public void setPurchaseDt(Date purchaseDt) {
		this.purchaseDt = purchaseDt;
	}

	/**
	 * @return the ownerSr
	 */
	public Integer getOwnerSr() {
		return ownerSr;
	}

	/**
	 * @param ownerSr the ownerSr to set
	 */
	public void setOwnerSr(Integer ownerSr) {
		this.ownerSr = ownerSr;
	}

	/**
	 * @return the ownerName
	 */
	public String getOwnerName() {
		return ownerName;
	}

	/**
	 * @param ownerName the ownerName to set
	 */
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	/**
	 * @return the panNo
	 */
	public String getPanNo() {
		return panNo;
	}

	/**
	 * @param panNo the panNo to set
	 */
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	/**
	 * @return the fName
	 */
	public String getfName() {
		return fName;
	}

	/**
	 * @param fName the fName to set
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}

	/**
	 * @return the cAdd1
	 */
	public String getcAdd1() {
		return cAdd1;
	}

	/**
	 * @param cAdd1 the cAdd1 to set
	 */
	public void setcAdd1(String cAdd1) {
		this.cAdd1 = cAdd1;
	}

	/**
	 * @return the cAdd2
	 */
	public String getcAdd2() {
		return cAdd2;
	}

	/**
	 * @param cAdd2 the cAdd2 to set
	 */
	public void setcAdd2(String cAdd2) {
		this.cAdd2 = cAdd2;
	}

	/**
	 * @return the cCity
	 */
	public String getcCity() {
		return cCity;
	}

	/**
	 * @param cCity the cCity to set
	 */
	public void setcCity(String cCity) {
		this.cCity = cCity;
	}

	/**
	 * @return the cDistrict
	 */
	public String getcDistrict() {
		return cDistrict;
	}

	/**
	 * @param cDistrict the cDistrict to set
	 */
	public void setcDistrict(String cDistrict) {
		this.cDistrict = cDistrict;
	}

	/**
	 * @return the cPincode
	 */
	public String getcPincode() {
		return cPincode;
	}

	/**
	 * @param cPincode the cPincode to set
	 */
	public void setcPincode(String cPincode) {
		this.cPincode = cPincode;
	}

	/**
	 * @return the pAdd1
	 */
	public String getpAdd1() {
		return pAdd1;
	}

	/**
	 * @param pAdd1 the pAdd1 to set
	 */
	public void setpAdd1(String pAdd1) {
		this.pAdd1 = pAdd1;
	}

	/**
	 * @return the pAdd2
	 */
	public String getpAdd2() {
		return pAdd2;
	}

	/**
	 * @param pAdd2 the pAdd2 to set
	 */
	public void setpAdd2(String pAdd2) {
		this.pAdd2 = pAdd2;
	}

	/**
	 * @return the pCity
	 */
	public String getpCity() {
		return pCity;
	}

	/**
	 * @param pCity the pCity to set
	 */
	public void setpCity(String pCity) {
		this.pCity = pCity;
	}

	/**
	 * @return the pDistrict
	 */
	public String getpDistrict() {
		return pDistrict;
	}

	/**
	 * @param pDistrict the pDistrict to set
	 */
	public void setpDistrict(String pDistrict) {
		this.pDistrict = pDistrict;
	}

	/**
	 * @return the pPincode
	 */
	public String getpPincode() {
		return pPincode;
	}

	/**
	 * @param pPincode the pPincode to set
	 */
	public void setpPincode(String pPincode) {
		this.pPincode = pPincode;
	}

	/**
	 * @return the ownerCd
	 */
	public Integer getOwnerCd() {
		return ownerCd;
	}

	/**
	 * @param ownerCd the ownerCd to set
	 */
	public void setOwnerCd(Integer ownerCd) {
		this.ownerCd = ownerCd;
	}

	/**
	 * @return the regnType
	 */
	public Character getRegnType() {
		return regnType;
	}

	/**
	 * @param regnType the regnType to set
	 */
	public void setRegnType(Character regnType) {
		this.regnType = regnType;
	}

	/**
	 * @return the vhClass
	 */
	public Integer getVhClass() {
		return vhClass;
	}

	/**
	 * @param vhClass the vhClass to set
	 */
	public void setVhClass(Integer vhClass) {
		this.vhClass = vhClass;
	}

	/**
	 * @return the chasiNo
	 */
	public String getChasiNo() {
		return chasiNo;
	}

	/**
	 * @param chasiNo the chasiNo to set
	 */
	public void setChasiNo(String chasiNo) {
		this.chasiNo = chasiNo;
	}

	/**
	 * @return the engNo
	 */
	public String getEngNo() {
		return engNo;
	}

	/**
	 * @param engNo the engNo to set
	 */
	public void setEngNo(String engNo) {
		this.engNo = engNo;
	}

	/**
	 * @return the maker
	 */
	public Integer getMaker() {
		return maker;
	}

	/**
	 * @param maker the maker to set
	 */
	public void setMaker(Integer maker) {
		this.maker = maker;
	}

	/**
	 * @return the makerModel
	 */
	public String getMakerModel() {
		return makerModel;
	}

	/**
	 * @param makerModel the makerModel to set
	 */
	public void setMakerModel(String makerModel) {
		this.makerModel = makerModel;
	}

	/**
	 * @return the bodyType
	 */
	public String getBodyType() {
		return bodyType;
	}

	/**
	 * @param bodyType the bodyType to set
	 */
	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}

	/**
	 * @return the noCyl
	 */
	public Integer getNoCyl() {
		return noCyl;
	}

	/**
	 * @param noCyl the noCyl to set
	 */
	public void setNoCyl(Integer noCyl) {
		this.noCyl = noCyl;
	}

	/**
	 * @return the hp
	 */
	public String getHp() {
		return hp;
	}

	/**
	 * @param hp the hp to set
	 */
	public void setHp(String hp) {
		this.hp = hp;
	}

	/**
	 * @return the seatCap
	 */
	public Integer getSeatCap() {
		return seatCap;
	}

	/**
	 * @param seatCap the seatCap to set
	 */
	public void setSeatCap(Integer seatCap) {
		this.seatCap = seatCap;
	}

	/**
	 * @return the unldWt
	 */
	public Integer getUnldWt() {
		return unldWt;
	}

	/**
	 * @param unldWt the unldWt to set
	 */
	public void setUnldWt(Integer unldWt) {
		this.unldWt = unldWt;
	}

	/**
	 * @return the ldWt
	 */
	public Integer getLdWt() {
		return ldWt;
	}

	/**
	 * @param ldWt the ldWt to set
	 */
	public void setLdWt(Integer ldWt) {
		this.ldWt = ldWt;
	}

	/**
	 * @return the fuel
	 */
	public Integer getFuel() {
		return fuel;
	}

	/**
	 * @param fuel the fuel to set
	 */
	public void setFuel(Integer fuel) {
		this.fuel = fuel;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the manuMon
	 */
	public Integer getManuMon() {
		return manuMon;
	}

	/**
	 * @param manuMon the manuMon to set
	 */
	public void setManuMon(Integer manuMon) {
		this.manuMon = manuMon;
	}

	/**
	 * @return the manuYr
	 */
	public Integer getManuYr() {
		return manuYr;
	}

	/**
	 * @param manuYr the manuYr to set
	 */
	public void setManuYr(Integer manuYr) {
		this.manuYr = manuYr;
	}

	/**
	 * @return the fitDt
	 */
	public Date getFitDt() {
		return fitDt;
	}

	/**
	 * @param fitDt the fitDt to set
	 */
	public void setFitDt(Date fitDt) {
		this.fitDt = fitDt;
	}

	/**
	 * @return the norms
	 */
	public Integer getNorms() {
		return norms;
	}

	/**
	 * @param norms the norms to set
	 */
	public void setNorms(Integer norms) {
		this.norms = norms;
	}

	/**
	 * @return the wheelbase
	 */
	public String getWheelbase() {
		return wheelbase;
	}

	/**
	 * @param wheelbase the wheelbase to set
	 */
	public void setWheelbase(String wheelbase) {
		this.wheelbase = wheelbase;
	}

	/**
	 * @return the cubicCap
	 */
	public String getCubicCap() {
		return cubicCap;
	}

	/**
	 * @param cubicCap the cubicCap to set
	 */
	public void setCubicCap(String cubicCap) {
		this.cubicCap = cubicCap;
	}

	/**
	 * @return the acFitted
	 */
	public Character getAcFitted() {
		return acFitted;
	}

	/**
	 * @param acFitted the acFitted to set
	 */
	public void setAcFitted(Character acFitted) {
		this.acFitted = acFitted;
	}

	/**
	 * @return the audioFitted
	 */
	public Character getAudioFitted() {
		return audioFitted;
	}

	/**
	 * @param audioFitted the audioFitted to set
	 */
	public void setAudioFitted(Character audioFitted) {
		this.audioFitted = audioFitted;
	}

	/**
	 * @return the videoFitted
	 */
	public Character getVideoFitted() {
		return videoFitted;
	}

	/**
	 * @param videoFitted the videoFitted to set
	 */
	public void setVideoFitted(Character videoFitted) {
		this.videoFitted = videoFitted;
	}

	/**
	 * @return the vchPurchaseAs
	 */
	public Character getVchPurchaseAs() {
		return vchPurchaseAs;
	}

	/**
	 * @param vchPurchaseAs the vchPurchaseAs to set
	 */
	public void setVchPurchaseAs(Character vchPurchaseAs) {
		this.vchPurchaseAs = vchPurchaseAs;
	}

	/**
	 * @return the vchCatg
	 */
	public String getVchCatg() {
		return vchCatg;
	}

	/**
	 * @param vchCatg the vchCatg to set
	 */
	public void setVchCatg(String vchCatg) {
		this.vchCatg = vchCatg;
	}

	/**
	 * @return the dealerCd
	 */
	public Integer getDealerCd() {
		return dealerCd;
	}

	/**
	 * @param dealerCd the dealerCd to set
	 */
	public void setDealerCd(Integer dealerCd) {
		this.dealerCd = dealerCd;
	}

	/**
	 * @return the taxOpt
	 */
	public String getTaxOpt() {
		return taxOpt;
	}

	/**
	 * @param taxOpt the taxOpt to set
	 */
	public void setTaxOpt(String taxOpt) {
		this.taxOpt = taxOpt;
	}

	/**
	 * @return the ataxOpt
	 */
	public String getAtaxOpt() {
		return ataxOpt;
	}

	/**
	 * @param ataxOpt the ataxOpt to set
	 */
	public void setAtaxOpt(String ataxOpt) {
		this.ataxOpt = ataxOpt;
	}

	/**
	 * @return the pvtCom
	 */
	public String getPvtCom() {
		return pvtCom;
	}

	/**
	 * @param pvtCom the pvtCom to set
	 */
	public void setPvtCom(String pvtCom) {
		this.pvtCom = pvtCom;
	}

	/**
	 * @return the saleAmt
	 */
	public Integer getSaleAmt() {
		return saleAmt;
	}

	/**
	 * @param saleAmt the saleAmt to set
	 */
	public void setSaleAmt(Integer saleAmt) {
		this.saleAmt = saleAmt;
	}

	/**
	 * @return the laserCode
	 */
	public String getLaserCode() {
		return laserCode;
	}

	/**
	 * @param laserCode the laserCode to set
	 */
	public void setLaserCode(String laserCode) {
		this.laserCode = laserCode;
	}

	/**
	 * @return the opDt
	 */
	public Date getOpDt() {
		return opDt;
	}

	/**
	 * @param opDt the opDt to set
	 */
	public void setOpDt(Date opDt) {
		this.opDt = opDt;
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
	 * @return the garageAdd
	 */
	public String getGarageAdd() {
		return garageAdd;
	}

	/**
	 * @param garageAdd the garageAdd to set
	 */
	public void setGarageAdd(String garageAdd) {
		this.garageAdd = garageAdd;
	}
	
	
}

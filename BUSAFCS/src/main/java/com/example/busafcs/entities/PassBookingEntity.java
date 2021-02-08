package com.example.busafcs.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PassBookingDetail")
@NamedQueries
({
	@NamedQuery(name="PassBookingEntity.findByPassSerialNum", query="SELECT pass FROM PassBookingEntity pass WHERE pass.passSerialNum = :passSerialNum"),
	@NamedQuery(name="PassBookingEntity.findBySrcDest", query="SELECT pb FROM PassBookingEntity pb WHERE pb.srcStopId IN (:srcStpList) AND pb.destStopId IN (:destStpList)"),
	@NamedQuery(name="PassBookingEntity.findByCreatedBy", query="SELECT pass FROM PassBookingEntity pass WHERE pass.createdBy = :createdBy"),
	
})
public class PassBookingEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6999526777268407546L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Long id;

	@Column(name = "createdBy")
	private String createdBy;

	@Column(name = "deviceId")
	private String deviceId;

	@Column(name = "deviceIp")
	private String deviceIp;

	@Column(name = "passType")
	private String passType;

	@Column(name = "passDetails")
	private String passDetails;

	@Column(name = "docType")
	private String docType;

	@Column(name = "docRequired")
	private String docRequired;

	@Column(name = "docAttached")
	private String docAttached;

	@Column(name = "srcStopId")
	private Integer srcStopId;

	@Column(name = "destStopId")
	private Integer destStopId;

	@Column(name = "totAmnt")
	private BigDecimal totAmnt;

	@Column(name = "discAmnt")
	private BigDecimal discAmnt;

	@Column(name = "amntToPay")
	private BigDecimal amntToPay;

	@Column(name = "dtIssue")
	private Date dtIssue;

	@Column(name = "validUpto")
	private Date validUpto;

	@Column(name = "passId")
	private String passId;

	@Column(name = "passSerialNum")
	private String passSerialNum;

	@Column(name = "passRequestDateTime")
	private Timestamp passRequestDateTime;

	@Column(name = "duration")
	private String duration;
	
	@Column(name = "pmntId")
	private Integer pmntId;
	
	@Column(name = "trsctId")
	private Integer trsctId;
	
	@Column(name = "passqrCode")
	private String passqrCode;
	
	@Column(name = "entryCount")
	private String entryCount;
	
	@Column(name = "exitCount")
	private String exitCount;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "maxTripAllowed")
	private Integer maxTripAllowed;
	
	@Column(name = "remainingTrip")
	private Integer remainingTrip;
	
	/*
	 * @OneToMany(targetEntity = PassEntryExitDetail.class, cascade =
	 * CascadeType.ALL, orphanRemoval = true)
	 * 
	 * @JoinColumn(name = "passbId", referencedColumnName = "id") private
	 * List<PassEntryExitDetail> passEntryExit;
	 */

	public Long getId() {
		return id;
	}

	
	/*
	 * public List<PassEntryExitDetail> getPassEntryExit() { return passEntryExit; }
	 * 
	 * public void setPassEntryExit(List<PassEntryExitDetail> passEntryExit) {
	 * this.passEntryExit = passEntryExit; }
	 */

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceIp() {
		return deviceIp;
	}

	public void setDeviceIp(String deviceIp) {
		this.deviceIp = deviceIp;
	}

	public String getPassType() {
		return passType;
	}

	public void setPassType(String passType) {
		this.passType = passType;
	}

	public String getPassDetails() {
		return passDetails;
	}

	public void setPassDetails(String passDetails) {
		this.passDetails = passDetails;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getDocRequired() {
		return docRequired;
	}

	public void setDocRequired(String docRequired) {
		this.docRequired = docRequired;
	}

	public String getDocAttached() {
		return docAttached;
	}

	public void setDocAttached(String docAttached) {
		this.docAttached = docAttached;
	}

	public Integer getSrcStopId() {
		return srcStopId;
	}

	public void setSrcStopId(Integer srcStopId) {
		this.srcStopId = srcStopId;
	}

	public Integer getDestStopId() {
		return destStopId;
	}

	public void setDestStopId(Integer destStopId) {
		this.destStopId = destStopId;
	}

	public BigDecimal getTotAmnt() {
		return totAmnt;
	}

	public void setTotAmnt(BigDecimal totAmnt) {
		this.totAmnt = totAmnt;
	}

	public BigDecimal getDiscAmnt() {
		return discAmnt;
	}

	public void setDiscAmnt(BigDecimal discAmnt) {
		this.discAmnt = discAmnt;
	}

	public BigDecimal getAmntToPay() {
		return amntToPay;
	}

	public void setAmntToPay(BigDecimal amntToPay) {
		this.amntToPay = amntToPay;
	}

	public Date getDtIssue() {
		return dtIssue;
	}

	public void setDtIssue(Date dtIssue) {
		this.dtIssue = dtIssue;
	}

	public Date getValidUpto() {
		return validUpto;
	}

	public void setValidUpto(Date validUpto) {
		this.validUpto = validUpto;
	}

	public String getPassId() {
		return passId;
	}

	public void setPassId(String passId) {
		this.passId = passId;
	}

	public String getPassSerialNum() {
		return passSerialNum;
	}

	public void setPassSerialNum(String passSerialNum) {
		this.passSerialNum = passSerialNum;
	}

	public Timestamp getPassRequestDateTime() {
		return passRequestDateTime;
	}

	public void setPassRequestDateTime(Timestamp passRequestDateTime) {
		this.passRequestDateTime = passRequestDateTime;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Integer getPmntId() {
		return pmntId;
	}

	public void setPmntId(Integer pmntId) {
		this.pmntId = pmntId;
	}

	public Integer getTrsctId() {
		return trsctId;
	}

	public void setTrsctId(Integer trsctId) {
		this.trsctId = trsctId;
	}

	public String getPassqrCode() {
		return passqrCode;
	}

	public void setPassqrCode(String passqrCode) {
		this.passqrCode = passqrCode;
	}

	public String getEntryCount() {
		return entryCount;
	}

	public void setEntryCount(String entryCount) {
		this.entryCount = entryCount;
	}

	public String getExitCount() {
		return exitCount;
	}

	public void setExitCount(String exitCount) {
		this.exitCount = exitCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getMaxTripAllowed() {
		return maxTripAllowed;
	}

	public void setMaxTripAllowed(Integer maxTripAllowed) {
		this.maxTripAllowed = maxTripAllowed;
	}

	public Integer getRemainingTrip() {
		return remainingTrip;
	}

	public void setRemainingTrip(Integer remainingTrip) {
		this.remainingTrip = remainingTrip;
	}
	
	
	
}

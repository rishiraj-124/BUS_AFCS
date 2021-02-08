package com.example.busafcs.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.busafcs.bean.Passenger;


@Entity
@Table(name = "SingleJourney")
@NamedQueries
({
	@NamedQuery(name="SingleJourneyEntitiy.findByQRCode", query="SELECT sj FROM SingleJourneyEntitiy sj WHERE sj.qrTicketHash = :qrTicketHash"),
	@NamedQuery(name="SingleJourneyEntitiy.findByTicketSrNum", query="SELECT sj FROM SingleJourneyEntitiy sj WHERE sj.tktNo = :tktNo"),
	@NamedQuery(name="SingleJourneyEntitiy.findByUserId", query="SELECT sj FROM SingleJourneyEntitiy sj WHERE sj.userId = :userId"),
	@NamedQuery(name="SingleJourneyEntitiy.findBySrcDest", query="SELECT sj FROM SingleJourneyEntitiy sj WHERE sj.srcStpId IN (:srcStpList) AND sj.destStpId IN (:destStpList)")
})
public class SingleJourneyEntitiy implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2336071173831525483L;
	
	
	   	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "id")
	    private Long id;
	   
	   	@Column(name = "userId")
		private String userId;
		
	   	@Column(name = "tktBookingDtTime")
		private Timestamp tktBookingDtTime;
		
	   	@Column(name = "srcStpId")
		private Integer srcStpId;
		
	   	@Column(name = "destStpId")
		private Integer destStpId;
		
	   	@Column(name = "tktNo")
		private Long tktNo;
		
	   	@Column(name = "custIpAddress")
		private String custIpAddress;
		
	   	@Column(name = "custImei")
		private String custImei;
		
	   	@Column(name = "tktType")
		private String tktType;
		
	   	
	   	@OneToMany(targetEntity=PassengerEntity.class,cascade = CascadeType.ALL, 
	              orphanRemoval = true)
	   	@JoinColumn(name = "sjId", referencedColumnName = "id")
		private List<PassengerEntity> passengers;
		
		
	   	@Column(name = "payMode")
		private String payMode;
		
	   	@Column(name = "paidAmt")
		private String paidAmt;
		
	   	@Column(name = "pmtId")
		private String pmtId;
	   	
	   	@Column(name = "qrTicketHash")
	   	private String qrTicketHash;
	   	
	   	@Column(name = "entryV")
	   	private String entry;
	   	
	   	@Column(name = "tktEntryDtTime")
	   	private Timestamp tktEntryDtTime;
	   	
	   	@Column(name = "exitV")
	   	private String exit;

	   	@Column(name = "tktExitDtTime")
	   	private Timestamp tktExitDtTime;
	   	
	   	@Column(name = "entryStation")
	   	private String entryStation;
	   	
	   	@Column(name = "exitStation")
	   	private String exitStation;
	   	
	   	@Column(name = "status")
	   	private String status;
	   	
	   	@Column(name = "validUpto")
	   	private Timestamp validUpto;
	   	
	   	@Column(name = "qrStatus")
	   	private String qrStatus;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public Timestamp getTktBookingDtTime() {
			return tktBookingDtTime;
		}

		public void setTktBookingDtTime(Timestamp tktBookingDtTime) {
			this.tktBookingDtTime = tktBookingDtTime;
		}

		public Integer getSrcStpId() {
			return srcStpId;
		}

		public void setSrcStpId(Integer srcStpId) {
			this.srcStpId = srcStpId;
		}

		public Integer getDestStpId() {
			return destStpId;
		}

		public void setDestStpId(Integer destStpId) {
			this.destStpId = destStpId;
		}

		public Long getTktNo() {
			return tktNo;
		}

		public void setTktNo(Long tktNo) {
			this.tktNo = tktNo;
		}

		public String getCustIpAddress() {
			return custIpAddress;
		}

		public void setCustIpAddress(String custIpAddress) {
			this.custIpAddress = custIpAddress;
		}

		public String getCustImei() {
			return custImei;
		}

		public void setCustImei(String custImei) {
			this.custImei = custImei;
		}

		public String getTktType() {
			return tktType;
		}

		public void setTktType(String tktType) {
			this.tktType = tktType;
		}

	
		public List<PassengerEntity> getPassengers() {
			return passengers;
		}

		public void setPassengers(List<PassengerEntity> passengers) {
			this.passengers = passengers;
		}

		public String getPayMode() {
			return payMode;
		}

		public void setPayMode(String payMode) {
			this.payMode = payMode;
		}

		public String getPaidAmt() {
			return paidAmt;
		}

		public void setPaidAmt(String paidAmt) {
			this.paidAmt = paidAmt;
		}

		public String getPmtId() {
			return pmtId;
		}

		public void setPmtId(String pmtId) {
			this.pmtId = pmtId;
		}

		public String getQrTicketHash() {
			return qrTicketHash;
		}

		public void setQrTicketHash(String qrTicketHash) {
			this.qrTicketHash = qrTicketHash;
		}

		public String getEntry() {
			return entry;
		}

		public void setEntry(String entry) {
			this.entry = entry;
		}

		public String getExit() {
			return exit;
		}

		public void setExit(String exit) {
			this.exit = exit;
		}

		public String getEntryStation() {
			return entryStation;
		}

		public void setEntryStation(String entryStation) {
			this.entryStation = entryStation;
		}

		public String getExitStation() {
			return exitStation;
		}

		public void setExitStation(String exitStation) {
			this.exitStation = exitStation;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Timestamp getValidUpto() {
			return validUpto;
		}

		public void setValidUpto(Timestamp validUpto) {
			this.validUpto = validUpto;
		}

		public String getQrStatus() {
			return qrStatus;
		}

		public void setQrStatus(String qrStatus) {
			this.qrStatus = qrStatus;
		}

		public Timestamp getTktEntryDtTime() {
			return tktEntryDtTime;
		}

		public void setTktEntryDtTime(Timestamp tktEntryDtTime) {
			this.tktEntryDtTime = tktEntryDtTime;
		}

		public Timestamp getTktExitDtTime() {
			return tktExitDtTime;
		}

		public void setTktExitDtTime(Timestamp tktExitDtTime) {
			this.tktExitDtTime = tktExitDtTime;
		}
		
		
		
	
}

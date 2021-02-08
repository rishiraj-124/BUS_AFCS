package com.example.busafcs.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "ValueQRTicket")
@NamedQueries
({
	@NamedQuery(name="ValueQRTicketEntity.findByValueTktSerialNum", query="SELECT valueQR FROM ValueQRTicketEntity valueQR WHERE valueQR.fullTicketNo = :fullTicketNo")
})
public class ValueQRTicketEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6832041381206592675L;
	
 	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
	private Long id;
	
 	@Column(name = "amount")
	private Long amount;
	
 	@Column(name = "paymentMode")
	private String paymentMode;
	
 	@Column(name = "imei")
	private String imei;
	
 	@Column(name = "ipAddress")
	private String ipAddress;
	
 	@Column(name = "ticketId")
	private String ticketId;
	
 	@Column(name = "fullTicketNo")
	private String fullTicketNo;
	
 	@Column(name = "qrTicketHash")
	private String qrTicketHash;
	
 	@Column(name = "paymentStatus")
	private String paymentStatus;
	
 	@Column(name = "ticketStatus")
	private String ticketStatus;
	
 	@Column(name = "ticketValidity")
	private String ticketValidity;
	
 	@Column(name = "issueDateTime")
	private Timestamp issueDateTime;
	
 	@Column(name = "entryCount")
 	private String entryCount;
	
 	@Column(name = "exitCount")
	private String exitCount;
 	
 	@Column(name = "remainingValue")
 	private Long remainingValue; 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getFullTicketNo() {
		return fullTicketNo;
	}

	public void setFullTicketNo(String fullTicketNo) {
		this.fullTicketNo = fullTicketNo;
	}

	public String getQrTicketHash() {
		return qrTicketHash;
	}

	public void setQrTicketHash(String qrTicketHash) {
		this.qrTicketHash = qrTicketHash;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public String getTicketValidity() {
		return ticketValidity;
	}

	public void setTicketValidity(String ticketValidity) {
		this.ticketValidity = ticketValidity;
	}

	public Timestamp getIssueDateTime() {
		return issueDateTime;
	}

	public void setIssueDateTime(Timestamp issueDateTime) {
		this.issueDateTime = issueDateTime;
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

	public Long getRemainingValue() {
		return remainingValue;
	}

	public void setRemainingValue(Long remainingValue) {
		this.remainingValue = remainingValue;
	}

	
	
	
	
	
	
}

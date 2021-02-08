package com.example.busafcs.bean;

import java.util.Date;
import java.util.List;

import com.example.busafcs.entities.PassengerEntity;

public class MyTicketRequest implements ValidationBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3452933086066522581L;
	
	private String customerId;
	
	private String deviceId;
	
	private String deviceIp;
	
	private String validTicket;
	
	private String ticketType;
	
	private Date tktBookingdt;
	
	private Date tktValiddt;
	
	private String srcStpId;
	
	private String destStpId;
	
	private String tktNo;
	
	private String custIpAddress;
	
	private String custImei;
	
	
	private List<PassengerEntity> psgList;
	
	private String payMode;
	
	private String paidAmnt;
	
	private String pmtId;
	
	private String qrTicketHash;
	
	private String tktStatus;
	
	private String tktValidity;
	
	private String tktId;
	
	private String paymentStatus;
	
	private String userId;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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

	public String getValidTicket() {
		return validTicket;
	}

	public void setValidTicket(String validTicket) {
		this.validTicket = validTicket;
	}

	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	public Date getTktBookingdt() {
		return tktBookingdt;
	}

	public void setTktBookingdt(Date tktBookingdt) {
		this.tktBookingdt = tktBookingdt;
	}

	public Date getTktValiddt() {
		return tktValiddt;
	}

	public void setTktValiddt(Date tktValiddt) {
		this.tktValiddt = tktValiddt;
	}

	public String getSrcStpId() {
		return srcStpId;
	}

	public void setSrcStpId(String srcStpId) {
		this.srcStpId = srcStpId;
	}

	public String getDestStpId() {
		return destStpId;
	}

	public void setDestStpId(String destStpId) {
		this.destStpId = destStpId;
	}

	public String getTktNo() {
		return tktNo;
	}

	public void setTktNo(String tktNo) {
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

	public List<PassengerEntity> getPsgList() {
		return psgList;
	}

	public void setPsgList(List<PassengerEntity> psgList) {
		this.psgList = psgList;
	}

	public String getPayMode() {
		return payMode;
	}

	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}

	public String getPaidAmnt() {
		return paidAmnt;
	}

	public void setPaidAmnt(String paidAmnt) {
		this.paidAmnt = paidAmnt;
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

	public String getTktStatus() {
		return tktStatus;
	}

	public void setTktStatus(String tktStatus) {
		this.tktStatus = tktStatus;
	}

	public String getTktValidity() {
		return tktValidity;
	}

	public void setTktValidity(String tktValidity) {
		this.tktValidity = tktValidity;
	}

	public String getTktId() {
		return tktId;
	}

	public void setTktId(String tktId) {
		this.tktId = tktId;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
		
}

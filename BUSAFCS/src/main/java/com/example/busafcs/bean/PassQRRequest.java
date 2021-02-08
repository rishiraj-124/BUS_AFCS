package com.example.busafcs.bean;

import java.sql.Date;

public class PassQRRequest implements ValidationBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1391417420873724001L;
	
	private String userId;
	
	private String deviceId;
	
	private String deviceIp;
	
	private String passType;
	
	private String passDetails;
	
	private Date dtIssue;
	
	private String passRequestDateTime;
	
	private String validUpto;
	
	private String validUptoTime;
	
	private String passId;
	
	private String passSerialNum;
	
	private String passQRCode;
	
	private String duration;
	
	private String docType;
	
	private String docRequired;
	
	private String docAttached;
	
	private String srcStpId;
	
	private String destStpId;
	
	private String pmtId;
	
	private String trsctId;
	
	private String paidAmt;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public Date getDtIssue() {
		return dtIssue;
	}

	public void setDtIssue(Date dtIssue) {
		this.dtIssue = dtIssue;
	}

	public String getPassRequestDateTime() {
		return passRequestDateTime;
	}

	public void setPassRequestDateTime(String passRequestDateTime) {
		this.passRequestDateTime = passRequestDateTime;
	}

	public String getValidUpto() {
		return validUpto;
	}

	public void setValidUpto(String validUpto) {
		this.validUpto = validUpto;
	}

	public String getValidUptoTime() {
		return validUptoTime;
	}

	public void setValidUptoTime(String validUptoTime) {
		this.validUptoTime = validUptoTime;
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

	public String getPassQRCode() {
		return passQRCode;
	}

	public void setPassQRCode(String passQRCode) {
		this.passQRCode = passQRCode;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
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

	public String getPmtId() {
		return pmtId;
	}

	public void setPmtId(String pmtId) {
		this.pmtId = pmtId;
	}

	public String getTrsctId() {
		return trsctId;
	}

	public void setTrsctId(String trsctId) {
		this.trsctId = trsctId;
	}

	public String getPaidAmt() {
		return paidAmt;
	}

	public void setPaidAmt(String paidAmt) {
		this.paidAmt = paidAmt;
	}

		

}

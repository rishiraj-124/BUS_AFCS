package com.example.busafcs.bean;

public class PassSerialNumRequest implements ValidationBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7493549012359316216L;
	
	private String userId;
	
	private String deviceId;
	
	private String deviceIp;
	
	private String passType;
	
	private String passDetails;
	
	private String dtIssue;
	
	private String validUpto;
	
	private String passId;
	
	private String passSerialNum;
	
	private String passRequestDate;
	
	private String passRequestTime;
	
	private String duration;
	
	private String docType;
	
	private String docRequired;
	
	private String docAttached;
	
	private String srcStpId;
	
	private String destStpId;
	
	private String totalAmt;
	
	private String discAmt;
	
	private String amtToPay;

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

	public String getDtIssue() {
		return dtIssue;
	}

	public void setDtIssue(String dtIssue) {
		this.dtIssue = dtIssue;
	}

	public String getValidUpto() {
		return validUpto;
	}

	public void setValidUpto(String validUpto) {
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

	public String getPassRequestDate() {
		return passRequestDate;
	}

	public void setPassRequestDate(String passRequestDate) {
		this.passRequestDate = passRequestDate;
	}

	public String getPassRequestTime() {
		return passRequestTime;
	}

	public void setPassRequestTime(String passRequestTime) {
		this.passRequestTime = passRequestTime;
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

	public String getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
	}

	public String getDiscAmt() {
		return discAmt;
	}

	public void setDiscAmt(String discAmt) {
		this.discAmt = discAmt;
	}

	public String getAmtToPay() {
		return amtToPay;
	}

	public void setAmtToPay(String amtToPay) {
		this.amtToPay = amtToPay;
	}
	
	
}

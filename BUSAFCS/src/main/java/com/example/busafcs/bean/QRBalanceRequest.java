package com.example.busafcs.bean;

public class QRBalanceRequest implements ValidationBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7604065310048462796L;
	
	
	private String tktSerialNum;
	
	private String qrType;
	
	private String qrHashCode;
	
	private String deviceId;
	
	private String qrBalance;
	
	private String qrStatus;

	public String getTktSerialNum() {
		return tktSerialNum;
	}

	public void setTktSerialNum(String tktSerialNum) {
		this.tktSerialNum = tktSerialNum;
	}

	public String getQrType() {
		return qrType;
	}

	public void setQrType(String qrType) {
		this.qrType = qrType;
	}

	public String getQrHashCode() {
		return qrHashCode;
	}

	public void setQrHashCode(String qrHashCode) {
		this.qrHashCode = qrHashCode;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getQrBalance() {
		return qrBalance;
	}

	public void setQrBalance(String qrBalance) {
		this.qrBalance = qrBalance;
	}

	public String getQrStatus() {
		return qrStatus;
	}

	public void setQrStatus(String qrStatus) {
		this.qrStatus = qrStatus;
	}
	
	
	
}

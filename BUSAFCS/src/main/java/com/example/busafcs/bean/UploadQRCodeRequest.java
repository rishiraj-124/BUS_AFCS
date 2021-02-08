package com.example.busafcs.bean;

public class UploadQRCodeRequest implements ValidationBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8772033566140508772L;
	
	
	private String tktSrNUm;
	
	private String qrCode;
	
	private String tktType;
	
	private Integer scanfor;
	
	private String stopId;
	

	public String getTktSrNUm() {
		return tktSrNUm;
	}

	public void setTktSrNUm(String tktSrNUm) {
		this.tktSrNUm = tktSrNUm;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public String getTktType() {
		return tktType;
	}

	public void setTktType(String tktType) {
		this.tktType = tktType;
	}

	public Integer getScanfor() {
		return scanfor;
	}

	public void setScanfor(Integer scanfor) {
		this.scanfor = scanfor;
	}

	public String getStopId() {
		return stopId;
	}

	public void setStopId(String stopId) {
		this.stopId = stopId;
	}

	
	
	

}

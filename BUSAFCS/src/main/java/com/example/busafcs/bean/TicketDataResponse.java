package com.example.busafcs.bean;

public class TicketDataResponse implements ValidationBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7856612219716794535L;
	
	private String tktSerialNum;
	
	private String qrCode;
	
	private String qrType;
	
	private String ticketType;
	
	private String srcStpCode;
	
	private String destStpCode;
	
	private String tktAmnt;
	
	private String qrStatus;
	
	private String tktStatus;
	
	private String qrValidUpto;
	
	private String remainingtrips;

	public String getTktSerialNum() {
		return tktSerialNum;
	}

	public void setTktSerialNum(String tktSerialNum) {
		this.tktSerialNum = tktSerialNum;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public String getQrType() {
		return qrType;
	}

	public void setQrType(String qrType) {
		this.qrType = qrType;
	}

	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	public String getSrcStpCode() {
		return srcStpCode;
	}

	public void setSrcStpCode(String srcStpCode) {
		this.srcStpCode = srcStpCode;
	}

	public String getDestStpCode() {
		return destStpCode;
	}

	public void setDestStpCode(String destStpCode) {
		this.destStpCode = destStpCode;
	}

	public String getTktAmnt() {
		return tktAmnt;
	}

	public void setTktAmnt(String tktAmnt) {
		this.tktAmnt = tktAmnt;
	}

	public String getQrStatus() {
		return qrStatus;
	}

	public void setQrStatus(String qrStatus) {
		this.qrStatus = qrStatus;
	}

	public String getTktStatus() {
		return tktStatus;
	}

	public void setTktStatus(String tktStatus) {
		this.tktStatus = tktStatus;
	}

	public String getQrValidUpto() {
		return qrValidUpto;
	}

	public void setQrValidUpto(String qrValidUpto) {
		this.qrValidUpto = qrValidUpto;
	}

	public String getRemainingtrips() {
		return remainingtrips;
	}

	public void setRemainingtrips(String remainingtrips) {
		this.remainingtrips = remainingtrips;
	}
	
	
}

package com.example.busafcs.bean;

public class TicketTxnData implements ValidationBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1119850295390676681L;
	
	private String txnId;
	
	private String txnStartDateTime;
	
	private String payMode;
	
	private String custCardId;
	
	private String srcStop;
	
	private String destStop;
	
	private String tktAmnt;
	
	private String totAmnt;
	
	private String txnAmnt;

	public String getTxnId() {
		return txnId;
	}

	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}

	public String getTxnStartDateTime() {
		return txnStartDateTime;
	}

	public void setTxnStartDateTime(String txnStartDateTime) {
		this.txnStartDateTime = txnStartDateTime;
	}

	public String getPayMode() {
		return payMode;
	}

	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}

	public String getCustCardId() {
		return custCardId;
	}

	public void setCustCardId(String custCardId) {
		this.custCardId = custCardId;
	}

	public String getSrcStop() {
		return srcStop;
	}

	public void setSrcStop(String srcStop) {
		this.srcStop = srcStop;
	}

	public String getDestStop() {
		return destStop;
	}

	public void setDestStop(String destStop) {
		this.destStop = destStop;
	}

	public String getTktAmnt() {
		return tktAmnt;
	}

	public void setTktAmnt(String tktAmnt) {
		this.tktAmnt = tktAmnt;
	}

	public String getTotAmnt() {
		return totAmnt;
	}

	public void setTotAmnt(String totAmnt) {
		this.totAmnt = totAmnt;
	}

	public String getTxnAmnt() {
		return txnAmnt;
	}

	public void setTxnAmnt(String txnAmnt) {
		this.txnAmnt = txnAmnt;
	}
	
	

}

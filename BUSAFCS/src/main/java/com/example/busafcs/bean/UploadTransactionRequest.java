package com.example.busafcs.bean;

import java.util.List;

public class UploadTransactionRequest implements ValidationBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 65121993511414329L;
	
	private String userId;
	
	private String readerId;
	
	private String busNo;
	
	private String trip;
	
	private String route;
	
	private String busServiceType;
	
	private List<TicketTxnData> tktTxnList;
	
	private String errorMsg;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getReaderId() {
		return readerId;
	}

	public void setReaderId(String readerId) {
		this.readerId = readerId;
	}

	public String getBusNo() {
		return busNo;
	}

	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}

	public String getTrip() {
		return trip;
	}

	public void setTrip(String trip) {
		this.trip = trip;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getBusServiceType() {
		return busServiceType;
	}

	public void setBusServiceType(String busServiceType) {
		this.busServiceType = busServiceType;
	}

	public List<TicketTxnData> getTktTxnList() {
		return tktTxnList;
	}

	public void setTktTxnList(List<TicketTxnData> tktTxnList) {
		this.tktTxnList = tktTxnList;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
	
	
	
	
	

}

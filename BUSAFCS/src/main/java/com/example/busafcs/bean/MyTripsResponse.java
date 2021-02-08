package com.example.busafcs.bean;

import java.util.List;

import com.example.busafcs.entities.PassEntryExitDetail;

public class MyTripsResponse implements ValidationBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -879058619948496237L;
	
	private String id;
	
	private String ticketNum;
	
	private String tripStartDtTime;
	
	private String tripEndDtTime;
	
	private String srcStpCode;
	
	private String destStpCode;
	
	private String tripStatus;
	
	private String routeId;
	
	private List<PassEntryExitDetail> passEntryExitList;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTicketNum() {
		return ticketNum;
	}

	public void setTicketNum(String ticketNum) {
		this.ticketNum = ticketNum;
	}

	public String getTripStartDtTime() {
		return tripStartDtTime;
	}

	public void setTripStartDtTime(String tripStartDtTime) {
		this.tripStartDtTime = tripStartDtTime;
	}

	public String getTripEndDtTime() {
		return tripEndDtTime;
	}

	public void setTripEndDtTime(String tripEndDtTime) {
		this.tripEndDtTime = tripEndDtTime;
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

	public String getTripStatus() {
		return tripStatus;
	}

	public void setTripStatus(String tripStatus) {
		this.tripStatus = tripStatus;
	}

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public List<PassEntryExitDetail> getPassEntryExitList() {
		return passEntryExitList;
	}

	public void setPassEntryExitList(List<PassEntryExitDetail> passEntryExitList) {
		this.passEntryExitList = passEntryExitList;
	}
	
	
	
}

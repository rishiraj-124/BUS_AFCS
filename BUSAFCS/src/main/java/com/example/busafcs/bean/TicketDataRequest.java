package com.example.busafcs.bean;

import java.util.List;

import com.example.busafcs.entities.SingleJourneyEntitiy;

public class TicketDataRequest implements ValidationBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2537390626541226107L;
	
	private String deviceId;
	
	private String routeNum;
	
	private List<TicketDataResponse> ticketDataList;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getRouteNum() {
		return routeNum;
	}

	public void setRouteNum(String routeNum) {
		this.routeNum = routeNum;
	}

	public List<TicketDataResponse> getTicketDataList() {
		return ticketDataList;
	}

	public void setTicketDataList(List<TicketDataResponse> ticketDataList) {
		this.ticketDataList = ticketDataList;
	}
	
	
	

}

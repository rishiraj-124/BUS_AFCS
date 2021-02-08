package com.example.busafcs.bean;

public class FareRequest implements ValidationBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7463276626659839052L;
	
	private String ticketType;
	
	private String srcStpId;
	
	private String destStpId;
	
	private String paxType;
	
	private String tktJrnyType;
	
	private String noOfPax;
	
	private String fareAmount;
	
	private String discount;
	
	private String netAmnt;
	
	

	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
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

	public String getPaxType() {
		return paxType;
	}

	public void setPaxType(String paxType) {
		this.paxType = paxType;
	}

	public String getTktJrnyType() {
		return tktJrnyType;
	}

	public void setTktJrnyType(String tktJrnyType) {
		this.tktJrnyType = tktJrnyType;
	}

	public String getNoOfPax() {
		return noOfPax;
	}

	public void setNoOfPax(String noOfPax) {
		this.noOfPax = noOfPax;
	}

	public String getFareAmount() {
		return fareAmount;
	}

	public void setFareAmount(String fareAmount) {
		this.fareAmount = fareAmount;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getNetAmnt() {
		return netAmnt;
	}

	public void setNetAmnt(String netAmnt) {
		this.netAmnt = netAmnt;
	}
	
	

}

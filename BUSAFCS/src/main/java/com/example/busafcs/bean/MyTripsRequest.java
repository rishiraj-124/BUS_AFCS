package com.example.busafcs.bean;

public class MyTripsRequest implements ValidationBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2951181423797816802L;
	
	private String mobileNum;
	
	private String tripType;

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getTripType() {
		return tripType;
	}

	public void setTripType(String tripType) {
		this.tripType = tripType;
	}
	
	
}

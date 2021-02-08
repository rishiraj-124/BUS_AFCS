package com.example.busafcs.bean;

import java.sql.Date;

public class PassFareRequest implements ValidationBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2449365258386412355L;
	
	private String userId;
	
	private String deviceId;
	
	private String deviceIp;
	
	private String passType;
	
		
	private String srcStpId;
	
	private String destStpId;

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

	
		
			

}

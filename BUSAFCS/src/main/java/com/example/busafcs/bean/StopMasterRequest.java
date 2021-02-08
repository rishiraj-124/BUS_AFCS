package com.example.busafcs.bean;

import java.io.Serializable;

public class StopMasterRequest implements ValidationBean {

	private static final long serialVersionUID = -7024594886699120079L;
	
	private String mobile;
	
	private String routeNum;
	
	private String deviceId;
	
	private String errorMsg;
	
	private String masterData;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getRouteNum() {
		return routeNum;
	}

	public void setRouteNum(String routeNum) {
		this.routeNum = routeNum;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getMasterData() {
		return masterData;
	}

	public void setMasterData(String masterData) {
		this.masterData = masterData;
	}
	
	
	
}

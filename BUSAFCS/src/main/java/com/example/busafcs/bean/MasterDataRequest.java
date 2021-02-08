package com.example.busafcs.bean;

import java.util.List;

import com.example.busafcs.entities.BusRoutes;
import com.example.busafcs.entities.DiscountEntity;
import com.example.busafcs.entities.FareEntity;
import com.example.busafcs.entities.FareRules;
import com.example.busafcs.entities.PassMasterEntity;

public class MasterDataRequest implements ValidationBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -23987432608082887L;
	
	private String busNo;
	
	private String busType;
	
	private String depot;
	
	private String deviceId;
	
	private List<BusRoutes> busRouteList;
	
	private List<PassMasterEntity> passMasterList;
	
	private List<DiscountEntity> discountList;
	
	private List<FareEntity> fareRuleList;
	
	private List<FareRules> byDistancefareRuleList;
	
	private String manufacturer;
	
	private String errorMsg;

	
	public String getBusNo() {
		return busNo;
	}

	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getDepot() {
		return depot;
	}

	public void setDepot(String depot) {
		this.depot = depot;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public List<BusRoutes> getBusRouteList() {
		return busRouteList;
	}

	public void setBusRouteList(List<BusRoutes> busRouteList) {
		this.busRouteList = busRouteList;
	}

	public List<PassMasterEntity> getPassMasterList() {
		return passMasterList;
	}

	public void setPassMasterList(List<PassMasterEntity> passMasterList) {
		this.passMasterList = passMasterList;
	}

	public List<DiscountEntity> getDiscountList() {
		return discountList;
	}

	public void setDiscountList(List<DiscountEntity> discountList) {
		this.discountList = discountList;
	}

	public List<FareEntity> getFareRuleList() {
		return fareRuleList;
	}

	public void setFareRuleList(List<FareEntity> fareRuleList) {
		this.fareRuleList = fareRuleList;
	}
	
	public List<FareRules> getByDistancefareRuleList() {
		return byDistancefareRuleList;
	}

	public void setByDistancefareRuleList(List<FareRules> byDistancefareRuleList) {
		this.byDistancefareRuleList = byDistancefareRuleList;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
		
}

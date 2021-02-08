package com.example.busafcs.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "bus_Stops")
@NamedQueries
({
	@NamedQuery(name="BusStops.findByRouteNum", query="SELECT bs FROM BusStops bs WHERE bs.routeNum = :routeNum")
	
})
public class BusStops implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8175092814075326865L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
	private long id;

	@Column(name = "stopId")
	private int stopId;
	
	@Column(name = "stopName")
	private String stopName;
	
	@Column(name = "stopCode")
	private String stopCode;
	
	@Column(name = "isTerminal")
	private String isTerminal;
	
	@Column(name = "isDepot")
	private String isDepot;
	
	@Column(name = "stopLat")
	private String stopLat;
	
	@Column(name = "stopLong")
	private String stopLong;
	
	@Column(name = "stopLandmark")
	private String stopLandmark;
	
	@Column(name = "stopCity")
	private String stopCity;
	
	@Column(name = "stopState")
	private String stopState;
	
	@Column(name = "stopPincode")
	private int stopPincode;
	
	@Column(name = "createdOn")
	private Date createdOn;
	
	@Column(name = "createdBy")
	private String createdBy;
	
	@Column(name = "stopStatus")
	private String stopStatus;
	
	@Column(name = "routeNum")
	private String routeNum;

	
	@ManyToOne
	@JoinColumn(name = "routeId", nullable = false)
	private BusRoutes route; 
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getStopId() {
		return stopId;
	}

	public void setStopId(int stopId) {
		this.stopId = stopId;
	}

	public String getStopName() {
		return stopName;
	}

	public void setStopName(String stopName) {
		this.stopName = stopName;
	}

	public String getStopCode() {
		return stopCode;
	}

	public void setStopCode(String stopCode) {
		this.stopCode = stopCode;
	}

	public String getIsTerminal() {
		return isTerminal;
	}

	public void setIsTerminal(String isTerminal) {
		this.isTerminal = isTerminal;
	}

	public String getIsDepot() {
		return isDepot;
	}

	public void setIsDepot(String isDepot) {
		this.isDepot = isDepot;
	}

	
	public String getStopLat() {
		return stopLat;
	}

	public void setStopLat(String stopLat) {
		this.stopLat = stopLat;
	}

	public String getStopLong() {
		return stopLong;
	}

	public void setStopLong(String stopLong) {
		this.stopLong = stopLong;
	}

	public String getStopLandmark() {
		return stopLandmark;
	}

	public void setStopLandmark(String stopLandmark) {
		this.stopLandmark = stopLandmark;
	}

	public String getStopCity() {
		return stopCity;
	}

	public void setStopCity(String stopCity) {
		this.stopCity = stopCity;
	}

	public String getStopState() {
		return stopState;
	}

	public void setStopState(String stopState) {
		this.stopState = stopState;
	}

	public int getStopPincode() {
		return stopPincode;
	}

	public void setStopPincode(int stopPincode) {
		this.stopPincode = stopPincode;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getStopStatus() {
		return stopStatus;
	}

	public void setStopStatus(String stopStatus) {
		this.stopStatus = stopStatus;
	}
	

	public String getRouteNum() {
		return routeNum;
	}

	public void setRouteNum(String routeNum) {
		this.routeNum = routeNum;
	}

	/*
	 * public BusRoutes getRoute() { return route; }
	 * 
	 * public void setRoute(BusRoutes route) { this.route = route; }
	 */	 
	
	
}

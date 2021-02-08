package com.example.busafcs.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bus_routes")
@NamedQueries({
		@NamedQuery(name = "BusRoutes.findByDepotNum", query = "SELECT br FROM BusRoutes br WHERE br.depotNum = :depotNum")

})
public class BusRoutes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7721128109103215911L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Long id;

	@Column(name = "routeNumber")
	private String routeNumber;

	@Column(name = "routeDescription")
	private String routeDescription;

	@Column(name = "sourceStop")
	private int sourceStop;

	@Column(name = "destStop")
	private int destStop;

	@Column(name = "noOfStops")
	private int noOfStops;

	@Column(name = "noOfBuses")
	private int noOfBuses;

	@Column(name = "busFrequency")
	private int busFrequency;

	@Column(name = "runningTime")
	private int runningTime;

	@Column(name = "distanceCovered")
	private int distanceCovered;

	@Column(name = "routeStatus")
	private int routeStatus;

	@Column(name = "createdOn")
	private Date createdOn;

	@Column(name = "createdBy")
	private String createdBy;

	@Column(name = "depotNum")
	private String depotNum;

	@OneToMany(targetEntity = BusStops.class, cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "routeId", referencedColumnName = "id")
	private List<BusStops> stops;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRouteNumber() {
		return routeNumber;
	}

	public void setRouteNumber(String routeNumber) {
		this.routeNumber = routeNumber;
	}

	public String getRouteDescription() {
		return routeDescription;
	}

	public void setRouteDescription(String routeDescription) {
		this.routeDescription = routeDescription;
	}

	public int getSourceStop() {
		return sourceStop;
	}

	public void setSourceStop(int sourceStop) {
		this.sourceStop = sourceStop;
	}

	public int getDestStop() {
		return destStop;
	}

	public void setDestStop(int destStop) {
		this.destStop = destStop;
	}

	public int getNoOfStops() {
		return noOfStops;
	}

	public void setNoOfStops(int noOfStops) {
		this.noOfStops = noOfStops;
	}

	public int getNoOfBuses() {
		return noOfBuses;
	}

	public void setNoOfBuses(int noOfBuses) {
		this.noOfBuses = noOfBuses;
	}

	public int getBusFrequency() {
		return busFrequency;
	}

	public void setBusFrequency(int busFrequency) {
		this.busFrequency = busFrequency;
	}

	public int getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}

	public int getDistanceCovered() {
		return distanceCovered;
	}

	public void setDistanceCovered(int distanceCovered) {
		this.distanceCovered = distanceCovered;
	}

	public int getRouteStatus() {
		return routeStatus;
	}

	public void setRouteStatus(int routeStatus) {
		this.routeStatus = routeStatus;
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

	public List<BusStops> getStops() {
		return stops;
	}

	public void setStops(List<BusStops> stops) {
		this.stops = stops;
	}

	public String getDepotNum() {
		return depotNum;
	}

	public void setDepotNum(String depotNum) {
		this.depotNum = depotNum;
	}

}

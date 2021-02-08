package com.example.busafcs.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Depot")
@NamedQueries
({
	@NamedQuery(name="Depot.findByDepotId", query="SELECT d FROM Depot d WHERE d.depotId = :depotId"),
	
})

public class Depot implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
	
	@Column(name = "depotId")
	private String depotId;
	
	@Column(name = "depotName")
	private String depotName;
	
	/*
	 * @OneToMany(targetEntity = BusRoutes.class, cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "depotId", referencedColumnName = "id") private
	 * List<BusRoutes> busRouteList;
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDepotId() {
		return depotId;
	}

	public void setDepotId(String depotId) {
		this.depotId = depotId;
	}

	public String getDepotName() {
		return depotName;
	}

	public void setDepotName(String depotName) {
		this.depotName = depotName;
	}


	/*
	 * public List<BusRoutes> getBusRouteList() { return busRouteList; }
	 * 
	 * public void setBusRouteList(List<BusRoutes> busRouteList) { this.busRouteList
	 * = busRouteList; }
	 * 
	 * 
	 */
}

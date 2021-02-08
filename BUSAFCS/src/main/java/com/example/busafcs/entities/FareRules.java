package com.example.busafcs.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FareRulebyDistance")
public class FareRules implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4087954070802808585L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
	
	@Column(name = "minDistance")
	private String minDistance;
	
	@Column(name = "maxDistance")
	private String maxDistance;
	
	@Column(name = "fareAmnt")
	private String fareAmnt;
	
	@Column(name = "status")
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMinDistance() {
		return minDistance;
	}

	public void setMinDistance(String minDistance) {
		this.minDistance = minDistance;
	}

	public String getMaxDistance() {
		return maxDistance;
	}

	public void setMaxDistance(String maxDistance) {
		this.maxDistance = maxDistance;
	}

	public String getFareAmnt() {
		return fareAmnt;
	}

	public void setFareAmnt(String fareAmnt) {
		this.fareAmnt = fareAmnt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
}

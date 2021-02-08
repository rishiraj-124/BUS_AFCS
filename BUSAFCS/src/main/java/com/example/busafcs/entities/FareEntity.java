package com.example.busafcs.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Fare")
@NamedQueries
({
	@NamedQuery(name="FareEntity.findBySrcDestCode", query="SELECT fe FROM FareEntity fe WHERE fe.srcStpId = :srcStpId AND fe.destStpId = :destStpId")
	
})
public class FareEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8526902554738754589L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
	
	@Column(name = "srcStpId")
	private String srcStpId;
	
	@Column(name = "destStpId")
	private String destStpId;
	
	@Column(name = "discAmnt")
	private int discAmnt;
	
	@Column(name = "fareAmnt")
	private int fareAmnt;
	
	@Column(name = "status")
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public int getDiscAmnt() {
		return discAmnt;
	}

	public void setDiscAmnt(int discAmnt) {
		this.discAmnt = discAmnt;
	}

	public int getFareAmnt() {
		return fareAmnt;
	}

	public void setFareAmnt(int fareAmnt) {
		this.fareAmnt = fareAmnt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
}

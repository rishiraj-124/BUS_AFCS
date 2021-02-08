package com.example.busafcs.entities;

import java.io.Serializable;
import java.sql.Timestamp;

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
@Table(name = "PassEntryExitDetail")
@NamedQueries
({
	@NamedQuery(name="PassEntryExitDetail.findByPassId", query="SELECT pe FROM PassEntryExitDetail pe WHERE pe.passbId = :passbId")
})
public class PassEntryExitDetail implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5814797179282893806L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Long id;
	
	@Column(name="tripEntryDtTime")
	private Timestamp tripEntryDtTime;
	
	@Column(name="tripExitDtTime")
	private Timestamp tripExitDtTime;
	
	@Column(name="tripNum")
	private String tripNum;
	
	@Column(name="passbId") 
	private String passbId;
	
	private PassEntryExitDetail() {}

	

	public PassEntryExitDetail(Timestamp tripEntryDtTime, Timestamp tripExitDtTime, String tripNum,
			String passbId) {
		super();
		//this.id = id;
		this.tripEntryDtTime = tripEntryDtTime;
		this.tripExitDtTime = tripExitDtTime;
		this.tripNum = tripNum;
		this.passbId = passbId;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getTripEntryDtTime() {
		return tripEntryDtTime;
	}

	public void setTripEntryDtTime(Timestamp tripEntryDtTime) {
		this.tripEntryDtTime = tripEntryDtTime;
	}

	public Timestamp getTripExitDtTime() {
		return tripExitDtTime;
	}

	public void setTripExitDtTime(Timestamp tripExitDtTime) {
		this.tripExitDtTime = tripExitDtTime;
	}

	public String getTripNum() {
		return tripNum;
	}

	public void setTripNum(String tripNum) {
		this.tripNum = tripNum;
	}



	public String getPassbId() {
		return passbId;
	}



	public void setPassbId(String passbId) {
		this.passbId = passbId;
	}


	
	
	
	
	
	
	
	
	

}

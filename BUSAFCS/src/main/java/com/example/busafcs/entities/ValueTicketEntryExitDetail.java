package com.example.busafcs.entities;

import java.io.Serializable;
import java.sql.Timestamp;

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
@Table(name = "ValueTicketEntryExitDetail")
@NamedQueries
({
	@NamedQuery(name="ValueTicketEntryExitDetail.findByValueId", query="SELECT v FROM ValueTicketEntryExitDetail v WHERE v.valueTktId = :valueTktId")
})

public class ValueTicketEntryExitDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1110448228454649711L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Long id;
	
	@Column(name="tripEntryDtTime")
	private Timestamp tripEntryDtTime;
	
	@Column(name="tripExitDtTime")
	private Timestamp tripExitDtTime;
	
	@Column(name="valueTktId") 
	private String valueTktId;
	
	@Column(name="entryStopId")
	private String entryStopId;
	
	@Column(name="exitStopId")
	private String exitStopId;
	
	@Column(name="tripNum")
	private String tripNum;

	
	
	public ValueTicketEntryExitDetail() {}
	
	

	public ValueTicketEntryExitDetail(Timestamp tripEntryDtTime, Timestamp tripExitDtTime, String valueTktId,
			String entryStopId, String exitStopId, String tripNum) {
		super();
		//this.id = id;
		this.tripEntryDtTime = tripEntryDtTime;
		this.tripExitDtTime = tripExitDtTime;
		this.valueTktId = valueTktId;
		this.entryStopId = entryStopId;
		this.exitStopId = exitStopId;
		this.tripNum = tripNum;
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

	public String getValueTktId() {
		return valueTktId;
	}

	public void setValueTktId(String valueTktId) {
		this.valueTktId = valueTktId;
	}

	public String getEntryStopId() {
		return entryStopId;
	}

	public void setEntryStopId(String entryStopId) {
		this.entryStopId = entryStopId;
	}

	public String getExitStopId() {
		return exitStopId;
	}

	public void setExitStopId(String exitStopId) {
		this.exitStopId = exitStopId;
	}
	
	public String getTripNum() {
		return tripNum;
	}
	
	public void setTripNum(String tripNum) {
		this.tripNum = tripNum;
	}
	
	
	
 
	
	
}

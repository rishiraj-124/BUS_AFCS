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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.busafcs.bean.TicketTxnData;

@Entity
@Table(name = "TransactionUploadUser")
public class TransactionUploadUser implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 128790383181741875L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
   
	@Column(name = "userId")
	private String userId;
	
	@Column(name = "readerId")
	private String readerId;
	
	@Column(name = "busNo")
	private String busNo;
	
	@Column(name = "trip")
	private String trip;
	
	@Column(name = "route")
	private String route;
	
	@Column(name = "busServiceType")
	private String busServiceType;
	
	@OneToMany(targetEntity=TicketTxnDataEntity.class,cascade = CascadeType.ALL, 
            orphanRemoval = true)
 	@JoinColumn(name = "txnUploaUserId", referencedColumnName = "id")
	private List<TicketTxnDataEntity> tktTxnList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getReaderId() {
		return readerId;
	}

	public void setReaderId(String readerId) {
		this.readerId = readerId;
	}

	public String getBusNo() {
		return busNo;
	}

	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}

	public String getTrip() {
		return trip;
	}

	public void setTrip(String trip) {
		this.trip = trip;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getBusServiceType() {
		return busServiceType;
	}

	public void setBusServiceType(String busServiceType) {
		this.busServiceType = busServiceType;
	}

	public List<TicketTxnDataEntity> getTktTxnList() {
		return tktTxnList;
	}

	public void setTktTxnList(List<TicketTxnDataEntity> tktTxnList) {
		this.tktTxnList = tktTxnList;
	}
	

	

}

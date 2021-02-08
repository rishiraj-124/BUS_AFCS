package com.example.busafcs.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TicketTransactionData")
public class TicketTxnDataEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
	
	@Column(name = "txnId")
	private String txnId;
	
	@Column(name = "txnStartDateTime")
	private String txnStartDateTime;
	
	@Column(name = "payMode")
	private String payMode;
	
	@Column(name = "custCardId")
	private String custCardId;
	
	@Column(name = "srcStop")
	private String srcStop;
	
	@Column(name = "destStop")
	private String destStop;
	
	@Column(name = "tktAmnt")
	private String tktAmnt;
	
	@Column(name = "totAmnt")
	private String totAmnt;
	
	@Column(name = "txnAmnt")
	private String txnAmnt;
	
	@ManyToOne
	@JoinColumn(name="txnUploaUserId", nullable=false) 
	private TransactionUploadUser transactionUploadUser;
	
	public TicketTxnDataEntity(){}

	public TicketTxnDataEntity(String txnId, String txnStartDateTime, String payMode, String custCardId,
			String srcStop, String destStop, String tktAmnt, String totAmnt, String txnAmnt,
			TransactionUploadUser transactionUploadUser) {
		super();
		//this.id = id;
		this.txnId = txnId;
		this.txnStartDateTime = txnStartDateTime;
		this.payMode = payMode;
		this.custCardId = custCardId;
		this.srcStop = srcStop;
		this.destStop = destStop;
		this.tktAmnt = tktAmnt;
		this.totAmnt = totAmnt;
		this.txnAmnt = txnAmnt;
		this.transactionUploadUser = transactionUploadUser;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTxnId() {
		return txnId;
	}

	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}

	public String getTxnStartDateTime() {
		return txnStartDateTime;
	}

	public void setTxnStartDateTime(String txnStartDateTime) {
		this.txnStartDateTime = txnStartDateTime;
	}

	public String getPayMode() {
		return payMode;
	}

	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}

	public String getCustCardId() {
		return custCardId;
	}

	public void setCustCardId(String custCardId) {
		this.custCardId = custCardId;
	}

	public String getSrcStop() {
		return srcStop;
	}

	public void setSrcStop(String srcStop) {
		this.srcStop = srcStop;
	}

	public String getDestStop() {
		return destStop;
	}

	public void setDestStop(String destStop) {
		this.destStop = destStop;
	}

	public String getTktAmnt() {
		return tktAmnt;
	}

	public void setTktAmnt(String tktAmnt) {
		this.tktAmnt = tktAmnt;
	}

	public String getTotAmnt() {
		return totAmnt;
	}

	public void setTotAmnt(String totAmnt) {
		this.totAmnt = totAmnt;
	}

	public String getTxnAmnt() {
		return txnAmnt;
	}

	public void setTxnAmnt(String txnAmnt) {
		this.txnAmnt = txnAmnt;
	}

	public TransactionUploadUser getTransactionUploadUser() {
		return transactionUploadUser;
	}

	public void setTransactionUploadUser(TransactionUploadUser transactionUploadUser) {
		this.transactionUploadUser = transactionUploadUser;
	}
	
	
   
}

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
@Table(name = "Discount")
public class DiscountEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1494134803715640458L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
	
	@Column(name = "discountId")
	private String discountId;
	
	@Column(name = "discountType")
	private String discountType;
	
	@Column(name = "discountInPer")
	private String discountInPer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDiscountId() {
		return discountId;
	}

	public void setDiscountId(String discountId) {
		this.discountId = discountId;
	}

	public String getDiscountType() {
		return discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	public String getDiscountInPer() {
		return discountInPer;
	}

	public void setDiscountInPer(String discountInPer) {
		this.discountInPer = discountInPer;
	}
	
	
	
}

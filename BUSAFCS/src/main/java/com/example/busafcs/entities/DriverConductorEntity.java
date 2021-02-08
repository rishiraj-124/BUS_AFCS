package com.example.busafcs.entities;

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
@Table(name = "DriverConductorUser")
@NamedQueries
({
	@NamedQuery(name="DriverConductorEntity.findByMobile", query="SELECT ue FROM DriverConductorEntity ue WHERE ue.mobile = :mobile"),
	@NamedQuery(name="DriverConductorEntity.findByEmpId", query="SELECT ue FROM DriverConductorEntity ue WHERE ue.employeeId = :employeeId"),
})
public class DriverConductorEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
	@Column(name = "employeeId")
	private String employeeId;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "depotId")
	private String depotId;
	
	@Column(name = "depotName")
	private String depotName;
	
	@Column(name = "busAssigned")
	private String busAssigned;
	
	@Column(name = "emailId")
	private String emailId;
	
	@Column(name = "mobile")
	private String mobile;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "mpin")
	private String mpin;
	
	@Column(name = "password")
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public String getBusAssigned() {
		return busAssigned;
	}

	public void setBusAssigned(String busAssigned) {
		this.busAssigned = busAssigned;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMpin() {
		return mpin;
	}

	public void setMpin(String mpin) {
		this.mpin = mpin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}

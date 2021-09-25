package com.springboot.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="driver")
public class Driver {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="firstname")
	private String firstname;
	@Column(name="lastname")
	private String lastname;
	@Column(name="dob")
	private String dob;
	@Column(name="address")
	private String address;
//	@Column(name="upload_License")
//	private byte[] upload_License;
	@Column(name="license_Number")
	private String license_Number;
	@Column(name="license_expiry_date")
	private String license_expiry_date;
	
	
	
	
	public Driver() {
		super();
	}
	public Driver(String firstname, String lastname, String dob, String address, 
			String license_Number, String license_expiry_date) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.address = address;
		
		this.license_Number = license_Number;
		this.license_expiry_date = license_expiry_date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getLicense_Number() {
		return license_Number;
	}
	public void setLicense_Number(String license_Number) {
		this.license_Number = license_Number;
	}
	public String getLicense_expiry_date() {
		return license_expiry_date;
	}
	public void setLicense_expiry_date(String license_expiry_date) {
		this.license_expiry_date = license_expiry_date;
	}
	
	
	
}

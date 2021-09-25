package com.springboot.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vehicle")
public class Vehicle {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="vehicle_name")
	private String vehicle_Name;
	@Column(name="vehicle_Model")
	private String vehicle_Model;
	@Column(name="vehicle_Year")
	private String vehicle_Year;
	@Column(name="chassis_Number")
	private String chassis_Number;
	@Column(name="registration_Number")
	private String registration_Number;
	@Column(name="fuel_Type")
	private String fuel_Type;
	
	
	
	public Vehicle() {
		super();
	}

	public Vehicle(String vehicle_Name, String vehicle_Model, String vehicle_Year, String chassis_Number,
			String registration_Number, String fuel_Type) {
		super();
		this.vehicle_Name = vehicle_Name;
		this.vehicle_Model = vehicle_Model;
		this.vehicle_Year = vehicle_Year;
		this.chassis_Number = chassis_Number;
		this.registration_Number = registration_Number;
		this.fuel_Type = fuel_Type;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVehicle_Name() {
		return vehicle_Name;
	}
	public void setVehicle_Name(String vehicle_Name) {
		this.vehicle_Name = vehicle_Name;
	}
	public String getVehicle_Model() {
		return vehicle_Model;
	}
	public void setVehicle_Model(String vehicle_Model) {
		this.vehicle_Model = vehicle_Model;
	}
	public String getVehicle_Year() {
		return vehicle_Year;
	}
	public void setVehicle_Year(String vehicle_Year) {
		this.vehicle_Year = vehicle_Year;
	}
	public String getChassis_Number() {
		return chassis_Number;
	}
	public void setChassis_Number(String chassis_Number) {
		this.chassis_Number = chassis_Number;
	}
	public String getRegistration_Number() {
		return registration_Number;
	}
	public void setRegistration_Number(String registration_Number) {
		this.registration_Number = registration_Number;
	}
	public String getFuel_Type() {
		return fuel_Type;
	}
	public void setFuel_Type(String fuel_Type) {
		this.fuel_Type = fuel_Type;
	}
	
	
	
}

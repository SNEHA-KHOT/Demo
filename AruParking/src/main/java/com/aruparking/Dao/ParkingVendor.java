package com.aruparking.Dao;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "PARKING_VENDOR")
@NamedQuery(name = "ParkingVendor.findAll", query = "SELECT t FROM ParkingVendor t")
public class ParkingVendor {
	
	@Id
	@Column(name = "VENDOR_ID")
	private long vendorId;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "VENDOR_TYPE")
	private String vendorType;
	
	@Column(name = "EMAIL_ID")
	private String emailId;
	
	@Column(name = "LANGUAGE")
	private String language;
	
	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "DOB")
	private Date dob;
	
	
	

}

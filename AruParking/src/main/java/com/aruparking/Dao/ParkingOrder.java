package com.aruparking.Dao;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "PARKING_ORDER")
@NamedQuery(name = "ParkingOrder.finedAll", query = "SELECT e FROM ParkingOrder e")
public class ParkingOrder {
	
	
	@Id
	@SequenceGenerator(name = "PARKING_ORDER_ID_GENERATOR", sequenceName="PARKING_ORDER_SEQ",initialValue = 1, allocationSize = 1 )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PARKING_ORDER_ID_GENERATOR")
	@Column(name = "ID",nullable=false,unique=true)
	private long id;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="AMOUNT")
	private BigDecimal amount;
	
	@Column(name="VEHICLE_NO")
	private String vehicleNo;
	
	@Column(name="CONTACT_NO")
	private String contactNo;
	
	@Column(name="FINE_NO")
	private long fineNo;
	
	@Column(name="TRANSACTION_ID")
	private String trasactionId;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	@JsonManagedReference
	private ParkingUsers parkingUser;

	@ManyToOne
	@JoinColumn(name = "SLOT_ID")
	@JsonManagedReference
	private ParkingZoneSlot parkingZoneSlot;
	
	@Column(name = "PARKING_START_TIME", updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date parkingStartTime;

	@Column(name = "PARKING_END_TIME", updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date parkingEndTime;
	
	@Column(name = "CREATED_ON", updatable=false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	@Column(name="LAST_MODIFIED_ON")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdatedOn;

	public ParkingOrder() {
		super();
		
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public BigDecimal getAmount() {
		return amount;
	}


	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	public String getVehicleNo() {
		return vehicleNo;
	}


	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}


	public String getContactNo() {
		return contactNo;
	}


	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}


	public ParkingUsers getParkingUser() {
		return parkingUser;
	}


	public void setParkingUser(ParkingUsers parkingUser) {
		this.parkingUser = parkingUser;
	}


	public Date getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}


	public Date getLastUpdatedOn() {
		return lastUpdatedOn;
	}


	public void setLastUpdatedOn(Date lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}


	


	public ParkingZoneSlot getParkingZoneSlot() {
		return parkingZoneSlot;
	}


	public void setParkingZoneSlot(ParkingZoneSlot parkingZoneSlot) {
		this.parkingZoneSlot = parkingZoneSlot;
	}


	public String getTrasactionId() {
		return trasactionId;
	}


	public void setTrasactionId(String trasactionId) {
		this.trasactionId = trasactionId;
	}


	public Date getParkingStartTime() {
		return parkingStartTime;
	}


	public void setParkingStartTime(Date parkingStartTime) {
		this.parkingStartTime = parkingStartTime;
	}


	public Date getParkingEndTime() {
		return parkingEndTime;
	}


	public void setParkingEndTime(Date parkingEndTime) {
		this.parkingEndTime = parkingEndTime;
	}


	public long getFineNo() {
		return fineNo;
	}


	public void setFineNo(long fineNo) {
		this.fineNo = fineNo;
	}


	


	
	
	
	

}

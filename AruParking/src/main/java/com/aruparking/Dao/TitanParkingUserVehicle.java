package com.aruparking.Dao;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@jakarta.persistence.Entity
@Table(name = "TITAN_PARKING_USER_VEHICLE")
@NamedQuery(name = "TitanParkingUserVehicle.finedAll", query = "SELECT e FROM TitanParkingUserVehicle e")
public class TitanParkingUserVehicle implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "TITAN_PARKING_USER_VEHICLE_ID_GENERATOR", sequenceName="TITAN_PARKING_USER_VEHICLE_SEQ",initialValue = 1, allocationSize = 1 )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TITAN_PARKING_USER_VEHICLE_ID_GENERATOR")
	@Column(name = "ID",nullable=false,unique=true)
	private long id;
	
	@Column(name="VEHICLE_NO")
	private String vehicleNo;
	
	@Column(name="VEHICLE_NAME")
	private String vehicleName;
	
	
	@Column(name = "DEFAULT_FLAG")
	private boolean defaultFlag;
	
	@Column(name = "FAV_FLAG")
	private boolean favFlag;
	
	@Column(name = "STATUS")
	private int status;
	
	@Column(name = "CREATED_ON", updatable = false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@Column(name = "LAST_MODIFIED_ON")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdatedOn;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	@JsonManagedReference
	//@NotAudited
	private ParkingUsers parkingUsers;

	public TitanParkingUserVehicle() { super(); }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public boolean isDefaultFlag() {
		return defaultFlag;
	}

	public void setDefaultFlag(boolean defaultFlag) {
		this.defaultFlag = defaultFlag;
	}

	public boolean isFavFlag() {
		return favFlag;
	}

	public void setFavFlag(boolean favFlag) {
		this.favFlag = favFlag;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public ParkingUsers getParkingUsers() {
		return parkingUsers;
	}

	public void setParkingUsers(ParkingUsers parkingUsers) {
		this.parkingUsers = parkingUsers;
	}

	
}

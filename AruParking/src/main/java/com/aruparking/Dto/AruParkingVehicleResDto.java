package com.aruparking.Dto;

import java.util.Date;

public class AruParkingVehicleResDto {
	
	private long userId;
	private long id;
	private String vehicleNo;
	private Date createdDate;
	private Date lastModifiedDate;
	private int status;
	private boolean defaultVehicle;
	private boolean favVehicle;
	private String vehicleName;
	
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
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public boolean isDefaultVehicle() {
		return defaultVehicle;
	}
	public void setDefaultVehicle(boolean defaultVehicle) {
		this.defaultVehicle = defaultVehicle;
	}
	public boolean isFavVehicle() {
		return favVehicle;
	}
	public void setFavVehicle(boolean favVehicle) {
		this.favVehicle = favVehicle;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	
	
	
	

}

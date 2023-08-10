package com.aruparking.Dto;

public class AruParkingVehicleReqDto {
	
	private long userId;
	private long id;
	private boolean defaultVehicle;
	private boolean favVehicle;
	private String vehicleNo;
	private String vehicleName;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	
	
	
	
	

}

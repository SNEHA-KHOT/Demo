package com.aruparking.Dto;

public class ParkingZoneDto {
	
	private long zoneId;
	private String zoneName;
	private int status;
	
	public ParkingZoneDto() {
		super();
		
	}
	public long getZoneId() {
		return zoneId;
	}
	public void setZoneId(long zoneId) {
		this.zoneId = zoneId;
	}
	public String getZoneName() {
		return zoneName;
	}
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	

}

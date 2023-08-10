package com.aruparking.Dto;

import java.util.Date;

public class ParkingZoneSlotResDto {
	
	
	private long slotId;
	private String spaceNum;
	private long zoneId;
	private Date createdOn;
	private Date lastUpdatedOn;
	private int status;
	
	public ParkingZoneSlotResDto() {
		super();
		
	}

	public long getSlotId() {
		return slotId;
	}

	public void setSlotId(long slotId) {
		this.slotId = slotId;
	}

	public String getSpaceNum() {
		return spaceNum;
	}

	public void setSpaceNum(String spaceNum) {
		this.spaceNum = spaceNum;
	}

	public long getZoneId() {
		return zoneId;
	}

	public void setZoneId(long zoneId) {
		this.zoneId = zoneId;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	

}

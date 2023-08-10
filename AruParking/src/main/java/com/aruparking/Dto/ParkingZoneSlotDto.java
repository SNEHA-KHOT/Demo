package com.aruparking.Dto;

public class ParkingZoneSlotDto {
	
	private long slotId;
	private String slotName;
	private long zoneId;
	
	public ParkingZoneSlotDto() {
		super();
		
	}

	public long getSlotId() {
		return slotId;
	}

	public void setSlotId(long slotId) {
		this.slotId = slotId;
	}

	public String getSlotName() {
		return slotName;
	}

	public void setSlotName(String slotName) {
		this.slotName = slotName;
	}

	public long getZoneId() {
		return zoneId;
	}

	public void setZoneId(long zoneId) {
		this.zoneId = zoneId;
	}
	
	

}

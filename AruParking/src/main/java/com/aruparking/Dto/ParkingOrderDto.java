package com.aruparking.Dto;

import java.math.BigDecimal;

public class ParkingOrderDto {
	
	private long userId;
	private long slotId;
	private long feeId;
	private String vehicleNo;
	private String contactNo;
	private BigDecimal amount;
	
	public ParkingOrderDto() {
		super();
		
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getSlotId() {
		return slotId;
	}

	public void setSlotId(long slotId) {
		this.slotId = slotId;
	}

	public long getFeeId() {
		return feeId;
	}

	public void setFeeId(long feeId) {
		this.feeId = feeId;
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

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	

}

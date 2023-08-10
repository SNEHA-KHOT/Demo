package com.aruparking.Dto;

import java.math.BigDecimal;
import java.util.Date;

public class PurchasePastDto {
	
	private long userId;
	private long slotId;
	private long zoneId;
	private Long orderId;
	private BigDecimal Amount;
	private String TransactioId;
	private Date parkingStartTime;
	private Date parkingEndTime;
	private String payee;
	private String vehicleNo;
	private String slotName;
	private long fineId;

	public PurchasePastDto() {
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

	public long getZoneId() {
		return zoneId;
	}

	public void setZoneId(long zoneId) {
		this.zoneId = zoneId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public BigDecimal getAmount() {
		return Amount;
	}

	public void setAmount(BigDecimal amount) {
		Amount = amount;
	}

	public String getTransactioId() {
		return TransactioId;
	}

	public void setTransactioId(String transactioId) {
		TransactioId = transactioId;
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

	public String getPayee() {
		return payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getSlotName() {
		return slotName;
	}

	public void setSlotName(String slotName) {
		this.slotName = slotName;
	}

	public long getFineId() {
		return fineId;
	}

	public void setFineId(long fineId) {
		this.fineId = fineId;
	}

	
	
	

}

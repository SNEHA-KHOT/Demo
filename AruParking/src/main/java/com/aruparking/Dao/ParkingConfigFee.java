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
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "PARKING_CONFIG_FEE")
@NamedQuery(name = "ParkingConfigFee.finedAll", query = "SELECT e FROM ParkingConfigFee e")
public class ParkingConfigFee {
	

	@Id
	@SequenceGenerator(name = "PARKING_CONFIG_FEE_ID_GENERATOR", sequenceName="PARKING_CONFIG_FEE_SEQ",initialValue = 1, allocationSize = 1 )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PARKING_CONFIG_FEE_ID_GENERATOR")
	@Column(name = "ID",nullable=false,unique=true)
	private long id;
	
	@Column(name="AMOUNT")
	private BigDecimal amount;
	
	@Column(name="TIMING")
	private String timing;
	
	@Column(name = "CREATED_ON", updatable=false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	@Column(name="LAST_MODIFIED_ON")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdatedOn;

	public ParkingConfigFee() {
		super();
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getTiming() {
		return timing;
	}

	public void setTiming(String timing) {
		this.timing = timing;
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
	
	
	

}

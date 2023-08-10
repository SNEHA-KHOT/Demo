package com.aruparking.Dao;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "PARKING_ZONES_SLOT")
@NamedQuery(name = "ParkingZoneSlot.finedAll", query = "SELECT e FROM ParkingZoneSlot e")
public class ParkingZoneSlot implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "PARKING_ZONES_SLOT_ID_GENERATOR", sequenceName="PARKING_ZONES_SLOT_SEQ",initialValue = 1, allocationSize = 1 )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PARKING_ZONES_SLOT_ID_GENERATOR")
	@Column(name = "ID",nullable=false,unique=true)
	private long id;
	
	@Column(name="SLOT")
	private String slot;
	
	@Column(name="STATUS")
	private int status;
	
	@ManyToOne
	@JoinColumn(name="ZONE_ID" )
	@JsonManagedReference 
	private ParkingZones parkingZones;
	
	@Column(name = "CREATED_ON", updatable=false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	@Column(name="LAST_MODIFIED_ON")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdatedOn;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public ParkingZones getParkingZones() {
		return parkingZones;
	}

	public void setParkingZones(ParkingZones parkingZones) {
		this.parkingZones = parkingZones;
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

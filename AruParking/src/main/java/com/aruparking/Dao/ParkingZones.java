package com.aruparking.Dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
//@Audited
@Table(name = "PARKING_ZONES")
@NamedQuery(name = "ParkingZones.finedAll", query = "SELECT e FROM ParkingZones e")
public class ParkingZones implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "PARKING_ZONES_ID_GENERATOR", sequenceName="PARKING_ZONES_SEQ",initialValue = 1, allocationSize = 1 )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PARKING_ZONES_ID_GENERATOR")
	@Column(name = "ID",nullable=false,unique=true)
	private long id;
	
	
	@Column(name="ZONE_NAME")
	private String zoneName;
	
	@Column(name="STATUS")
	private int status;
	
	@Column(name = "CREATED_ON", updatable=false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	@Column(name="LAST_MODIFIED_ON")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdatedOn;
	
	
	
	@ManyToOne
	@JoinColumn(name = "VENDOR_ID")
	@JsonManagedReference
	private ParkingVendor parkingVendor;
	
	public ParkingZones() {
		super();
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	

	public ParkingVendor getParkingVendor() {
		return parkingVendor;
	}

	public void setParkingVendor(ParkingVendor parkingVendor) {
		this.parkingVendor = parkingVendor;
	}
	
	

}

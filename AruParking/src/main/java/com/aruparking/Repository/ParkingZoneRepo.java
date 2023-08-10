package com.aruparking.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aruparking.Dao.ParkingZones;

@Repository
public interface ParkingZoneRepo extends CrudRepository<ParkingZones, Long>{
	
	List<ParkingZones> findAll();
	ParkingZones findById(long zoneId);
	ParkingZones findByZoneName(String zoneName);

}

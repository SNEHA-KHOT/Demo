package com.aruparking.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aruparking.Dao.ParkingZoneSlot;
import com.aruparking.Dao.ParkingZones;

@Repository
public interface ParkingZoneSlotRepo extends CrudRepository<ParkingZoneSlot, Long> {

	
	ParkingZoneSlot findById(long slotId);
	ParkingZoneSlot findByslot(String slotName);
	
	List<ParkingZoneSlot> findByParkingZonesId(long zoneId);
	ParkingZoneSlot findByslotAndParkingZonesId(String slotName, long l);
	
}

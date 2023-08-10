package com.aruparking.Vendor.services;

import java.util.List;

import com.aruparking.Dto.ParkingZoneDto;
import com.aruparking.Dto.ParkingZoneSlotDto;
import com.aruparking.Dto.PurchasePastDto;

public interface VendorService {

	Object getAllZone();
	
	Object getZoneById(long zoneId);
	
	Object createZone(ParkingZoneDto zone);

	Object updateZone(ParkingZoneDto zone);

	Object getSlotsByZone(long zoneId);

	Object getSlotsById(long slotId);

	Object createSlot(ParkingZoneSlotDto slot);

	Object updateSlot(ParkingZoneSlotDto slot);

	List<PurchasePastDto> getParkingHistoryOfZone(long zoneId);

	List<PurchasePastDto> getParkingHistoryOfSlot(long slotId);

	

}

package com.aruparking.Vendor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aruparking.Dto.ParkingZoneDto;
import com.aruparking.Dto.ParkingZoneSlotDto;
import com.aruparking.Dto.PurchasePastDto;
import com.aruparking.Vendor.services.VendorService;

@RestController
public class VendorController {
	
	@Autowired
	VendorService vendorService;

	//Zones
		@GetMapping(path = "v1/vendor/parking/zones",produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Object> getAllZone() /* throws Exception */{
			Object obj = vendorService.getAllZone();
			return new ResponseEntity<Object>(obj, HttpStatus.OK);
		}
		
		//ZoneById
		@GetMapping(path = "v1/vendor/parking/zone/{zoneId}",produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Object> getZoneById(@PathVariable("zoneId") long zoneId) {
			
			
			Object obj = vendorService.getZoneById(zoneId);
			return new ResponseEntity<Object>(obj, HttpStatus.OK);
		}
		
	    //createZone
		@PostMapping(path = "v1/vendor/parking/zone",consumes=MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Object> createZone( @RequestBody ParkingZoneDto zone){
			Object obj=vendorService.createZone(zone);
			return new ResponseEntity<Object>(obj, HttpStatus.OK);
		}
		
		
	
		
		//updateZone
		@PutMapping(value = "v1/vendor/parking/zone/update",consumes=MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Object> updateZone( @RequestBody ParkingZoneDto zone ) 
		{   Object obj=vendorService.updateZone(zone);
			return new ResponseEntity<Object>(obj, HttpStatus.OK);
			
		}
		
		
		
		
		
		
		//SlotsOfZone
		@GetMapping(path = "v1/vendor/parking/zone/slot/{zoneId}",produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Object> getSlotsByZone(@PathVariable long zoneId) {
			
			
			Object obj =vendorService.getSlotsByZone(zoneId);
			return new ResponseEntity<Object>(obj, HttpStatus.OK);
		}
		
		//SlotById
		@GetMapping(path = "v1/vendor/parking/slot/{slotId}",produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Object> getSlotsById(@PathVariable long slotId) {
			
			Object obj =vendorService.getSlotsById(slotId);
			return new ResponseEntity<Object>(obj, HttpStatus.OK);
		}
		
		
		
		//createSlot
		@PostMapping(path = "v1/vendor/parking/zone/slot",consumes=MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Object> createSlot( @RequestBody ParkingZoneSlotDto slot){
			
			Object obj=vendorService.createSlot(slot);
		  return new ResponseEntity<Object>(obj, HttpStatus.OK);
			}
			
		@PutMapping(value = "v1/vendor/parking/slot/update",consumes=MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Object> updateSlot( @RequestBody ParkingZoneSlotDto slot ) 
		{
			
			Object obj=vendorService.updateSlot(slot);
			return new ResponseEntity<Object>(obj, HttpStatus.OK);
			
		}
		
		
		//HISTORY
		
		@GetMapping(path ="v1/vendor/parking/zone/history/{zoneId}", produces = MediaType.APPLICATION_JSON_VALUE)
		public List<PurchasePastDto> getParkingZoneHistory(@PathVariable long zoneId){
			List<PurchasePastDto> orders = vendorService.getParkingHistoryOfZone(zoneId);
			return orders;
		}
		
		@GetMapping(path ="v1/vendor/parking/zone/slot/history/{slotId}", produces = MediaType.APPLICATION_JSON_VALUE)
		public List<PurchasePastDto> getParkingSlotHistory(@PathVariable long slotId){
			List<PurchasePastDto> orders = vendorService.getParkingHistoryOfSlot(slotId);
			return orders;
		}
		
		
		

}

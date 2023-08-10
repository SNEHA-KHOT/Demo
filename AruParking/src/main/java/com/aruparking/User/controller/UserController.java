package com.aruparking.User.controller;

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

import com.aruparking.Dto.AruParkingVehicleReqDto;
import com.aruparking.Dto.ParkingOrderDto;
import com.aruparking.Dto.PurchasePastDto;
import com.aruparking.User.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(path = "v1/parking/zone/all",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getAllZone() /* throws Exception */{
		
		Object obj = userService.getAllZone();
		return new ResponseEntity<Object>(obj, HttpStatus.OK);
	}
	
	@GetMapping(path = "v1/parking/zone/slot/{zoneId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getSlotsByZone(@PathVariable long zoneId) {
		Object obj = userService.getSlotsByZone(zoneId);
		return new ResponseEntity<Object>(obj, HttpStatus.OK);
		
	}

	@PostMapping(path = "v1/parking/zone/order/placement",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> orderPlacement(@RequestBody ParkingOrderDto order) throws Exception{
		
		Object obj = userService.orderPlacement(order);
		return new ResponseEntity<Object>(obj, HttpStatus.OK);
	} 
	
	@GetMapping(path ="v1/parking/zone/history/past/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PurchasePastDto> getParkingHistory(@PathVariable long userId){
		List<PurchasePastDto> orders = userService.getParkingHistoryOfUser(userId,2);
		return orders;
	}
	
	@GetMapping(path ="v1/parking/zone/history/active/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PurchasePastDto> getActiveParkingHistory(@PathVariable long userId){
		
		List<PurchasePastDto> orders =userService.getParkingHistoryOfUser(userId,1);
		return orders;
	}
	
	//Vehicle Account
	
	
	@PostMapping(path = "v1/parking/zone/vehicle/add")
	public ResponseEntity<Object> saveAccount(@RequestBody AruParkingVehicleReqDto car) throws Exception{
		
		
		Object obj = userService.saveVehicle( car);
		return new ResponseEntity<Object>(obj, HttpStatus.OK);
	}
	
	@PutMapping(path = "v1/parking/zone/vehicle/remove/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> deleteAccount(@PathVariable ("id") long id ) throws Exception{
		
		Object obj = userService.deleteVehicle( id);
		return new ResponseEntity<Object>(obj, HttpStatus.OK);
	}
}

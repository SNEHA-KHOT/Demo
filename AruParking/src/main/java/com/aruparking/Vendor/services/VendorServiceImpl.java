package com.aruparking.Vendor.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aruparking.Dao.ParkingOrder;
import com.aruparking.Dao.ParkingZoneSlot;
import com.aruparking.Dao.ParkingZones;
import com.aruparking.Dto.ParkingZoneDto;
import com.aruparking.Dto.ParkingZoneResDto;
import com.aruparking.Dto.ParkingZoneSlotDto;
import com.aruparking.Dto.ParkingZoneSlotResDto;
import com.aruparking.Dto.PurchasePastDto;
import com.aruparking.Repository.ParkingOrderRepo;
import com.aruparking.Repository.ParkingZoneRepo;
import com.aruparking.Repository.ParkingZoneSlotRepo;

@Service
public class VendorServiceImpl implements VendorService {

	@Autowired
	ParkingZoneRepo parkingZoneRepo;
	
	@Autowired
	ParkingZoneSlotRepo parkingZoneSlotRepo;
	
	@Autowired
	ParkingOrderRepo parkingOrderRepo;
	
	
	private static Logger log = LoggerFactory.getLogger(VendorServiceImpl.class);
	
	
	//Zone
	
	@Override
	public Object getAllZone() {
		List<ParkingZoneDto> zDtoList = new ArrayList<ParkingZoneDto>();
		List<ParkingZones> pZones = parkingZoneRepo.findAll();
		for (ParkingZones zone : pZones) {
			ParkingZoneDto zDto = new ParkingZoneDto();
			zDto.setZoneId(zone.getId());
			zDto.setZoneName(zone.getZoneName());
			zDto.setStatus(zone.getStatus());
			zDtoList.add(zDto);
		}
		return zDtoList;
	}

	@Override
	public Object getZoneById(long zoneId) {
		ParkingZones zone=parkingZoneRepo.findById(zoneId);
		if(zone!= null) {
			ParkingZoneResDto zDto=DaoToDto(zone);
			return zDto;
	}else {
		throw new RuntimeException("Zone does not exist");
	}
	}
	
	private ParkingZoneResDto DaoToDto(ParkingZones zone) {
		ParkingZoneResDto zDto = new ParkingZoneResDto();
		zDto.setZoneId(zone.getId());
		zDto.setZoneName(zone.getZoneName());
		zDto.setStatus(zone.getStatus());
		zDto.setCreatedOn(zone.getCreatedOn());
		zDto.setLastUpdatedOn(zone.getLastUpdatedOn());
		
		return zDto;
		}
	
	@Override
	public Object createZone(ParkingZoneDto zone) {
		try {
			
			ParkingZones pZone =parkingZoneRepo.findByZoneName(zone.getZoneName());
		if(pZone != null) {
			throw new RuntimeException("Zone already exists");
		}else {
			ParkingZones pZone1= new ParkingZones();
			
			
			pZone1.setZoneName(zone.getZoneName());
			pZone1.setStatus(zone.getStatus());
			
				parkingZoneRepo.save(pZone1);
				ParkingZoneResDto zDto=DaoToDto(pZone1);
						
			return zDto;
		}}catch (Exception e) {
			log.info("Vendor AruParking createZone api error  {} ",e);
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public Object updateZone(ParkingZoneDto pZone) {
		try {
			ParkingZones dbZone = parkingZoneRepo.findById( pZone.getZoneId());
				
			if(pZone != null && dbZone != null ) {
				
			
			dbZone.setZoneName(pZone.getZoneName());
			dbZone.setStatus(pZone.getStatus());
			
			
			parkingZoneRepo.save(dbZone);
			ParkingZoneResDto zDto=DaoToDto(dbZone);
	       
			return zDto;
			
			}else {
			       throw new RuntimeException("Zone does not exist");
			}}catch (Exception e) {

				log.info("Vendor AruParking updateZone api error  {} ",e);
				e.printStackTrace();
				throw new RuntimeException(e.getMessage());}
	}


	
	//SLOT
	
	
	
	@Override
	public Object getSlotsByZone(long zoneId) {
		
		List<ParkingZoneSlotDto> sDtoList = new ArrayList<ParkingZoneSlotDto>();
		List<ParkingZoneSlot> pSlots =  parkingZoneSlotRepo.findByParkingZonesId(zoneId);
		
		for (ParkingZoneSlot slot : pSlots) {
			ParkingZoneSlotDto sDto = new ParkingZoneSlotDto();
			sDto.setSlotId(slot.getId());
			sDto.setSlotName(slot.getSlot());
			sDto.setZoneId(slot.getParkingZones().getId());
			sDtoList.add(sDto);
		}
		return sDtoList;
	}

	@Override
	public Object getSlotsById(long slotId) {
		ParkingZoneSlot pSlot=parkingZoneSlotRepo.findById(slotId);
		if(pSlot!= null) {
		ParkingZoneSlotResDto sDto = DaoToDto2(pSlot);
		return sDto;
		}else {
			throw new RuntimeException("Slot does not exist");}
	}
	
	private  ParkingZoneSlotResDto DaoToDto2(ParkingZoneSlot slot) {
		ParkingZoneSlotResDto sDto = new ParkingZoneSlotResDto();
		sDto.setSlotId(slot.getId());
		sDto.setSpaceNum(slot.getSlot());
		sDto.setZoneId(slot.getParkingZones().getId());
		sDto.setStatus(slot.getStatus());
		sDto.setCreatedOn(slot.getCreatedOn());
		sDto.setLastUpdatedOn(slot.getLastUpdatedOn());
		
		return sDto;
		}


	@Override
	public Object createSlot(ParkingZoneSlotDto slot) {
		
		try {
			ParkingZones pZone = parkingZoneRepo.findById( slot.getZoneId());
			if(pZone != null) {
			ParkingZoneSlot pSlot=parkingZoneSlotRepo.findByslotAndParkingZonesId(slot.getSlotName(),slot.getZoneId());
			if(pSlot != null) { 
				//throw new RuntimeException("Slot already exists");
				Map<String,String> map = new HashMap<String,String>();
				map.put("errorMessage", "Slot already exists");
				return map;
				
				
			}else {
				ParkingZoneSlot pSlot1= new ParkingZoneSlot();
				pSlot1.setSlot(slot.getSlotName());
				pSlot1.setParkingZones(pZone);
				pSlot1.setStatus(1);
				pSlot1 = parkingZoneSlotRepo.save(pSlot1);
				return DaoToDto2( pSlot1);
			}}else {
				//throw new RuntimeException("zone doesn't exist");
				Map<String,String> map = new HashMap<String,String>();
				map.put("errorMessage", "zone doesn't exist");
				return map;
			}
			}catch (Exception e) {
				log.info("Vendor AruParking createSlot api error  {} ",e);
				e.printStackTrace();
				throw new RuntimeException(e.getMessage());
			}
	}

	@Override
	public Object updateSlot(ParkingZoneSlotDto pslot) {
		try {
			ParkingZoneSlot dbSlot=parkingZoneSlotRepo.findById(pslot.getSlotId());
				
			if(pslot != null && dbSlot != null ) {
				
				dbSlot.setSlot(pslot.getSlotName());
				
				ParkingZoneSlot dbslot1=parkingZoneSlotRepo.save(dbSlot);
				ParkingZoneSlotResDto sDto=DaoToDto2(dbslot1);
	       
			return sDto;
			
			}else {
			       throw new RuntimeException("Slot does not exist");
			}}catch (Exception e) {

				log.info("Vendor AruParking updateSlot api error  {} ",e);
				e.printStackTrace();
				throw new RuntimeException(e.getMessage());}
	}

	@Override
	public List<PurchasePastDto> getParkingHistoryOfZone(long zoneId) {
		
		
		Date strtDate = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(strtDate);
		c.add(Calendar.HOUR, -23);
		Date endDate = c.getTime();
		
		
		
		
		List<PurchasePastDto> pDtoList = new ArrayList<PurchasePastDto>();
		//List<ParkingOrder> orders =  parkingOrderRepo.findByParkingEndTimeBetweenAndParkingZoneSlotParkingZonesIdOrderByCreatedOnDesc(endDate,strtDate,zoneId);
		List<ParkingOrder> orders =  parkingOrderRepo.findByParkingZoneSlotParkingZonesIdOrderByCreatedOnDesc(zoneId);
		 for (ParkingOrder order : orders) {
			 
			 pDtoList.add(DAOtoDTOHistory(order));
		 }
			 
		return pDtoList;
	}

	private PurchasePastDto DAOtoDTOHistory(ParkingOrder order) {

		PurchasePastDto pastDto = new PurchasePastDto();
		
		pastDto.setAmount(order.getAmount());
		pastDto.setFineId(order.getFineNo());
		pastDto.setOrderId(order.getId());
		pastDto.setParkingStartTime(order.getParkingStartTime());
		pastDto.setParkingEndTime(order.getParkingEndTime());
		pastDto.setPayee("AruParking");
		pastDto.setSlotId(order.getParkingZoneSlot().getId());
		pastDto.setSlotName(order.getParkingZoneSlot().getSlot());
		pastDto.setTransactioId(order.getTrasactionId());
		pastDto.setUserId(order.getParkingUser().getUserId());
		pastDto.setVehicleNo(order.getVehicleNo());
		pastDto.setZoneId(order.getParkingZoneSlot().getParkingZones().getId());
		
		return pastDto;
	}

	@Override
	public List<PurchasePastDto> getParkingHistoryOfSlot(long slotId) {
		
		List<PurchasePastDto> pDtoList = new ArrayList<PurchasePastDto>();
		List<ParkingOrder> orders =  parkingOrderRepo.findByParkingZoneSlotIdOrderByCreatedOnDesc(slotId);
		 for (ParkingOrder order : orders) {
			 
			 pDtoList.add(DAOtoDTOHistory(order));
		 }
			 
		return pDtoList;
	}
	}

	



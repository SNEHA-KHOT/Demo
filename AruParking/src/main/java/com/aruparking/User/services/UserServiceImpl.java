package com.aruparking.User.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.time.DateUtils;
import com.aruparking.Dao.ParkingConfigFee;
import com.aruparking.Dao.ParkingOrder;
import com.aruparking.Dao.ParkingUsers;
import com.aruparking.Dao.ParkingZoneSlot;
import com.aruparking.Dao.ParkingZones;
import com.aruparking.Dao.TitanParkingUserVehicle;
import com.aruparking.Dto.AruParkingVehicleReqDto;
import com.aruparking.Dto.AruParkingVehicleResDto;
import com.aruparking.Dto.ParkingOrderDto;
import com.aruparking.Dto.ParkingZoneDto;
import com.aruparking.Dto.ParkingZoneSlotDto;
import com.aruparking.Dto.PurchasePastDto;
import com.aruparking.Repository.ParkingConfigFeeRepo;
import com.aruparking.Repository.ParkingOrderRepo;
import com.aruparking.Repository.ParkingUserRepo;
import com.aruparking.Repository.ParkingVehicleRepo;
import com.aruparking.Repository.ParkingZoneRepo;
import com.aruparking.Repository.ParkingZoneSlotRepo;

@Service
public class UserServiceImpl implements  UserService{

	@Autowired
	ParkingZoneRepo parkingZoneRepo;
	
	@Autowired
	ParkingZoneSlotRepo parkingZoneSlotRepo;
	
	@Autowired
	ParkingUserRepo parkingUserRepo;
	
	@Autowired
	ParkingConfigFeeRepo parkingConfigFeeRepo;
	
	@Autowired
	ParkingOrderRepo parkingOrderRepo;
	
	@Autowired
	ParkingVehicleRepo parkingVehicleRepo;
	
	Map<String,String> returnMap = new HashMap<>();
	
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
	public Object orderPlacement(ParkingOrderDto orderDto) {
		
		
		ParkingOrder ParkingOrder=new ParkingOrder();
		ParkingConfigFee Fee=parkingConfigFeeRepo.findById(orderDto.getFeeId());
		
		ParkingUsers parkingUser=parkingUserRepo.findById(orderDto.getUserId());
		System.out.println(Fee.getAmount());
		if(parkingUser.getBalance().compareTo(Fee.getAmount()) != -1 ) {
			parkingUser.setBalance((parkingUser.getBalance()).subtract(Fee.getAmount()));
		}else {
				returnMap.put("message", "Insufficient Balance");
				return returnMap;
			}
	
		ParkingUsers userDao = new ParkingUsers();
		userDao.setUserId(parkingUser.getUserId());
		ParkingOrder.setAmount(Fee.getAmount());
		ParkingOrder.setDescription("AruParking");
		ParkingOrder.setParkingStartTime(new Date());
		
		if(Fee.getId()==1) {ParkingOrder.setParkingEndTime(DateUtils.addMinutes(ParkingOrder.getParkingStartTime(), 30));}
		else if(Fee.getId()==2){ParkingOrder.setParkingEndTime(DateUtils.addMinutes(ParkingOrder.getParkingStartTime(), 60));}
		
		ParkingZoneSlot Slot=parkingZoneSlotRepo.findById(orderDto.getSlotId());
		ParkingOrder.setParkingZoneSlot(Slot);
		
		ParkingOrder.setVehicleNo(orderDto.getVehicleNo());
		ParkingOrder.setContactNo(orderDto.getContactNo());
		ParkingOrder.setFineNo(orderDto.getFeeId());
		ParkingOrder.setParkingUser(userDao);
		ParkingOrder.setTrasactionId(parkingUser.getUserId()+"4616798456"+Slot.getId());
		ParkingOrder finalOrderDao =parkingOrderRepo.save(ParkingOrder);
		
		Map<String,Object> returnMap = new HashMap<>();
		returnMap.put("Message", "Payment Successful");
		returnMap.put("OrderId", finalOrderDao.getId());
		returnMap.put("TrasactionId",finalOrderDao.getTrasactionId() );
		returnMap.put("Amount", Fee.getAmount().doubleValue());
		return returnMap;	
		
	}

	@Override
	public List<PurchasePastDto> getParkingHistoryOfUser(long userId ,int historyType) {
		List<PurchasePastDto> pDtoList = new ArrayList<PurchasePastDto>();
		List<ParkingOrder> orders =  parkingOrderRepo.findByParkingUserUserIdOrderByCreatedOnDesc(userId);
		 for (ParkingOrder order : orders) {
			 
			 if(historyType==2 && new Date().compareTo(order.getParkingEndTime()) > 0){
				
				 pDtoList.add(DAOtoDTO(order,userId));
				 
			 }else if(historyType==1 && new Date().compareTo(order.getParkingEndTime()) < 0) {
			
				 pDtoList.add(DAOtoDTO(order,userId));
			 }
			 
			 }
		return pDtoList;
		 }
		 
		
	private PurchasePastDto DAOtoDTO(ParkingOrder order, long userId) {
		
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
	public Object saveVehicle(AruParkingVehicleReqDto iVehicle) {
		
		ParkingUsers userDao = parkingUserRepo.findByUserId(iVehicle.getUserId());
		TitanParkingUserVehicle pVehicle = new TitanParkingUserVehicle();
		pVehicle.setParkingUsers(userDao);
		
		TitanParkingUserVehicle pVehicle1=parkingVehicleRepo.findByParkingUsersUserIdAndVehicleNoAndStatus(iVehicle.getUserId(), iVehicle.getVehicleNo(), 1);
		if(pVehicle1 == null) {
			
			//TitanParkingUserVehicle pVehicle2=parkingVehicleRepo.findByTitanUsersUserIdAndVehicleNameAndStatus(userId, iVehicle.getVehicleName(), 1);	
			//if(pVehicle2 == null) {
				
				if (iVehicle.isDefaultVehicle()) {
					TitanParkingUserVehicle pVehicle3 = parkingVehicleRepo.findByParkingUsersUserIdAndStatusAndDefaultFlag(iVehicle.getUserId(),1,true);
					
					if (pVehicle3!=null) {
						
						pVehicle3.setDefaultFlag(false);
						parkingVehicleRepo.save(pVehicle3);
					} 
					
				}return DAOtoDTOveh(DTOtoDAOveh(pVehicle , iVehicle));
				
			//}else {throw new RuntimeException("vehicleName is used by other account");}
		    }else {throw new RuntimeException("vehicleNo is used by other account");}
	}

	private AruParkingVehicleResDto DAOtoDTOveh(TitanParkingUserVehicle pVehicle) {
		
     AruParkingVehicleResDto cDto = new AruParkingVehicleResDto();
		
     cDto.setUserId(pVehicle.getParkingUsers().getUserId());
		cDto.setId(pVehicle.getId());
		cDto.setVehicleNo(pVehicle.getVehicleNo());
		cDto.setVehicleName(pVehicle.getVehicleName());
		cDto.setCreatedDate(pVehicle.getCreatedOn());
		cDto.setDefaultVehicle(pVehicle.isDefaultFlag());
		cDto.setFavVehicle(pVehicle.isFavFlag());
		cDto.setLastModifiedDate(pVehicle.getLastUpdatedOn());
		cDto.setStatus(pVehicle.getStatus());
		
		return cDto;
	}

	private TitanParkingUserVehicle DTOtoDAOveh(TitanParkingUserVehicle pVehicle, AruParkingVehicleReqDto iVehicle) {
		
		
		
		pVehicle.setVehicleNo(iVehicle.getVehicleNo());
		pVehicle.setVehicleName(iVehicle.getVehicleName());
		pVehicle.setDefaultFlag(iVehicle.isDefaultVehicle());
		pVehicle.setFavFlag(iVehicle.isFavVehicle());
		pVehicle.setStatus(1);
		pVehicle=parkingVehicleRepo.save(pVehicle);
		
		return pVehicle;
	}

	@Override
	public Object deleteVehicle(long id) {
		TitanParkingUserVehicle pCar=parkingVehicleRepo.findById(id);
	//	Map<String, String> map = new HashMap();
		if( pCar != null ) {
			
			pCar.setStatus(0);
			pCar=parkingVehicleRepo.save( pCar);
			returnMap.put("status", "Deleted successfully");
			return returnMap;
		}else {
			
			returnMap.put("status", "Vehicle does not exist");
			return returnMap;
	}
	}

}

package com.aruparking.User.services;

import java.util.List;

import com.aruparking.Dto.AruParkingVehicleReqDto;
import com.aruparking.Dto.ParkingOrderDto;
import com.aruparking.Dto.PurchasePastDto;

public interface UserService {

	Object getAllZone();

	Object getSlotsByZone(long zoneId);

	Object orderPlacement(ParkingOrderDto order);

	List<PurchasePastDto> getParkingHistoryOfUser(long userId, int historyType);

	Object saveVehicle(AruParkingVehicleReqDto car);

	Object deleteVehicle(long id);

}

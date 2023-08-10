package com.aruparking.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aruparking.Dao.ParkingUsers;
import com.aruparking.Dao.TitanParkingUserVehicle;

@Repository
public interface ParkingVehicleRepo extends CrudRepository<TitanParkingUserVehicle, Long> {
	
	TitanParkingUserVehicle findById(long id);

	TitanParkingUserVehicle findByParkingUsersUserIdAndVehicleNoAndStatus(long userId, String vehicleNo, int i);

	TitanParkingUserVehicle findByParkingUsersUserIdAndStatusAndDefaultFlag(long userId, int i, boolean b);

}

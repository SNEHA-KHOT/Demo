package com.aruparking.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aruparking.Dao.ParkingUsers;
import com.aruparking.Dao.ParkingZones;

@Repository
public interface ParkingUserRepo extends CrudRepository<ParkingUsers, Long>{
	
	ParkingUsers findById(long userId);

	ParkingUsers findByUserId(long userId);

}

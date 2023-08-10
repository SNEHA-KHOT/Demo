package com.aruparking.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aruparking.Dao.ParkingConfigFee;
import com.aruparking.Dao.ParkingUsers;

@Repository
public interface ParkingConfigFeeRepo extends CrudRepository<ParkingConfigFee, Long> {

	ParkingConfigFee findById(long feeId);
}

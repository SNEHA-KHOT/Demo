package com.aruparking.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aruparking.Dao.ParkingOrder;

@Repository
public interface ParkingOrderRepo extends CrudRepository<ParkingOrder, Long>{

	

	List<ParkingOrder> findByParkingUserUserIdOrderByCreatedOnDesc(long userId);

	List<ParkingOrder> findByParkingZoneSlotParkingZonesIdOrderByCreatedOnDesc(long zoneId);

	List<ParkingOrder> findByParkingZoneSlotIdOrderByCreatedOnDesc(long slotId);

	List<ParkingOrder> findByParkingEndTimeBetweenAndParkingZoneSlotParkingZonesIdOrderByCreatedOnDesc(Date strtDate,
			Date endDate, long zoneId);
	

}

package com.project.hotelmanagement.room;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface RoomRepository extends JpaRepository<Room, String> {
	Room findByRoomId(String roomId);
	@Transactional
	@Modifying
	@Query("update Room r set r.room_price = ?1 where r.roomId = ?2")
	void updatePrice(Long room_price, String room_id);

}

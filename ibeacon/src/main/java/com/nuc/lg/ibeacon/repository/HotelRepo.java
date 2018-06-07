package com.nuc.lg.ibeacon.repository;


import com.nuc.lg.ibeacon.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface HotelRepo extends JpaRepository<RoomEntity, Integer> {

    @Override
    List<RoomEntity> findAll();

    @Query(value = "select * from room u where (u.start_time is NULL or u.end_time is  NULL) " +
            "or (u.end_time < :startTime) or (u.start_time > :endTime)", nativeQuery = true)
    List<RoomEntity> findSuitRoom(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    List<RoomEntity> findRoomEntitiesByUserIs(String user);

    RoomEntity save(RoomEntity roomEntity);

}

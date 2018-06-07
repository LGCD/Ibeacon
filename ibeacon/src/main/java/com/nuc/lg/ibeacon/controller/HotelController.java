package com.nuc.lg.ibeacon.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.nuc.lg.ibeacon.entity.PeopleEntity;
import com.nuc.lg.ibeacon.entity.RoomEntity;
import com.nuc.lg.ibeacon.repository.HotelRepo;
import com.nuc.lg.ibeacon.vo.Hotel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    private Logger Log = LoggerFactory.getLogger(this.getClass());
    private final String SUCCESS = "1";

    @Autowired
    HotelRepo hotelRepo;

    @RequestMapping(value = "/all", produces = {"application/json;charset=UTF-8"}, consumes = {"application/json"})
    public Object selectSuitRoom(@RequestBody Hotel hotel) {

        Log.info("request roomEntity is ", hotel.toString());
        RoomEntity roomEntity = hotel.toRoomEntity();
        List<RoomEntity> suitRoomList = hotelRepo.findSuitRoom(roomEntity.getStartTime(), roomEntity.getEndTime());
        return JSON.toJSONString(suitRoomList, SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping(value = "/user", produces = {"application/json;charset=UTF-8"}, consumes = {"application/json"})
    public Object selectUserRoom(@RequestBody PeopleEntity people) {

        List<RoomEntity> userRoom = hotelRepo.findRoomEntitiesByUserIs(people.getId());
        Log.info("UserRoom", JSON.toJSONString(userRoom, SerializerFeature.DisableCircularReferenceDetect));
        return JSON.toJSONString(userRoom, SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping(value = "/buy", produces = {"application/json;charset=UTF-8"}, consumes = {"application/json"})
    public Object buyRoom(@RequestBody Hotel hotel) {

        RoomEntity roomEntity = hotel.toRoomEntity();
        hotelRepo.save(roomEntity);
        return null;
    }

    @RequestMapping(value = "/findAll")
    public Object allRoom() {
        List<RoomEntity> roomList = hotelRepo.findAll();
        return JSON.toJSONString(roomList, SerializerFeature.DisableCircularReferenceDetect);
    }

    /**
     * Room的更新与添加
     *
     * @param roomEntity
     * @return
     */
    @RequestMapping(value = "/save", produces = {"application/json;charset=UTF-8"}, consumes = {"application/json"})
    public Object save(@RequestBody RoomEntity roomEntity) {
        hotelRepo.save(roomEntity);
        return SUCCESS;
    }

    /**
     * Room的更新与添加
     *
     * @param roomEntity
     * @return
     */
    @RequestMapping(value = "/delete", produces = {"application/json;charset=UTF-8"}, consumes = {"application/json"})
    public Object delete(@RequestBody RoomEntity roomEntity) {
        hotelRepo.delete(roomEntity);
        return SUCCESS;
    }

}

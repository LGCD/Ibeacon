package com.nuc.lg.ibeacon.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.nuc.lg.ibeacon.entity.AttractionEntity;
import com.nuc.lg.ibeacon.entity.AttractionEntityPK;
import com.nuc.lg.ibeacon.entity.IbeaconEntity;
import com.nuc.lg.ibeacon.repository.AttractionRepo;
import com.nuc.lg.ibeacon.repository.PeopleRepo;
import com.nuc.lg.ibeacon.repository.TicketRepo;
import com.nuc.lg.ibeacon.vo.UserAndTic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("attraction")
public class AttractionController {

    @Autowired
    AttractionRepo attractionRepo;

    @Autowired
    TicketRepo ticketRepo;

    @Autowired
    PeopleRepo peopleRepo;

    private Logger Log = LoggerFactory.getLogger(this.getClass());


    @RequestMapping(value = "/findAttraction", produces = {"application/json;charset=UTF-8"}, consumes = {"application/json"})
    public Object selectAttraction(@RequestBody IbeaconEntity ibeaconEntity) {

        Log.info(ibeaconEntity.toString());
        AttractionEntity result = attractionRepo.findAttractionEntityByUuidIsAndMajorIsAndMinorIs(ibeaconEntity.getUuid(), ibeaconEntity.getMajor(), ibeaconEntity.getMinor());
        return JSON.toJSONString(result, SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping(value = "/num", produces = {"text/plain;charset=UTF-8"}, consumes = {"application/json"})
    public Object selectTicketNum(@RequestBody UserAndTic userAndTic) {

        String num = String.valueOf(ticketRepo.countByUserIsAndStatusIsAndTicketIdIs(userAndTic.getId(), 1, userAndTic.getTicketId()));
        userAndTic.setTicketNum(num);
        String name = peopleRepo.findPeopleById(userAndTic.getId()).getName();
        userAndTic.setName(name);
        return JSON.toJSONString(userAndTic, SerializerFeature.DisableCircularReferenceDetect);

    }

}

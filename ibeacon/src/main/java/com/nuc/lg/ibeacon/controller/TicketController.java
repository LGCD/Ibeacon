package com.nuc.lg.ibeacon.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.nuc.lg.ibeacon.entity.PeopleEntity;
import com.nuc.lg.ibeacon.entity.TicketEntity;
import com.nuc.lg.ibeacon.repository.TicketRepo;
import com.nuc.lg.ibeacon.vo.Ticket;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketRepo ticketRepo;

    private org.slf4j.Logger Log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/number", produces = {"text/plain;charset=UTF-8"}, consumes = {"application/json"})
    public Object getTicketMessage() {
        return null;
    }

    @RequestMapping(value = "/buy", produces = {"text/plain;charset=UTF-8"}, consumes = {"application/json"})
    public Object buyTicket(@RequestBody Ticket ticket) {

        Log.info("buy ticket is : ", ticket.toString());
        if (ticket != null) {
            int number = Integer.parseInt(ticket.getNumber());
            for (int i = 0; i < number; i++) {
                TicketEntity ticketEntity = ticket.toTicketEntity();
                ticketRepo.save(ticketEntity);
            }
        }
        return null;
    }

    @RequestMapping(value = "/all", produces = {"text/plain;charset=UTF-8"}, consumes = {"application/json"})
    public Object findUserT(@RequestBody PeopleEntity peopleEntity) {
        List<TicketEntity> userTicketList = ticketRepo.findByUserIs(peopleEntity.getId());
        return JSON.toJSONString(userTicketList, SerializerFeature.DisableCircularReferenceDetect);
    }

}

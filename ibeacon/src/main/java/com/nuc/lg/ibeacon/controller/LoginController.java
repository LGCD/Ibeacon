package com.nuc.lg.ibeacon.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.nuc.lg.ibeacon.vo.People;
import com.nuc.lg.ibeacon.entity.PeopleEntity;
import com.nuc.lg.ibeacon.repository.PeopleRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("login")
public class LoginController {

    private static final String TRUE_RESULT = "1";
    private static final String NULL_PEOPLE = "0";
    private static final String PASSWORD_WRONG = "-1";
    private static final String REGISTERED = "-2";
    private Logger Log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PeopleRepo peopleRepo;

    @RequestMapping(value = "/sign", produces = {"text/plain;charset=UTF-8"}, consumes = {"application/json"})
    public Object sign(@RequestBody PeopleEntity peopleEntity) {
        People people = peopleRepo.findPeopleById(peopleEntity.getId());
        if (people == null) {
            peopleRepo.save(peopleEntity);
            return JSON.toJSONString(TRUE_RESULT, SerializerFeature.DisableCircularReferenceDetect);
        } else {
            return JSON.toJSONString(REGISTERED, SerializerFeature.DisableCircularReferenceDetect);
        }
    }

    @RequestMapping(value = "/update", produces = {"application/json;charset=UTF-8"}, consumes = {"application/json"})
    public void update(@RequestBody PeopleEntity peopleEntity) {

    }

    @RequestMapping(value = "/login", produces = {"text/plain;charset=UTF-8"}, consumes = {"application/json"})
    public Object login(@RequestBody PeopleEntity peopleEntity) {

        System.out.println(peopleEntity.toString());

        People people = peopleRepo.findPeopleById(peopleEntity.getId());
        if (people == null) {
            return JSON.toJSONString(NULL_PEOPLE, SerializerFeature.DisableCircularReferenceDetect);
        }
        if (!people.getPassword().equals(peopleEntity.getPassword())) {
            return JSON.toJSONString(PASSWORD_WRONG, SerializerFeature.DisableCircularReferenceDetect);
        }
        return JSON.toJSONString(TRUE_RESULT, SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping(value = "/select", produces = {"text/plain;charset=UTF-8"}, consumes = {"application/json"})
    public Object select(@RequestBody PeopleEntity peopleEntity) {

        Log.info("select people is ", peopleEntity);
        People people = peopleRepo.findPeopleById(peopleEntity.getId());
        return JSON.toJSONString(people, SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping(value = "/selectAll", produces = {"text/plain;charset=UTF-8"}, consumes = {"application/json"})
    public Object selectAll() {
        List<PeopleEntity> peopleList = peopleRepo.findAll();
        return JSON.toJSONString(peopleList, SerializerFeature.DisableCircularReferenceDetect);
    }

}

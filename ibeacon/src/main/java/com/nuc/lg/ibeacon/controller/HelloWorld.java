package com.nuc.lg.ibeacon.controller;

import com.alibaba.fastjson.JSON;
import com.nuc.lg.ibeacon.repository.PeopleRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorld {

    @Autowired
    PeopleRepo peopleRepo;

    private Logger LOG = LoggerFactory.getLogger(HelloWorld.class);

    @RequestMapping(value = "/test", produces = {"text/plain;charset=UTF-8"})
    public Object groupMsg() {
        Object object = JSON.toJSONString("徐少翔，大基佬");
        LOG.info(object.toString());
        return object;
    }
}

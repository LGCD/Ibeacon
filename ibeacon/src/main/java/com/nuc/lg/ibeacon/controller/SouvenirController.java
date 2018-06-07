package com.nuc.lg.ibeacon.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.nuc.lg.ibeacon.entity.SouvenirEntity;
import com.nuc.lg.ibeacon.repository.SouvenirRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


@RestController
@RequestMapping("/souvenir")
public class SouvenirController {

    private final String SUCCESS = "1";

    @Autowired
    SouvenirRepo souvenirRepo;

    /**
     * 查询所有纪念品
     *
     * @return
     */
    @RequestMapping(value = "/all")
    public Object getAllSouvenir() {

        List<SouvenirEntity> souvenirEntityList = souvenirRepo.findAll();
        return JSON.toJSONString(souvenirEntityList, SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping(value = "/save", produces = {"application/json;charset=UTF-8"}, consumes = {"application/json"})
    public Object saveSouvenir(@RequestBody SouvenirEntity souvenirEntity) {
        souvenirRepo.save(souvenirEntity);
        return SUCCESS;
    }

    @RequestMapping(value = "/delete", produces = {"application/json;charset=UTF-8"}, consumes = {"application/json"})
    public Object deleteSouvenir(@RequestBody SouvenirEntity souvenirEntity) {
        souvenirRepo.delete(souvenirEntity);
        return SUCCESS;
    }

}

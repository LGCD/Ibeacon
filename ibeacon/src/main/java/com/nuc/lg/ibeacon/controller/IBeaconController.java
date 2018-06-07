package com.nuc.lg.ibeacon.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.nuc.lg.ibeacon.entity.IbeaconEntity;
import com.nuc.lg.ibeacon.repository.IBeaconRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("iBeacon")
public class IBeaconController {

    @Autowired
    IBeaconRepo iBeaconRepo;

    private final String SUCCESS = "1";

    @RequestMapping(value = "/select", produces = {"application/json;charset=UTF-8"}, consumes = {"application/json"})
    public Object sign(@RequestBody IbeaconEntity ibeaconEntity) {

        IbeaconEntity result = iBeaconRepo.findIbeaconEntitiesByUuidIsAndMajorIsAndMinorIs(ibeaconEntity.getUuid(), ibeaconEntity.getMajor(), ibeaconEntity.getMinor());

        return JSON.toJSONString(result, SerializerFeature.DisableCircularReferenceDetect);
    }

    /**
     * 获取所有IBeacon
     *
     * @return
     */
    @RequestMapping(value = "/all")
    public Object findAll() {
        List<IbeaconEntity> ibeaconList = iBeaconRepo.findAll();
        return JSON.toJSONString(ibeaconList, SerializerFeature.DisableCircularReferenceDetect);
    }

    /**
     * 更新与添加数据
     *
     * @param ibeaconEntity
     * @return
     */
    @RequestMapping(value = "/save", produces = {"application/json;charset=UTF-8"}, consumes = {"application/json"})
    public Object save(@RequestBody IbeaconEntity ibeaconEntity) {
        iBeaconRepo.save(ibeaconEntity);
        return SUCCESS;
    }

    /**
     * 删除数据
     *
     * @param ibeaconEntity
     * @return
     */
    @RequestMapping(value = "/delete", produces = {"application/json;charset=UTF-8"}, consumes = {"application/json"})
    public Object delete(@RequestBody IbeaconEntity ibeaconEntity) {
        iBeaconRepo.delete(ibeaconEntity);
        return SUCCESS;
    }

}

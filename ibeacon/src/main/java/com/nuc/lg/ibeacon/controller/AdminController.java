package com.nuc.lg.ibeacon.controller;


import com.nuc.lg.ibeacon.entity.AdminEntity;
import com.nuc.lg.ibeacon.repository.AdminRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminRepo adminRepo;

    private static final String SUCCESS = "1";
    private static final String FAIL = "0";

    private Logger Log = LoggerFactory.getLogger(this.getClass());

    /**
     * 管理员登录
     *
     * @param adminEntity
     * @return
     */
    @RequestMapping(value = "/login", produces = {"text/plain;charset=UTF-8"}, consumes = {"application/json"})
    public Object adminLogin(@RequestBody AdminEntity adminEntity) {

        AdminEntity findAdminEntity = adminRepo.findAdminEntitiyByIdAndPassword(adminEntity.getId(), adminEntity.getPassword());
        if (findAdminEntity != null) {
            return SUCCESS;
        } else {
            return FAIL;
        }

    }

    /**
     * 管理员注册
     *
     * @param adminEntity
     * @return
     */
    @RequestMapping(value = "/sign", produces = {"text/plain;charset=UTF-8"}, consumes = {"application/json"})
    public Object adminSign(@RequestBody AdminEntity adminEntity) {

        AdminEntity findAdminEntity = adminRepo.save(adminEntity);
        if (findAdminEntity != null) {
            return SUCCESS;
        } else {
            return FAIL;
        }

    }
}

package com.nuc.lg.ibeacon.repository;


import com.nuc.lg.ibeacon.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<AdminEntity, String> {

    AdminEntity findAdminEntitiyByIdAndPassword(String id, String password);
}

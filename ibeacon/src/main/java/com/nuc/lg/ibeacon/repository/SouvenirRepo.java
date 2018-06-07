package com.nuc.lg.ibeacon.repository;


import com.nuc.lg.ibeacon.entity.SouvenirEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SouvenirRepo extends JpaRepository<SouvenirEntity, Integer> {

    List<SouvenirEntity> findAll();

}

package com.nuc.lg.ibeacon.repository;


import com.nuc.lg.ibeacon.entity.IbeaconEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBeaconRepo extends JpaRepository<IbeaconEntity, String> {


    IbeaconEntity findIbeaconEntitiesByUuidIsAndMajorIsAndMinorIs(String uuid, String major, String minor);

    @Override
    List<IbeaconEntity> findAll();

}

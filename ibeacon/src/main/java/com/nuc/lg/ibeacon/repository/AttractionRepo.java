package com.nuc.lg.ibeacon.repository;

import com.nuc.lg.ibeacon.entity.AttractionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttractionRepo extends JpaRepository<AttractionEntity, String> {

    AttractionEntity findAttractionEntityByUuidIsAndMajorIsAndMinorIs(String uuid, String major, String minor);
}

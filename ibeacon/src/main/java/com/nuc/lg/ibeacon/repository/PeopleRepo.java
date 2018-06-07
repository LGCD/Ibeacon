package com.nuc.lg.ibeacon.repository;


import com.nuc.lg.ibeacon.vo.People;
import com.nuc.lg.ibeacon.entity.PeopleEntity;
import com.nuc.lg.ibeacon.vo.UserAndTic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PeopleRepo extends JpaRepository<PeopleEntity, String> {

    @Query("select new com.nuc.lg.ibeacon.vo.People(p.id,p.name,p.password,p.sex) from PeopleEntity p where p.id = :id")
    People findPeopleById(@Param("id") String id);

    PeopleEntity save(PeopleEntity peopleEntity);

    @Override
    List<PeopleEntity> findAll();

    @Query("select new com.nuc.lg.ibeacon.vo.UserAndTic(p.id,p.name) from PeopleEntity p where p.id = :id")
    UserAndTic findUserAndTicById(@Param("id") String id);

}

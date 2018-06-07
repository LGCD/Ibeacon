package com.nuc.lg.ibeacon.repository;


import com.nuc.lg.ibeacon.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepo extends JpaRepository<TicketEntity, String> {

    int countByUserIsAndStatusIsAndTicketIdIs(String user, int status, int ticketId);

    TicketEntity save(TicketEntity ticketEntity);

    List<TicketEntity> findByUserIs(String user);
}

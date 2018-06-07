package com.nuc.lg.ibeacon.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ticket", schema = "ibeacon", catalog = "")
public class TicketEntity {
    private int id;
    private String user;
    private int status;
    private String buyTime;
    private String scenicRegion;
    private int ticketId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user")
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Basic
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "buy_time")
    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime;
    }

    @Basic
    @Column(name = "scenic_region")
    public String getScenicRegion() {
        return scenicRegion;
    }

    public void setScenicRegion(String scenicRegion) {
        this.scenicRegion = scenicRegion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketEntity that = (TicketEntity) o;
        return id == that.id &&
                status == that.status &&
                Objects.equals(user, that.user) &&
                Objects.equals(buyTime, that.buyTime) &&
                Objects.equals(scenicRegion, that.scenicRegion);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, user, status, buyTime, scenicRegion);
    }

    @Basic
    @Column(name = "ticket_id")
    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }
}

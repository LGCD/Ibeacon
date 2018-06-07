package com.nuc.lg.ibeacon.vo;

import com.nuc.lg.ibeacon.entity.TicketEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ticket {

    private int id;
    private int ticketId;
    private String user;
    private int status;
    private String buyTime;
    private String scenicRegion;
    private String number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime;
    }

    public String getScenicRegion() {
        return scenicRegion;
    }

    public void setScenicRegion(String scenicRegion) {
        this.scenicRegion = scenicRegion;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public TicketEntity toTicketEntity() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String now = simpleDateFormat.format(date);
        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setBuyTime(now);
        ticketEntity.setScenicRegion(this.scenicRegion);
        ticketEntity.setStatus(this.status);
        ticketEntity.setTicketId(this.ticketId);
        ticketEntity.setUser(this.user);
        return ticketEntity;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", ticketId=" + ticketId +
                ", user='" + user + '\'' +
                ", status=" + status +
                ", buyTime='" + buyTime + '\'' +
                ", scenicRegion='" + scenicRegion + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}

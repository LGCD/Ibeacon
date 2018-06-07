package com.nuc.lg.ibeacon.vo;

import com.nuc.lg.ibeacon.entity.RoomEntity;

public class Hotel {

    private int id;
    private String user;
    private String type;
    private String hotel;
    private int price;
    private String startTime;
    private String endTime;
    private String imagePath;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public RoomEntity toRoomEntity() {
        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setId(this.id);
        roomEntity.setUser(this.user);
        roomEntity.setType(this.type);
        roomEntity.setHotel(this.hotel);
        roomEntity.setPrice(this.price);
        roomEntity.setImagePath(this.imagePath);
        roomEntity.setStartTime(java.sql.Date.valueOf(this.startTime));
        roomEntity.setEndTime(java.sql.Date.valueOf(this.endTime));
        return roomEntity;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", type='" + type + '\'' +
                ", hotel='" + hotel + '\'' +
                ", price=" + price +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}

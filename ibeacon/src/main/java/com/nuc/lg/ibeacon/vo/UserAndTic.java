package com.nuc.lg.ibeacon.vo;

public class UserAndTic {

    private String id;
    private String name;
    private String ticketNum;
    private int ticketId;

    public UserAndTic(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserAndTic() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(String ticketNum) {
        this.ticketNum = ticketNum;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }
}

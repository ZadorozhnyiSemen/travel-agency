package com.epam.travel.model;

import java.util.Date;

public class Booking {
    private int id;
    private User user;
    private AgentHotelRelation relation;
    private Date startDate;
    private Date endDate;
    private String status;

    public Booking() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AgentHotelRelation getRelation() {
        return relation;
    }

    public void setRelation(AgentHotelRelation relation) {
        this.relation = relation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

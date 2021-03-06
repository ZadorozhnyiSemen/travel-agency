package com.epam.travel.model;

public class AgentHotelRelation {
    private int id;
    private Agent agent;
    private Hotel hotel;

    public AgentHotelRelation() {
    }

    public AgentHotelRelation(int id, Agent agent, Hotel hotel) {
        this.id = id;
        this.agent = agent;
        this.hotel = hotel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}

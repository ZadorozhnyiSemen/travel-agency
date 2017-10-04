package com.epam.travel.dao;

import com.epam.travel.model.AgentHotelRelation;

import java.util.List;

public interface RelationDAO {
    List<AgentHotelRelation> getAllRelations();
    void addRelation(AgentHotelRelation relation);
    AgentHotelRelation findRelation(int id);
}

package com.epam.travel.service;

import com.epam.travel.model.AgentHotelRelation;

import java.util.List;

public interface RelationService {
    List<AgentHotelRelation> getAllRelations();
    void addRelation(AgentHotelRelation relation);
    AgentHotelRelation findRelation(int id);
}

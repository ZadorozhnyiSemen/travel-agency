package com.epam.travel.service;

import com.epam.travel.dao.RelationDAO;
import com.epam.travel.model.AgentHotelRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationServiceImpl implements RelationService {

    @Autowired
    RelationDAO relationDAO;

    @Override
    public List<AgentHotelRelation> getAllRelations() {
        return relationDAO.getAllRelations();
    }

    @Override
    public void addRelation(AgentHotelRelation relation) {

    }

    @Override
    public AgentHotelRelation findRelation(int id) {
        return null;
    }
}

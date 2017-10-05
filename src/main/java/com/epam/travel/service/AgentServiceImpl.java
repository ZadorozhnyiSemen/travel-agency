package com.epam.travel.service;

import com.epam.travel.dao.AgentDAO;
import com.epam.travel.model.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentServiceImpl implements AgentService {

    @Autowired
    AgentDAO agentDAO;

    @Override
    public List<Agent> getAllAgents() {
        return agentDAO.getAllAgents();
    }

    @Override
    public void addAgent(Agent agent) {
        agentDAO.addAgent(agent);
    }

    @Override
    public Agent findAgent(int id) {
        return agentDAO.findAgent(id);
    }
}

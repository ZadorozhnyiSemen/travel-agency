package com.epam.travel.dao;

import com.epam.travel.model.Agent;

import java.util.List;

public interface AgentDAO {
    List<Agent> getAllAgents();

    void addAgent(Agent agent);

    Agent findAgent(int id);
}

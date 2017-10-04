package com.epam.travel.service;

import com.epam.travel.model.Agent;

import java.util.List;

public interface AgentService {
    List<Agent> getAllAgents();

    void addAgent(Agent agent);

    Agent findAgent(int id);
}

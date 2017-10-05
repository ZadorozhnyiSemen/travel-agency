package com.epam.travel.dao;

import com.epam.travel.model.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class AgentDAOImpl extends JdbcDaoSupport implements AgentDAO {
    @Qualifier("dataSource")
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void init() {
        setDataSource(dataSource);
    }

    @Override
    public List<Agent> getAllAgents() {
        String sql = "SELECT * from agent";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        List<Agent> result = new ArrayList<>(rows.size());
        for (Map<String, Object> row : rows) {
            Agent agent = new Agent();
            agent.setId((Integer) row.get("id"));
            agent.setName((String) row.get("agent_name"));
            agent.setAddress((String) row.get("agent_address"));
            agent.setPhone((String) row.get("agent_phone"));
            result.add(agent);
        }
        return result;
    }

    @Override
    public void addAgent(Agent agent) {
        String sql = "INSERT INTO agent (agent_name, agent_address, agent_phone) " +
                "VALUES (?, ?, ?)";
        getJdbcTemplate().update(sql,
                agent.getName(),
                agent.getPhone(),
                agent.getAddress());
    }

    @Override
    public Agent findAgent(int id) {
        String sql = "SELECT * FROM customer WHERE id = ?";
        return getJdbcTemplate().queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Agent agent = new Agent();
            agent.setId(rs.getInt("id"));
            agent.setName(rs.getString("agent_name"));
            agent.setAddress(rs.getString("agent_address"));
            agent.setPhone(rs.getString("agent_phone"));
            return agent;
        });
    }
}

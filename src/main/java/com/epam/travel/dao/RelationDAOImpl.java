package com.epam.travel.dao;

import com.epam.travel.model.Agent;
import com.epam.travel.model.AgentHotelRelation;
import com.epam.travel.model.Hotel;
import com.epam.travel.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class RelationDAOImpl extends JdbcDaoSupport implements RelationDAO {

    @Qualifier("dataSource")
    @Autowired
    DataSource dataSource;

    @Override
    public List<AgentHotelRelation> getAllRelations() {
        String sql = "SELECT ahr.id, ag.id AS agent_id, ag.agent_name, ag.agent_address, ag.agent_phone, \n" +
                "ho.id AS hotet_id, ho.hotel_country, ho.hotel_city, ho.hotel_address, ho.hotel_phone, ho.hotel_rank \n" +
                "FROM agent_hotel_relation AS ahr\n" +
                "JOIN agent AS ag\n" +
                "ON ag.id = ahr.agent_id\n" +
                "JOIN hotel AS ho\n" +
                "ON ho.id = ahr.hotel_id";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<AgentHotelRelation> result = new ArrayList<>();
        for (Map<String, Object> row:  rows) {
            Agent agent = new Agent();
            agent.setId((Integer) row.get("agent_id"));
            agent.setName((String) row.get("agent_name"));
            agent.setAddress((String) row.get("agent_address"));
            agent.setPhone((String) row.get("agent_phone"));

            Hotel hotel = new Hotel();
            hotel.setId((Integer) row.get("hotel_id"));
            hotel.setCountry((String) row.get("hotel_country"));
            hotel.setCity((String) row.get("hotel_city"));
            hotel.setAddress((String) row.get("hotel_address"));
            hotel.setPhone((String) row.get("hotel_phone"));
            hotel.setRank((Integer) row.get("hotel_rank"));

            AgentHotelRelation relation = new AgentHotelRelation((Integer) row.get("id"), agent, hotel);
            result.add(relation);
        }
        return result;
    }

    @Override
    public void addRelation(AgentHotelRelation relation) {

    }

    @Override
    public AgentHotelRelation findRelation(int id) {
        return null;
    }
}

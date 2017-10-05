package com.epam.travel.dao;

import com.epam.travel.model.Hotel;
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
public class HotelDAOImpl extends JdbcDaoSupport implements HotelDAO {

    @Qualifier("dataSource")
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void init() {
        setDataSource(dataSource);
    }

    @Override
    public List<Hotel> getAllHotels() {
        String sql = "SELECT * FROM hotel";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Hotel> result = new ArrayList<>(rows.size());
        for (Map<String, Object> row : rows) {
            Hotel hotel = new Hotel();
            hotel.setId((Integer) row.get("id"));
            hotel.setName((String) row.get("hotel_name"));
            hotel.setCountry((String) row.get("hotel_country"));
            hotel.setCity((String) row.get("hotel_city"));
            hotel.setAddress((String) row.get("hotel_address"));
            hotel.setPhone((String) row.get("hotel_phone"));
            hotel.setRank((Integer) row.get("hotel_rank"));
            result.add(hotel);
        }
        return result;
    }

    @Override
    public void addHotel(Hotel hotel) {
        String sql = "INSERT INTO hotel (hotel_name, hotel_country, hotel_city, hotel_address, hotel_phone, hotel_rank) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        getJdbcTemplate().update(sql,
                hotel.getName(),
                hotel.getCountry(),
                hotel.getCity(),
                hotel.getAddress(),
                hotel.getPhone(),
                hotel.getRank());
    }

    @Override
    public Hotel findHotel(int id) {
        String sql = "SELECT * FROM hotel WHERE id = ?";

        return getJdbcTemplate().queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Hotel hotel = new Hotel();
            hotel.setId(rs.getInt("id"));
            hotel.setName(rs.getString("hotel_name"));
            hotel.setCountry(rs.getString("hotel_country"));
            hotel.setCity(rs.getString("hotel_city"));
            hotel.setAddress(rs.getString("hotel_address"));
            hotel.setPhone(rs.getString("hotel_phone"));
            hotel.setRank(rs.getShort("hotel_rank"));
            return hotel;
        });
    }
}
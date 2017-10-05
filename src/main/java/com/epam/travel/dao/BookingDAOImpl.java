package com.epam.travel.dao;

import com.epam.travel.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class BookingDAOImpl extends JdbcDaoSupport implements BookingDAO {
    @Qualifier("dataSource")
    @Autowired
    DataSource dataSource;
    @Autowired
    UserDAO userDAO;
    @Autowired
    RelationDAO relationDAO;

    @PostConstruct
    private void init() {
        setDataSource(dataSource);
    }

    @Override
    public List<Booking> getAllBookings() {
        String sql = "SELECT * from booking";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        List<Booking> result = new ArrayList<>(rows.size());
        for (Map<String, Object> row : rows) {
            Booking booking = new Booking();
            booking.setId((Integer) row.get("id"));
            booking.setUser(userDAO.findUser((Integer) row.get("user_id")));
            booking.setRelation(relationDAO.findRelation((Integer) row.get("relation_id")));
            booking.setStartDate((Date) row.get("start_day"));
            booking.setEndDate((Date) row.get("end_day"));
            booking.setStatus((String) row.get("status"));
            result.add(booking);
        }
        return result;
    }

    @Override
    public void addBooking(Booking booking) {
        String sql = "INSERT INTO booking (user_id, relation_id, start_day, end_day, status) "
                + "VALUES (?, ?, ?, ?, ?)";
        getJdbcTemplate().update(sql,
                booking.getUser().getId(),
                booking.getRelation().getId(),
                booking.getStartDate(),
                booking.getEndDate(),
                booking.getStatus());
    }

    @Override
    public Booking findBooking(int id) {
        String sql = "SELECT * FROM booking WHERE id = ?";
        return getJdbcTemplate().queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Booking booking = new Booking();
            booking.setId((Integer) rs.getInt("id"));
            booking.setUser(userDAO.findUser((Integer) rs.getInt("user_id")));
            booking.setRelation(relationDAO.findRelation((Integer) rs.getInt("relation_id")));
            booking.setStartDate((Date) rs.getDate("start_day"));
            booking.setEndDate((Date) rs.getDate("end_day"));
            booking.setStatus((String) rs.getString("status"));
            return booking;
        });
    }
}
package com.epam.travel.dao;

import com.epam.travel.model.User;
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
public class UserDAOImpl extends JdbcDaoSupport implements UserDAO{

    @Qualifier("dataSource")
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void init() {
        setDataSource(dataSource);
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM customer";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<User> result = new ArrayList<>();
        for (Map<String, Object> row:  rows) {
            User user = new User();
            user.setId((Integer) row.get("id"));
            user.setName((String) row.get("user_name"));
            user.setSurname((String) row.get("user_surname"));
            user.setMail((String) row.get("user_mail"));
            user.setPhone((String) row.get("user_phone"));
            user.setLoyalty((Boolean) row.get("user_loyalty"));
            result.add(user);
        }
        return result;

    }

    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO customer (user_name, user_surname, user_mail, user_phone, user_loyalty) " +
                "VALUES (?, ?, ?, ?, ?)";
        getJdbcTemplate().update(sql,
                user.getName(),
                user.getSurname(),
                user.getMail(),
                user.getPhone(),
                user.isLoyalty());
    }

    @Override
    public User findUser(int id) {
        String sql = "SELECT * FROM customer WHERE id = ?";

        return getJdbcTemplate().queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            User user = new User();
            user.setId((Integer) rs.getInt("id"));
            user.setName((String) rs.getString("user_name"));
            user.setSurname((String) rs.getString("user_surname"));
            user.setMail((String) rs.getString("user_mail"));
            user.setPhone((String) rs.getString("user_phone"));
            user.setLoyalty((Boolean) rs.getBoolean("user_loyalty"));
            return user;
        });
    }
}

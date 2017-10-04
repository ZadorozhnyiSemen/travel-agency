package com.epam.travel.dao;

import com.epam.travel.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class UserDAOImpl extends JdbcDaoSupport implements UserDAO{

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void init() {
        setDataSource(dataSource);
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM user";
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

    }

    @Override
    public User findUser(int id) {
        return null;
    }
}

package com.example.server.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao {
  @Autowired
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Override
  public List<User> findAll() {
    String sql = "SELECT id, name FROM users";
    Map<String, Object> map = new HashMap<>();
    List<User> results = namedParameterJdbcTemplate.query(sql, map, (rs, rowNum) -> {
      User user = new User(rs.getInt("id"), rs.getString("name"));
      return user;
    });
    return results;
  }

  @Override
  public User create(User user) {
    String sql = "INSERT INTO users(name) VALUE (:name)";
    KeyHolder keyholder = new GeneratedKeyHolder();
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue("name", user.getName());
    namedParameterJdbcTemplate.update(sql, parameters, keyholder);
    user.setId(keyholder.getKey().intValue());
    return user;
  }
}

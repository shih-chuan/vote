package com.example.server.option;

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
public class OptionDaoImpl implements OptionDao {
  @Autowired
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Override
  public List<Option> findAll() {
    String sql = "SELECT id, label FROM options";
    Map<String, Object> map = new HashMap<>();
    List<Option> results = namedParameterJdbcTemplate.query(sql, map, new OptionRowMapper());
    return results;
  }

  @Override
  public Option create(Option option) {
    String sql = "INSERT INTO options(label) VALUE (:label)";
    KeyHolder keyholder = new GeneratedKeyHolder();
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue("label", option.getLabel());
    namedParameterJdbcTemplate.update(sql, parameters, keyholder);
    option.setId(keyholder.getKey().intValue());
    return option;
  }

  @Override
  public int update(Integer id, Option option) {
    String sql = "UPDATE options " +
        "SET label = :label " +
        "WHERE id = :id";

    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue("id", id);
    parameters.addValue("label", option.getLabel());

    return namedParameterJdbcTemplate.update(sql, parameters);
  }

  @Override
  public int deleteById(Integer id) {
    String sql = "DELETE FROM options WHERE id=:id";
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue("id", id);
    return namedParameterJdbcTemplate.update(sql, parameters);
  }

}

package com.example.server.option;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class OptionRowMapper implements RowMapper<Option> {

  @Override
  public Option mapRow(ResultSet rs, int rowNum) throws SQLException {
    Option option = new Option();
    option.setId(rs.getInt("id"));
    option.setLabel(rs.getString("label"));
    return option;
  }
}

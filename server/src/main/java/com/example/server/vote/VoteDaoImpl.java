package com.example.server.vote;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.example.server.option.Option;
import com.example.server.user.User;

@Component
public class VoteDaoImpl implements VoteDao {
  @Autowired
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Override
  public int create(Integer userId, Integer optionId) {
    String sql = "INSERT INTO votes (user_id, option_id) VALUE (:userId, :optionId)";
    KeyHolder keyholder = new GeneratedKeyHolder();
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue("userId", userId);
    parameters.addValue("optionId", optionId);
    return namedParameterJdbcTemplate.update(sql, parameters, keyholder);
  }

  @Override
  public int deleteById(Integer userId, Integer optionId) {
    String sql = "DELETE FROM votes WHERE user_id=:userId AND option_id=:optionId";
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue("userId", userId);
    parameters.addValue("optionId", optionId);
    return namedParameterJdbcTemplate.update(sql, parameters);
  }

  @Override
  public Vote findById(Integer userId, Integer optionId) {
    String sql = """
            SELECT
                u.id AS user_id,
                o.id AS option_id,
                u.name AS user_name,
                o.label AS option_label
            FROM
                votes v
            JOIN
                users u ON v.user_id = u.id
            JOIN
                options o ON v.option_id = o.id
            WHERE
                v.user_id = :userId AND v.option_id = :optionId
        """;
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue("userId", userId);
    parameters.addValue("optionId", optionId);
    return namedParameterJdbcTemplate.queryForObject(sql, parameters, (rs, rowNum) -> {
      Vote vote = new Vote();
      Option option = new Option(rs.getInt("option_id"), rs.getString("option_label"));
      User user = new User(rs.getInt("user_id"), rs.getString("user_name"));
      vote.setOption(option);
      vote.setUser(user);
      return vote;
    });
  }

  @Override
  public List<Integer> findByUserId(Integer userId) {
    String sql = """
          SELECT
              o.id
          FROM
              votes v
          JOIN
              options o ON v.option_id = o.id
          WHERE
              v.user_id = :userId
        """;
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue("userId", userId);
    return namedParameterJdbcTemplate.query(sql, parameters, (rs, rowNum) -> {
      return rs.getInt("id");
    });
  }
}

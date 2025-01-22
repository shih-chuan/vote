package com.example.server.option;

import java.util.List;

public interface OptionDao {
  List<OptionDto> findAll();

  Option create(Option option);

  int update(Integer id, Option option);

  int deleteById(Integer id);
}

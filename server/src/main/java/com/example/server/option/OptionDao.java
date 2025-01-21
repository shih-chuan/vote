package com.example.server.option;

import java.util.List;

public interface OptionDao {
  List<Option> findAll();

  Option create(Option option);

  int update(Integer id, Option option);

  int deleteById(Integer id);
}

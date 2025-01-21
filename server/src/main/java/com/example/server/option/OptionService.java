package com.example.server.option;

import java.util.List;

public interface OptionService {
  Option createOption(Option option);

  List<Option> getAllOptions();

  void deleteOption(Integer id);

  void updateOption(Integer id, Option option);
}

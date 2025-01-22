package com.example.server.option;

import java.util.List;

public interface OptionService {
  Option createOption(Option option);

  List<OptionDto> getAllOptions();

  void deleteOption(Integer id);

  void updateOption(Integer id, Option option);
}

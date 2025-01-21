package com.example.server.option;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OptionServiceImpl implements OptionService {

  @Autowired
  private OptionDao optionDao;

  @Override
  public Option createOption(Option option) {
    return optionDao.create(option);
  }

  @Override
  public List<Option> getAllOptions() {
    return optionDao.findAll();
  }

  @Override
  public void deleteOption(Integer id) {
    optionDao.deleteById(id);
  }

  @Override
  public void updateOption(Integer id, Option option) {
    optionDao.update(id, option);
  }

}

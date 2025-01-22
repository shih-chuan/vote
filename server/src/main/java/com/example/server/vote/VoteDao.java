package com.example.server.vote;

import java.util.List;

public interface VoteDao {
  int create(Integer userId, Integer optionId);

  Vote findById(Integer userId, Integer optionId);

  List<Integer> findByUserId(Integer userId);

  int deleteById(Integer userId, Integer optionId);
}

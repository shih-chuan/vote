package com.example.server.vote;

public interface VoteDao {
  int create(Integer userId, Integer optionId);

  Vote findById(Integer userId, Integer optionId);

  int deleteById(Integer userId, Integer optionId);
}

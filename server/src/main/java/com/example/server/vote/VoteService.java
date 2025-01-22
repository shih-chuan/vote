package com.example.server.vote;

public interface VoteService {
  Vote createVote(Integer userId, Integer optionId);

  void deleteVote(Integer userId, Integer optionId);
}

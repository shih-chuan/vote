package com.example.server.vote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class VoteServiceImpl implements VoteService {

  @Autowired
  private VoteDao voteDao;

  @Override
  public Vote createVote(Integer userId, Integer optionId) {
    voteDao.create(userId, optionId);
    return voteDao.findById(userId, optionId);
  }

  @Override
  public void deleteVote(Integer userId, Integer optionId) {
    voteDao.deleteById(userId, optionId);
  }
}

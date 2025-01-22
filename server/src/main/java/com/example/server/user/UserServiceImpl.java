package com.example.server.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.server.vote.VoteDao;

@Component
public class UserServiceImpl implements UserService {
  @Autowired
  private UserDao userDao;

  @Autowired
  private VoteDao voteDao;

  @Override
  public List<User> getAllUsers() {
    return userDao.findAll();
  }

  @Override
  public List<Integer> getUserVotes(Integer id) {
    return voteDao.findByUserId(id);
  }

  @Override
  public User createUser(User user) {
    return userDao.create(user);
  }
}

package com.example.server.user;

import java.util.List;

public interface UserService {
  List<User> getAllUsers();

  List<Integer> getUserVotes(Integer id);

  User createUser(User user);
}

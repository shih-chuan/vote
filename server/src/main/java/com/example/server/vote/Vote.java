package com.example.server.vote;

import com.example.server.option.Option;
import com.example.server.user.User;

import jakarta.validation.constraints.NotNull;

public class Vote {
  @NotNull
  private User user;
  @NotNull
  private Option option;

  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Option getOption() {
    return this.option;
  }

  public void setOption(Option option) {
    this.option = option;
  }

}

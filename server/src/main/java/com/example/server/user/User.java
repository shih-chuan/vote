package com.example.server.user;

import jakarta.validation.constraints.NotBlank;

public class User {
  private Integer id;

  @NotBlank
  private String name;

  public User(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

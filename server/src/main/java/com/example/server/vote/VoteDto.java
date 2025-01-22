package com.example.server.vote;

public class VoteDto {
  private Integer userId;
  private Integer optionId;

  public Integer getUserId() {
    return this.userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Integer getOptionId() {
    return this.optionId;
  }

  public void setOptionId(Integer optionId) {
    this.optionId = optionId;
  }

}

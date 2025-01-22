package com.example.server.option;

public class OptionDto {
  private Integer id;
  private String label;
  private Integer votes;
  private Boolean selected;

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getLabel() {
    return this.label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public Integer getVotes() {
    return this.votes;
  }

  public void setVotes(Integer votes) {
    this.votes = votes;
  }

  public Boolean isSelected() {
    return this.selected;
  }

  public Boolean getSelected() {
    return this.selected;
  }

  public void setSelected(Boolean selected) {
    this.selected = selected;
  }

}

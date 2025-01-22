package com.example.server.option;

import jakarta.validation.constraints.NotBlank;

public class Option {
  private Integer id;

  @NotBlank
  private String label;

  public Option() {
  }

  public Option(Integer id, String label) {
    this.id = id;
    this.label = label;
  }

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

}

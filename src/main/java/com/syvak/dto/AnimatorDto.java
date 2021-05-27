package com.syvak.dto;

import javax.persistence.Column;

public class AnimatorDto {
  private Integer id;
  private String name;
  private String surname;
  private String last_name;
  private Integer age;

  public AnimatorDto(Integer id, String name, String surname, String last_name, Integer age) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.last_name = last_name;
    this.age = age;
  }

  public AnimatorDto(String name, String surname, String last_name, Integer age) {
    this.name = name;
    this.surname = surname;
    this.last_name = last_name;
    this.age = age;
  }
  public AnimatorDto() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getLastName() {
    return last_name;
  }

  public void setLastName(String last_name) {
    this.last_name = last_name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

}

package com.syvak.dto;


public class CustomDto {
  private Integer id;
  private String date;
  private Integer duration_in_hours;
  private String address;
  private Integer cost_in_uah;

  public CustomDto(Integer id, String date,Integer duration_in_hours, String address ,  Integer commentsId, Integer cost_in_uah) {
    this.id = id;
    this.date = date;
    this.duration_in_hours = duration_in_hours;
    this.address = address;
    this.cost_in_uah = cost_in_uah;
  }

  public CustomDto(String date,Integer duration_in_hours, String address, Integer cost_in_uah) {
    this.date = date;
    this.duration_in_hours = duration_in_hours;
    this.address = address;
    this.cost_in_uah = cost_in_uah;
  }

  public CustomDto() {
  }

  public CustomDto(Integer id, String date, Integer duration_in_hours, String address, Integer cost_in_uah) {
    }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Integer getDuration_in_hours() {
    return duration_in_hours;
  }

  public void setDuration_in_hours(Integer duration_in_hours) {
    this.duration_in_hours = duration_in_hours;
  }


  public Integer getCost_in_uah() {
    return cost_in_uah;
  }

  public void setCost_in_uah(Integer cost_in_uah) {
    this.cost_in_uah = cost_in_uah;
  }

}

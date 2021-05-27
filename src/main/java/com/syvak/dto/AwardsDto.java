package com.syvak.dto;

public class AwardsDto {
  private Integer id;

  private String name;

  private Integer year;

  private String nomination;

  private String agency_id;

  public AwardsDto(Integer id, String name, Integer year, String nomination, String agency_id) {
    this.id = id;
    this.name = name;
    this.year = year;
    this.nomination = nomination;
    this.agency_id = agency_id;
  }

  public AwardsDto(String author, Integer year, String nomination, String agency_id) {
    this.name = author;
    this.year = year;
    this.nomination = nomination;
    this.agency_id = agency_id;
  }

  public AwardsDto() { }

  public AwardsDto(Integer id, String name, Integer year, String nomination, Integer agency_id) {
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

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public String getNomination() {
    return nomination;
  }

  public void setNomination(String nomination) {
    this.nomination = nomination;
  }

  public String getAgency_id() {
    return agency_id;
  }

  public void setAgency_id(String agency_id) {
    this.agency_id = agency_id;
  }
}

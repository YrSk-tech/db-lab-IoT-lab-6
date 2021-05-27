package com.syvak.dto;

public class DiscountsDto {
  private Integer id;
  private String name;
  private Integer cost;
  private Integer agency_id;

  public DiscountsDto(Integer id, String name,Integer cost,Integer agency_id) {
    this.id = id;
    this.name = name;
    this.cost = cost;
    this.agency_id = agency_id;
  }

  public DiscountsDto(String name,Integer cost,Integer agency_id) {
    this.name = name;
    this.cost = cost;
    this.agency_id = agency_id;
  }

  public DiscountsDto() {
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

  public Integer getCost() {
    return cost;
  }

  public void setCost(Integer cost) {
    this.cost = cost;
  }

  public Integer getAgency_id() {
    return agency_id;
  }

  public void setAgency_id(Integer agency_id) {
    this.agency_id = agency_id;
  }
}

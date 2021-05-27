package com.syvak.domain;

import javax.persistence.*;

@Entity
@Table(name = "award")
public class Award {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "year")
  private Integer year;

  @Column(name = "nomination")
  private String nomination;

  @Column(name = "agency_id")
  private Integer agency_id;

  public Award(Integer id, String name, Integer year, String nomination, Integer agency_id) {
    this.id = id;
    this.name = name;
    this.year = year;
    this.nomination = nomination;
    this.agency_id = agency_id;
  }

  public Award(String name, Integer year, String nomination, Integer agency_id) {
    this(null, name, year, nomination, agency_id);
  }
  public Award() {
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

  public Integer getAgency_id() {
    return agency_id;
  }

  public void setAgency_id(Integer agency_id) {
    this.agency_id = agency_id;
  }

  @Override
  public String toString() {
    return "Award{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", year='" + year + '\'' +
            ", nomination=" + nomination +
            ", agency_id=" + agency_id +
            '}';
  }
}

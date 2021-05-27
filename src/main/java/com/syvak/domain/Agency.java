package com.syvak.domain;

import javax.persistence.*;

@Entity
@Table(name = "agency")
public class Agency {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;
  @Column(name = "name")
  private String name;
  @Column(name = "phone_number")
  private Integer phone_number;

  public Agency(Integer id, String name, Integer phone_number) {
    this.id = id;
    this.name = name;
    this.phone_number = phone_number;
  }

  public Agency(String name, Integer phone_number) {
    this(null, name, phone_number);
  }

  public Agency() {

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

  public Integer getPhone_number() {
    return phone_number;
  }

  public void setPhone_number(Integer phone_number) {
    this.phone_number = phone_number;
  }

  @Override
  public String toString() {
    return "Agency{" +
            "id=" + id +
            ", name=" + name +
            ", phone_number=" + phone_number +
            '}';
  }
}

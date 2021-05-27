package com.syvak.domain;

import javax.persistence.*;

@Entity
@Table(name = "custom")
public class Custom {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "date")
  private String date;

  @Column(name = "duration_in_hours")
  private Integer duration_in_hours;

  @Column(name = "address")
  private String address;

  @Column(name = "cost_in_uah")
  private Integer cost_in_uah;


  public Custom(Integer id, String date,Integer duration_in_hours, String address , Integer cost_in_uah) {
    this.id = id;
    this.date = date;
    this.duration_in_hours = duration_in_hours;
    this.address = address;
    this.cost_in_uah = cost_in_uah;
  }


  public Custom(String date,Integer duration_in_hours, String address ,  Integer cost_in_uah) {
    this(null,  date,duration_in_hours, address , cost_in_uah);
  }

  public Custom() {

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

  @Override
  public String toString() {
    return "Custom{" +
            "id=" + id +
            ", date='" + date + '\'' +
            ", duration_in_hours='" + duration_in_hours + '\'' +
            ", address=" + address +
            ", cost_in_uah=" + cost_in_uah +
            '}';
  }
}

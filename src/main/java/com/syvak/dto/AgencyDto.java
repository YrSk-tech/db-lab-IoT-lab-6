package com.syvak.dto;

public class AgencyDto {
    private Integer id;

    private String name;

    private Integer phone_number;

    public AgencyDto(Integer id, String name, Integer phone_number) {
        this.id = id;
        this.name = name;
        this.phone_number = phone_number;
    }

    public AgencyDto(String name, Integer phone_number) {
        this.name = name;
        this.phone_number = phone_number;
    }

    public AgencyDto() {
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
}


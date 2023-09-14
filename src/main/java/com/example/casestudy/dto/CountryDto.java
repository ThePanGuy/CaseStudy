package com.example.casestudy.dto;

import com.example.casestudy.entities.Country;

public class CountryDto {
    private String name;
    private Double area;
    private String countryCode2;

    public CountryDto(Country country) {
        this.name = country.getName();
        this.area = country.getArea().doubleValue();
        this.countryCode2 = country.getCountryCode2();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getCountryCode2() {
        return countryCode2;
    }

    public void setCountryCode2(String countryCode2) {
        this.countryCode2 = countryCode2;
    }
}

package com.example.casestudy.dto;

import com.example.casestudy.entities.Country;
import com.example.casestudy.entities.CountryStat;

import java.math.BigDecimal;

public class BestCountryStatDto {
    private String name;
    private String countryCode3;
    private Integer year;
    private Integer population;
    private BigDecimal gdp;

    public BestCountryStatDto(Country country, CountryStat countryStat) {
        this.name = country.getName();
        this.countryCode3 = country.getCountryCode3();
        this.year = countryStat.getId().getYear();
        this.gdp = countryStat.getGdp();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode3() {
        return countryCode3;
    }

    public void setCountryCode3(String countryCode3) {
        this.countryCode3 = countryCode3;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public BigDecimal getGdp() {
        return gdp;
    }

    public void setGdp(BigDecimal gdp) {
        this.gdp = gdp;
    }
}

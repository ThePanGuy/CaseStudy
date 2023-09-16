package com.example.casestudy.dto;

import com.example.casestudy.entities.Country;
import com.example.casestudy.entities.CountryStat;

import java.math.BigDecimal;

public class BestCountryStatDto {
    private String countryName;
    private String countryCode3;
    private Integer year;
    private Integer population;
    private BigDecimal gdp;

    public BestCountryStatDto(Country country, CountryStat countryStat) {
        this.countryName = country.getName();
        this.countryCode3 = country.getCountryCode3();
        if (countryStat != null) {
            this.year = countryStat.getId().getYear();
            this.population = countryStat.getPopulation();
            this.gdp = countryStat.getGdp();
        }
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
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

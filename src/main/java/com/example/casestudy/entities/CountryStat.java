package com.example.casestudy.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "country_stats")
public class CountryStat {
    @EmbeddedId
    private CountryStatId id;

    private Integer population;
    private BigDecimal gdp;

    @MapsId("countryId")
    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    public CountryStatId getId() {
        return id;
    }

    public void setId(CountryStatId id) {
        this.id = id;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
package com.example.casestudy.entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CountryStatId implements Serializable {
    private Long countryId;
    private Integer year;

    public CountryStatId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryStatId that = (CountryStatId) o;
        return Objects.equals(countryId, that.countryId) && Objects.equals(year, that.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, year);
    }
}
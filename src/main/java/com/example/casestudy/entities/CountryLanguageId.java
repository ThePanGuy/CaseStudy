package com.example.casestudy.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CountryLanguageId implements Serializable {
    private Long countryId;
    private Long languageId;

    public CountryLanguageId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryLanguageId that = (CountryLanguageId) o;
        return Objects.equals(countryId, that.countryId) && Objects.equals(languageId, that.languageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, languageId);
    }
}
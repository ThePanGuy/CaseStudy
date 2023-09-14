package com.example.casestudy.entities;

import jakarta.persistence.*;

@Entity
public class CountryLanguage {
    @EmbeddedId
    private CountryLanguageId id;

    private boolean official;

    @MapsId("countryId")
    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @MapsId("languageId")
    @ManyToOne
    @JoinColumn(name = "language_id", nullable = false)
    private Language language;

    public CountryLanguageId getId() {
        return id;
    }

    public void setId(CountryLanguageId id) {
        this.id = id;
    }

    public boolean isOfficial() {
        return official;
    }

    public void setOfficial(boolean official) {
        this.official = official;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
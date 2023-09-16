package com.example.casestudy.dto;

import java.util.List;

public class CountryLanguagesDto {
    private String countryName;
    private List<String> languages;

    public CountryLanguagesDto(String countryName, List<String> languages) {
        this.countryName = countryName;
        this.languages = languages;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }
}

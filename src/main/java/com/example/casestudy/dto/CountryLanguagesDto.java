package com.example.casestudy.dto;

import java.util.ArrayList;
import java.util.List;

public class CountryLanguagesDto {
    private String countryName;
    private List<String> officialLanguages;
    private List<String> languages;

    public CountryLanguagesDto() {

    }

    public CountryLanguagesDto(String countryName) {
        this.countryName = countryName;
    }

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

    public List<String> getOfficialLanguages() {
        return officialLanguages;
    }

    public void setOfficialLanguages(List<String> officialLanguages) {
        this.officialLanguages = officialLanguages;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public void addOfficialLanguage(String language) {
        if (this.officialLanguages == null) {
            this.officialLanguages = new ArrayList<>();
        }
        this.officialLanguages.add(language);
    }

    public void addLanguage(String language) {
        if (this.languages == null) {
            this.languages = new ArrayList<>();
        }
        this.languages.add(language);
    }
}

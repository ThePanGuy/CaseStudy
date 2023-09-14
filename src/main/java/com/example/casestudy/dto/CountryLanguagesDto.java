package com.example.casestudy.dto;

import java.util.List;

public class CountryLanguagesDto {
    private String name;
    private List<String> language;

    public CountryLanguagesDto(String name, List<String> language) {
        this.name = name;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

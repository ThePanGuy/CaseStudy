package com.example.casestudy.services;

import com.example.casestudy.dto.CountryLanguagesDto;
import com.example.casestudy.entities.Country;

public interface LanguageService {
    CountryLanguagesDto findCountryLanguages(Country country);
}

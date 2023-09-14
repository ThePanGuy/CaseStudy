package com.example.casestudy.services;

import com.example.casestudy.dto.CountryLanguagesDto;
import com.example.casestudy.entities.Country;
import com.example.casestudy.entities.CountryLanguage;
import com.example.casestudy.repositories.CountryLanguageRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LanguageService {


    private final CountryLanguageRepository countryLanguageRepository;

    public LanguageService(CountryLanguageRepository countryLanguageRepository) {
        this.countryLanguageRepository = countryLanguageRepository;
    }

    public CountryLanguagesDto findCountryLanguages(Country country) {
        List<CountryLanguage> countryLanguages = countryLanguageRepository.findAllByCountry(country);
        List<String> languages = new ArrayList<>();
        for (CountryLanguage countryLanguage : countryLanguages) {
            languages.add(countryLanguage.getLanguage().getLanguageName());
        }
        return new CountryLanguagesDto(country.getName(), languages);
    }
}

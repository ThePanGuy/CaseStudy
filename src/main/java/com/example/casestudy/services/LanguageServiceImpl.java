package com.example.casestudy.services;

import com.example.casestudy.dto.CountryLanguagesDto;
import com.example.casestudy.entities.Country;
import com.example.casestudy.entities.CountryLanguage;
import com.example.casestudy.repositories.CountryLanguageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {


    private final CountryLanguageRepository countryLanguageRepository;

    public LanguageServiceImpl(CountryLanguageRepository countryLanguageRepository) {
        this.countryLanguageRepository = countryLanguageRepository;
    }

    @Override
    public CountryLanguagesDto findCountryLanguages(Country country) {
        List<CountryLanguage> countryLanguages = countryLanguageRepository.findAllByCountry(country);
        CountryLanguagesDto countryLanguagesDto = new CountryLanguagesDto(country.getName());
        for (CountryLanguage countryLanguage : countryLanguages) {
            if (countryLanguage.isOfficial()) {
                countryLanguagesDto.addOfficialLanguage(countryLanguage.getLanguage().getLanguageName());
            } else {
                countryLanguagesDto.addLanguage(countryLanguage.getLanguage().getLanguageName());
            }
        }
        return countryLanguagesDto;
    }
}

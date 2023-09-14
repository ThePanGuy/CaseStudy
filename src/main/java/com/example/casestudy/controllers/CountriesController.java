package com.example.casestudy.controllers;

import com.example.casestudy.dto.BestCountryStatDto;
import com.example.casestudy.dto.CountryDto;
import com.example.casestudy.dto.CountryLanguagesDto;
import com.example.casestudy.entities.Country;
import com.example.casestudy.repositories.CountryRepository;
import com.example.casestudy.services.CountryStatService;
import com.example.casestudy.services.LanguageService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/countries")
public class CountriesController {

    private final CountryRepository countryRepository;
    private final CountryStatService countryStatService;
    private final LanguageService languageService;

    public CountriesController(CountryRepository countryRepository, CountryStatService countryStatService, LanguageService languageService) {
        this.countryRepository = countryRepository;
        this.countryStatService = countryStatService;
        this.languageService = languageService;
    }


    @GetMapping(path = "/all")
    public List<CountryDto> getAllCountries() {
        List<Country> countries = countryRepository.findAll();
        List<CountryDto> countriesDto = new ArrayList<>();
        for (Country country : countries) {
            countriesDto.add(new CountryDto(country));
        }
        return countriesDto;
    }

    @GetMapping(path = "/languages/{countryId}")
    public CountryLanguagesDto getAllLanguagesForCountry(@RequestParam Long countryId) {
        Country country = countryRepository.findById(countryId)
                .orElseThrow(EntityNotFoundException::new);

        return languageService.findCountryLanguages(country);
    }

    @GetMapping(path = "/gdp")
    public List<BestCountryStatDto> getCountriesGdp() {
        List<Country> countries = countryRepository.findAll();
        return countryStatService.getCountriesBestStat(countries);
    }

}

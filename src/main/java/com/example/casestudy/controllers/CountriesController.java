package com.example.casestudy.controllers;

import com.example.casestudy.dto.*;
import com.example.casestudy.entities.Country;
import com.example.casestudy.repositories.CountryRepository;
import com.example.casestudy.services.CountryService;
import com.example.casestudy.services.CountryStatService;
import com.example.casestudy.services.LanguageService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/countries")
public class CountriesController {

    private final CountryRepository countryRepository;
    private final CountryStatService countryStatService;
    private final LanguageService languageService;
    private final CountryService countryService;

    public CountriesController(CountryRepository countryRepository, CountryStatService countryStatService, LanguageService languageService, CountryService countryService) {
        this.countryRepository = countryRepository;
        this.countryStatService = countryStatService;
        this.languageService = languageService;
        this.countryService = countryService;
    }


    @GetMapping(path = "/all")
    public List<CountryDto> getAllCountries() {
        return countryService.fetchAllCountries();
    }

    @GetMapping(path = "/languages/{countryId}")
    public CountryLanguagesDto getAllLanguagesForCountry(@PathVariable Long countryId) {
        Country country = countryRepository.findById(countryId)
                .orElseThrow(EntityNotFoundException::new);

        return languageService.findCountryLanguages(country);
    }

    @GetMapping(path = "/gdp")
    public List<BestCountryStatDto> getCountriesGdp() {
        return countryStatService.getCountriesBestStats();
    }

    @PostMapping(path = "/country-stats")
    public Page<CountryStatDto> findCountryStats(@RequestBody FilterRequest filterRequest, Pageable pageable) {
        if (pageable == null) {
            throw new IllegalArgumentException("Please define paging properties.");
        }
        if (pageable.getSort().isEmpty()) {
            pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("id.year").descending());
        }
        return countryStatService.filterCountriesStats(filterRequest, pageable);
    }

}

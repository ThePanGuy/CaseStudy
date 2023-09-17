package com.example.casestudy.controllers;

import com.example.casestudy.dto.*;
import com.example.casestudy.entities.Country;
import com.example.casestudy.repositories.CountryRepository;
import com.example.casestudy.services.CountryServiceImpl;
import com.example.casestudy.services.CountryStatServiceImpl;
import com.example.casestudy.services.LanguageServiceImpl;
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
    private final CountryStatServiceImpl countryStatServiceImpl;
    private final LanguageServiceImpl languageServiceImpl;
    private final CountryServiceImpl countryServiceImpl;

    public CountriesController(CountryRepository countryRepository, CountryStatServiceImpl countryStatServiceImpl, LanguageServiceImpl languageServiceImpl, CountryServiceImpl countryServiceImpl) {
        this.countryRepository = countryRepository;
        this.countryStatServiceImpl = countryStatServiceImpl;
        this.languageServiceImpl = languageServiceImpl;
        this.countryServiceImpl = countryServiceImpl;
    }


    @GetMapping(path = "/all")
    public List<CountryDto> getAllCountries() {
        return countryServiceImpl.fetchAllCountries();
    }

    @GetMapping(path = "/languages/{countryId}")
    public CountryLanguagesDto getAllLanguagesForCountry(@PathVariable Long countryId) {
        Country country = countryRepository.findById(countryId)
                .orElseThrow(EntityNotFoundException::new);

        return languageServiceImpl.findCountryLanguages(country);
    }

    @GetMapping(path = "/gdp")
    public List<BestCountryStatDto> getCountriesGdp() {
        return countryStatServiceImpl.getCountriesBestStats();
    }

    @PostMapping(path = "/country-stats")
    public Page<CountryStatDto> findCountryStats(@RequestBody FilterRequest filterRequest, Pageable pageable) {
        if (pageable.getSort().isEmpty()) {
            pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("id.year").descending());
        }
        return countryStatServiceImpl.filterCountriesStats(filterRequest, pageable);
    }

}

package com.example.casestudy.controllers;

import com.example.casestudy.dto.*;
import com.example.casestudy.entities.Country;
import com.example.casestudy.repositories.CountryRepository;
import com.example.casestudy.services.CountryStatServiceImpl;
import com.example.casestudy.services.LanguageServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/countries")
public class CountriesController {

    private final CountryRepository countryRepository;
    private final CountryStatServiceImpl countryStatServiceImpl;
    private final LanguageServiceImpl languageServiceImpl;

    public CountriesController(CountryRepository countryRepository, CountryStatServiceImpl countryStatServiceImpl, LanguageServiceImpl languageServiceImpl) {
        this.countryRepository = countryRepository;
        this.countryStatServiceImpl = countryStatServiceImpl;
        this.languageServiceImpl = languageServiceImpl;
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
    public CountryLanguagesDto getAllLanguagesForCountry(@PathVariable Long countryId) {
        Country country = countryRepository.findById(countryId)
                .orElseThrow(EntityNotFoundException::new);

        return languageServiceImpl.findCountryLanguages(country);
    }

    @GetMapping(path = "/gdp")
    public List<BestCountryStatDto> getCountriesGdp() {
        List<Country> countries = countryRepository.findAll();
        return countryStatServiceImpl.getCountriesBestStat(countries);
    }

    @PostMapping(path = "/country-stats")
    public Page<CountryStatDto> findCountryStats(@RequestBody FilterRequest filterRequest, Pageable pageable) {
        if (pageable.getSort().isEmpty()) {
            pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("id.year").descending());
        }
        return countryStatServiceImpl.filterCountriesStats(filterRequest, pageable);
    }

}

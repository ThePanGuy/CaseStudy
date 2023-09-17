package com.example.casestudy.services;

import com.example.casestudy.dto.CountryDto;
import com.example.casestudy.entities.Country;
import com.example.casestudy.repositories.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService{
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<CountryDto> fetchAllCountries() {
        List<Country> countries = countryRepository.findAll();
        List<CountryDto> countriesDto = new ArrayList<>();
        for (Country country : countries) {
            countriesDto.add(new CountryDto(country));
        }
        return countriesDto;
    }
}

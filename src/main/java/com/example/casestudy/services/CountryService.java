package com.example.casestudy.services;

import com.example.casestudy.dto.CountryDto;

import java.util.List;

public interface CountryService {
    List<CountryDto> fetchAllCountries();
}

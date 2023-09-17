package com.example.casestudy.services;

import com.example.casestudy.dto.BestCountryStatDto;
import com.example.casestudy.dto.CountryStatDto;
import com.example.casestudy.dto.FilterRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CountryStatService {
    Page<CountryStatDto> filterCountriesStats(FilterRequest filterRequest, Pageable pageable);

    List<BestCountryStatDto> getCountriesBestStats();
}

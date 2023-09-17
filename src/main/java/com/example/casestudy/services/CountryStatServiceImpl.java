package com.example.casestudy.services;

import com.example.casestudy.dto.BestCountryStatDto;
import com.example.casestudy.dto.CountryStatDto;
import com.example.casestudy.dto.FilterRequest;
import com.example.casestudy.entities.Country;
import com.example.casestudy.entities.CountryStat;
import com.example.casestudy.repositories.CountryRepository;
import com.example.casestudy.repositories.CountryStatRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CountryStatServiceImpl implements CountryStatService{

    private final CountryStatRepository countryStatRepository;
    private final CountryRepository countryRepository;

    public CountryStatServiceImpl(CountryStatRepository countryStatRepository,
                                  CountryRepository countryRepository) {
        this.countryStatRepository = countryStatRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public Page<CountryStatDto> filterCountriesStats(FilterRequest filterRequest, Pageable pageable) {
        return countryStatRepository.filterCountryStats("%" + filterRequest.getRegionName() + "%",
                filterRequest.getFrom(), filterRequest.getTo(), pageable);
    }

    @Override
    public List<BestCountryStatDto> getCountriesBestStats() {
        List<Country> countries = countryRepository.findAll();
        Map<Country, CountryStat> bestCountryStatMap = new HashMap<>();
        for (Country country : countries) {
            bestCountryStatMap.put(country, findBestCountryStat(country));
        }
        List<BestCountryStatDto> bestCountryStatDtoList = new ArrayList<>();
        bestCountryStatMap.forEach((key, value) -> bestCountryStatDtoList.add(new BestCountryStatDto(key, value)));
        return bestCountryStatDtoList;
    }

    private CountryStat findBestCountryStat(Country country) {
        List<CountryStat> countryStats = countryStatRepository.findAllByCountry(country);
        CountryStat bestStat = null;
        for (CountryStat countryStat : countryStats) {
            BigDecimal gpdPerPopulationRatio = calculateGpdPerPopulationRatio(countryStat);
            if (bestStat == null || gpdPerPopulationRatio.compareTo(calculateGpdPerPopulationRatio(bestStat)) > 0) {
                bestStat = countryStat;
            }
        }
        return bestStat;
    }

    private static BigDecimal calculateGpdPerPopulationRatio(CountryStat countryStat) {
        return countryStat.getGdp().divide(BigDecimal.valueOf(countryStat.getPopulation()), RoundingMode.HALF_UP);
    }
}

package com.example.casestudy.repositories;

import com.example.casestudy.entities.Country;
import com.example.casestudy.entities.CountryStat;
import com.example.casestudy.entities.CountryStatId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryStatRepository extends JpaRepository<CountryStat, CountryStatId> {
    List<CountryStat> findAllByCountry(Country country);
}
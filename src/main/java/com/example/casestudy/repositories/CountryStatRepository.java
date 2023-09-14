package com.example.casestudy.repositories;

import com.example.casestudy.entities.CountryStat;
import com.example.casestudy.entities.CountryStatId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryStatRepository extends JpaRepository<CountryStat, CountryStatId> {
}
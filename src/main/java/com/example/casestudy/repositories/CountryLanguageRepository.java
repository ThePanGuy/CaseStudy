package com.example.casestudy.repositories;

import com.example.casestudy.entities.CountryLanguage;
import com.example.casestudy.entities.CountryLanguageId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, CountryLanguageId> {
}
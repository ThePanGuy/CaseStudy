package com.example.casestudy.repositories;

import com.example.casestudy.dto.CountryStatDto;
import com.example.casestudy.entities.Country;
import com.example.casestudy.entities.CountryStat;
import com.example.casestudy.entities.CountryStatId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountryStatRepository extends JpaRepository<CountryStat, CountryStatId> {
    List<CountryStat> findAllByCountry(Country country);

    @Query("select new com.example.casestudy.dto.CountryStatDto(ct.name, r.name, c.name, cs.id.year, cs.population, cs.gdp) " +
           "from CountryStat cs " +
           "inner join cs.country c " +
           "inner join c.region r " +
           "inner join r.continent ct " +
           "where (:regionName is null or upper(r.name) like upper(:regionName)) " +
           "and (:fromDate is null or cs.id.year >= :fromDate) " +
           "and (:toDate is null or cs.id.year <= :toDate)")
    Page<CountryStatDto> filterCountryStats(
            @Param("regionName") String regionName,
            @Param("fromDate") Integer fromDate,
            @Param("toDate") Integer toDate,
            Pageable pageable
    );
}
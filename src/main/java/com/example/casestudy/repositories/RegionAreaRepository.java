package com.example.casestudy.repositories;

import com.example.casestudy.entities.RegionArea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionAreaRepository extends JpaRepository<RegionArea, String> {
}
package com.example.casestudy.services;

import com.example.casestudy.dto.RegionDto;

import java.util.List;

public interface RegionService {
    List<RegionDto> fetchAllRegions();
}

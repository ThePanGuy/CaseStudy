package com.example.casestudy.services;

import com.example.casestudy.dto.RegionDto;
import com.example.casestudy.entities.Region;
import com.example.casestudy.repositories.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegionServiceImpl implements RegionService{
    private final RegionRepository regionRepository;

    public RegionServiceImpl(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public List<RegionDto> fetchAllRegions() {
        List<Region> regions = regionRepository.findAll();
        List<RegionDto> regionsDto = new ArrayList<>();
        for (Region region : regions) {
            regionsDto.add(new RegionDto(region));
        }
        return regionsDto;
    }
}

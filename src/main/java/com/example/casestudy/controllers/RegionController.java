package com.example.casestudy.controllers;

import com.example.casestudy.dto.RegionDto;
import com.example.casestudy.entities.Region;
import com.example.casestudy.repositories.RegionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/regions")
public class RegionController {

    private final RegionRepository regionRepository;

    public RegionController(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }


    @GetMapping
    public List<RegionDto> getAvailableRegions() {
        List<Region> regions = regionRepository.findAll();
        List<RegionDto> regionDtos = new ArrayList<>();
        for (Region region : regions) {
            regionDtos.add(new RegionDto(region));
        }
        return regionDtos;
    }
}

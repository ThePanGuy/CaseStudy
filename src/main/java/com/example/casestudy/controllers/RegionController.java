package com.example.casestudy.controllers;

import com.example.casestudy.dto.RegionDto;
import com.example.casestudy.services.RegionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/regions")
public class RegionController {

    private final RegionService regionService;

    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }


    @GetMapping
    public List<RegionDto> getAvailableRegions() {
        return regionService.fetchAllRegions();
    }
}

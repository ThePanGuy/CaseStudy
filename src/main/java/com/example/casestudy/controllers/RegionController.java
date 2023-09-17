package com.example.casestudy.controllers;

import com.example.casestudy.dto.RegionDto;
import com.example.casestudy.services.RegionServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/regions")
public class RegionController {

    private final RegionServiceImpl regionServiceImpl;

    public RegionController(RegionServiceImpl regionServiceImpl) {
        this.regionServiceImpl = regionServiceImpl;
    }


    @GetMapping
    public List<RegionDto> getAvailableRegions() {
        return regionServiceImpl.fetchAllRegions();
    }
}

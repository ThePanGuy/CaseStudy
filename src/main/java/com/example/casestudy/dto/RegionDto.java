package com.example.casestudy.dto;

import com.example.casestudy.entities.Region;

public class RegionDto {
    private Long regionId;
    private String name;

    public RegionDto(Region region) {
        this.regionId = region.getRegionId();
        this.name = region.getName();
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

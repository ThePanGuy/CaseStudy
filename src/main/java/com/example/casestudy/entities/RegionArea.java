package com.example.casestudy.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "region_areas")
public class RegionArea {
    @Id
    private String regionName;

    private BigDecimal regionArea;

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public BigDecimal getRegionArea() {
        return regionArea;
    }

    public void setRegionArea(BigDecimal regionArea) {
        this.regionArea = regionArea;
    }
}
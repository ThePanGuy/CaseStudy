package com.example.casestudy.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "vips")
public class Vip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vipId;
    @Column
    private String name;

    public Long getVipId() {
        return vipId;
    }

    public void setVipId(Long vipId) {
        this.vipId = vipId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
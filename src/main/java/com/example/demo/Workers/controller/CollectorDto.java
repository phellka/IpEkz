package com.example.demo.Workers.controller;

import com.example.demo.Workers.model.Collector;

public class CollectorDto {
    private final long id;
    private final String name;

    public  CollectorDto(Collector collector){
        this.id = collector.getId();
        this.name = String.format("%s %s %s", collector.getExperience(), collector.getName(), collector.getQualification());
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

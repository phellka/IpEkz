package com.example.demo.Workers.controller;

import com.example.demo.Configuration.WebConfiguration;
import com.example.demo.Workers.service.CollectorService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(WebConfiguration.REST_API + "/collector")
public class CollectorController {
    private final CollectorService collectorService;

    public CollectorController(CollectorService collectorService) {
        this.collectorService = collectorService;
    }

    @GetMapping("/{id}")
    public CollectorDto getCollector(@PathVariable Long id) {
        return new CollectorDto(collectorService.findCollector(id));
    }

    @GetMapping()
    public List<CollectorDto> getCollectors() {
        return collectorService.findAllCollectors().stream()
                .map(CollectorDto::new)
                .toList();
    }
    @PostMapping()
    public CollectorDto createCollector(@RequestParam("experience") int experience,
                                     @RequestParam("name") String name,
                                     @RequestParam("qualificationId") long qualificationId) {
        return new CollectorDto(collectorService.addCollector(experience, name, qualificationId));
    }
    @PatchMapping("/{id}")
    public CollectorDto updateCollector(@PathVariable Long id,
                                     @RequestParam("experience") int experience,
                                     @RequestParam("name") String name,
                                     @RequestParam("qualificationId") long qualificationId) {
        return new CollectorDto(collectorService.updateCollector(id, experience, name, qualificationId));
    }
    @DeleteMapping("/{id}")
    public CollectorDto deleteCollector(@PathVariable Long id) {
        return new CollectorDto(collectorService.deleteCollector(id));
    }
}

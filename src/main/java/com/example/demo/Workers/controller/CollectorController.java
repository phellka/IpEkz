package com.example.demo.Workers.controller;

import com.example.demo.Workers.model.Collector;
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
@RequestMapping("/collector")
public class CollectorController {
    private final CollectorService collectorService;

    public CollectorController(CollectorService collectorService) {
        this.collectorService = collectorService;
    }

    @GetMapping("/{id}")
    public Collector getCollector(@PathVariable Long id) {
        return collectorService.findCollector(id);
    }

    @GetMapping("/")
    public List<Collector> getCollectors() {
        return collectorService.findAllCollectors();
    }
    @PostMapping("/")
    public Collector createCollector(@RequestParam("experience") int experience,
                                     @RequestParam("name") String name,
                                     @RequestParam("qualificationId") long qualificationId) {
        return collectorService.addCollector(experience, name, qualificationId);
    }
    @PatchMapping("/{id}")
    public Collector updateCollector(@PathVariable Long id,
                                     @RequestParam("experience") int experience,
                                     @RequestParam("name") String name,
                                     @RequestParam("qualificationId") long qualificationId) {
        return collectorService.updateCollector(id, experience, name, qualificationId);
    }
    @DeleteMapping("/{id}")
    public Collector deleteCollector(@PathVariable Long id) {
        return collectorService.deleteCollector(id);
    }
}

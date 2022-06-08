package com.example.demo.Workers.controller;

import com.example.demo.Workers.model.Qualification;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Workers.service.QualificationService;

import java.util.List;

@RestController
@RequestMapping("/qualification")
public class QualificationController {
    private final QualificationService qualificationService;

    public QualificationController(QualificationService qualificationService) {
        this.qualificationService = qualificationService;
    }

    @GetMapping("/{id}")
    public QualificationDto getQualification(@PathVariable Long id) {
        return new QualificationDto(qualificationService.findQualification(id));
    }

    @GetMapping("/")
    public List<QualificationDto> getQualifications() {
        return qualificationService.findAllQualifications().stream()
                .map(QualificationDto::new)
                .toList();
    }

    @PostMapping("/")
    public QualificationDto createQualification(@RequestParam("category") int category,
                                 @RequestParam("name") String name) {
        return new QualificationDto(qualificationService.addQualification(category, name));
    }

    @PatchMapping("/{id}")
    public QualificationDto updateQualification(@PathVariable Long id,
                                 @RequestParam("category") int category,
                                 @RequestParam("name") String name) {
        return new QualificationDto(qualificationService.updateQualification(id, category, name));
    }

    @DeleteMapping("/{id}")
    public QualificationDto deleteQualification(@PathVariable Long id) {
        return new QualificationDto(qualificationService.deleteQualification(id));
    }
}

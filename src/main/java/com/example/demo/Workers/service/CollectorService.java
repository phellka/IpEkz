package com.example.demo.Workers.service;

import com.example.demo.Workers.repository.QualificationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.Workers.model.Qualification;
import com.example.demo.Workers.model.Collector;
import com.example.demo.Workers.repository.CollectorRepository;
import com.example.demo.Workers.repository.QualificationRepository;
import com.example.demo.util.validation.ValidatorUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class CollectorService {
    private final CollectorRepository collectorRepository;
    private final QualificationRepository qualificationRepository;
    private final ValidatorUtil validatorUtil;

    public CollectorService(CollectorRepository collectorRepository,
                            QualificationRepository qualificationRepository,
                            ValidatorUtil validatorUtil){
        this.collectorRepository = collectorRepository;
        this.qualificationRepository = qualificationRepository;
        this.validatorUtil = validatorUtil;
    }

    @Transactional
    public Collector addCollector(int experience, String name, long qualificationId) {
        final Optional<Qualification> qualification = qualificationRepository.findById(qualificationId);
        final Collector collector = new Collector(experience, name, qualification.get());
        validatorUtil.validate(collector);
        return collectorRepository.save(collector);
    }

    @Transactional(readOnly = true)
    public Collector findCollector(Long id) {
        final Optional<Collector> collector = collectorRepository.findById(id);
        return collector.orElseThrow(() -> new CollectorNotFoundException(id));
    }

    @Transactional(readOnly = true)
    public List<Collector> findAllCollectors() {
        return collectorRepository.findAll();
    }

    @Transactional
    public Collector updateCollector(Long id, int experience, String name, long qualificationId) {
        final Collector currentCollector = findCollector(id);
        currentCollector.setExperience(experience);
        currentCollector.setName(name);
        final Optional<Qualification> qualification = qualificationRepository.findById(qualificationId);
        currentCollector.setQualification(qualification.get());
        return collectorRepository.save(currentCollector);
    }

    @Transactional
    public Collector deleteCollector(Long id) {
        final Collector currentCollector = findCollector(id);
        collectorRepository.delete(currentCollector);
        return currentCollector;
    }

    @Transactional
    public void deleteAllCollectors() {
        collectorRepository.deleteAll();
    }
}

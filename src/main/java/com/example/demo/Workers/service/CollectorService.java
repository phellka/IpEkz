package com.example.demo.Workers.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.Workers.model.Qualification;
import com.example.demo.Workers.model.Collector;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class CollectorService {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Collector addCollector(int experience, String name, long qualificationId) {
        Qualification qualification = em.find(Qualification.class, qualificationId);
        if (qualification == null) {
            throw new EntityNotFoundException(String.format("Qualification with id [%s] is not found", qualificationId));
        }
        final Collector collector = new Collector(experience, name, qualification);
        em.persist(collector);
        return collector;
    }

    @Transactional(readOnly = true)
    public Collector findCollector(Long id) {
        final Collector collector = em.find(Collector.class, id);
        if (collector == null) {
            throw new EntityNotFoundException(String.format("Collector with id [%s] is not found", id));
        }
        return collector;
    }

    @Transactional(readOnly = true)
    public List<Collector> findAllCollectors() {
        return em.createQuery("select c from Collector c", Collector.class)
                .getResultList();
    }

    @Transactional
    public Collector updateCollector(Long id, int experience, String name, long qualificationId) {
        final Collector currentCollector = findCollector(id);
        currentCollector.setExperience(experience);
        currentCollector.setName(name);
        Qualification qualification = em.find(Qualification.class, qualificationId);
        if (qualification == null) {
            throw new EntityNotFoundException(String.format("Qualification with id [%s] is not found", qualificationId));
        }
        currentCollector.setQualification(qualification);
        return em.merge(currentCollector);
    }

    @Transactional
    public Collector deleteCollector(Long id) {
        final Collector currentCollector = findCollector(id);
        em.remove(currentCollector);
        return currentCollector;
    }

    @Transactional
    public void deleteAllCollectors() {
        em.createQuery("delete from Collector").executeUpdate();
    }
}

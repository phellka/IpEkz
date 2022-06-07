package com.example.demo.Workers.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.Workers.model.Qualification;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class QualificationService {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Qualification addQualification(int category, String name) {
        final Qualification qualification = new Qualification(category, name);
        em.persist(qualification);
        return qualification;
    }

    @Transactional(readOnly = true)
    public Qualification findQualification(Long id) {
        final Qualification qualification = em.find(Qualification.class, id);
        if (qualification == null) {
            throw new EntityNotFoundException(String.format("Qualification with id [%s] is not found", id));
        }
        return qualification;
    }

    @Transactional(readOnly = true)
    public List<Qualification> findAllQualifications() {
        return em.createQuery("select s from Qualification s", Qualification.class)
                .getResultList();
    }

    @Transactional
    public Qualification updateQualification(Long id, int category, String name) {
        final Qualification currentQualification = findQualification(id);
        currentQualification.setCategory(category);
        currentQualification.setName(name);
        return em.merge(currentQualification);
    }

    @Transactional
    public Qualification deleteQualification(Long id) {
        final Qualification currentQualification = findQualification(id);
        em.remove(currentQualification);
        return currentQualification;
    }

    @Transactional
    public void deleteAllQualifications() {
        em.createQuery("delete from Qualification").executeUpdate();
    }
}

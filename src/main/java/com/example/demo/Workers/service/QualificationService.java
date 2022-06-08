package com.example.demo.Workers.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.Workers.model.Qualification;
import com.example.demo.Workers.repository.QualificationRepository;
import com.example.demo.util.validation.ValidatorUtil;

import java.util.List;
import java.util.Optional;

@Service
public class QualificationService {
    private final QualificationRepository qualificationRepository;
    private final ValidatorUtil validatorUtil;

    public QualificationService(QualificationRepository qualificationRepository,
                                ValidatorUtil validatorUtil){
        this.qualificationRepository = qualificationRepository;
        this.validatorUtil = validatorUtil;
    }

    @Transactional
    public Qualification addQualification(int category, String name) {
        final Qualification qualification = new Qualification(category, name);
        validatorUtil.validate(qualification);
        return qualificationRepository.save(qualification);
    }

    @Transactional(readOnly = true)
    public Qualification findQualification(Long id) {
        final Optional<Qualification> qualification = qualificationRepository.findById(id);
        return qualification.orElseThrow(() -> new QualificationNotFoundException(id));
    }

    @Transactional(readOnly = true)
    public List<Qualification> findAllQualifications() {
        return qualificationRepository.findAll();
    }

    @Transactional
    public Qualification updateQualification(Long id, int category, String name) {
        final Qualification currentQualification = findQualification(id);
        currentQualification.setCategory(category);
        currentQualification.setName(name);
        return qualificationRepository.save(currentQualification);
    }

    @Transactional
    public Qualification deleteQualification(Long id) {
        final Qualification currentQualification = findQualification(id);
        qualificationRepository.delete(currentQualification);
        return currentQualification;
    }

    @Transactional
    public void deleteAllQualifications() {
        qualificationRepository.deleteAll();
    }
}

package com.example.demo.Workers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Workers.model.Qualification;

public interface QualificationRepository extends JpaRepository<Qualification, Long>  {
}

package com.example.demo.Workers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Workers.model.Collector;

public interface CollectorRepository extends JpaRepository<Collector, Long> {
}

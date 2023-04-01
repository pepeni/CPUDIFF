package com.pepeni.springboot.cpudiff.repository;

import com.pepeni.springboot.cpudiff.model.Processor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProcessorRepo extends JpaRepository<Processor, Long> {
    Optional<Processor> findProcessorById(Long id);
}

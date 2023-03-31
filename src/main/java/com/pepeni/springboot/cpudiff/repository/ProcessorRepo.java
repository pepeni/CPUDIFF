package com.pepeni.springboot.cpudiff.repository;

import com.pepeni.springboot.cpudiff.model.Processor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessorRepo extends JpaRepository<Processor, Long> {
}

package com.pepeni.springboot.cpudiff.service;

import com.pepeni.springboot.cpudiff.exception.ArticleNotFoundException;
import com.pepeni.springboot.cpudiff.exception.ProcessorNotFoundException;
import com.pepeni.springboot.cpudiff.model.Article;
import com.pepeni.springboot.cpudiff.model.Processor;
import com.pepeni.springboot.cpudiff.repository.ProcessorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessorService {

    private final ProcessorRepo processorRepo;

    @Autowired
    public ProcessorService(ProcessorRepo processorRepo) {
        this.processorRepo = processorRepo;
    }

    public Processor addProcessor(Processor processor){
        return processorRepo.save(processor);
    }

    public List<Processor> findAllProcessors(){
        return processorRepo.findAll();
    }

    public Processor findProcessorById(Long id){
        return processorRepo.findProcessorById(id).orElseThrow(() -> new ProcessorNotFoundException("Processor by id = " + id + " was not found"));
    }

    public void deleteProcessor(Long id){
        processorRepo.deleteById(id);
    }
}
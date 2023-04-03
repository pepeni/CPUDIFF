package com.pepeni.springboot.cpudiff.controllers;

import com.pepeni.springboot.cpudiff.model.Article;
import com.pepeni.springboot.cpudiff.model.Processor;
import com.pepeni.springboot.cpudiff.service.ProcessorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Service
public class ProcessorsController {

    private final ProcessorService processorService;

    public ProcessorsController(ProcessorService processorService) {
        this.processorService = processorService;
    }

    @GetMapping("/processorTest")
    public ResponseEntity<Processor> getProcesorTest(){
        Processor processor = new Processor(1L, "Desktop", 6, 2.6, 3.6);
        return new ResponseEntity<Processor>(processor, HttpStatus.OK);
    }

    @GetMapping("/processor/{id}")
    public ResponseEntity<Processor> getProcesor(@PathVariable("id") Long id){
        Processor processor = processorService.findProcessorById(id);
        return new ResponseEntity<Processor>(processor, HttpStatus.OK);
    }

    @GetMapping("/addProcessor")
    public ResponseEntity<List<Processor>> addProcesor(){
        List<Processor> processors = processorService.findAllProcessors();
        return new ResponseEntity<List<Processor>>(processors, HttpStatus.OK);
    }

    @PutMapping("/updateProcessor")
    public ResponseEntity<Processor> updateProcessor(@RequestBody Processor processor){
        Processor updateProcessor = processorService.updateProcessor(processor);
        return new ResponseEntity<>(updateProcessor, HttpStatus.OK);
    }

    @GetMapping("/deleteProcessor/{id}")
    public ResponseEntity<?> deleteProcessorById(@PathVariable("id") Long id){
        processorService.deleteProcessor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

package com.pepeni.springboot.cpudiff.controllers;

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
        Processor processor = new Processor( "name", "Desktop", 6, 2.6, 3.6);
        return new ResponseEntity<Processor>(processor, HttpStatus.OK);
    }

    @GetMapping("/allProcessors")
    public ResponseEntity<List<Processor>> getAllProcessors(){
        List<Processor> processors = processorService.findAllProcessors();
        return new ResponseEntity<>(processors, HttpStatus.OK);
    }

    @GetMapping("/processor/{id}")
    public ResponseEntity<Processor> getProcesor(@PathVariable("id") Long id){
        Processor processor = processorService.findProcessorById(id);
        return new ResponseEntity<Processor>(processor, HttpStatus.OK);
    }

    @PostMapping("/addProcessor")
    public ResponseEntity<Processor> addProcesor(@RequestBody Processor processor){
        Processor addProcessor = processorService.addProcessor(processor);
        return new ResponseEntity<Processor>(addProcessor, HttpStatus.OK);
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

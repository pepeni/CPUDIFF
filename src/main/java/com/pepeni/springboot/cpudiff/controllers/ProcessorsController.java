package com.pepeni.springboot.cpudiff.controllers;

import com.pepeni.springboot.cpudiff.model.Processor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Service
public class ProcessorsController {



    @GetMapping("/processor")
    public ResponseEntity<Processor> getProcesor(){
        Processor processor = new Processor(1L, "Desktop", 6, 2.6, 3.6);
        return new ResponseEntity<Processor>(processor, HttpStatus.OK);
    }
}

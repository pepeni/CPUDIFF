package com.pepeni.springboot.cpudiff.exception;

public class ProcessorNotFoundException extends RuntimeException {
    public ProcessorNotFoundException(String s) {
        super(s);
    }
}

package com.pepeni.springboot.cpudiff.model;

import java.io.Serializable;

public class Processor implements Serializable {
    private Integer id;
    private String CpuClass;
    private Integer Cores;
    private Double ProcessorClockSpeed;
    private Double ProcessorClockSpeedTurbo;

    public Processor(Integer id, String cpuClass, Integer cores, Double processorClockSpeed, Double processorClockSpeedTurbo) {
        this.id = id;
        CpuClass = cpuClass;
        Cores = cores;
        ProcessorClockSpeed = processorClockSpeed;
        ProcessorClockSpeedTurbo = processorClockSpeedTurbo;
    }

    public Integer getId() {
        return id;
    }

    public String getCpuClass() {
        return CpuClass;
    }

    public void setCpuClass(String cpuClass) {
        CpuClass = cpuClass;
    }

    public Integer getCores() {
        return Cores;
    }

    public void setCores(Integer cores) {
        Cores = cores;
    }

    public Double getProcessorClockSpeed() {
        return ProcessorClockSpeed;
    }

    public void setProcessorClockSpeed(Double processorClockSpeed) {
        ProcessorClockSpeed = processorClockSpeed;
    }

    public Double getProcessorClockSpeedTurbo() {
        return ProcessorClockSpeedTurbo;
    }

    public void setProcessorClockSpeedTurbo(Double processorClockSpeedTurbo) {
        ProcessorClockSpeedTurbo = processorClockSpeedTurbo;
    }
}

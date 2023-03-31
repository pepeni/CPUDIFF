package com.pepeni.springboot.cpudiff.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="PROCESSOR")
public class Processor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String CpuClass;
    private Integer Cores;
    private Double ProcessorClockSpeed;
    private Double ProcessorClockSpeedTurbo;

    @OneToMany(mappedBy = "processor")
    Set<Comment> comments;

    public Processor() {
    }

    public Processor(Long id, String cpuClass, Integer cores, Double processorClockSpeed, Double processorClockSpeedTurbo) {
        this.id = id;
        CpuClass = cpuClass;
        Cores = cores;
        ProcessorClockSpeed = processorClockSpeed;
        ProcessorClockSpeedTurbo = processorClockSpeedTurbo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Processor{" +
                "id=" + id +
                ", CpuClass='" + CpuClass + '\'' +
                ", Cores=" + Cores +
                ", ProcessorClockSpeed=" + ProcessorClockSpeed +
                ", ProcessorClockSpeedTurbo=" + ProcessorClockSpeedTurbo +
                ", comments=" + comments +
                '}';
    }
}

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
    private String name;
    private String cpuClass;
    private Integer cores;
    private Double processorClockSpeed;
    private Double processorClockSpeedTurbo;

    @Transient
    @OneToMany(mappedBy = "processor")
    Set<Comment> comments;

    public Processor() {
    }

    public Processor(String name, String cpuClass, Integer cores, Double processorClockSpeed, Double processorClockSpeedTurbo) {
        this.name = name;
        this.cpuClass = cpuClass;
        this.cores = cores;
        this.processorClockSpeed = processorClockSpeed;
        this.processorClockSpeedTurbo = processorClockSpeedTurbo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpuClass() {
        return cpuClass;
    }

    public void setCpuClass(String cpuClass) {
        this.cpuClass = cpuClass;
    }

    public Integer getCores() {
        return cores;
    }

    public void setCores(Integer cores) {
        this.cores = cores;
    }

    public Double getProcessorClockSpeed() {
        return processorClockSpeed;
    }

    public void setProcessorClockSpeed(Double processorClockSpeed) {
        this.processorClockSpeed = processorClockSpeed;
    }

    public Double getProcessorClockSpeedTurbo() {
        return processorClockSpeedTurbo;
    }

    public void setProcessorClockSpeedTurbo(Double processorClockSpeedTurbo) {
        this.processorClockSpeedTurbo = processorClockSpeedTurbo;
    }

    @Override
    public String toString() {
        return "Processor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpuClass='" + cpuClass + '\'' +
                ", cores=" + cores +
                ", processorClockSpeed=" + processorClockSpeed +
                ", processorClockSpeedTurbo=" + processorClockSpeedTurbo +
                '}';
    }
}

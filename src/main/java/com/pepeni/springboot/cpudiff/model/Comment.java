package com.pepeni.springboot.cpudiff.model;

import java.io.Serializable;

public class Comment implements Serializable {
    private Long id;
    private Long userId;
    private Long processorId;
    private String content;
}

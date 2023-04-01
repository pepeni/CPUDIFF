package com.pepeni.springboot.cpudiff.exception;

public class ArticleNotFoundException extends RuntimeException{
    public ArticleNotFoundException(String s) {
        super(s);
    }
}

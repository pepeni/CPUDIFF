package com.pepeni.springboot.cpudiff.controllers;

import com.pepeni.springboot.cpudiff.model.Article;
import com.pepeni.springboot.cpudiff.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Service
public class ArticleController {

    private final ArticleService articleService;


    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/allArticles")
    public ResponseEntity<List<Article>> getAllArticles(){
        List<Article> articles = articleService.findAllArticles();
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

    @GetMapping("/article/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable("id") Long id){
        Article article = articleService.findArticleById(id);
        return new ResponseEntity<>(article, HttpStatus.OK);
    }

    @PostMapping("/addArticle")
    public ResponseEntity<Article> addArticle(@RequestBody Article article){
        Article newArticle = articleService.addArticle(article);
        return new ResponseEntity<>(newArticle, HttpStatus.CREATED);
    }

    @PutMapping("/updateArticle")
    public ResponseEntity<Article> updateArticle(@RequestBody Article article){
        Article updateArticle = articleService.updateArticle(article);
        return new ResponseEntity<>(updateArticle, HttpStatus.OK);
    }

    @DeleteMapping("/deleteArticle/{id}")
    public ResponseEntity<?> deleteArticleById(@PathVariable("id") Long id){
        articleService.deleteArticle(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

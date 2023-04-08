package com.pepeni.springboot.cpudiff.service;

import com.pepeni.springboot.cpudiff.exception.ArticleNotFoundException;
import com.pepeni.springboot.cpudiff.model.Article;
import com.pepeni.springboot.cpudiff.repository.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    private final ArticleRepo articleRepo;

    @Autowired
    public ArticleService(ArticleRepo articleRepo) {
        this.articleRepo = articleRepo;
    }

    public Article addArticle(Article article){
        return articleRepo.save(article);
    }

    public List<Article> findAllArticles(){
        return articleRepo.findAll();
    }

    public Article findArticleById(Long id){
        return articleRepo.findArticleById(id);
    }

    public Article updateArticle(Article article){
        return articleRepo.save(article);
    }

    public void deleteArticle(Long id){
        articleRepo.deleteById(id);
    }

}

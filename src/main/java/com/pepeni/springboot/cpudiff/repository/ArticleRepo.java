package com.pepeni.springboot.cpudiff.repository;

import com.pepeni.springboot.cpudiff.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleRepo extends JpaRepository<Article, Long> {
    Optional<Article> findArticleById(Long id);
}

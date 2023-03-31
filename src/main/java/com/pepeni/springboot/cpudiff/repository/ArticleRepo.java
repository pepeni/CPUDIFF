package com.pepeni.springboot.cpudiff.repository;

import com.pepeni.springboot.cpudiff.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepo extends JpaRepository<Article, Long> {
}

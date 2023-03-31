package com.pepeni.springboot.cpudiff.repository;

import com.pepeni.springboot.cpudiff.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}

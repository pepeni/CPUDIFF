package com.pepeni.springboot.cpudiff.repository;

import com.pepeni.springboot.cpudiff.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CommentRepo extends JpaRepository<Comment, Long> {
    Comment findCommentById(Long id);

    @Query(value = "SELECT * FROM COMMENT WHERE processor_id = :processorId", nativeQuery = true)
    List<Comment> findCommentByProcessorId(@Param("processorId") Long id);

    @Modifying
    @Query(value = "DELETE FROM COMMENT WHERE users_id = :usersId", nativeQuery = true)
    void deleteCommentsByUserId(@Param("usersId") Long id);
}

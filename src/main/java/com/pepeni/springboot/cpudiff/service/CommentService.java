package com.pepeni.springboot.cpudiff.service;

import com.pepeni.springboot.cpudiff.model.Comment;
import com.pepeni.springboot.cpudiff.repository.CommentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepo commentRepo;

    @Autowired
    public CommentService(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    public Comment addComment(Comment comment){
        return commentRepo.save(comment);
    }

    public List<Comment> findAllComments(){
        return commentRepo.findAll();
    }

    public Comment findCommentById(Long id){
        return commentRepo.findCommentById(id);
    }

    public List<Comment> findCommentByProcessorId(Long id){
        return commentRepo.findCommentByProcessorId(id);
    }

    public Comment updateComment(Comment comment){
        return commentRepo.save(comment);
    }

    public void deleteComment(Long id){
        commentRepo.deleteById(id);
    }

    @Transactional
    public void deleteCommentsByUserId(Long id) { commentRepo.deleteCommentsByUserId(id);}
}

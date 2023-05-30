package com.pepeni.springboot.cpudiff.controllers;

import com.pepeni.springboot.cpudiff.model.Comment;
import com.pepeni.springboot.cpudiff.model.User;
import com.pepeni.springboot.cpudiff.requestResponse.CommentRequest;
import com.pepeni.springboot.cpudiff.requestResponse.CommentResponse;
import com.pepeni.springboot.cpudiff.service.CommentService;
import com.pepeni.springboot.cpudiff.service.ProcessorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Service
public class
CommentController {
    private final CommentService commentService;
    private final ProcessorService processorService;

    public CommentController(CommentService commentService, ProcessorService processorService) {
        this.commentService = commentService;
        this.processorService = processorService;
    }

    @PostMapping("/addComment")
    public ResponseEntity<?> addComment(@RequestBody CommentRequest commentRequest){
        Comment comment = new Comment();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        comment.setUser(user);
        comment.setContent(commentRequest.getContent());
        comment.setProcessor(processorService.findProcessorById(commentRequest.getProcessId()));
        commentService.addComment(comment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/comments/{processor_id}")
    public ResponseEntity<List<CommentResponse>> getCommentById(@PathVariable("processor_id") Long id) {
        List<Comment> comments = commentService.findCommentByProcessorId(id);
        List<CommentResponse> commentResponses = new ArrayList<>();

        for (Comment comment : comments) {
            CommentResponse commentResponse = CommentResponse.builder()
                    .id(comment.getId())
                    .content(comment.getContent())
                    .processorId(comment.getProcessor().getId())
                    .userNick(comment.getUser().getNick())
                    .build();

            commentResponses.add(commentResponse);
        }

        return new ResponseEntity<>(commentResponses, HttpStatus.OK);
    }

    @PutMapping("/updateComment")
    public ResponseEntity<Comment> updateComment(@RequestBody Comment comment){
        Comment updateComment = commentService.updateComment(comment);
        return new ResponseEntity<>(updateComment, HttpStatus.OK);
    }

    @DeleteMapping("/deleteComment/{id}")
    public ResponseEntity<?> deleteCommentsById(@RequestBody Long id){
        commentService.deleteComment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

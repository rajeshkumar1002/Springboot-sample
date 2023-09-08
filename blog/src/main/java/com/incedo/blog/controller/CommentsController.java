package com.incedo.blog.controller;

import com.incedo.blog.entity.Comments;
import com.incedo.blog.service.CommentsService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommentsController {
    @Autowired
    CommentsService commentsService;

    @PostMapping("/{postId}/comments")
    public ResponseEntity<Comments> createComment(@PathVariable Long postId,@RequestBody Comments comment){
        var data = commentsService.createComment(postId,comment);
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }

    @PutMapping("/{postId}/comments/{commentId}")
    public ResponseEntity<Comments> updateComment(@PathVariable Long postId,@PathVariable Long commentId,@RequestBody Comments comment){
        var data = commentsService.updateComment(postId,commentId,comment);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/{postId}/comments")
    public ResponseEntity<List<Comments>> listComments(@PathVariable Long postId){
        return new ResponseEntity<>(commentsService.listCommentsByPostId(postId),HttpStatus.OK);
    }

    @GetMapping("/{postId}/comments/{commentId}")
    public ResponseEntity<Comments> getComments(@PathVariable Long postId,@PathVariable Long commentId){
        return new ResponseEntity<>(commentsService.viewComment(postId,commentId),HttpStatus.OK);
    }

    @DeleteMapping("/{postId}/comments/{commentId}")
    public ResponseEntity<String> removeComment(@PathVariable Long postId,@PathVariable Long commentId){
        commentsService.removeComment(postId,commentId);
        return new ResponseEntity<>("Comment Removed",HttpStatus.OK);
    }
}

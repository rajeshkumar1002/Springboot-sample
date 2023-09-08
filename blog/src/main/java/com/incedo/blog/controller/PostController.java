package com.incedo.blog.controller;

import com.incedo.blog.payload.PostDto;
import com.incedo.blog.payload.PostResponse;
import com.incedo.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto){
        var data =  postService.createPost(postDto);
        return new ResponseEntity<>(data,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable Long id, @RequestBody PostDto post){
        var data = postService.updatePost(id,post);
        return new ResponseEntity<>(data,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<PostResponse>listAllPost(
            @RequestParam(value = "pageNo",required = false, defaultValue = "0") int pageNo,
            @RequestParam(value = "pageSize",required = false, defaultValue = "10") int pageSize,
            @RequestParam(value = "sortBy",required = false, defaultValue = "title") String sortBy,
            @RequestParam(value = "sortDir",required = false, defaultValue = "ASC") String sortDir

            ){
        var data = postService.listPosts(pageNo,pageSize,sortBy,sortDir);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPost(@PathVariable Long id){
        var data = postService.getPostById(id);
        return new ResponseEntity<>(data,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removePost(@PathVariable Long id){
        postService.deletePost(id);
        return new ResponseEntity<>("Removed Post",HttpStatus.OK);
    }

}

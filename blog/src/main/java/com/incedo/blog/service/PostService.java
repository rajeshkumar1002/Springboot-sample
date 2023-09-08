package com.incedo.blog.service;

import com.incedo.blog.entity.Post;
import com.incedo.blog.payload.PostDto;
import com.incedo.blog.payload.PostResponse;

public interface PostService {
    PostDto createPost(PostDto newPost);
    PostResponse listPosts(int pageNo, int pageSize, String sortBy, String sortDir);
    PostDto getPostById(Long id);
    PostDto updatePost(Long id,PostDto post);
    void deletePost(Long id);

}

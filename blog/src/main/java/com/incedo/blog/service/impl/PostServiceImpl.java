package com.incedo.blog.service.impl;

import com.incedo.blog.entity.Post;
import com.incedo.blog.payload.PostDto;
import com.incedo.blog.payload.PostResponse;
import com.incedo.blog.exception.ResourceNotFoundException;
import com.incedo.blog.repository.PostRepository;
import com.incedo.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    @Override
    public PostDto createPost(PostDto postDto) {
        Post newPost = mapToEntity(postDto);
        Post savedPost = postRepository.save(newPost);
        return mapToDto(savedPost);
    }

    @Override
    public PostResponse listPosts(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())? Sort.by(sortBy).ascending():
                Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo,pageSize,sort);
        Page<Post> page = postRepository.findAll(pageable);
        PostResponse response = new PostResponse();
        response.setContent(page.getContent());
        response.setLast(page.isLast());
        response.setPageNo(page.getNumber());
        response.setPageSize(page.getSize());
        response.setTotalElement(page.getTotalPages());

        return response;
    }

    @Override
    public PostDto getPostById(Long id) {
        var post = postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","postId",id));
        return mapToDto(post);
    }

    @Override
    public PostDto updatePost(Long id,PostDto post) {
        Post savedPost = postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post","postId",id));
        savedPost.setTitle(post.getTitle());
        savedPost.setContent(post.getContent());
        savedPost.setDescription(post.getDescription());
        return mapToDto(postRepository.save(savedPost));

    }

    @Override
    public void deletePost(Long id) {
        var post = postRepository.findById(id).orElseThrow(()-> {
            return new ResourceNotFoundException("Post", "postId", id);
        });
        postRepository.deleteById(id);
    }

    private PostDto mapToDto(Post post){
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setComments(post.getComments());
        postDto.setContent(post.getContent());
        return postDto;
    }

    private Post mapToEntity(PostDto postDto){
        Post post = new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setComments(postDto.getComments());
        post.setContent(postDto.getContent());
        return post;
    }
}
